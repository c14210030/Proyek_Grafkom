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

public class Main {
    private Window window =
            new Window
                    (800, 800, "Hello World");
    private ArrayList<Object> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();

    private MouseInput mouseInput;
    int countDegree = 0;
    float counterDegreeKaki = 30f;
    float counterDegreeKepala = 10f;
    float countDegreeFacing = 0f;
    int gantiArah = 1;
    float ybadan = 0f;
    public ArrayList<Object> bezier1 = new ArrayList<>();
    public ArrayList<Object> bezier2 = new ArrayList<>();
    public ArrayList<Object> bezier3 = new ArrayList<>();
    public ArrayList<Object> bezier4 = new ArrayList<>();
    public ArrayList<Object> bezier5 = new ArrayList<>();
    public ArrayList<Object> bezier6 = new ArrayList<>();
    public ArrayList<Object> bezier7 = new ArrayList<>();
    public ArrayList<Object> bezier8 = new ArrayList<>();
    int tes;
    public static float[][] controlbezier1 = {
            {-0.0675f, 0.0725f, -0.222f},
            {-0.01f, 0.0325f, -0.222f}
    };
    public static float[][] controlbezier2 = {
            {-0.01f, 0.0325f, -0.222f},
            {0.0675f, 0.0725f, -0.222f}
    };
    // garis kiri nike
    public static float[][] controlbezier3 = {
            {-0.0375f, 0.0525f, -0.222f},
            {-0.01f, 0.0325f, -0.222f}
    };
    public static float[][] controlbezier4 = {
            {-0.09f, 0.07f, -0.18f},
            {-0.02f, 0.09f, -0.18f}
    };
    public static float[][] controlbezier5 = {
            {0.02f, 0.09f, -0.18f},
            {0.09f, 0.07f, -0.18f}
    };
    //Cony
    private ArrayList<Object> objectsCony
            = new ArrayList<>();
    float counterDegreeKakiCony = 45f;
    float counterDegreeKepalaXCony = 25f;
    float counterDegreeKepalaYCony = 45f;

    //Sally
    private ArrayList<Object> objectsSally
            = new ArrayList<>();
    float CounterDegreeKakiSally = 30f;
    float CounterDegreeKepalaSally = 30f;

    //Brown
    private ArrayList<Object> objectsBrown
            = new ArrayList<>();
    float counterDegreeKakiBrown = 30f;
    float counterDegreeGelengBrown = 45f;

    private ArrayList<Object> pohon = new ArrayList<>();

    // Enviroment
    private ArrayList<Object> objectsAwan
            = new ArrayList<>();

