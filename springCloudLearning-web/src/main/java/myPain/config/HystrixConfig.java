package myPain.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Component
public class HystrixConfig implements EurekaClientFeign{

    @Override
    public String sayHiFromClientEureka(@RequestParam("name") String name) {
        log.error("error hystrix");
        log.info("error hystrix");
        return "error from HystrixConfig";
    }
}
