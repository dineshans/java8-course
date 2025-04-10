package designpatterns;

public class DoubleCheckLazySingleton {

    private static DoubleCheckLazySingleton singleton;
    private DoubleCheckLazySingleton() {
    }
    public static DoubleCheckLazySingleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckLazySingleton.class) {
                singleton = new DoubleCheckLazySingleton();
            }
        }
        return singleton;
    }
}
