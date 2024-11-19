package com.example.demo;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ObjReader objReader = new ObjReader();
        objReader.load("C:\\Users\\gg\\Desktop\\obj-m\\hangar.obj");

        // Применение аффинных преобразований
        Transform3D transform = new Transform3D();

        // Перемещение на вектор
        transform.setTranslation(new Vector3d(2, 2, 2));
        objReader.applyTransformation(transform);
        printCurrentState(objReader, "После перемещения на вектор");

        // Поворот вокруг оси
        Transform3D rotation = new Transform3D();
        rotation.rotY(Math.toRadians(45));
        objReader.applyTransformation(rotation);
        printCurrentState(objReader, "После поворота");

        // Масштабирование
        Transform3D scale = new Transform3D();
        scale.setScale(new Vector3d(2, 2, 2)); // Масштабирование
        objReader.applyTransformation(scale);
        printCurrentState(objReader, "После масштабирования ");
    }

    private static void printCurrentState(ObjReader objReader, String message) {
        System.out.println(message);
        // Получение текущих вершин
        List<Point3d> currentVertices = objReader.getVertices();
        for (Point3d vertex : currentVertices) {
            System.out.println("Vertex: " + vertex);
        }
        System.out.println(); // Пустая строка для разделения выводов
    }
}
