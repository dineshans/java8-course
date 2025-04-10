package designpatterns.reflection;

public class MyClone implements Cloneable {
    @Override
    public MyClone clone() throws CloneNotSupportedException {
         return (MyClone) super.clone();
        }
    }
