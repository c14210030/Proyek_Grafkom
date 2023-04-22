import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Brown {

//    private ArrayList<Object> objectsBrown
//            = new ArrayList<>();

    int countDegree = 0;
    float counterDegreeKaki = 30f;
    float counterDegreeGeleng = 45f;
    int gantiArah = 1;
    float ybadan = 0f;
    int tes;
    public ArrayList<Object> bezier1 = new ArrayList<>();
    public ArrayList<Object> bezier2 = new ArrayList<>();
    public ArrayList<Object> bezier3 = new ArrayList<>();
    public ArrayList<Object> bezier4 = new ArrayList<>();
    public ArrayList<Object> bezier5 = new ArrayList<>();
    public ArrayList<Object> bezier6 = new ArrayList<>();
    public ArrayList<Object> bezier7 = new ArrayList<>();
    public ArrayList<Object> bezier8 = new ArrayList<>();
    public static float[][] controlbezier1 = {
            { -0.0675f, 0.0725f, -0.222f},
            { -0.01f, 0.0325f, -0.222f}
    };
    public static float[][] controlbezier2 = {
            { -0.01f, 0.0325f, -0.222f},
            { 0.0675f,0.0725f, -0.222f}
    };
    // garis kiri nike
    public static float[][] controlbezier3 = {
            { -0.0375f, 0.0525f, -0.222f},
            { -0.01f, 0.0325f, -0.222f}
    };
    public static float[][] controlbezier4 = {
            { -0.09f, 0.07f, -0.18f},
            { -0.02f, 0.09f, -0.18f}
    };
    public static float[][] controlbezier5 = {
            { 0.02f, 0.09f, -0.18f},
            { 0.09f, 0.07f, -0.18f}
    };

    public void init(ArrayList<Object> objectsBrown) {
        //code
        //kepala (parent)
        objectsBrown.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objectsBrown.get(0).scaleObject(0.53f, 0.45f, 0.5f);
        //badan
        objectsBrown.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objectsBrown.get(1).scaleObject(0.32f, 0.45f, 0.32f);
        objectsBrown.get(1).translateObject(0f, -0.3f, 0f);
        //tangan kanan
        objectsBrown.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objectsBrown.get(2).translateObject(-0.3f, -0.9f, 0f);
        objectsBrown.get(2).scaleObject(0.15f, 0.38f, 0.15f);
        objectsBrown.get(2).rotateObject(0.5f, 0.0f, 0f, -1f);
        //tangan kiri
        objectsBrown.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objectsBrown.get(3).translateObject(0.3f, -0.9f, 0f);
        objectsBrown.get(3).scaleObject(0.15f, 0.38f, 0.15f);
        objectsBrown.get(3).rotateObject(0.5f, 0.0f, 0f, 1f);
        //kaki kanan
        objectsBrown.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.065f,
                0.25f,
                0.065f,
                36,
                18
        ));
        objectsBrown.get(4).translateObject(-0.07f, -0.4f, 0f);

        //kaki kiri
        objectsBrown.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.065f,
                0.25f,
                0.065f,
                36,
                18
        ));
        objectsBrown.get(5).translateObject(0.07f, -0.4f, 0f);

        //area mulut
        objectsBrown.get(0).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.749f, 0.658f, 0.592f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(0).translateObject(0f, -0.1f, -2.15f);
        objectsBrown.get(0).getChildObject().get(0).scaleObject(0.12f, 0.15f, 0.1f);

        //hidung
        objectsBrown.get(0).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0, 0, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(1).translateObject(0f, 0f, -2.16f);
        objectsBrown.get(0).getChildObject().get(1).scaleObject(0.1f, 0.1f, 0.1f);

        //mata kanan
        objectsBrown.get(0).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0, 0, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.02f,
                0.02f,
                0.02f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(2).translateObject(-0.03f, 0.07f, -0.225f);

        //mata kiri
        objectsBrown.get(0).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0, 0, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.02f,
                0.02f,
                0.02f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(3).translateObject(0.03f, 0.07f, -0.225f);

        //telinga kanan luar
        objectsBrown.get(0).getChildObject().add(new EllipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.009f,
                0.009f,
                0.0009f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(4).rotateObject(135f, 0f, 1f, 0f);
        objectsBrown.get(0).getChildObject().get(4).translateObject(-0.14f, 0.19f, 0f);

        //telinga kiri luar
        objectsBrown.get(0).getChildObject().add(new EllipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.009f,
                0.009f,
                0.0009f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(5).rotateObject(135f, 0f, 1f, 0f);
        objectsBrown.get(0).getChildObject().get(5).translateObject(0.14f, 0.19f, 0f);

        //telinga kanan dalam
        objectsBrown.get(0).getChildObject().add(new EllipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.498f, 0.301f, 0.160f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.005f,
                0.005f,
                0.0005f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(6).rotateObject(135f, 0f, 1f, 0f);
        objectsBrown.get(0).getChildObject().get(6).translateObject(-0.139f, 0.19f, -0.02f);

        //telinga kiri dalam
        objectsBrown.get(0).getChildObject().add(new EllipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.498f, 0.301f, 0.160f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.005f,
                0.005f,
                0.0005f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(7).rotateObject(135f, 0f, 1f, 0f);
        objectsBrown.get(0).getChildObject().get(7).translateObject(0.139f, 0.19f, -0.02f);

        //telapak kaki kanan
        objectsBrown.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
//                new Vector4f(0f,0f,0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.08f,
                0.05f,
                0.09f,
                36,
                18
        ));
        objectsBrown.get(6).translateObject(-0.07f, -0.67f, -0.02f);

        //telapak kaki kiri
        objectsBrown.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
//                new Vector4f(0f,0f,0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.08f,
                0.05f,
                0.09f,
                36,
                18
        ));
        objectsBrown.get(7).translateObject(0.07f, -0.67f, -0.02f);

        //garis mulut kebawah
        objectsBrown.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f,
                0.04f,
                0.01f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(8).translateObject(0f, 0f, -0.257f);

        //garis mulut kesamping kanan
        objectsBrown.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f,
                0.03f,
                0.01f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(-30), 0f, 0f, 1f);
        objectsBrown.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(-25), 1f, 0f, 0f);
        objectsBrown.get(0).getChildObject().get(9).translateObject(-0.0031f, -0.032f, -0.257f);

        //garis mulut kesamping kiri
        objectsBrown.get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f,
                0.022f,
                0.01f,
                36,
                18
        ));
        objectsBrown.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(45), 0f, 0f, 1f);
        objectsBrown.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(-30), 1f, 0f, 0f);
        objectsBrown.get(0).getChildObject().get(10).translateObject(0.0031f, -0.032f, -0.257f);

        //celana dalam putih polos
        objectsBrown.add(new EllipticCone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.034f,
                0.034f,
                0.035f,
                36,
                18
        ));
        objectsBrown.get(8).translateObject(0f, -0.57f, 0f);

        //pembatas dot pacifier
        objectsBrown.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.807f, 0.572f, 0.572f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f,
                0.02f,
                0.05f,
                36,
                18
        ));
        objectsBrown.get(9).rotateObject((float)Math.toRadians(90f),1f,0f,0f);
        objectsBrown.get(9).translateObject(0.5f,0f,0f);

        //pegangan pacifier
        objectsBrown.get(9).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.960f, 0.8f, 0.8f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.03f,
                0.03f,
                0.03f,
                36,
                18
        ));
        objectsBrown.get(9).getChildObject().get(0).translateObject(0.5f,0f,-0.05f);

        //penghubung dot pacifier
        objectsBrown.get(9).getChildObject().add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.960f, 0.8f, 0.8f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.02f,
                0.02f,
                0.04f,
                36,
                18
        ));
        objectsBrown.get(9).getChildObject().get(1).translateObject(0.5f,0f,-0.02f);

        //dot pacifier
        objectsBrown.get(9).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.964f, 0.874f,0.874f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.015f,
                0.015f,
                0.015f,
                36,
                18
        ));
        objectsBrown.get(9).getChildObject().get(2).translateObject(0.5f,0f,0.02f);
        objectsBrown.get(9).translateObject(-0.5f,-0.027f,-0.275f);
        objectsBrown.get(9).rotateObject((float)Math.toRadians(-7f),1f,0f,0f);

        //logo nike di celana dalem
        bezier5.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f)
        ));
        bezier6.add(new Object(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f)
        ));
        bezierMulut(controlbezier3,4);
        objectsBrown.get(8).getChildObject().add(bezier5.get(0));
        objectsBrown.get(8).getChildObject().get(0).translateObject(0f,-0.3f,-0.2f);
        objectsBrown.get(8).getChildObject().get(0).rotateObject((float)Math.toRadians(45f),-1f,0f,0f);
        bezierMulut(controlbezier2,5);
        objectsBrown.get(8).getChildObject().add(bezier6.get(0));
        objectsBrown.get(8).getChildObject().get(1).translateObject(0f,-0.3f,-0.2f);
        objectsBrown.get(8).getChildObject().get(1).rotateObject((float)Math.toRadians(45f),-1f,0f,0f);
    }

    public void bezierMulut(float[][] floats, int pilihan) {
        int indexbezier = 0;
        for (float t = 0; t <= 1; t += 0.01f) {
            float x = 0;
            float y = 0;
            float z = 0;
            int n = floats.length - 1;
            for (int i = 0; i <= n; i++) {
                int koefisien = koefSegitigaPascal(n, i);
                float term = koefisien * (float) Math.pow(1 - t, n - i) * (float) Math.pow(t, i);
                x += term * floats[i][0];
                y += term * floats[i][1];
                z += term * floats[i][2];
            }
            if (tes == 0) {
                //leonard
                if (pilihan == 0){
                    bezier1.get(0).addVertices(new Vector3f(x, y, z));
                }
                if (pilihan == 1){
                    bezier2.get(0).addVertices(new Vector3f(x, y, z));
                }
                //cony
                if (pilihan == 2){
                    bezier3.get(0).addVertices(new Vector3f(x, y, z));
                }
                if (pilihan == 3){
                    bezier4.get(0).addVertices(new Vector3f(x, y, z));
                }
                //brown
                if (pilihan == 4){
                    bezier5.get(0).addVertices(new Vector3f(x, y, z));
                }
                if (pilihan == 5){
                    bezier6.get(0).addVertices(new Vector3f(x, y, z));
                }
                //sally
                if (pilihan == 6){
                    bezier7.get(0).addVertices(new Vector3f(x, y, z));
                }if (pilihan == 7){
                    bezier8.get(0).addVertices(new Vector3f(x, y, z));
                }
            }
        }
    }
    public int koefSegitigaPascal(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        int koef = 1;
        for (int i = 0; i < k; i++) {
            koef *= (n - i);
            koef /= (i + 1);
        }
        return koef;
    }
}