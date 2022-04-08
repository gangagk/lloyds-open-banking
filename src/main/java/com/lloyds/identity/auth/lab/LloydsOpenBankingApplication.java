package com.lloyds.identity.auth.lab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class LloydsOpenBankingApplication {

  @Value(("${connection.time.out}"))
  private Duration connectionTimeOut;

  @Value(("${connection.read.time.out}"))
  private Duration connectionReadTimeOut;

  public static void main(String[] args) {

    SpringApplication.run(LloydsOpenBankingApplication.class, args);
  }

  @Bean
  public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder
        .setConnectTimeout(connectionTimeOut)
        .setReadTimeout(connectionReadTimeOut)
        .build();
  }
}
