package cn.mitrecx.thread;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class WeakReferenceDemo {
//    public static User user;
    public static void main(String[] args) {
        User user = new User("123", "mitre", 21);
        WeakReference<User> weakRef = new WeakReference<>(user);
        System.out.println("弱引用 和 强引用 同时指向的内存区域：" + weakRef.get());
        System.out.println("弱引用 和 强引用 同时指向的内存区域：" + user);
//        WeakReferenceDemo demo = new WeakReferenceDemo();


//        new ThreadLocal<String>().set("wo00000000");
//        demo.test2();
        System.out.println("---GC---");
        System.gc();
        System.out.println("弱引用 和 强引用 同时指向的内存区域：" + weakRef.get());
        System.out.println("弱引用 和 强引用 同时指向的内存区域：" + user);
//        demo.test2();

        System.out.println("\n移除user对象持有的强引用");
        user = null;
        System.out.println("---GC---");
        System.gc();
        System.out.println("只有 弱引用 指向的内存区域：" + weakRef.get());
//        System.out.println("after gc, 强引用 user: " + user);
    }

    public void test2(){
        try {
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object threadLocalMap = field.get(t);
            Class<?> tlmClass = threadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(threadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.printf("key: %s,值: %s %n", referenceField.get(o), valueField.get(o));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
