package myPain.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import myPain.config.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Date 2021/2/4 9:26 下午
 **/
@Slf4j
@RefreshScope
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private EurekaClientFeign eurekaClientFeign;

    @Value("${app.version}")
    private String version;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("user");
        log.info(serviceInstance.getHost());*/
        /*ResponseEntity<String> result = restTemplate.getForEntity("http://user/hello", String.class);
        log.info(result.getBody());*/
        return eurekaClientFeign.sayHiFromClientEureka("hi");
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    @ResponseBody
    public String version(){
        return version;
    }
}
