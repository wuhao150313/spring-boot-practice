package wuhao.springboot.filter.intercepor.intercepor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.mock.web.MockMultipartFile;

/**
 * @author PC
 */
@Component
@Slf4j
public class ImageUploadInterceptor implements HandlerInterceptor {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    private static final long MAX_FILE_SIZE = 2 * 1024 * 1024;
    // 5MB
    private static final int MAX_WIDTH = 1920;
    private static final int MAX_HEIGHT = 1080;
    private static final String[] ALLOWED_TYPES = {"image/png", "image/jpeg", "image/gif"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file");

            if (file != null) {
                log.info("Original file MIME type: {}", file.getContentType());

                if (file.getSize() > MAX_FILE_SIZE) {
                    log.warn("文件大小超出限制: {} bytes", file.getSize());
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "File size exceeds limit");
                    return false;
                }

                if (!isValidFileType(file)) {
                    log.warn("无效的文件类型: {}", file.getContentType());
                    response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Invalid file type");
                    return false;
                }

                BufferedImage img = ImageIO.read(file.getInputStream());
                if (img.getWidth() > MAX_WIDTH || img.getHeight() > MAX_HEIGHT) {
                    log.warn("图片尺寸超出限制: {}x{}", img.getWidth(), img.getHeight());
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Image size exceeds limit");
                    return false;
                }

                String watermarkText = "wuhao150313";
                BufferedImage watermarkedImage = addWatermark(img, watermarkText);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(watermarkedImage, "png", baos);
                byte[] bytes = baos.toByteArray();
                MultipartFile newFile = new MockMultipartFile("file", file.getOriginalFilename(), "image/png", bytes);

                log.info("New file MIME type after watermarking: {}", newFile.getContentType());
                log.info("New file name after watermarking: {}", newFile.getOriginalFilename());

                String objectName = generateUniqueFileName(file.getOriginalFilename());
                uploadFileToOSS(objectName, newFile);
            }
        }

        String path = request.getRequestURI();
        String clientIp = request.getRemoteAddr();
        log.info("请求已经到达拦截器：path:{}, clientIp:{}, beginTime:{}", path, clientIp, LocalDateTime.now());
        return true;
    }

    private boolean isValidFileType(MultipartFile file) {
        String contentType = file.getContentType();
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf('.') + 1).toLowerCase() : "";

        log.info("文件名: {}, MIME类型: {}, 扩展名: {}", originalFilename, contentType, extension);

        return switch (extension) {
            case "png" -> "image/png".equals(contentType) || "application/octet-stream".equals(contentType);
            case "jpg", "jpeg" -> "image/jpeg".equals(contentType) || "application/octet-stream".equals(contentType);
            case "gif" -> "image/gif".equals(contentType);
            default -> false;
        };
    }

    private void uploadFileToOSS(String objectName, MultipartFile file) throws IOException {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            File tempFile = File.createTempFile("upload-", objectName);
            file.transferTo(tempFile);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, tempFile);
            ossClient.putObject(putObjectRequest);
            log.info("文件上传成功: {}", objectName);
            tempFile.delete(); // 删除临时文件
        } finally {
            ossClient.shutdown();
        }
    }

    private BufferedImage addWatermark(BufferedImage originalImage, String watermarkText) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage watermarked = new BufferedImage(width, height, originalImage.getType());

        Graphics2D g = (Graphics2D) watermarked.getGraphics();
        g.drawImage(originalImage, 0, 0, null);

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(Color.RED);
        g.drawString(watermarkText, width / 5, height / 2);

        g.dispose();
        return watermarked;
    }

    private String generateUniqueFileName(String originalFilename) {
        String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String uniqueId = UUID.randomUUID().toString();
        return uniqueId + extension;
    }
}
