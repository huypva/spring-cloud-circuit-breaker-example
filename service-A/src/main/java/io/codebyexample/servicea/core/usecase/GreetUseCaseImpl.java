package io.codebyexample.servicea.core.usecase;

import io.codebyexample.servicea.core.entity.Greeting;
import io.codebyexample.servicea.dataprovider.serviceb.MessageB;
import io.codebyexample.servicea.dataprovider.serviceb.ServiceBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Component
public class GreetUseCaseImpl implements GreetUseCase {

  ServiceBClient serviceBClient;

  @Autowired
  public GreetUseCaseImpl(ServiceBClient serviceBClient) {
    this.serviceBClient = serviceBClient;
  }

  @Override
  public Greeting greetB(int id) {
    MessageB messageB = serviceBClient.greet(id);
    return new Greeting(id, "MessageA -> " + messageB.getMessage());
  }
}
