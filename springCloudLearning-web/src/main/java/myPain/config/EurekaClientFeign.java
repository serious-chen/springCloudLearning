package myPain.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user", configuration = FeignConfig.class, fallback = HystrixConfig.class)
public interface EurekaClientFeign {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientEureka(@RequestParam("name") String name);
}
