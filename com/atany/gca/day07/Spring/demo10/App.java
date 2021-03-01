package com.atany.gca.day07.Spring.demo10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author：耿常安
 * Date：2021-02-28-13:08
 * Description：<描述>
 */

/*
    单例、多例
    spring默认是单例的
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotation = new
                AnnotationConfigApplicationContext(HelloConfiguration.class);   //加载配置类
        //通过对象匹配
        HelloService helloService1 = annotation.getBean(HelloService.class);
        System.out.println("helloService1=" + helloService1);
        HelloService helloService2 = annotation.getBean(HelloService.class);
        System.out.println("helloService2=" + helloService2);

    }
}
