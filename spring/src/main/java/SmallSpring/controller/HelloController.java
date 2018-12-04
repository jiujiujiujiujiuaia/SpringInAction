package SmallSpring.controller;

import SmallSpring.annotion.AutoWired;
import SmallSpring.annotion.Controller;
import SmallSpring.service.HelloService;

/**
 * @Author yuchunwei
 */
@Controller("helloController")
public class HelloController {
    @AutoWired("helloService")
    private HelloService helloService;

}   
