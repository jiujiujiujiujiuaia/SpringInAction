package SmallSpring.servlet;

import SmallSpring.annotion.AutoWired;
import SmallSpring.annotion.Controller;
import SmallSpring.annotion.RequestMapping;
import SmallSpring.annotion.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yuchunwei
 */
public class DispatcherServlet extends HttpServlet {

    private static List<String> classNames = new ArrayList<>();
    private HashMap<String,Object> hashMap = new HashMap<>();
    private HashMap<String,Method> urlToMethod = new HashMap<>();

    public DispatcherServlet() {
        super();
    }
    @Override
    public void init() throws ServletException{
        //扫描所有class文件夹中的.class文件
        scanPackage("SmallSpring");
        //实例化带有@Controller，@Service注解的类
        fileterAndInstance();
        //查看所有hashmap中有@Autowire的成员变量 并注入相应的实例进去
        springDI();
        //把访问路径url和带有@RequestMapping的方法存储在一起
        mvc();

    }

    private void mvc(){
        if(hashMap.size() == 0){
            return;
        }
        for(Map.Entry<String,Object> entry : hashMap.entrySet()){
            if(entry.getValue().getClass().isAnnotationPresent(Controller.class)) {
                String baseUrl = entry.getValue().getClass().getAnnotation(Controller.class).value();
                Method[] methods = entry.getValue().getClass().getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(RequestMapping.class)) {
                        String value = method.getAnnotation(RequestMapping.class).value();
                        urlToMethod.put(baseUrl+"/"+value,method);
                    }
                }
            }
        }

    }

    private void springDI(){
        if(hashMap.size() == 0){
            return ;
        }

        for(Map.Entry<String,Object> entry : hashMap.entrySet()){
            Field[] fields = entry.getValue().getClass().getFields();
            for(Field field : fields){
                if(field.isAnnotationPresent(AutoWired.class)){
                    try {
                        String key = field.getAnnotation(AutoWired.class).value();
                        field.setAccessible(true);
                        field.set(entry.getKey(), hashMap.get(key));
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void fileterAndInstance(){

        if(classNames.size() == 0){
            return ;
        }

       try {
           for (String className : classNames) {
               Class classze = Class.forName(className.replaceAll(".class", ""));
               if(classze.isAnnotationPresent(Controller.class)){
                   String id = ((Controller)classze.getAnnotation(Controller.class)).value();
                    hashMap.put(id,classze.newInstance());
               }
               else if(classze.isAnnotationPresent(Service.class)){
                   String id = ((Service)classze.getAnnotation(Service.class)).value();
                   hashMap.put(id,classze.newInstance());
                   }
               }
           }
       catch (Exception e){
            e.printStackTrace();
       }

    }
    private void scanPackage(String packages){
        URL url = this.getClass().getClassLoader().getResource(replacePath(packages));//获取类得根目录URL类
        String path = url.getPath();//获取其字符串
        File file = new File(path);
        String[] strFiles = file.list();
        for(String strFile : strFiles){
           File eachFile = new File(path +"/" + strFile);
           if(eachFile.isDirectory()){
               scanPackage(packages+"."+eachFile.getName());
           }
           else {
               System.out.println(packages + "." + eachFile.getName());
               classNames.add(packages + "." + eachFile.getName());
           }
        }
    }
    private String replacePath(String path){
        return  path.replaceAll("\\.","/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public static void main(String[] args) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.scanPackage("SmallSpring");
    }
}   
