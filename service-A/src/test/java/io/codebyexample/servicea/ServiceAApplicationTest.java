package io.codebyexample.servicea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author huypva
 */
@Slf4j
class ServiceAApplicationTest {

  public void test() throws InterruptedException {
    RestTemplate restTemplate = new RestTemplate();

    List<Integer> testList = new ArrayList<>();
    for (int i = 1; i <= 30; i++) {
      testList.add(i);

      long startTime = System.currentTimeMillis();
      String fooResourceUrl = "http://localhost:8081/greetb";
      ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/" + (i * 1000), String.class);
      long processTime = System.currentTimeMillis() - startTime;
      if (processTime < 1000) {
        Thread.sleep(2000);
      }
      log.info("Response [" + processTime + "], " + response.getBody());
    }

  }
}