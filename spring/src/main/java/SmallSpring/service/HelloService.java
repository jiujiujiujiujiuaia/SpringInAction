package SmallSpring.service;

import SmallSpring.annotion.Service;

/**
 * @Author yuchunwei
 */
@Service("helloService")
public class HelloService {
    public String get(){
        return "hello spring";
    }
}   
