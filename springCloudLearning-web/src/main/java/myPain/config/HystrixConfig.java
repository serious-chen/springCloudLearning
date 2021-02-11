package myPain.config;

public class HystrixConfig implements EurekaClientFeign{

    public String sayHiFromClientEureka(String name) {
        return "error from HystrixConfig";
    }
}
