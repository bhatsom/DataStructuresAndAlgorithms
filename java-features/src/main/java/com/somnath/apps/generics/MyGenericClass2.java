package com.somnath.apps.generics;

import java.util.List;

/**
 * Created by somnath on 3/4/17.
 */
public class MyGenericClass2 {

    public static void main(String[] args) {


    }

    private static void copyShapesToCollection(Object[] source, List<Object> target) {
        for (Object element : source)
            target.add(element);

    }

    private static void copyShapesToCollection2(Object[] source, List<?> target) {
        for (Object element : source){
            //target.add(element);
        }

    }

    private static <T> void copyShapesToCollection3(T[] source, List<T> target) {
        for (T element : source)
            target.add(element);
    }

    private static <T> void copy1(List<T> src, List<T> dest){

    }

    private static <T> void copy2(List<? extends T> src, List<T> dest){

    }

    private static <T, S extends T> void copy3(List<S> src, List<T> dest){

    }


}
