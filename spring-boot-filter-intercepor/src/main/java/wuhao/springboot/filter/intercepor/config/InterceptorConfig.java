package wuhao.springboot.filter.intercepor.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import wuhao.springboot.filter.intercepor.intercepor.AuthInterceptor;
import wuhao.springboot.filter.intercepor.intercepor.CORSInterceptor;
import wuhao.springboot.filter.intercepor.intercepor.ImageUploadInterceptor;
import wuhao.springboot.filter.intercepor.intercepor.LoggingInterceptor;

/**
 * @author PC
 */

@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final LoggingInterceptor loggingInterceptor;
    private final AuthInterceptor authInterceptor;
    private final CORSInterceptor corsInterceptor;
    private final ImageUploadInterceptor imageUploadInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//       registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        registry.addInterceptor(imageUploadInterceptor).addPathPatterns("/api/upload");
        // 假设这是上传的路径
    }



}
