package chapter2.soundSystem.cdPlayer;

import chapter2.soundSystem.cd.CD;
import org.springframework.stereotype.Component;

@Component
public class CdPlayer implements Player {
    private CD cd;
    public CdPlayer(CD cd){
        this.cd = cd;
    }
    public CdPlayer(){

    }

    public void play(){
        cd.play();
    }
    public void play(String a){
        cd.play(a);
    }
}
