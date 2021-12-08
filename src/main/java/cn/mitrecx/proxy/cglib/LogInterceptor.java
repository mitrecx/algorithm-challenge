package cn.mitrecx.proxy.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

public class LogInterceptor implements MethodInterceptor {
    /**
     * @param object      表示要进行增强的对象
     * @param method      表示拦截的方法
     * @param objects     数组表示参数列表, 基本数据类型需要传入其包装类型(如int-->Integer)
     * @param methodProxy 表示对方法的代理, invokeSuper方法表示对被代理对象方法的调用
     */
    @Override
    public Object intercept(Object object,
                            Method method,
                            Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        System.out.printf("log start time [%s] %n", new Date());
        // 注意这里是调用 invokeSuper 而不是 invoke,
        // 否则死循环, methodProxy.invokesuper 执行的是原始类的方法,
        // method.invoke 执行的是子类的方法
        Object result = methodProxy.invokeSuper(object, objects);
        System.out.printf("log end time [%s] %n", new Date());
        return result;
    }
}