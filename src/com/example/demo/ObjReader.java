package com.example.demo;


import javax.vecmath.*;

import java.io.*;
import java.util.*;

public class ObjReader {
    // Список для хранения вершин 3D модели
    private List<Point3d> vertices;

    public ObjReader() {
        vertices = new ArrayList<>();
    }

    // Загрузка модели из .obj файла
    public void load(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Чтение только строк, начинающихся с 'v ' (вершины)
                if (line.startsWith("v ")) {
                    String[] tokens = line.split(" ");
                    double x = Double.parseDouble(tokens[1]);
                    double y = Double.parseDouble(tokens[2]);
                    double z = Double.parseDouble(tokens[3]);
                    vertices.add(new Point3d(x, y, z));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Применение аффинных преобразований к вершинам
    public void applyTransformation(Transform3D transform) {
        for (Point3d vertex : vertices) {
            transform.transform(vertex);
        }
    }

    public List<Point3d> getVertices() {
        return vertices;
    }
}
