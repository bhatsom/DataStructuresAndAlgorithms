package com.somnath.apps.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by somnath on 3/4/17.
 */
public class MyGenericClass1 {

    public static void main(String[] args) {

        //below two legal declaration
        List<String> myStringList = new ArrayList<>();
        List<Object> myObjectList = new ArrayList<>();

        //below two don't compile as List<String> is not a Subtype of List<Object>
        //List<Object> myObjectList2 = myStringList;
        //List<Object> myObjectList2 = new ArrayList<String>();

        myStringList.add("First Element");
        myObjectList.add("Element1"); // allowed as String is type of Object

        //doesn't compile. type cast required
        //String fromObjList = myObjectList.get(0);
        String fromObjList = (String) myObjectList.get(0);
        System.out.println("fromObjList:" + fromObjList);

        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        //allowed as anything that is of type shape is accepted
        drawSingleShape(circle);
        drawSingleShape(rectangle);

        List<? extends Shape> shapeListToBeDrawn1 = new ArrayList<>();
        //shapeListToBeDrawn1.add(circle); //not allowed

        //below is allowed but of no use
        List<? extends Shape> shapeListToBeDrawn2 = new ArrayList<Circle>();
        //shapeListToBeDrawn2.add(circle); //not allowed
        /*shapeListToBeDrawn2.add(new Shape() { //not allowed
            @Override
            public void draw() {
                System.out.println("draw circle");
            }
        });
*/
        List<Shape> shapeListToBeDrawn3 = new ArrayList<>();
        shapeListToBeDrawn3.add(circle); //now its allowed
        shapeListToBeDrawn3.add(rectangle); //now ist allowed
        shapeListToBeDrawn3.add(new Shape() { //sing anonymous inner class
            @Override
            public void draw() {
                System.out.println("draw circle");
            }
        });
        shapeListToBeDrawn3.add(() -> System.out.println("draw circle")); // using lambda

        drawSingleShape(circle);
        drawSingleShape(rectangle);
        drawMultipleShape(shapeListToBeDrawn3);

        Map<String, Circle> circleMap = new HashMap<>();
        circleMap.put("circle1", new Circle());
        Circle circle2 = new Circle();
        circleMap.put("circle2", circle2);

        printShapeRegistry(circleMap);
    }

    private static void drawSingleShape(Shape shape){
        shape.draw();
    }

    private static void drawMultipleShape(List<Shape> shapeList){
        for (Shape shape : shapeList)
            shape.draw();
    }

    private static void addToShapeList(List<? extends Shape> registryList){
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        //registryList.add(circle);
        //registryList.add(rectangle);
    }

    private static void addToShapeRegistry(Map<String, ? extends Shape> registryMap){
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        //registryMap.put("circle", circle);
        //registryMap.put("rectangle", rectangle);

        Map<String, Circle> circleMap = new HashMap<>();
        // not allowed as circle is of type shape, even though it points to a Circle object
        //circleMap.put("circle1", circle);
        //now its allowed
        circleMap.put("circle1", new Circle());
        Circle circle2 = new Circle();
        circleMap.put("circle2", circle2);

        //finally not allowed
        //registryMap.putAll(circleMap);

    }
    private static void printShapeRegistry(Map<String, ? extends Shape> registryMap){
        //print all from registryMap

    }
}
