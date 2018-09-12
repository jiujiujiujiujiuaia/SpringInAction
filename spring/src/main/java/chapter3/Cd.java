package chapter3;

public class Cd {
    private String title = "primary";
    public Cd(String title){
        this.title = title;
    }
    public Cd(){

    }
    public void play(){
        System.out.println(title);
    }
}
