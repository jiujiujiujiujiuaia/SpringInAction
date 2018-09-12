package chapter2.soundSystem.cd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import chapter2.soundSystem.cdPlayer.CdPlayer;

@Configuration
@ComponentScan
public class CDConfig {

//    @Bean
//    public Disk disk(){
//        return new Disk();
//    }
    @Bean
    public CdPlayer player(SgtPeppers sgtPeppers){
        return new CdPlayer(sgtPeppers);
    }
    @Bean
    public CdPlayer play(SgtPeppers sgtPeppers){
        return new CdPlayer(sgtPeppers);
    }
//    @Bean
//    public SgtPeppers sgtPeppers(){
//        return new SgtPeppers();
//    }
}
