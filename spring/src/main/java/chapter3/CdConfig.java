package chapter3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CdConfig {
    @Bean
    @Profile("dev")
    public Cd cd1(){
        return new Cd("dev");
    }
    @Bean
    @Profile("prod")
    public Cd cd(){
        return new Cd("prod");
    }


}
