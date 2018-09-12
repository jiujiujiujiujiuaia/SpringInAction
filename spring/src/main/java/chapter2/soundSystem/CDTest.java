package chapter2.soundSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import chapter2.soundSystem.cd.CD;
import chapter2.soundSystem.cd.CDConfig;
import chapter2.soundSystem.cdPlayer.CdPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =CDConfig.class)
public class CDTest {
    @Autowired
    private CD cd;
    @Autowired
    private CdPlayer player;
    @Autowired
    private CdPlayer play;

//    @Test
//    public void cdIsNull(){
//        cd.play();
//    }
    @Test
    public void playerIsNull(){
        player.play();
        player.play("this is player");
        player.play();
        play.play();
    }
    @Test
    public void player(){

    }

}
