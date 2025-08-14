package com.nt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CineBiteProjectApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CineBiteProjectApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CineBiteProjectApplication.class, args);
        System.out.println(new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("password123"));

    }
}
