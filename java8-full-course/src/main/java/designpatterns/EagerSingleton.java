package designpatterns;

public class EagerSingleton {

    private static final EagerSingleton singleton = new EagerSingleton();

    private EagerSingleton() {

    }
    public static EagerSingleton getInstance() {
        return singleton;
    }
}
