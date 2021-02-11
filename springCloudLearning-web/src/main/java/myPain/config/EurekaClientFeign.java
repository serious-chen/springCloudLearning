package myPain.config;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user", configuration = FeignConfig.class, fallback = HystrixConfig.class)
public interface EurekaClientFeign {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientEureka(@RequestParam("name") String name);
}
