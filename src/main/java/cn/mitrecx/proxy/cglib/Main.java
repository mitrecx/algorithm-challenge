package cn.mitrecx.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
        LogInterceptor interceptor = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        // 设置超类, cglib是通过继承来实现的
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(interceptor);

        // 创建代理类
        UserDao dao = (UserDao) enhancer.create();

        dao.update();
        dao.select();
    }
}
