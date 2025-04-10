package designpatterns;

public class Test {

    public static void main(String[] args) {

        // eager singleton class
        /*EagerSingleton singleton1 = EagerSingleton.getInstance();
        System.out.println(singleton1.hashCode());

        EagerSingleton singleton2 = EagerSingleton.getInstance();
        System.out.println(singleton2.hashCode());*/

        // lazy singleton class
       /* LazySingleton lazySingleton1 = LazySingleton.getInstance();
        System.out.println(lazySingleton1.hashCode());

        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println(lazySingleton2.hashCode());*/

        // lazy singleton class
        /*SynchronizedLazySingleton synchronizedLazySingleton1 = SynchronizedLazySingleton.getInstance();
        System.out.println(synchronizedLazySingleton1.hashCode());

        SynchronizedLazySingleton synchronizedLazySingleton2 = SynchronizedLazySingleton.getInstance();
        System.out.println(synchronizedLazySingleton2.hashCode());*/

        DoubleCheckLazySingleton synchronizedLazySingleton1 = DoubleCheckLazySingleton.getInstance();
        System.out.println(synchronizedLazySingleton1.hashCode());

        DoubleCheckLazySingleton synchronizedLazySingleton2 = DoubleCheckLazySingleton.getInstance();
        System.out.println(synchronizedLazySingleton2.hashCode());
    }
}
