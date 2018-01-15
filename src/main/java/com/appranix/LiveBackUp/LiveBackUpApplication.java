package com.appranix.LiveBackUp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
@EnableConfigurationProperties
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
@EnableResourceServer
public class LiveBackUpApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LiveBackUpApplication.class, args);
	}

	@Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

	@Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LiveBackUpApplication.class);
    }
}
