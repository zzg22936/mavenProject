package sort;

import java.util.Arrays;
import java.util.List;

public interface SortAlgorithm{
//    <T extends Comparable<T>> T[] sort(T[] unsorted);
    <T extends Comparable<T>> void sort(T[] unsorted);
    /*
    JDK1.8中为了加强接口的能力，使得接口可以存在具体的方法，前提是方法需要被default或static关键字所修饰。
    default修饰的目的是让接口可以拥有具体的方法，让接口内部包含了一些默认的方法实现。
    被default修饰的方法是接口的默认方法。既只要实现该接口的类，都具有这么一个默认方法，默认方法也可以被重写。
     */
    default <T extends Comparable<T>> void sort(List<T> unsorted){
        sort(unsorted.toArray((T[])new Comparable[unsorted.size()] ));
    }
    
}
