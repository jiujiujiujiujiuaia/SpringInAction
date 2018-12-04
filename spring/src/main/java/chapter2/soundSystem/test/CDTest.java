package chapter2.soundSystem.test;

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
//    @Autowired
//    private CdPlayer cdPlayerConstructor1;
//    @Autowired
//    private CdPlayer cdPlayerConstructor2;
//    @Autowired
//    private CdPlayer cdPlayerNotConstructor;

    @Test
    public void testCd(){
        //这里有两个cd的实现类 一个是@Component 一个是在config中手动配置的bean,
        // 如果不注释一个,就会报错,因为就不会知道注入哪一个进来了
        //@Qualifier可以解决这个问题
        cd.play();
    }

//    @AopTest
//    public void testWireSingleton(){
//        //这证明了Bean装配的是同一个Bean，也就是单例注入
//        cdPlayerConstructor1.play();
//        cdPlayerConstructor2.play("singel");
//        cdPlayerConstructor1.play();
//    }
//    @AopTest
    public void player(){

    }

}
