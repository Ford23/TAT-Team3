package com.at3.demo.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hotels/admin").setViewName("adminPanel");
        registry.addViewController("/login").setViewName("Login");
        registry.addViewController("/hotels/all").setViewName("userPanel");
        registry.addViewController("/supervisor").setViewName("supervizor");
    }
}
