package chapter2.soundSystem.cd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import chapter2.soundSystem.cdPlayer.CdPlayer;

@Configuration
@ComponentScan
public class CDConfig {

//    @Bean
//    public CdNotComponent cdNotComponent(){
//        return new CdNotComponent();
//    }

    @Bean(name = "cdPlayerConstructor1")
    public CdPlayer cdPlayerConstructor1(CdComponent cdComponent){
        return new CdPlayer(cdComponent);
    }
    @Bean(name = "cdPlayerNotConstructor")
    public CdPlayer cdPlayerNotConstructor(){
        return new CdPlayer();
    }
    @Bean(name = "cdPlayerConstructor2")
    public CdPlayer cdPlayerConstructor2(CdComponent cdComponent){
        return new CdPlayer(cdComponent);
    }
}