    public void init() {
        window.init();
        GL.createCapabilities();
        mouseInput = window.getMouseInput();
        //code
        //pohon
        pohon.add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.065f,
                0.25f,
                0.065f,
                36,
                18
        ));
        pohon.get(0).translateObject(0.5f, 0f, 0.3f);

        pohon.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 1f, 0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.03f,
                0.25f,
                0.03f,
                36,
                18
        ));
        pohon.get(1).translateObject(0.5f, 0.2f, 0.3f);


        //Brown
        //kepala (parent)
        objectsBrown.add(new EllipsoidBrown(
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
        objectsBrown.add(new EllipsoidBrown(
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
        objectsBrown.add(new EllipsoidBrown(
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
        objectsBrown.add(new EllipsoidBrown(
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
        objectsBrown.add(new CylinderBrown(
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
        objectsBrown.add(new CylinderBrown(
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
        objectsBrown.get(0).getChildObject().add(new EllipsoidBrown(
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
        objectsBrown.get(0).getChildObject().add(new EllipsoidBrown(
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
        objectsBrown.get(0).getChildObject().add(new EllipsoidBrown(
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
        objectsBrown.get(0).getChildObject().add(new EllipsoidBrown(
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
        objectsBrown.get(0).getChildObject().add(new EllipticParaboloidBrown(
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
        objectsBrown.get(0).getChildObject().add(new EllipticParaboloidBrown(
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
        objectsBrown.get(0).getChildObject().add(new EllipticParaboloidBrown(
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
        objectsBrown.get(0).getChildObject().add(new EllipticParaboloidBrown(
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
        objectsBrown.add(new EllipsoidBrown(
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
        objectsBrown.add(new EllipsoidBrown(
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
        objectsBrown.get(0).getChildObject().add(new CylinderBrown(
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
        objectsBrown.get(0).getChildObject().add(new CylinderBrown(
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
        objectsBrown.get(0).getChildObject().add(new CylinderBrown(
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
        objectsBrown.add(new EllipticConeBrown(
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
        objectsBrown.add(new CylinderBrown(
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
        objectsBrown.get(9).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objectsBrown.get(9).translateObject(0.5f, 0f, 0f);

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
        objectsBrown.get(9).getChildObject().get(0).translateObject(0.5f, 0f, -0.05f);

        //penghubung dot pacifier
        objectsBrown.get(9).getChildObject().add(new EllipsoidBrown(
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
        objectsBrown.get(9).getChildObject().get(1).translateObject(0.5f, 0f, -0.02f);

        //dot pacifier
        objectsBrown.get(9).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.964f, 0.874f, 0.874f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.015f,
                0.015f,
                0.015f,
                36,
                18
        ));
        objectsBrown.get(9).getChildObject().get(2).translateObject(0.5f, 0f, 0.02f);
        objectsBrown.get(9).translateObject(-0.5f, -0.027f, -0.275f);
        objectsBrown.get(9).rotateObject((float) Math.toRadians(-7f), 1f, 0f, 0f);

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
        bezierMulut(controlbezier3, 4);
        objectsBrown.get(8).getChildObject().add(bezier5.get(0));
        objectsBrown.get(8).getChildObject().get(0).translateObject(0f, -0.3f, -0.2f);
        objectsBrown.get(8).getChildObject().get(0).rotateObject((float) Math.toRadians(45f), -1f, 0f, 0f);
        bezierMulut(controlbezier2, 5);
        objectsBrown.get(8).getChildObject().add(bezier6.get(0));
        objectsBrown.get(8).getChildObject().get(1).translateObject(0f, -0.3f, -0.2f);
        objectsBrown.get(8).getChildObject().get(1).rotateObject((float) Math.toRadians(45f), -1f, 0f, 0f);
        //awan
        objectsAwan.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 1f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        //melebar, meninggi, menebal
        objectsAwan.get(0).scaleObject(0.4f, 0.3f, 0.3f);
        objectsAwan.get(0).translateObject(0.8f, 0.8f, 0f);

        objectsAwan.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 1f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        //melebar, meninggi, menebal
        objectsAwan.get(1).scaleObject(0.4f, 0.3f, 0.3f);
        objectsAwan.get(1).translateObject(0.6f, 1f, 0.2f);

        objectsAwan.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 1f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        //melebar, meninggi, menebal
        objectsAwan.get(2).scaleObject(0.4f, 0.3f, 0.3f);
        objectsAwan.get(2).translateObject(0.6f, 0.7f, 0.2f);

        objectsAwan.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 1f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        //melebar, meninggi, menebal
        objectsAwan.get(3).scaleObject(0.4f, 0.3f, 0.3f);
        objectsAwan.get(3).translateObject(0.4f, 0.85f, 0f);

        //matahari
        objectsAwan.add(new Ellipsoid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.7f, 0.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objectsAwan.get(4).translateObject(-1.7f, 2f, 1f);
        objectsAwan.get(4).scaleObject(0.38f, 0.38f, 0.4f);

        //tiang lampu
        objectsAwan.add(new CylinderBrown(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objectsAwan.get(5).translateObject(28f, 0.2f, 1f);
        objectsAwan.get(5).scaleObject(0.03f, 1.5f, 0.4f);

        //bola lampu
        objectsAwan.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,
                0.5f,
                0.5f,
                36,
                18
        ));
        objectsAwan.get(6).translateObject(4.2f, 1.3f, 0.4f);
        objectsAwan.get(6).scaleObject(0.2f, 0.2f, 0.4f);

        //pindah posisi karakter
//        for (Object object : objects){
//            object.translateObject(-1.5f,-0.14f,0f);
//            object.scaleObject(0.5f,0.5f,0.6f);
//        }
//        for (Object object : objectsCony){
//            object.translateObject(-0.46f,0.08f,0f);
//            object.scaleObject(0.7f,0.7f,0.7f);
//        }
//        for (Object object : objectsSally){
//            object.translateObject(0.07f,-0.45f,0f);
//            object.scaleObject(0.4f,0.4f,0.5f);
//        }
//        for (Object object : objectsBrown){
//            object.translateObject(0.7f,0.09f,0f);
//            object.scaleObject(0.7f,0.7f,0.7f);
//        }
//        for(Object object : objectsBrown.get(0).getChildObject()){
//            System.out.println(object);
//        }

    }

    public void input() {
        //puter ke kiri
        if (window.isKeyPressed(GLFW_KEY_A)) {
            setYbadan(0.5f);
//            for (Object object : objects){
//                object.rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
//            }
//            for (Object object : objectsCony){
//                object.rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
//            }
//            for (Object object : objectsSally){
//                object.rotateObject((float) Math.toRadians(0.5f),0.0f,1.0f,0.0f);
//            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            }
        }


        //puter ke kanan
        if (window.isKeyPressed(GLFW_KEY_D)) {
            setYbadan(-0.5f);
//            for (Object object : objects) {
//                object.rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
//            }
//            for (Object object : objectsCony){
//                object.rotateObject((float) Math.toRadians(0.5f),0.0f, -1.0f,0.0f);
//            }
//            for (Object object : objectsSally){
//                object.rotateObject((float) Math.toRadians(0.5f),0.0f, -1.0f,0.0f);
//            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(0.5f), 0.0f, -1.0f, 0.0f);
            }
        }

        //puter ke atas
        if (window.isKeyPressed(GLFW_KEY_W)) {
//            for (Object object : objects) {
//                object.rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
//            }
//            for (Object object : objectsCony){
//                object.rotateObject((float) Math.toRadians(0.5f),1.0f, 0.0f,0.0f);
//            }
//            for (Object object : objectsSally){
//                object.rotateObject((float) Math.toRadians(0.5f),1.0f, 0.0f,0.0f);
//            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            }
        }

        //puter ke bawah
        if (window.isKeyPressed(GLFW_KEY_S)) {
//            for (Object object : objects) {
//                object.rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
//            }
//            for (Object object : objectsCony){
//                object.rotateObject((float) Math.toRadians(0.5f),-1.0f, 0.0f,0.0f);
//            }
//            for (Object object : objectsSally){
//                object.rotateObject((float) Math.toRadians(0.5f),-1.0f, 0.0f,0.0f);
//            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(0.5f), -1.0f, 0.0f, 0.0f);
            }
        }

        //jalan
        if (window.isKeyPressed(GLFW_KEY_E)) {
            if (countDegreeFacing > 90) {
                setYbadan(1f);
                for (Object object : objectsBrown) {
                    object.rotateObject((float) Math.toRadians(1f), 0f, -1f, 0f);
                }
                countDegreeFacing += 1f;
            } else {
                float degree = 0.7f;
                System.out.println("count degree kaki: " + counterDegreeKaki);
                if (counterDegreeKaki >= 60f) {
                    gantiArah *= -1;
                    counterDegreeKaki = 0;
                    System.out.println("ganti arah");
                }

                //Brown
                //kaki kanan
                List<Float> tempp = new ArrayList<>(objectsBrown.get(4).getCenterPoint());
                objectsBrown.get(4).translateObject(tempp.get(0) * -1, tempp.get(1) * -1, tempp.get(2) * -1);
                objectsBrown.get(4).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
                objectsBrown.get(4).translateObject(tempp.get(0) * 1, tempp.get(1) * 1, tempp.get(2) * 1);
                //kaki kiri
                List<Float> temp1B = new ArrayList<>(objectsBrown.get(5).getCenterPoint());
                objectsBrown.get(5).translateObject(temp1B.get(0) * -1, temp1B.get(1) * -1, temp1B.get(2) * -1);
                objectsBrown.get(5).rotateObject((float) Math.toRadians(gantiArah * (-degree)), 1f, 0f, 0f);
                objectsBrown.get(5).translateObject(temp1B.get(0) * 1, temp1B.get(1) * 1, temp1B.get(2) * 1);
                //telapak kaki kanan
                objectsBrown.get(6).translateObject(tempp.get(0) * -1, tempp.get(1) * -1, tempp.get(2) * -1);
                objectsBrown.get(6).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
                objectsBrown.get(6).translateObject(tempp.get(0) * 1, tempp.get(1) * 1, tempp.get(2) * 1);
                //telapak kaki kiri
                objectsBrown.get(7).translateObject(temp1B.get(0) * -1, temp1B.get(1) * -1, temp1B.get(2) * -1);
                objectsBrown.get(7).rotateObject((float) Math.toRadians(gantiArah * (-degree)), 1f, 0f, 0f);
                objectsBrown.get(7).translateObject(temp1B.get(0) * 1, temp1B.get(1) * 1, temp1B.get(2) * 1);
                //tangan kanan
                List<Float> temp2B = new ArrayList<>(objectsBrown.get(2).getCenterPoint());
                objectsBrown.get(2).translateObject(temp2B.get(0) * -1, temp2B.get(1) * -1, temp2B.get(2) * -1);
                objectsBrown.get(2).rotateObject((float) Math.toRadians(gantiArah * (-degree)), 1f, 0f, 0f);
                objectsBrown.get(2).translateObject(temp2B.get(0) * 1, temp2B.get(1) * 1, temp2B.get(2) * 1);
                //tangan kiri
                List<Float> temp3B = new ArrayList<>(objectsBrown.get(3).getCenterPoint());
                objectsBrown.get(3).translateObject(temp3B.get(0) * -1, temp3B.get(1) * -1, temp3B.get(2) * -1);
                objectsBrown.get(3).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
                objectsBrown.get(3).translateObject(temp3B.get(0) * 1, temp3B.get(1) * 1, temp3B.get(2) * 1);


                for (Object object : objectsBrown) {
                    object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
                }

                counterDegreeKaki += degree;

//                for (Object object : objectsBrown) {
//                    object.translateObject(0.005f, 0f, 0f);
//                }
            }
        }

//        Ngangguk kepala
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            setYbadan(0.5f);
            float degree = 0.3f;
            System.out.println("count degree kepala: " + counterDegreeKepala);
            if (counterDegreeKepala >= 20f) {
                gantiArah *= -1;
                counterDegreeKepala = 0;
                System.out.println("ganti arah");
            }
//            for (Object object : objects) {
//                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
//            }
//            for (Object object : objectsCony) {
//                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
//            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
            }
//            for (Object object : objectsSally) {
//                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
//            }
            //kepala
//            List<Float> tempp = new ArrayList<>(objects.get(2).getCenterPoint());
//            objects.get(0).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//            objects.get(0).rotateObject((float)Math.toRadians(gantiArah*(-degree)), -1f, 0f,0f);
//            objects.get(0).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
//            //mata kiri
//            objects.get(6).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//            objects.get(6).rotateObject((float)Math.toRadians(gantiArah*(-degree)), -1f, 0f,0f);
//            objects.get(6).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
//            //mata kanan
//            objects.get(7).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//            objects.get(7).rotateObject((float)Math.toRadians(gantiArah*(-degree)), -1f, 0f,0f);
//            objects.get(7).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
//            //wajah
//            for (int i = 12; i <= 22; i++){
//                objects.get(i).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//                objects.get(i).rotateObject((float)Math.toRadians(gantiArah*(-degree)), -1f, 0f,0f);
//                objects.get(i).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
//            }
//            objects.get(25).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//            objects.get(25).rotateObject((float)Math.toRadians(gantiArah*(-degree)), -1f, 0f,0f);
//            objects.get(25).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
//            objects.get(26).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//            objects.get(26).rotateObject((float)Math.toRadians(gantiArah*(-degree)), -1f, 0f,0f);
//            objects.get(26).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);

            //Brown
            //kepala
            List<Float> temppB = new ArrayList<>(objectsBrown.get(0).getCenterPoint());
            objectsBrown.get(0).translateObject(temppB.get(0) * -1, temppB.get(1) * -1, temppB.get(2) * -1);
            objectsBrown.get(0).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(0).translateObject(temppB.get(0) * 1, temppB.get(1) * 1, temppB.get(2) * 1);
            objectsBrown.get(9).translateObject(temppB.get(0) * -1, temppB.get(1) * -1, temppB.get(2) * -1);
            objectsBrown.get(9).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(9).translateObject(temppB.get(0) * 1, temppB.get(1) * 1, temppB.get(2) * 1);

            //Cony
//            List<Float> tempC = new ArrayList<>(objectsCony.get(0).getCenterPoint());
//            //kepala
//            objectsCony.get(0).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(0).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(0).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            //telinga
//            objectsCony.get(8).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(8).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(8).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(9).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(9).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(9).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            //mata
//            objectsCony.get(10).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(10).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(10).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(11).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(11).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(11).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            //hidung
//            objectsCony.get(12).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(12).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(12).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(13).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(13).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(13).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            //blushes
//            objectsCony.get(14).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(14).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(14).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(15).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(15).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(15).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            //hat
//            objectsCony.get(18).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(18).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(18).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(19).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(19).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(19).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            //mulut
//            objectsCony.get(20).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(20).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(20).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(21).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(21).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(21).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(22).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(22).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(22).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(23).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(23).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(23).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(24).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(24).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(24).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(26).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(26).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(26).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//            objectsCony.get(27).translateObject(tempC.get(0)*-1,tempC.get(1)*-1,tempC.get(2)*-1);
//            objectsCony.get(27).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsCony.get(27).translateObject(tempC.get(0)*1,tempC.get(1)*1,tempC.get(2)*1);
//
//            //Sally
//            //kepala
//            List<Float> temp0S = new ArrayList<>(objectsSally.get(0).getCenterPoint());
//            objectsSally.get(0).translateObject(temp0S.get(0)*-1,temp0S.get(1)*-1,temp0S.get(2)*-1);
//            objectsSally.get(0).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsSally.get(0).translateObject(temp0S.get(0)*1,temp0S.get(1)*1,temp0S.get(2)*1);
//            //mata kiri
//            objectsSally.get(6).translateObject(temp0S.get(0)*-1,temp0S.get(1)*-1,temp0S.get(2)*-1);
//            objectsSally.get(6).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsSally.get(6).translateObject(temp0S.get(0)*1,temp0S.get(1)*1,temp0S.get(2)*1);
//            //mata kanan
//            objectsSally.get(7).translateObject(temp0S.get(0)*-1,temp0S.get(1)*-1,temp0S.get(2)*-1);
//            objectsSally.get(7).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsSally.get(7).translateObject(temp0S.get(0)*1,temp0S.get(1)*1,temp0S.get(2)*1);
//            //mulut atas
//            objectsSally.get(8).translateObject(temp0S.get(0)*-1,temp0S.get(1)*-1,temp0S.get(2)*-1);
//            objectsSally.get(8).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsSally.get(8).translateObject(temp0S.get(0)*1,temp0S.get(1)*1,temp0S.get(2)*1);
//            //mulut bawah
//            objectsSally.get(9).translateObject(temp0S.get(0)*-1,temp0S.get(1)*-1,temp0S.get(2)*-1);
//            objectsSally.get(9).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
//            objectsSally.get(9).translateObject(temp0S.get(0)*1,temp0S.get(1)*1,temp0S.get(2)*1);

//            for (Object object : objects) {
//                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
//            }
//            for (Object object : objectsCony) {
//                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
//            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
            }
//            for (Object object : objectsSally) {
//                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
//            }
            counterDegreeKepala += degree;
        }

        //        Geleng kepala
        if (window.isKeyPressed(GLFW_KEY_G)) {
            float degree = 0.3f;
            System.out.println("count degree kepala: " + counterDegreeKepala);
            if (counterDegreeKepala >= 20f) {
                gantiArah *= -1;
                counterDegreeKepala = 0;
                System.out.println("ganti arah");
            }
//            for (Object object : objects) {
//                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
//            }
//            for (Object object : objectsCony) {
//                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
//            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
            }
//            for (Object object : objectsSally) {
//                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
//            }
            //kepala
//            List<Float> tempp = new ArrayList<>(objects.get(2).getCenterPoint());
//            objects.get(0).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//            objects.get(0).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//            objects.get(0).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
//            //mata kiri
//            objects.get(6).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//            objects.get(6).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//            objects.get(6).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
//            //mata kanan
//            objects.get(7).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//            objects.get(7).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//            objects.get(7).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
//            //wajah
//            for (int i = 12; i <= 22; i++){
//                objects.get(i).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//                objects.get(i).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//                objects.get(i).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
//            }
//            objects.get(25).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//            objects.get(25).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//            objects.get(25).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
//            objects.get(26).translateObject(tempp.get(0)*-1,tempp.get(1)*-1,tempp.get(2)*-1);
//            objects.get(26).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//            objects.get(26).translateObject(tempp.get(0)*1,tempp.get(1)*1,tempp.get(2)*1);
            //Brown
            //kepala
            List<Float> temppB = new ArrayList<>(objectsBrown.get(0).getCenterPoint());
            objectsBrown.get(0).translateObject(temppB.get(0) * -1, temppB.get(1) * -1, temppB.get(2) * -1);
            objectsBrown.get(0).rotateObject((float) Math.toRadians(gantiArah * degree), 0f, 1f, 0f);
            objectsBrown.get(0).translateObject(temppB.get(0) * 1, temppB.get(1) * 1, temppB.get(2) * 1);
            //pacifier
            objectsBrown.get(9).translateObject(temppB.get(0) * -1, temppB.get(1) * -1, temppB.get(2) * -1);
            objectsBrown.get(9).rotateObject((float) Math.toRadians(gantiArah * degree), 0f, 1f, 0f);
            objectsBrown.get(9).translateObject(temppB.get(0) * 1, temppB.get(1) * 1, temppB.get(2) * 1);

//            //Cony
//            List<Float> tempppC = new ArrayList<>(objectsCony.get(0).getCenterPoint());
//            //kepala
//            objectsCony.get(0).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(0).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(0).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            //telinga
//            objectsCony.get(8).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(8).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(8).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(9).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(9).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(9).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            //mata
//            objectsCony.get(10).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(10).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(10).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(11).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(11).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(11).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            //hidung
//            objectsCony.get(12).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(12).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(12).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(13).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(13).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(13).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            //blushes
//            objectsCony.get(14).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(14).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(14).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(15).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(15).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(15).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            //hat
//            objectsCony.get(18).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(18).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(18).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(19).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(19).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(19).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            //mulut
//            objectsCony.get(20).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(20).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(20).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(21).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(21).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(21).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(22).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(22).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(22).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(23).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(23).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(23).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(24).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(24).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(24).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(26).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(26).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(26).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//            objectsCony.get(27).translateObject(tempppC.get(0)*-1, tempppC.get(1)*-1, tempppC.get(2)*-1);
//            objectsCony.get(27).rotateObject((float)Math.toRadians(gantiArah*degree), 0f, 1f,0f);
//            objectsCony.get(27).translateObject(tempppC.get(0)*1, tempppC.get(1)*1, tempppC.get(2)*1);
//
//            //Sally
//            //kepala
//            List<Float> temp0S = new ArrayList<>(objectsSally.get(0).getCenterPoint());
//            objectsSally.get(0).translateObject(temp0S.get(0)*-1,temp0S.get(1)*-1,temp0S.get(2)*-1);
//            objectsSally.get(0).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//            objectsSally.get(0).translateObject(temp0S.get(0)*1,temp0S.get(1)*1,temp0S.get(2)*1);
//            //mata kiri
//            objectsSally.get(6).translateObject(temp0S.get(0)*-1,temp0S.get(1)*-1,temp0S.get(2)*-1);
//            objectsSally.get(6).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//            objectsSally.get(6).translateObject(temp0S.get(0)*1,temp0S.get(1)*1,temp0S.get(2)*1);
//            //mata kanan
//            objectsSally.get(7).translateObject(temp0S.get(0)*-1,temp0S.get(1)*-1,temp0S.get(2)*-1);
//            objectsSally.get(7).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//            objectsSally.get(7).translateObject(temp0S.get(0)*1,temp0S.get(1)*1,temp0S.get(2)*1);
//            //mulut atas
//            objectsSally.get(8).translateObject(temp0S.get(0)*-1,temp0S.get(1)*-1,temp0S.get(2)*-1);
//            objectsSally.get(8).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//            objectsSally.get(8).translateObject(temp0S.get(0)*1,temp0S.get(1)*1,temp0S.get(2)*1);
//            //mulut bawah
//            objectsSally.get(9).translateObject(temp0S.get(0)*-1,temp0S.get(1)*-1,temp0S.get(2)*-1);
//            objectsSally.get(9).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 0f, 1f,0f);
//            objectsSally.get(9).translateObject(temp0S.get(0)*1,temp0S.get(1)*1,temp0S.get(2)*1);
//
//            for (Object object : objects) {
//                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
//            }
//            for (Object object : objectsCony) {
//                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
//            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
            }
//            for (Object object : objectsSally) {
//                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
//            }
            counterDegreeKepala += degree;
        }

        //rotasi thd sb y masing2 character
        if (window.isKeyPressed(GLFW_KEY_Y)) {
            setYbadan(0.6f);
            for (Object object : objects) {
//                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
                object.rotateObjectOnPoint(0.6f, 0f, 1f, 0f, objects.get(0).getCpx(), objects.get(0).getCpy(), objects.get(0).getCpz());
            }
            for (Object object : objectsCony) {
//                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
                object.rotateObjectOnPoint(0.6f, 0f, 1f, 0f, objectsCony.get(0).getCpx(), objectsCony.get(0).getCpy(), objectsCony.get(0).getCpz());
            }
            for (Object object : objectsBrown) {
//                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
                object.rotateObjectOnPoint(0.6f, 0f, 1f, 0f, objectsBrown.get(0).getCpx(), objectsBrown.get(0).getCpy(), objectsBrown.get(0).getCpz());
            }
            for (Object object : objectsSally) {
//                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
                object.rotateObjectOnPoint(0.6f, 0f, 1f, 0f, objectsSally.get(0).getCpx(), objectsSally.get(0).getCpy(), objectsSally.get(0).getCpz());
            }
        }

        if (mouseInput.isLeftButtonPressed()) {
            Vector2f pos = mouseInput.getCurrentPos();
            pos.x = (pos.x - (window.getWidth()) / 2.0f) /
                    (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) /
                    (-window.getHeight() / 2.0f);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
                System.out.println("x : " + pos.x + " y : " + pos.y);
            }
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 1.0f, 1.0f, 0.0f);
            GL.createCapabilities();
            input();

            //code


            for (Object object : objectsBrown) {
//                object.draw(camera,projection);
                object.draw();
                for (Object childObject : object.getChildObject()) {
//                    childObject.draw(camera,projection);
                    childObject.draw();
                }
            }

            for (Object object : objectsAwan) {
                object.draw();
            }

            for (Object object : bezier1) {
                object.drawLine();
            }
            for (Object object : bezier2) {
                object.drawLine();
            }
            for (Object object : bezier3) {
                object.drawLine();
            }
            for (Object object : bezier4) {
                object.drawLine();
            }
            for (Object object : bezier5) {
                object.drawLine();
            }
            for (Object object : bezier6) {
                object.drawLine();
            }
            for (Object object : bezier7) {
                object.drawLine();
            }
            for (Object object : bezier8) {
                object.drawLine();
            }

            for (Object object : pohon) {
                object.draw();
            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void setYbadan(float ybadan) {
        this.ybadan += ybadan;
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
                if (pilihan == 0) {
                    bezier1.get(0).addVertices(new Vector3f(x, y, z));
                }
                if (pilihan == 1) {
                    bezier2.get(0).addVertices(new Vector3f(x, y, z));
                }
                //cony
                if (pilihan == 2) {
                    bezier3.get(0).addVertices(new Vector3f(x, y, z));
                }
                if (pilihan == 3) {
                    bezier4.get(0).addVertices(new Vector3f(x, y, z));
                }
                //brown
                if (pilihan == 4) {
                    bezier5.get(0).addVertices(new Vector3f(x, y, z));
                }
                if (pilihan == 5) {
                    bezier6.get(0).addVertices(new Vector3f(x, y, z));
                }
                //sally
                if (pilihan == 6) {
                    bezier7.get(0).addVertices(new Vector3f(x, y, z));
                }
                if (pilihan == 7) {
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