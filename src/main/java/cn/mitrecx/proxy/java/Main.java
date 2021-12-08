package cn.mitrecx.proxy.java;

import cn.mitrecx.proxy.java.util.ProxyUtils;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // 创建被代理的对象，UserService接口的实现类
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        // 调用  Proxy.newProxyInstance 创建代理实例
        UserService proxy = (UserService) Proxy.newProxyInstance(
                userServiceImpl.getClass().getClassLoader(), // 目标类 的类加载器
                userServiceImpl.getClass().getInterfaces(), // 目标类 实现的接口集合
                new LogHandler(userServiceImpl)); // InvocationHandler实例


        // 调用代理的方法
        proxy.select();
        proxy.update();

        // 保存JDK动态代理生成的代理类，类名保存为 UserServiceProxy
        ProxyUtils.generateClassFile(userServiceImpl.getClass(), "UserServiceProxy");
    }
}