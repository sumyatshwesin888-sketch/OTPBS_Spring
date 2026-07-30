package com.travelgo.otpb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Project အပြင်ဘက်မှာရှိတဲ့ "productphoto" folder ကို URL ကနေ လှမ်းယူလို့ရအောင် ဖွင့်ပေး
        registry.addResourceHandler("/productphoto/**")
                .addResourceLocations("file:productphoto/");
    }
}