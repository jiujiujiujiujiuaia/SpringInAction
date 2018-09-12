package chapter2.soundSystem.cd;


public class CdNotComponent implements CD{
    private String title = "你是我的眼";
    private String artist="萧煌奇";
    public void play(){
        System.out.println("notComponent"+artist+" "+title);
    }
    public void play(String title){
        this.title = title;
    }

}
