package consumer.controller;

import consumer.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GatewayProviderController
 * @Description TODO
 * @Author longxiaonan@163.com
 * @Date 2020/3/17 0017 16:44
 */
@RestController
@RequestMapping("/consumer")
public class GatewayConsumerController {

    @Autowired
    private FeignService feignService;

    @GetMapping(value = "/test/hi")
    public String test() {
        return feignService.test("Hi Feign");
    }
}
