package cn.mitrecx.proxy.java;

import java.util.Date;

/**
 * 只能代理 UserService 对象
 *
 * 相对于动态代理(如: {@link LogHandler}), 静态代理的不足:
 *
 * 代理对象 和 目标对象 紧密耦合 在一起.
 * 这导致新代理目标对象, 必须新写一个代理类.
 */
public class UserServiceLogStaticProxy implements UserService {
    // target 对象(被代理的对象)
    private final UserService target;

    public UserServiceLogStaticProxy(UserService target) {
        this.target = target;
    }

    public void select() {
        before();
        target.select();
        after();
    }

    public void update() {
        before();
        target.update();
        after();
    }

    private void before() {
        System.out.printf("log start time [%s] %n", new Date());
    }

    private void after() {
        System.out.printf("log end time [%s] %n", new Date());
    }
}
