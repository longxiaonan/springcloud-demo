package consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "gateway-provider")
public interface FeignService {
    @GetMapping(value = "/feign-test/hi/{message}")
    String test(@PathVariable("message") String message);
}
