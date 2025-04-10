package designpatterns;

public class SynchronizedLazySingleton {

    private static SynchronizedLazySingleton singleton;
    private SynchronizedLazySingleton() {

    }
    public static synchronized SynchronizedLazySingleton getInstance() {
        if (singleton == null) {
            singleton = new SynchronizedLazySingleton();
        }
        return singleton;
    }
}
