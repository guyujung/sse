package com.spoting.sportinguserapi;

import com.spoting.sportinguserapi.config.CorsConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties({
    CorsConfig.class
})
public class SportingUserApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SportingUserApiApplication.class, args);
  }

}
