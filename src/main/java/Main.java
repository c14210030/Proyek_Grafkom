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
    private ArrayList<Object> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl
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

    public void init() {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0,0,0.5f);
        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(30.0f));
        mouseInput = window.getMouseInput();
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
                object.rotateObject((float) Math.toRadians(0.6f), 0.0f, 1.0f, 0.0f);
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
            //kepala
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
            for (Object i : objectsBrown) {
//                    i.rotateObject(1f, 0, 0, 1);
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
//            for (Object object : objects) {
//                object.draw();
//                for (Object childObject : object.getChildObject()) {
//                    childObject.draw();
//                }
//            }

            for(Object object: objectsBrown){
//                object.draw(camera,projection);
                object.draw();
                for (Object childObject : object.getChildObject()) {
//                    childObject.draw(camera,projection);
                    childObject.draw();
                }
            }

//            stripMerah.drawWithInput(GL_LINE_STRIP);


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