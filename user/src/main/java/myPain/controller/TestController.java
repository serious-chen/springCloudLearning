package myPain.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Date 2021/2/5 6:59 下午
 **/
@Slf4j
@RestController
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        log.info("accept");
        return "hello";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    @ResponseBody
    public String hi(@RequestParam("name") String name){
        log.info(name);
        return name;
    }
}
