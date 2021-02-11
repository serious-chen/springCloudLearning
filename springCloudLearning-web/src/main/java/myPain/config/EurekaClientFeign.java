package myPain.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user", configuration = FeignConfig.class)
public interface EurekaClientFeign {

    @GetMapping("/hi")
    String sayHiFromClientEureka(@RequestParam("name") String name);
}
