package chapter2.soundSystem.cdPlayer;

import chapter2.soundSystem.cd.CD;

public class CdPlayer implements Player {
    private CD cd;
    public CdPlayer(CD cd){
        this.cd = cd;
    }

    public void play(){
        cd.play();
    }
    public void play(String a){
        cd.play(a);
    }
}
