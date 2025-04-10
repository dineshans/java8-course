package designpatterns.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*CloneSingleton singleton = CloneSingleton.getInstance();
        System.out.println(singleton.hashCode());

        CloneSingleton singleton1 = (CloneSingleton) singleton.clone();
        System.out.println(singleton1.hashCode());*/

        // now break using reflection
        CloneSingleton singleton1 = CloneSingleton.getInstance();
        System.out.println(singleton1.hashCode());

        CloneSingleton reflectionInstance = null;
        Constructor<?>[] constructors = CloneSingleton.class.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            reflectionInstance = (CloneSingleton) constructor.newInstance();
        }
        System.out.println(reflectionInstance.hashCode());

    }
}
