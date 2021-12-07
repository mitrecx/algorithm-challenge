package cn.mitrecx.practice.enumeration;

public class Singleton {
    private static Singleton INSTANCE;

    private Singleton() {
    }

    public static void init() {
        // initialize
        INSTANCE = new Singleton();
    }

    public Singleton getInstance() {
        return INSTANCE;
    }
}