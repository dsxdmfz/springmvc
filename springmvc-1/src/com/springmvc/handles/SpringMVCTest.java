package com.springmvc.handles;

import com.springmvc.entites.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by zhangl on 2017/5/14.
 */
//@SessionAttributes(value = {"user"},types = {String.class})
@RequestMapping("/springMVC")
@Controller
public class SpringMVCTest {
    private static final String SUCCESS = "success";

    @RequestMapping("/testViewAndViewResolver")
    public static String testViewAndViewResolver() {
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    /**
     *
     * 1、有@ModelAttribute 标记的方法，会在每个目标方法执行之前被springMVC 调用
     * 2、@ModelAttribute 注解也可以用来修饰POJO 类型的入参，其value 属性值有如下的作用：
     * 1）、SpringMVC 会使用value 属性值在 implicitModel 中查找对应的对象，若存在则会直接传入到目标方法的入参中
     * 2）、SpringMVC 会一value 为key，POJO 类型的对象为value，存入到request 中
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id,
                        Map<String,Object> map){
        System.out.println("ModelAttribute");
        if (id != null){
            //模拟从数据库总获取数据
            User user = new User(1,"Tom","123456",13,"Tom@123.com");
            System.out.println("从数据库中获得一个对象："+user);
            map.put("user",user);
        }
    }

    /**
     * 运行流程：
     * 1、执行@ModelAttribute 注解修饰的方法：从数据库中取出对象，把对象放入Map 中。键为：user
     * 2、SPringMVC 从Map 中取出User对象，并把表单请求的参数赋值给该User 对象的对应属性。
     * 3、SpringMVC 把上述对象传入目标方法参数
     *
     * 注意：在@ModelAttribute 修饰的方法中，放入到Map 时的键需要和目标方法入参类型的第一个字母小写的字符串一致
     */
    @RequestMapping("/testModelArribute")
    public String testModelArribute(User user){
        System.out.println("修改："+user);
        return SUCCESS;
    }

    /**
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外（实际上使用个是value 属性值），
     * 还可以通过模型属性对象类型制定哪些模型属性需要放到会话中（实际是使用types 属性值）
     * @param map
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public static String testSessionAttributes(Map<String,Object> map) {
        User user = new User("Tom","123456",15,"Tom@123.com");
        map.put("user",user);
        map.put("school","school");
        return SUCCESS;
    }

    /**
     *目标方法可以添加Map 类型（实际上也可以是model 类型或者 ModelMap 类型）的参数
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public static String testMap(Map<String,Object> map) {
        System.out.println(map.getClass().getName());
        map.put("name", Arrays.asList("Tom","Jerry","Mike"));
        return SUCCESS;
    }

    /**
     * 目标方法的返回值可以是ModelAndView 类型
     * 其中可以包含视图和模型信息
     * SpringMVC 会把 ModelAndView 的 model 中的数据放到 request 域对象中
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        //添加模型数据到ModelAndView 中
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }

    /**
     *可以使用Servlet 原生的API 作为目标方法的参数，具体支持以下类型
     *
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * InputStream
     * OutputStream
     * Reader
     * Writer
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
                               HttpServletResponse response,
                               Writer out) throws IOException {
        System.out.println("testServletAPI,"+request+","+response);
        out.write("hello");
//        return SUCCESS;
    }

    /**
     * SpringMVC 会按照请求参数名和POJO 属性吗进行自动匹配
     * 自动为该对象填充属性值，支持级联属性，如：dept.deptId
     *
     */
    @RequestMapping("/testPojo")
    public static String testPojo(User user) {
        System.out.println("testPojo,user:" + user);
        return SUCCESS;
    }

    /**
     * 了解：
     * @CookieValue：映射一个Cookie 值。属性同@RequestParam
     *
     */
    @RequestMapping("/testCookieValue")
    public  String testCookieValue(@CookieValue("JSESSIONID") String cookieId) {
        System.out.println("testCookieValue,JSESSIONID:" + cookieId);
        return SUCCESS;
    }

    /**
     * 了解：
     * 映射请求头信息
     * 用法同@RequestParam
     */
    @RequestMapping("/testRequestHeader")
    public  String testRequestHeader(@RequestHeader(value = "Accept-Language") String header) {
        System.out.println("testRequestHeader,Accept-Language:" + header);
        return SUCCESS;
    }

    /**
     * @RequestParam 来映射请求参数
     * value 值即请求参数的的参数名
     * required 该参数是否必须。默认为true
     *defaultValue 请求参数的默认值
     */
    @RequestMapping(value = "/testRequestParam")
    public  String testRequestParam(@RequestParam(value = "username") String un,
                                          @RequestParam(value = "age",required = false,defaultValue = "0") int age) {
        System.out.println("testRequestParam,username=" + un +",age=" +age);
        return SUCCESS;
    }

    /**
     * Rest 风格的URL
     * 以CRUD 为例：
     * 新增：/order POST
     * 修改：/order PUT        update?id=1
     * 获取：/order GET        get?id=1update?id=1
     * 删除：/order DELETE     delete?id=1
     *
     * 如何发送DELETE 请求和PUT 请求
     * 1.需要配置HiddenHttpMethodFilter
     * 2.需要发送POST请求
     * 3.需要在发送POST 请求时携带一个name="_method" 的隐藏域，值为DELETE 或PUT
     *
     * 在SpringMVC 的目标方法中如何获得id
     * 使用@PathVariable 注解
     *
     */
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public  String testRestPut(@PathVariable("id") Integer id) {
        System.out.println("testRest PUT:"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public  String testRestDelete(@PathVariable("id") Integer id) {
        System.out.println("testRest DELETE:"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public  String testRest() {
        System.out.println("testRest POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public  String testRest(@PathVariable("id") Integer id) {
        System.out.println("testRest GET:"+id);
        return SUCCESS;
    }

    /**
     * @PathVariable 可以用来映射URL 中的占位符到目标方法中的参数
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public  String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable:"+id);
        return SUCCESS;
    }

    @RequestMapping("/testAntMethod/*/abc")
    public  String testAntMethod() {
        System.out.println("testAntMethod");
        return SUCCESS;
    }

    /**
     * 了解：可以使用params 和 headers 来更加精准的映射请求。params 和 headers 支持简单的表达式
     * @return
     */
    @RequestMapping(value = "testParamsAndHeaders",
            params = {"username","age!=10"},
            headers = {"Accept-Language=zh-CN,zh;q=0.8"})
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * 常用：使用method 属性来指定请求方式
     * @return
     */
    @RequestMapping(value = "testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }

    /**
     * 1、@RequestMapping 除了修饰方法，还可以修饰类
     * 2、
     * 1）、类定义处：提供初步的请求映射信息。相当于WEB 应用的根目录
     * 2）、方法处：提供进一步的细分映射信息。
     * 相当于类定义处的URL。若类定义处为标记@RequestMapping 则方法处标记的URL 相当于WEB 应用的根目录
     * @return
     */
    @RequestMapping("/testRequestMapping")
    public static String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}
