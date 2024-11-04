package wuhao.productmanagement.api.utils;


import com.aliyun.oss.OSS;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import wuhao.productmanagement.api.config.OssConfig;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author PC
 */
@Component
@AllArgsConstructor
public class OssUtil {
    private final OSS ossClient;
    private final OssConfig ossConfig;

    public String uploadFile(MultipartFile file) { // usage
        try {
            // 获取文件的原始名称
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                throw new IllegalArgumentException("文件名称不能为空");
            }
            // 生成唯一文件名，防止覆盖，上传到 upload 子目录
            String fileName = "upload/" + UUID.randomUUID() + "_" + originalFilename;
            // 获取文件输入流
            InputStream inputStream = file.getInputStream();
            // 上传文件到OSS
            ossClient.putObject(ossConfig.getBucketName(), fileName, inputStream);
            // 构建文件的URL路径
            return "https://" + ossConfig.getBucketName() + "." + ossConfig.getEndpoint().replace("https://",  "") + "/" + fileName;
        } catch (Exception e) {
            throw new RuntimeException("文件上传失败", e);
        }
    }
}
