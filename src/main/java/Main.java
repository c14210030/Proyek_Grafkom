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
    private ArrayList<Object> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();

    private MouseInput mouseInput;
    int countDegree = 0;

    public void init() {
        window.init();
        GL.createCapabilities();
        mouseInput = window.getMouseInput();
        //code
        //kepala (parent)
        objects.add(new Ellipsoid(
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
        objects.get(0).scaleObject(0.53f, 0.45f, 0.5f);
        //badan
        objects.get(0).getChildObject().add(new Ellipsoid(
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
        objects.get(0).getChildObject().get(0).scaleObject(0.32f, 0.45f, 0.32f);
        objects.get(0).getChildObject().get(0).translateObject(0f, -0.3f, 0f);
        //tangan kanan
        objects.get(0).getChildObject().add(new Ellipsoid(
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
        objects.get(0).getChildObject().get(1).translateObject(-0.3f, -0.9f, 0f);
        objects.get(0).getChildObject().get(1).scaleObject(0.15f, 0.38f, 0.15f);
        objects.get(0).getChildObject().get(1).rotateObject(0.5f, 0.0f, 0f, -1f);
        //tangan kiri
        objects.get(0).getChildObject().add(new Ellipsoid(
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
        objects.get(0).getChildObject().get(2).translateObject(0.3f, -0.9f, 0f);
        objects.get(0).getChildObject().get(2).scaleObject(0.15f, 0.38f, 0.15f);
        objects.get(0).getChildObject().get(2).rotateObject(0.5f, 0.0f, 0f, 1f);
        //kaki kanan
//        objects.get(0).getChildObject().add(new Ellipsoid(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
//                Arrays.asList(0.0f, 0.0f, 0.0f),
//                0.5f,
//                0.5f,
//                0.5f,
//                36,
//                18
//        ));
//        objects.get(0).getChildObject().get(3).translateObject(-0.5f, -1.1f, 0f);
//        objects.get(0).getChildObject().get(3).scaleObject(0.15f, 0.44f, 0.15f);

        objects.get(0).getChildObject().add(new Cylinder(
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
        objects.get(0).getChildObject().get(3).translateObject(-0.07f, -0.4f, 0f);

        //kaki kiri
//        objects.get(0).getChildObject().add(new Ellipsoid(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.564f, 0.360f, 0.215f, 1.0f),
//                Arrays.asList(0.0f, 0.0f, 0.0f),
//                0.5f,
//                0.5f,
//                0.5f,
//                36,
//                18
//        ));
//        objects.get(0).getChildObject().get(4).translateObject(0.5f, -1.1f, 0f);
//        objects.get(0).getChildObject().get(4).scaleObject(0.15f, 0.44f, 0.15f);

        objects.get(0).getChildObject().add(new Cylinder(
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
        objects.get(0).getChildObject().get(4).translateObject(0.07f, -0.4f, 0f);

        //area mulut
        objects.get(0).getChildObject().add(new Ellipsoid(
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
        objects.get(0).getChildObject().get(5).translateObject(0f, -0.1f, -2.15f);
        objects.get(0).getChildObject().get(5).scaleObject(0.12f, 0.15f, 0.1f);

        //hidung
        objects.get(0).getChildObject().add(new Ellipsoid(
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
        objects.get(0).getChildObject().get(6).translateObject(0f, 0f, -2.15f);
        objects.get(0).getChildObject().get(6).scaleObject(0.1f, 0.1f, 0.1f);

        //mata kanan
        objects.get(0).getChildObject().add(new Ellipsoid(
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
        objects.get(0).getChildObject().get(7).translateObject(-0.03f, 0.08f, -0.225f);

        //mata kiri
        objects.get(0).getChildObject().add(new Ellipsoid(
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
        objects.get(0).getChildObject().get(8).translateObject(0.03f, 0.08f, -0.225f);

        //telinga kanan luar
        objects.get(0).getChildObject().add(new EllipticParaboloid(
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
        objects.get(0).getChildObject().get(9).rotateObject(135f, 0f,1f,0f);
        objects.get(0).getChildObject().get(9).translateObject(-0.14f,0.19f,0f);

        //telinga kiri luar
        objects.get(0).getChildObject().add(new EllipticParaboloid(
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
        objects.get(0).getChildObject().get(10).rotateObject(135f, 0f,1f,0f);
        objects.get(0).getChildObject().get(10).translateObject(0.14f,0.19f,0f);

        //telinga kanan dalam
        objects.get(0).getChildObject().add(new EllipticParaboloid(
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
        objects.get(0).getChildObject().get(11).rotateObject(135f, 0f,1f,0f);
        objects.get(0).getChildObject().get(11).translateObject(-0.139f,0.19f,-0.02f);

        //telinga kiri dalam
        objects.get(0).getChildObject().add(new EllipticParaboloid(
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
        objects.get(0).getChildObject().get(12).rotateObject(135f, 0f,1f,0f);
        objects.get(0).getChildObject().get(12).translateObject(0.139f,0.19f,-0.02f);

        //telapak kaki kanan
        objects.get(0).getChildObject().add(new Ellipsoid(
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
        objects.get(0).getChildObject().get(13).translateObject(-0.07f,-0.67f,-0.02f);

        //telapak kaki kiri
        objects.get(0).getChildObject().add(new Ellipsoid(
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
        objects.get(0).getChildObject().get(14).translateObject(0.07f,-0.67f,-0.02f);
    }

    public void input() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            countDegree++;
            //rotasi terhadap matahari
            objects.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            for (Object child : objects.get(0).getChildObject()) {
                List<Float> temp = new ArrayList<>(child.getCenterPoint());
                //rotasi terhadap sumbu masing-masing planet
                child.translateObject(temp.get(0) * -1, temp.get(1) * -1, temp.get(2) * -1);
                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                child.translateObject(temp.get(0) * 1, temp.get(1) * 1, temp.get(2) * 1);
                for (Object y : objects.get(0).getChildObject().get(1).getChildObject()) {
                    //rotasi terhadap bumi
                    List<Float> temp1 = new ArrayList<>(objects.get(0).getChildObject().get(1).getCenterPoint());
                    y.translateObject(temp1.get(0) * -1, temp1.get(1) * -1, temp1.get(2) * -1);
                    y.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                    y.translateObject(temp1.get(0) * 1, temp1.get(1) * 1, temp1.get(2) * 1);
                    //rotasi terhadap sumbunya sendiri
                    temp1 = new ArrayList<>(objects.get(0).getChildObject().get(1).getChildObject().get(0).getCenterPoint());
                    y.translateObject(temp1.get(0) * -1, temp1.get(1) * -1, temp1.get(2) * -1);
                    y.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                    y.translateObject(temp1.get(0) * 1, temp1.get(1) * 1, temp1.get(2) * 1);
                }
                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            }
        }
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
            for (Object object : objects) {
                object.rotateObject((float) Math.toRadians(0.5f), 1.0f, 0.0f, 0.0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_Y)) {
            for (Object object : objects) {
                object.rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            for (Object object : objects) {
                object.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
            }
        }

    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(1.0f,
                    1.0f, 1.0f,
                    0.0f);
            GL.createCapabilities();
            input();

            //code
            for (Object object : objects) {
                object.draw();
                for (Object childObject: object.getChildObject()){
                    childObject.draw();
                }
            }
            for (Object object : objectsRectangle) {
                object.draw();
            }
            for (Object object : objectsPointsControl) {
                object.drawLine();
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
}