package myPain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description 启动eureka
 * @Date 2021/2/2 10:26 上午
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain.class, args);
    }
}
