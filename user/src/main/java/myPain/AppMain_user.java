package myPain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description TODO
 * @Date 2021/2/5 6:57 下午
 **/
@SpringBootApplication
@EnableEurekaClient
public class AppMain_user {

    public static void main(String[] args) {
        SpringApplication.run(AppMain_user.class, args);
    }
}
