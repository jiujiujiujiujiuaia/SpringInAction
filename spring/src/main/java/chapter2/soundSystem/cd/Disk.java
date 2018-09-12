package chapter2.soundSystem.cd;


public class Disk implements CD{
    private String title = "你是我的眼";
    private String artist="萧煌奇";
    public void play(){
        System.out.println("playing"+artist+" "+title);
    }
    public void play(String title){
        this.title = title;
    }

}
