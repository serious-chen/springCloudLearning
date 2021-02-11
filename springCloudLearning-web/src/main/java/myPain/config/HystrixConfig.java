package myPain.config;

import org.springframework.stereotype.Component;

@Component
public class HystrixConfig implements EurekaClientFeign{

    public String sayHiFromClientEureka(String name) {
        return "error from HystrixConfig";
    }
}
