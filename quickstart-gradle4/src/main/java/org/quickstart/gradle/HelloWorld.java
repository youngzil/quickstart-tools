/**
 * 项目名称：quickstart-gradle 
 * 文件名：HelloWorld.java
 * 版本信息：
 * 日期：2018年7月28日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.gradle;

/**
 * HelloWorld
 * 
 * @author：yangzl@asiainfo.com
 * @2018年7月28日 下午9:28:45
 * @since 1.0
 */
public class HelloWorld {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }
}
