pom.xml
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```
通过 @EnableFeignClients 注解开启 Feign 功能
```java
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GatewayConsumerApplication8005 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayConsumerApplication8005.class, args);
    }

}
```
通过 @FeignClient("服务名") 注解来指定调用哪个服务。代码如下：
```java
@FeignClient(value = "gateway-provider")
public interface FeignService {
    @GetMapping(value = "/feign-test/hi/{message}")
    String test(@PathVariable("message") String message);
}
```
8003和8004服务也配置controller测试类：
```java
@RestController
@RequestMapping("/feign-test")
public class GatewayProviderControllerFeign {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/hi/{message}")
    public String provider(@PathVariable String message) {
        return serverPort + " " + message;
    }

}
```
测试：
这时打开 http://localhost:8006/consumer/test/hi
"8003 Hi Feign"和"8004 Hi Feign"交替显示
