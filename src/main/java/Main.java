import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
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
    private ArrayList<Object> objectsBrown
            = new ArrayList<>();
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());
    private EllipticCone stripMerah;
    private MouseInput mouseInput;
    int countDegree = 0;
    float counterDegreeKaki = 30f;
    float counterDegreeGeleng = 45f;
    int gantiArah = 1;
    float ybadan = 0f;

    //Cony
    private ArrayList<Object> objectsCony
            = new ArrayList<>();
    float counterDegreeKakiCony = 45f;
    float counterDegreeKepalaXCony = 25f;
    float counterDegreeKepalaYCony = 45f;

    //Leonard
    private ArrayList<Object> objectsLeonard
            = new ArrayList<>();
    float counterDegreeKakiLeonard = 30f;
    float counterDegreeKepalaLeonard = 10f;

    //Sally
    private ArrayList<Object> objectsSally
            = new ArrayList<>();
    float CounterDegreeKakiSally = 30f;
    float CounterDegreeKepalaSally = 30f;

    public void init() {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0,0,0.5f);
        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(30.0f));
        mouseInput = window.getMouseInput();
        //code

        //brown
        {
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
        }

        //cony
        {
            //kepala
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
            objectsCony.get(0).scaleObject(0.4f, 0.35f, 0.3f);
            //badan
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
            objectsCony.get(1).translateObject(0f, -0.6f, 0f);
            objectsCony.get(1).scaleObject(0.32f, 0.45f, 0.32f);
            //tangan kanan
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
            objectsCony.get(2).translateObject(-0.3f, -0.8f, 0f);
            objectsCony.get(2).scaleObject(0.12f, 0.36f, 0.15f);
            objectsCony.get(2).rotateObject(0.5f, 0.0f, 0f, -1f);
            //tangan kiri
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
            objectsCony.get(3).translateObject(0.3f, -0.8f, 0f);
            objectsCony.get(3).scaleObject(0.12f, 0.36f, 0.15f);
            objectsCony.get(3).rotateObject(0.5f, 0.0f, 0f, 1f);
            //kaki kanan
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
            objectsCony.get(4).translateObject(-0.5f, -1f, 0f);
            objectsCony.get(4).scaleObject(0.15f, 0.44f, 0.15f);

            //telapak kaki kanan
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    // atur warna
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, idk
            objectsCony.get(5).translateObject(0.6f,-5.5f,-0.1f);
            //melebar, meninggi, muncul garis2
            objectsCony.get(5).scaleObject(0.15f,0.11f,0.15f);
            //kaki kiri
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
            objectsCony.get(6).translateObject(0.5f, -1f, 0f);
            objectsCony.get(6).scaleObject(0.15f, 0.44f, 0.15f);
            //telapak kaki kiri
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    // atur warna
                    new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, idk
            objectsCony.get(7).translateObject(-0.6f,-5.5f,-0.1f);
            //melebar, meninggi, muncul garis2
            objectsCony.get(7).scaleObject(0.15f,0.11f,0.15f);
//        //telinga kiri
//        objectsCony.add(new Ellipsoid(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                Arrays.asList(0.0f, 0.0f, 0.0f),
//                0.5f,
//                0.5f,
//                0.5f,
//                36,
//                18
//        ));
//        objectsCony.get(8).translateObject(1f, 0.4f, 0f);
//        objectsCony.get(8).scaleObject(0.08f, 0.44f, 0.05f);
//        objectsCony.add(new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.976f, 0.565f, 0.635f, 1.0f),
//                Arrays.asList(0.0f, 0.0f, 0.0f),
//                0.5f,
//                0.5f
//        ));
//        objectsCony.get(9).translateObject(1.28f, 0.6f, -2.499f);
//        objectsCony.get(9).scaleObject(0.06f, 0.3f, 0.01f);
            //telinga kanan
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
            objectsCony.get(8).translateObject(-1f, 0.4f, 0f);
            objectsCony.get(8).scaleObject(0.08f, 0.44f, 0.05f);
            objectsCony.add(new Circle(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.976f, 0.565f, 0.635f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.5f,
                    0.5f
            ));
            objectsCony.get(9).translateObject(-1.28f, 0.6f, -2.499f);
            objectsCony.get(9).scaleObject(0.06f, 0.3f, 0.01f);
            //mata
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(10).translateObject(-1f, 1.2f, -3.2f);
            objectsCony.get(10).scaleObject(0.04f, 0.04f, 0.04f);
            objectsCony.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(11).translateObject(1f, 1.2f, -3.2f);
            objectsCony.get(11).scaleObject(0.04f, 0.04f, 0.04f);
            //hidung
            objectsCony.add(new Circle(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.5f,
                    0.5f
            ));
            objectsCony.get(12).translateObject(0f, 0f, -15f);
            objectsCony.get(12).scaleObject(0.05f, 0.04f, 0.01f);
            objectsCony.add(new EllipticParaboloid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
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
            objectsCony.get(13).translateObject(0f, 0f, -20f);
            objectsCony.get(13).scaleObject(0.02f, 0.013f, 0.0083f);
            //blushes
            objectsCony.add(new Circle(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.941f, 0.80f, 0.816f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.5f,
                    0.5f
            ));
            objectsCony.get(14).translateObject(1.72f, 0f, -14f);
            objectsCony.get(14).scaleObject(0.05f, 0.025f, 0.01f);
            objectsCony.add(new Circle(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.941f, 0.80f, 0.816f, 1.0f),
                    Arrays.asList(0.0f, 0.0f, 0.0f),
                    0.5f,
                    0.5f
            ));
            objectsCony.get(15).translateObject(-1.72f, 0f, -14f);
            objectsCony.get(15).scaleObject(0.05f, 0.025f, 0.01f);
            //bowtie
            objectsCony.add(new Cone(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(16).scaleObject(0.005f,0.02f,0.05f);
            objectsCony.get(16).translateObject(0.15f,-0.19f,0.02f);
            objectsCony.get(16).rotateObject((float)Math.toRadians(95),0f,1f,0f);
            objectsCony.add(new Cone(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(17).scaleObject(0.005f,0.02f,0.05f);
            objectsCony.get(17).translateObject(-0.15f,-0.19f,0.02f);
            objectsCony.get(17).rotateObject((float)Math.toRadians(95),0f,-1f,0f);
            //hat
            objectsCony.add(new CylinderOriginal(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(18).scaleObject(0.15f,0.15f,0.25f);
            objectsCony.get(18).translateObject(0.01f,0.0f,-0.15f);
            objectsCony.get(18).rotateObject((float)Math.toRadians(90),1f,0f,-0.5f);
            objectsCony.add(new CylinderOriginal(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(19).scaleObject(0.2f,0.2f,0.0f);
            objectsCony.get(19).translateObject(0.01f,0.0f,-0.15f);
            objectsCony.get(19).rotateObject((float)Math.toRadians(90),1f,0f,-0.5f);
            //mulut
            objectsCony.add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(20).scaleObject(0.014f,0.075f,0.0f);
            objectsCony.get(20).translateObject(0f,-0.033f,-0.149f);
            objectsCony.add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(21).scaleObject(0.05f,0.014f,0.0f);
            objectsCony.get(21).translateObject(0.015f,-0.049f,-0.145f);
            objectsCony.add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(22).scaleObject(0.05f,0.014f,0.0f);
            objectsCony.get(22).translateObject(-0.015f,-0.049f,-0.145f);
            objectsCony.add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(23).scaleObject(0.07f,0.014f,0.0f);
            objectsCony.get(23).translateObject(0.01f,-0.064f,-0.14f);
            objectsCony.get(23).rotateObject((float)Math.toRadians(34f),0.1f,0f,1f);
            objectsCony.add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsCony.get(24).scaleObject(0.07f,0.014f,0.0f);
            objectsCony.get(24).translateObject(-0.01f,-0.064f,-0.14f);
            objectsCony.get(24).rotateObject((float)Math.toRadians(34f),0.1f,0f,-1f);
        }

        //leonard
        {
            //kepala
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menebal
            objectsLeonard.get(0).scaleObject(0.6f,0.4f,0.3f);

            //badan
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsLeonard.get(1).translateObject(0f,-0.6f,0f);
            objectsLeonard.get(1).scaleObject(0.32f,0.45f,0.32f);

            //tangan kanan
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(2).translateObject(-0.3f,-0.8f,0f);
            //melebar, meninggi, menebal
            objectsLeonard.get(2).scaleObject(0.15f,0.38f,0.15f);
            objectsLeonard.get(2).rotateObject(0.5f,0.0f,0f,-1f);

            //tangan kiri
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(3).translateObject(0.3f,-0.8f,0f);
            //melebar, meninggi, menebal
            objectsLeonard.get(3).scaleObject(0.15f,0.38f,0.15f);
            objectsLeonard.get(3).rotateObject(0.5f,0.0f,0f,1f);

            //kaki kanan
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(4).translateObject(-0.5f,-1f,0f);
            //melebar, meninggi, menebal
            objectsLeonard.get(4).scaleObject(0.16f,0.43f,0.15f);

            //kaki kiri
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    // atur warna
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(5).translateObject(0.5f,-1f,0f);
            //melebar, meninggi, menebal
            objectsLeonard.get(5).scaleObject(0.16f,0.43f,0.15f);

            //mata kanan
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal+
            objectsLeonard.get(6).scaleObject(0.15f,0.2f,0.15f);
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(6).translateObject(0.14f,0.22f,0f);

            //mata kiri
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal+
            objectsLeonard.get(7).scaleObject(0.15f,0.2f,0.15f);
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(7).translateObject(-0.14f,0.22f,0f);

            //telapak tangan kiri
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(8).translateObject(4.3f,-1.3f,0f);
            //melebar, meninggi, menebal
            objectsLeonard.get(8).scaleObject(0.105f,0.138f,0.15f);
            objectsLeonard.get(8).rotateObject(0.55f,0.0f,0f,-1f);

            //telapak tangan kanan
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(9).translateObject(-4.3f,-1.3f,0f);
            //melebar, meninggi, menebal
            objectsLeonard.get(9).scaleObject(0.105f,0.138f,0.15f);
            objectsLeonard.get(9).rotateObject(0.55f,0.0f,0f,1f);

            //telapak kaki kiri
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(10).translateObject(0.6f,-5.5f,0f);
            //melebar, meninggi, menebal
            objectsLeonard.get(10).scaleObject(0.15f,0.11f,0.15f);

            //telapak kaki kanan
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    // atur warna
                    new Vector4f(0.15f,0.65f,0.2f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(11).translateObject(-0.6f,-5.5f,0f);
            //melebar, meninggi, menebal
            objectsLeonard.get(11).scaleObject(0.15f,0.11f,0.15f);

            //putih mata kanan
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(1.0f,1.0f,1.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal+
            objectsLeonard.get(12).scaleObject(0.1f,0.14f,0.05f);
            //geser kiri- kanan+, bawah- atas+, maju(dorong)+ mundur(tarik)-
            objectsLeonard.get(12).translateObject(0.14f,0.22f,-0.05f);

            //putih mata kiri
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(1.0f,1.0f,1.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal+
            objectsLeonard.get(13).scaleObject(0.1f,0.14f,0.05f);
            //geser kiri- kanan+, bawah- atas+, maju(dorong)+ mundur(tarik)-
            objectsLeonard.get(13).translateObject(-0.14f,0.22f,-0.05f);

            //hitam mata kanan
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(0.0f,0.0f,0.0f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal+
            objectsLeonard.get(14).scaleObject(0.07f,0.11f,0.04f);
            //geser kiri- kanan+, bawah- atas+, maju(dorong)+ mundur(tarik)-
            objectsLeonard.get(14).translateObject(0.126f,0.22f,-0.059f);

            //hitam mata kiri
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(0.0f,0.0f,0.0f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal+
            objectsLeonard.get(15).scaleObject(0.07f,0.11f,0.04f);
            //geser kiri- kanan+, bawah- atas+, maju(dorong)+ mundur(tarik)-
            objectsLeonard.get(15).translateObject(-0.154f,0.22f,-0.059f);

            //hidung kanan
            objectsLeonard.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(0.0f,0.0f,0.0f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal+
            objectsLeonard.get(16).scaleObject(0.038f,0.04f,0.03f);
            //geser kiri- kanan+, bawah- atas+, maju(dorong)+ mundur(tarik)-
            objectsLeonard.get(16).translateObject(0.03f,0.14f,-0.095f);

            //hidung kiri
            objectsLeonard.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(0.0f,0.0f,0.0f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal+
            objectsLeonard.get(17).scaleObject(0.038f,0.04f,0.03f);
            //geser kiri- kanan+, bawah- atas+, maju(dorong)+ mundur(tarik)-
            objectsLeonard.get(17).translateObject(-0.03f,0.14f,-0.095f);

            //garis lurus mulut kiri
            objectsLeonard.add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(0.0f,0.0f,0.0f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal+
            objectsLeonard.get(18).scaleObject(0.15f,0.03f,0.03f);
            //geser kiri- kanan+, bawah- atas+, maju(dorong)+ mundur(tarik)-
            objectsLeonard.get(18).translateObject(-0.02f,0.05f,-0.14f);
            // miring kiri\- kanan/+,naik- turun+ hilang
            objectsLeonard.get(18).rotateObject(-0.55f,0f,-0.5f,1f);

            //garis mulut lurus kanan
            objectsLeonard.add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(0.0f,0.0f,0.0f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal+
            objectsLeonard.get(19).scaleObject(0.15f,0.03f,0.03f);
            //geser kiri- kanan+, bawah- atas+, maju(dorong)+ mundur(tarik)-
            objectsLeonard.get(19).translateObject(0.02f,0.05f,-0.14f);
            // miring kiri\- kanan/+,naik- turun+ hilang
            objectsLeonard.get(19).rotateObject(0.55f,0f,-0.5f,1f);

            //topi cone natal merah
            objectsLeonard.add(new EllipticConeLeonard(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(1f,0f,0f,0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal
            objectsLeonard.get(20).scaleObject(0.15f,0.15f,0.15f);
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(20).translateObject(0.0f,0.43f,0f);

            //topi cone natal putih
            objectsLeonard.add(new EllipticConeLeonard(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(1f,1f,1f,1f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal
            objectsLeonard.get(21).scaleObject(0.17f,0.0f,0.17f);
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(21).translateObject(0.0f,0.2f,0f);

            //topi bulat natal putih
            objectsLeonard.add(new Sphere(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    //warna
                    new Vector4f(1f,1f,1f,1f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //melebar, meninggi, menipis- menebal
            objectsLeonard.get(22).scaleObject(0.05f,0.05f,0.05f);
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(22).translateObject(0.005f,0.44f,0f);

            //ikat pinggang hitam
            objectsLeonard.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(23).translateObject(0f,-2.25f,0f);
            //melebar, meninggi, menipis- menebal
            objectsLeonard.get(23).scaleObject(0.35f,0.15f,0.35f);

            //ikat pinggang kotak kuning
            objectsLeonard.add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f,1.0f,0.0f,0.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            //geser kiri- kanan+, bawah- atas+, dorong
            objectsLeonard.get(24).translateObject(0f,-1.7f,-0.59f);
            //melebar, meninggi, menipis- menebal
            objectsLeonard.get(24).scaleObject(0.22f,0.2f,0.2f);
        }

        //sally
        {
            //kepala
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f,0.8f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(0).scaleObject(0.4f,0.4f,0.4f);

            //badan
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f,0.8f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(1).translateObject(0f,-0.6f,0f);
            objectsSally.get(1).scaleObject(0.4f,0.42f,0.38f);

            //tangan kanan
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f,0.8f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(2).translateObject(-0.25f,-0.9f,0f);
            objectsSally.get(2).scaleObject(0.15f,0.38f,0.1f);
            objectsSally.get(2).rotateObject(0.5f,0.0f,0f,-1f);

            //tangan kiri
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f,0.8f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(3).translateObject(0.25f,-0.9f,0f);
            objectsSally.get(3).scaleObject(0.15f,0.38f,0.1f);
            objectsSally.get(3).rotateObject(0.5f,0.0f,0f,1f);

            //kaki kanan
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f,0.4f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(4).translateObject(-0.45f,-0.9f,0f);
            objectsSally.get(4).scaleObject(0.12f,0.42f,0.15f);

            //kaki kiri
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f,0.4f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(5).translateObject(0.45f,-0.9f,0f);
            objectsSally.get(5).scaleObject(0.12f,0.42f,0.15f);

            //mata kiri
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(6).translateObject(-0.7f,0.6f,-0.6f);
            objectsSally.get(6).scaleObject(0.06f,0.06f,0.2f);

            //mata kanan
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0.0f,0.0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(7).translateObject(0.7f,0.6f,-0.6f);
            objectsSally.get(7).scaleObject(0.06f,0.06f,0.2f);

            //mulut atas
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f,0.4f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(8).translateObject(0.f,-0.55f,-0.6f);
            objectsSally.get(8).scaleObject(0.14f,0.06f,0.2f);

            //mulut bwh
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f,0.4f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(9).translateObject(0.f,-0.78f,-0.6f);
            objectsSally.get(9).scaleObject(0.14f,0.066f,0.2f);

            //telapak kaki kiri
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    // atur warna
                    new Vector4f(1.0f,0.4f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(10).translateObject(-0.55f,-5.f,-0.1f);
            objectsSally.get(10).scaleObject(0.10f,0.11f,0.15f);

            //telapak kaki kiri
            objectsSally.add(new Ellipsoid(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    // atur warna
                    new Vector4f(1.0f,0.4f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(11).translateObject(0.55f,-5.f,-0.1f);
            objectsSally.get(11).scaleObject(0.10f,0.11f,0.15f);

            //surat
            objectsSally.add(new Box(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(1.0f,1f,1f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(12).translateObject(0.25f,-1.96f,0f);
            objectsSally.get(12).scaleObject(0.45f,0.3f,0.03f);
            objectsSally.get(12).rotateObject(0.45f,0.0f,0f,1f);

            //dasi
            objectsSally.add(new EllipticCone(
                    Arrays.asList(
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.vert"
                                            , GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData
                                    ("resources/shaders/scene.frag"
                                            , GL_FRAGMENT_SHADER)
                    ),
                    new ArrayList<>(),
                    new Vector4f(0f,0f,0.0f,1.0f),
                    Arrays.asList(0.0f,0.0f,0.0f),
                    0.5f,
                    0.5f,
                    0.5f,
                    36,
                    18
            ));
            objectsSally.get(13).translateObject(10f,0f,-7.9f);
            objectsSally.get(13).scaleObject(0.015f,0.03f,0.02f);
            objectsSally.get(13).rotateObject(1.6f,0f,0f,-1f);
        }

        //pindah posisi karakter
        for (Object object : objectsCony){
            object.translateObject(-0.8f,0.08f,0f);
            object.scaleObject(0.7f,0.7f,0.7f);
        }
        for (Object object : objectsBrown){
            object.translateObject(-0.25f,0.08f,0f);
            object.scaleObject(0.7f,0.7f,0.6f);
        }
        for (Object object : objectsLeonard){
            object.translateObject(0.4f,0.09f,0f);
            object.scaleObject(0.6f,0.6f,0.6f);
        }
        for (Object object : objectsSally){
            object.translateObject(0.8f,-0.2f,0f);
            object.scaleObject(0.5f,0.5f,0.5f);
        }
    }

    public void input() {
        if (mouseInput.isLeftButtonPressed()) {
            Vector2f pos = mouseInput.getCurrentPos();
//            System.out.println("x : "+pos.x+" y : "+pos.y);
            pos.x = (pos.x - (window.getWidth()) / 2.0f) /
                    (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) /
                    (-window.getHeight() / 2.0f);
            //System.out.println("x : "+pos.x+" y : "+pos.y);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
                System.out.println("x : " + pos.x + " y : " + pos.y);
//                objectsPointsControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
            }
        }
        if (window.isKeyPressed(GLFW_KEY_X)) {
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(0.6f), 1.0f, 0.0f, 0.0f);
            }
//            stripMerah.rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_Y)) {
            setYbadan(0.6f);
            for (Object object : objectsBrown) {
//                object.rotateObject((float) Math.toRadians(0.6f), 0.0f, 1.0f, 0.0f);
                object.rotateObjectOnPoint(1f, 0f, 1f, 0f, objectsBrown.get(0).getCpx(), objectsBrown.get(0).getCpy(), objectsBrown.get(0).getCpz());
            }
//            stripMerah.rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(0.6f), 0.0f, 0.0f, 1.0f);
            }
//            stripMerah.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
        }

        //animasi jalan kaki tgn juga gerak
        if (window.isKeyPressed(GLFW_KEY_R)) {
            float degree = 0.7f;
            System.out.println("count degree kaki: " + counterDegreeKaki);
            if (counterDegreeKaki >= 60f) {
                gantiArah *= -1;
                counterDegreeKaki = 0;
                System.out.println("ganti arah");
            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
            }
            //kaki kanan
            List<Float> tempp = new ArrayList<>(objectsBrown.get(4).getCenterPoint());
            objectsBrown.get(4).translateObject(tempp.get(0)*-1, tempp.get(1)*-1, tempp.get(2)*-1);
            objectsBrown.get(4).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(4).translateObject(tempp.get(0)*1, tempp.get(1)*1, tempp.get(2)*1);
            //kaki kiri
            List<Float> temp1 = new ArrayList<>(objectsBrown.get(5).getCenterPoint());
            objectsBrown.get(5).translateObject(temp1.get(0)*-1,temp1.get(1)*-1,temp1.get(2)*-1);
            objectsBrown.get(5).rotateObject((float) Math.toRadians(gantiArah * (-degree)), 1f, 0f, 0f);
            objectsBrown.get(5).translateObject(temp1.get(0)*1,temp1.get(1)*1,temp1.get(2)*1);
            //telapak kaki kanan
            objectsBrown.get(6).translateObject(tempp.get(0)*-1, tempp.get(1)*-1, tempp.get(2)*-1);
            objectsBrown.get(6).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(6).translateObject(tempp.get(0)*1, tempp.get(1)*1, tempp.get(2)*1);
            //telapak kaki kiri
            objectsBrown.get(7).translateObject(temp1.get(0)*-1,temp1.get(1)*-1,temp1.get(2)*-1);
            objectsBrown.get(7).rotateObject((float) Math.toRadians(gantiArah * (-degree)), 1f, 0f, 0f);
            objectsBrown.get(7).translateObject(temp1.get(0)*1,temp1.get(1)*1,temp1.get(2)*1);
            //tangan kanan
            List<Float> temp2 = new ArrayList<>(objectsBrown.get(2).getCenterPoint());
            objectsBrown.get(2).translateObject(temp2.get(0)*-1,temp2.get(1)*-1,temp2.get(2)*-1);
            objectsBrown.get(2).rotateObject((float)Math.toRadians(gantiArah*(-degree)), 1f, 0f,0f);
            objectsBrown.get(2).translateObject(temp2.get(0)*1,temp2.get(1)*1,temp2.get(2)*1);
            //tangan kiri
            List<Float> temp3 = new ArrayList<>(objectsBrown.get(3).getCenterPoint());
            objectsBrown.get(3).translateObject(temp3.get(0)*-1,temp3.get(1)*-1,temp3.get(2)*-1);
            objectsBrown.get(3).rotateObject((float)Math.toRadians(gantiArah*degree), 1f, 0f,0f);
            objectsBrown.get(3).translateObject(temp3.get(0)*1,temp3.get(1)*1,temp3.get(2)*1);
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
            }
            counterDegreeKaki += degree;
        }

        //animasi kepala geleng2
        if(window.isKeyPressed(GLFW_KEY_N)){
            float degree = 1f;
            System.out.println("count degree kaki: " + counterDegreeGeleng);
            if (counterDegreeGeleng >= 90f) {
                gantiArah *= -1;
                counterDegreeGeleng = 0;
                System.out.println("ganti arah");
            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
            }
            //kepala
            List<Float> tempp = new ArrayList<>(objectsBrown.get(0).getCenterPoint());
            objectsBrown.get(0).translateObject(tempp.get(0)*-1, tempp.get(1)*-1, tempp.get(2)*-1);
            objectsBrown.get(0).rotateObject((float) Math.toRadians(gantiArah * degree), 0f, 1f, 0f);
            objectsBrown.get(0).translateObject(tempp.get(0)*1, tempp.get(1)*1, tempp.get(2)*1);
            //pacifier
            objectsBrown.get(9).translateObject(tempp.get(0)*-1, tempp.get(1)*-1, tempp.get(2)*-1);
            objectsBrown.get(9).rotateObject((float) Math.toRadians(gantiArah * degree), 0f, 1f, 0f);
            objectsBrown.get(9).translateObject(tempp.get(0)*1, tempp.get(1)*1, tempp.get(2)*1);
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
            }
            counterDegreeGeleng += degree;
        }

        //animasi kepala mantuk2
        if(window.isKeyPressed(GLFW_KEY_M)){
            float degree = 1f;
            System.out.println("count degree kaki: " + counterDegreeKaki);
            if (counterDegreeKaki >= 60f) {
                gantiArah *= -1;
                counterDegreeKaki = 0;
                System.out.println("ganti arah");
            }
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(-ybadan), 0f, 1f, 0f);
            }
            List<Float> tempp = new ArrayList<>(objectsBrown.get(0).getCenterPoint());
            objectsBrown.get(0).translateObject(tempp.get(0)*-1, tempp.get(1)*-1, tempp.get(2)*-1);
            objectsBrown.get(0).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(0).translateObject(tempp.get(0)*1, tempp.get(1)*1, tempp.get(2)*1);

            objectsBrown.get(9).translateObject(tempp.get(0)*-1, tempp.get(1)*-1, tempp.get(2)*-1);
            objectsBrown.get(9).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(9).translateObject(tempp.get(0)*1, tempp.get(1)*1, tempp.get(2)*1);
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
            }
            counterDegreeKaki += degree;
        }

        if (window.isKeyPressed(GLFW_KEY_Q)) {
            setYbadan(0.5f);
            float degree = 0.5f;
            for (Object i : objectsBrown) {
//                    i.rotateObject((float)Math.toRadians(1f), 0f, 0f, 1f);
                i.rotateObjectOnPoint(1f, 0f, 0f, 1f, objectsBrown.get(0).getCpx(), objectsBrown.get(0).getCpy(), objectsBrown.get(0).getCpz());
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            setYbadan(0.5f);
            for (Object i : objectsBrown) {
//                    i.rotateObject(-1f, 0, 0, 1);
                i.rotateObjectOnPoint(-1f, 0f, 0f, 1f, objectsBrown.get(0).getCpx(), objectsBrown.get(0).getCpy(), objectsBrown.get(0).getCpz());
            }
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            setYbadan(0.5f);
            for (Object i : objectsBrown) {
//                    i.rotateObject(1f, 1, 0, 0);
                //logic: object i rotasi terhadap centerpoint object parent (dalam case ini kepala)
                i.rotateObjectOnPoint(1f, 1f, 0f, 0f, objectsBrown.get(0).getCpx(), objectsBrown.get(0).getCpy(), objectsBrown.get(0).getCpz());
            }
        }

        if (window.isKeyPressed(GLFW_KEY_S)) {
            setYbadan(0.5f);
            for (Object i : objectsBrown) {
//                    i.rotateObject(-1f, 1, 0, 0);
                i.rotateObjectOnPoint(-1f, 1f, 0f, 0f, objectsBrown.get(0).getCpx(), objectsBrown.get(0).getCpy(), objectsBrown.get(0).getCpz());
            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            setYbadan(0.5f);
            for (Object i : objectsBrown) {
//                    i.rotateObject(1f, 0, 1, 0);
                i.rotateObjectOnPoint(1f, 0f, 1f, 0f, objectsBrown.get(0).getCpx(), objectsBrown.get(0).getCpy(), objectsBrown.get(0).getCpz());
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            setYbadan(-0.5f);
            for (Object i : objectsBrown) {
//                    i.rotateObject(-1f, 0, 1, 0);
                i.rotateObjectOnPoint(-1f, 0f, 1f, 0f, objectsBrown.get(0).getCpx(), objectsBrown.get(0).getCpy(), objectsBrown.get(0).getCpz());
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (Object i : objectsBrown) {
                i.translateObject(0f, 0f, 0.01f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (Object i : objectsBrown) {
                i.translateObject(0f, 0f, -0.01f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (Object i : objectsBrown) {
                i.translateObject(0f, 0.01f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (Object i : objectsBrown) {
                i.translateObject(0f, -0.01f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (Object i : objectsBrown) {
                i.translateObject(-0.01f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (Object i : objectsBrown) {
                i.translateObject(0.01f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            camera.moveForward(0.02f);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveBackwards(0.02f);
        }
    }


    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.678f, 0.847f, 0.902f,
                    0.0f);
            GL.createCapabilities();
            input();

            //code
            for(Object object: objectsBrown){
//                object.draw(camera,projection);
                object.draw();
                for (Object childObject : object.getChildObject()) {
//                    childObject.draw(camera,projection);
                    childObject.draw();
                }
            }

            for(Object object: objectsLeonard){
                object.draw();
            }

            for(Object object: objectsCony){
                object.draw();
            }

            for(Object object: objectsSally){
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
}