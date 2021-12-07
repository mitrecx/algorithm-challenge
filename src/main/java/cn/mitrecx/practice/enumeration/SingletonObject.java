package cn.mitrecx.practice.enumeration;

public class SingletonObject {

    private SingletonObject() {
    }

    public static SingletonObject getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private final SingletonObject instance;

        Singleton() {
            instance = new SingletonObject();
        }

        private SingletonObject getInstance() {
            return instance;
        }
    }
}
