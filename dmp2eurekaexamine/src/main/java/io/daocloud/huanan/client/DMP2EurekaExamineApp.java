package io.daocloud.huanan.client;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by vincent on 2019-6-18 21:56
 */
@SpringBootApplication
@EnableEurekaClient
public class DMP2EurekaExamineApp  {
    public static void main(String[] args) {


        SpringApplication.run(DMP2EurekaExamineApp.class, args);
    }




}