package cn.mitrecx.proxy.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * LogHandler 可以代理任意的对象 target
 *
 * JDK 提供的 动态代理 的不足:
 * 1, 存在一定的限制, 例如它要求需要代理的对象必须实现了某个接口;
 * 2, 不够灵活, 动态代理 会为接口中的声明的所有方法添加上相同的代理逻辑.
 */
public class LogHandler implements InvocationHandler {
    // 目标对象(被代理的对象), 实际的方法执行者
    Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("log start time [%s] %n", new Date());
        // 调用 target 的 method 方法
        Object result = method.invoke(target, args);
        System.out.printf("log end time [%s] %n", new Date());
        return result;
    }
}