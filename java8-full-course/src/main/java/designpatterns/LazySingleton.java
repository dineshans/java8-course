package designpatterns;

public class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if(singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
