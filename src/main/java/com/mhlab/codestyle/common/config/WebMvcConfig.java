package com.mhlab.codestyle.common.config;

import com.mhlab.codestyle.common.component.AuthInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 설정을 처리하는 컨피그 클래스
 *
 * Created by MHLab on 02/09/2019..
 */

@Configuration
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    private AuthInterceptor authInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            //Session auth check
            registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/users/**"); //사용자 측은 제외해준다.
    }

}
