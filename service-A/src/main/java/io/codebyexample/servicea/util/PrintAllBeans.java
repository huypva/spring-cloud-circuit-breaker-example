package io.codebyexample.servicea.util;

import io.github.resilience4j.circuitbreaker.autoconfigure.CircuitBreakerProperties;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Slf4j
@Component
public class PrintAllBeans {

  @Autowired
  CircuitBreakerProperties circuitBreakerProperties;

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    log.info("circuitBreakerProperties:" + GsonUtils.toJson(circuitBreakerProperties));


    return args -> {
      log.info("====== Beans ======");
      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        log.info(beanName);
      }
      log.info("===========================================");
    };
  }
}
