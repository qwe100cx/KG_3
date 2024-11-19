package com.example.demo;

import javax.vecmath.*;

public class Transform3D {
    private Matrix4d matrix;

    public Transform3D() {
        matrix = new Matrix4d();
        matrix.setIdentity();
    }

    public void setTranslation(Vector3d translation) {
        Matrix4d translationMatrix = new Matrix4d();
        translationMatrix.setIdentity();
        translationMatrix.m03 = translation.x;
        translationMatrix.m13 = translation.y;
        translationMatrix.m23 = translation.z;
        matrix.mul(translationMatrix);
    }

    public void setScale(Vector3d scale) {
        Matrix4d scaleMatrix = new Matrix4d();
        scaleMatrix.setIdentity();
        scaleMatrix.m00 = scale.x;
        scaleMatrix.m11 = scale.y;
        scaleMatrix.m22 = scale.z;
        matrix.mul(scaleMatrix);
    }

    // Установка вращения вокруг оси X
    public void rotX(double angle) {
        Matrix4d rotationMatrix = new Matrix4d();
        rotationMatrix.rotX(angle);
        matrix.mul(rotationMatrix);
    }

    // Установка вращения вокруг оси Y
    public void rotY(double angle) {
        Matrix4d rotationMatrix = new Matrix4d();
        rotationMatrix.rotY(angle);
        matrix.mul(rotationMatrix);
    }

    // Установка вращения вокруг оси Z
    public void rotZ(double angle) {
        Matrix4d rotationMatrix = new Matrix4d();
        rotationMatrix.rotZ(angle);
        matrix.mul(rotationMatrix);
    }

    // Применение трансформации к точке
    public void transform(Point3d point) {
        matrix.transform(point);
    }
}


