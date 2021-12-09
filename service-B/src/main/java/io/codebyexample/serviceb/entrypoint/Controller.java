package io.codebyexample.serviceb.entrypoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@Slf4j
@RestController
public class Controller {

  @GetMapping("/greet/{id}")
  public MessageB greet(@PathVariable(name = "id") int id) throws InterruptedException {
    log.info("ServiceB.greet");
    Thread.sleep(15000);
    return new MessageB("MessageB greet " + id);
  }
}
