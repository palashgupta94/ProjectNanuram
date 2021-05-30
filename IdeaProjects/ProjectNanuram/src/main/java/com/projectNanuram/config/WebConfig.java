package com.projectNanuram.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.projectNanuram.controller"})
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        irvr.setViewClass(JstlView.class);
        irvr.setPrefix("/WEB-INF/views/");
        irvr.setSuffix(".jsp");
        return irvr;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
                

    }
}
