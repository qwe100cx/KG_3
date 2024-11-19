package com.example.demo;

import org.testng.annotations.Test;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ObjReaderTest {

    @Test
    public void testLoad() {
        ObjReader objReader = new ObjReader();
        objReader.load("C:\\Users\\gg\\Desktop\\obj-m\\hangar.obj");


        List<Point3d> vertices = objReader.getVertices();
        assertNotNull(vertices, "Vertices list should not be null");

    }

    @Test
    public void testApplyTranslation() {
        ObjReader objReader = new ObjReader();
        objReader.load("C:\\Users\\gg\\Desktop\\obj-m\\test.obj");

        Transform3D transform = new Transform3D();
        transform.setTranslation(new Vector3d(1, 2, 3));
        objReader.applyTransformation(transform);


        List<Point3d> vertices = objReader.getVertices();
        Point3d firstVertex = vertices.get(0);
        assertEquals(2.0, firstVertex.x, 0.001, "Translated X-coordinate should be 2.0");
        assertEquals(2.0, firstVertex.y, 0.001, "Translated Y-coordinate should be 2.0");
        assertEquals(3.0, firstVertex.z, 0.001, "Translated Z-coordinate should be 3.0");
    }



    @Test
    public void testRotationY() {
        ObjReader objReader = new ObjReader();
        objReader.load("C:\\Users\\gg\\Desktop\\obj-m\\test.obj");

        Transform3D transform = new Transform3D();
        transform.rotY(Math.toRadians(90));
        objReader.applyTransformation(transform);

        List<Point3d> vertices = objReader.getVertices();
        Point3d firstVertex = vertices.get(0);

        assertEquals(0.0, firstVertex.x, 0.001, "X-coordinate after rotation should be 0.0");
        assertEquals(0.0, firstVertex.y, 0.001, "Y-coordinate should remain unchanged");
        assertEquals(-1.0, firstVertex.z, 0.001, "Z-coordinate after rotation should be -1.0");
    }

    @Test
    public void testScaling() {
        ObjReader objReader = new ObjReader();
        objReader.load("C:\\Users\\gg\\Desktop\\obj-m\\test.obj");

        Transform3D transform = new Transform3D();
        transform.setScale(new Vector3d(2, 2, 2));
        objReader.applyTransformation(transform);

        // Проверяем первую вершину после масштабирования
        List<Point3d> vertices = objReader.getVertices();
        Point3d firstVertex = vertices.get(0);

        assertEquals(2.0, firstVertex.x, 0.001, "X-coordinate after scaling should be 2.0");
        assertEquals(0.0, firstVertex.y, 0.001, "Y-coordinate after scaling should be 0.0");
        assertEquals(0.0, firstVertex.z, 0.001, "Z-coordinate after scaling should be 0.0");
    }
}
