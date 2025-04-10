package designpatterns.reflection;

import designpatterns.LazySingleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CloneSingleton extends MyClone{

    private static CloneSingleton singleton;

    private CloneSingleton() {
        // to stop using instance using reflection
        if (singleton != null) {
            throw new IllegalStateException("Can't create new intance using reflection");
        }

    }

    // to stop creating instance using clone method
    @Override
    public MyClone clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Can't clone for new instance");
    }

    public static CloneSingleton getInstance() {
        if(singleton == null) {
            singleton = new CloneSingleton();
        }
        return singleton;
    }
}
