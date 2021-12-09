package io.codebyexample.servicea.dataprovider.serviceb;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huypva
 */
@FeignClient(value = "serviceb", url = "${serviceb.url}")
public interface ServiceBClient {

  @CircuitBreaker(name = "serviceB", fallbackMethod = "fallbackMethod")
  @RequestMapping(method = RequestMethod.GET, value = "${serviceb.path.greet}")
  public MessageB greet(@PathVariable(name = "id") int userId);

  default MessageB fallbackMethod(Throwable throwable) {
    return new MessageB("Fallback method");
  }
}
