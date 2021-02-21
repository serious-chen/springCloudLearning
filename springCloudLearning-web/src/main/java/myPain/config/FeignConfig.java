package myPain.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Description TODO
 * @Date 2021/2/9 7:06 下午
 **/
@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100l, TimeUnit.SECONDS.toMillis(1L), 1);
    }
}
