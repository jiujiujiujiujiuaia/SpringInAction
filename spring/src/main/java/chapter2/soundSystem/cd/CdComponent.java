package chapter2.soundSystem.cd;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CdComponent implements CD {
    private String title =  "断点";
    private String artist = "张敬轩";
    public void play(){
        System.out.println("Component "+artist+" "+title);
    }
    public void play(String title){
        this.title = title;
    }
}
