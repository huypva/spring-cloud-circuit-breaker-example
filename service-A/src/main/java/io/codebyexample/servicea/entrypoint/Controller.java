package io.codebyexample.servicea.entrypoint;

import io.codebyexample.servicea.core.entity.Greeting;
import io.codebyexample.servicea.core.usecase.GreetUseCase;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@Setter
@Slf4j
@RestController
public class Controller {

  @Autowired
  GreetUseCase greetUseCase;

  @GetMapping("/greetb/{id}")
  public Greeting greetB(@PathVariable(name = "id") int id) {
    log.info("ServiceA.greetB");
    return greetUseCase.greetB(id);
  }
}
