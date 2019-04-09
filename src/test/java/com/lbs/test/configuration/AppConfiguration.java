package com.lbs.test.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.lbs.bddworkshop.dao")
@EntityScan(basePackages = "com.lbs.bddworkshop.dao")
@PropertySource({"classpath:application.properties"})
@ComponentScan(basePackages = {"com.lbs.test", "com.lbs.bddworkshop.dao", "com.lbs.bddworkshop.services"})
public class AppConfiguration {

}
