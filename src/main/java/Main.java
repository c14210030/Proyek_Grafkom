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
    private ArrayList<Object> objectsBrown
            = new ArrayList<>();
    private ArrayList<Object> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    private EllipticCone stripMerah;
    private MouseInput mouseInput;
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
    boolean babify = false;
    Brown brown = new Brown();

    public void init() {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0, 0, 0.5f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(30.0f));
        mouseInput = window.getMouseInput();
        //code
//        Brown brown = new Brown();
        brown.init(objectsBrown);
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
            objectsBrown.get(4).translateObject(tempp.get(0) * -1, tempp.get(1) * -1, tempp.get(2) * -1);
            objectsBrown.get(4).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(4).translateObject(tempp.get(0) * 1, tempp.get(1) * 1, tempp.get(2) * 1);
            //kaki kiri
            List<Float> temp1 = new ArrayList<>(objectsBrown.get(5).getCenterPoint());
            objectsBrown.get(5).translateObject(temp1.get(0) * -1, temp1.get(1) * -1, temp1.get(2) * -1);
            objectsBrown.get(5).rotateObject((float) Math.toRadians(gantiArah * (-degree)), 1f, 0f, 0f);
            objectsBrown.get(5).translateObject(temp1.get(0) * 1, temp1.get(1) * 1, temp1.get(2) * 1);
            //telapak kaki kanan
            objectsBrown.get(6).translateObject(tempp.get(0) * -1, tempp.get(1) * -1, tempp.get(2) * -1);
            objectsBrown.get(6).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(6).translateObject(tempp.get(0) * 1, tempp.get(1) * 1, tempp.get(2) * 1);
            //telapak kaki kiri
            objectsBrown.get(7).translateObject(temp1.get(0) * -1, temp1.get(1) * -1, temp1.get(2) * -1);
            objectsBrown.get(7).rotateObject((float) Math.toRadians(gantiArah * (-degree)), 1f, 0f, 0f);
            objectsBrown.get(7).translateObject(temp1.get(0) * 1, temp1.get(1) * 1, temp1.get(2) * 1);
            //tangan kanan
            List<Float> temp2 = new ArrayList<>(objectsBrown.get(2).getCenterPoint());
            objectsBrown.get(2).translateObject(temp2.get(0) * -1, temp2.get(1) * -1, temp2.get(2) * -1);
            objectsBrown.get(2).rotateObject((float) Math.toRadians(gantiArah * (-degree)), 1f, 0f, 0f);
            objectsBrown.get(2).translateObject(temp2.get(0) * 1, temp2.get(1) * 1, temp2.get(2) * 1);
            //tangan kiri
            List<Float> temp3 = new ArrayList<>(objectsBrown.get(3).getCenterPoint());
            objectsBrown.get(3).translateObject(temp3.get(0) * -1, temp3.get(1) * -1, temp3.get(2) * -1);
            objectsBrown.get(3).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(3).translateObject(temp3.get(0) * 1, temp3.get(1) * 1, temp3.get(2) * 1);
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
            }
            counterDegreeKaki += degree;
        }

        //animasi kepala geleng2
        if (window.isKeyPressed(GLFW_KEY_N)) {
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
            objectsBrown.get(0).translateObject(tempp.get(0) * -1, tempp.get(1) * -1, tempp.get(2) * -1);
            objectsBrown.get(0).rotateObject((float) Math.toRadians(gantiArah * degree), 0f, 1f, 0f);
            objectsBrown.get(0).translateObject(tempp.get(0) * 1, tempp.get(1) * 1, tempp.get(2) * 1);
            //pacifier
            objectsBrown.get(9).translateObject(tempp.get(0) * -1, tempp.get(1) * -1, tempp.get(2) * -1);
            objectsBrown.get(9).rotateObject((float) Math.toRadians(gantiArah * degree), 0f, 1f, 0f);
            objectsBrown.get(9).translateObject(tempp.get(0) * 1, tempp.get(1) * 1, tempp.get(2) * 1);
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
            }
            counterDegreeGeleng += degree;
        }

        //animasi kepala mantuk2
        if (window.isKeyPressed(GLFW_KEY_M)) {
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
            List<Float> tempp = new ArrayList<>(objectsBrown.get(0).getCenterPoint());
            objectsBrown.get(0).translateObject(tempp.get(0) * -1, tempp.get(1) * -1, tempp.get(2) * -1);
            objectsBrown.get(0).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(0).translateObject(tempp.get(0) * 1, tempp.get(1) * 1, tempp.get(2) * 1);

            objectsBrown.get(9).translateObject(tempp.get(0) * -1, tempp.get(1) * -1, tempp.get(2) * -1);
            objectsBrown.get(9).rotateObject((float) Math.toRadians(gantiArah * degree), 1f, 0f, 0f);
            objectsBrown.get(9).translateObject(tempp.get(0) * 1, tempp.get(1) * 1, tempp.get(2) * 1);
            for (Object object : objectsBrown) {
                object.rotateObject((float) Math.toRadians(ybadan), 0f, 1f, 0f);
            }

            //kepala
//            objectsBrown.get(0).rotateObjectOnPoint(gantiArah*degree, 1f,0f,0f,objectsBrown.get(0).getCpx(), objectsBrown.get(0).getCpy(), objectsBrown.get(0).getCpz());
//            objectsBrown.get(9).rotateObjectOnPoint(gantiArah*degree, 1f,0f,0f,objectsBrown.get(0).getCpx(), objectsBrown.get(0).getCpy(), objectsBrown.get(0).getCpz());
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

        if (window.isKeyPressed(GLFW_KEY_1)) {
            babify = true;
        }

        if (window.isKeyPressed(GLFW_KEY_0)) {
            babify = false;
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

            for (Object object : objectsBrown) {
//                    object.draw();
//                    for (Object childObject : object.getChildObject()) {
//    //                    childObject.draw(camera,projection);
//                        childObject.draw();
//                    }
                //obj 9 pacifer
                //kalau bkn obj 9 draw
                if (object != objectsBrown.get(9)) {
                    object.draw();
                    for (Object childObject : object.getChildObject()) {
//                    childObject.draw(camera,projection);
                        childObject.draw();
                    }
                }
                //kalau obj 9 cek dulu apakah sdh dibabify
                else if (object == objectsBrown.get(9) && babify) {
                    object.draw();
                    for (Object childObject : object.getChildObject()) {
//                    childObject.draw(camera,projection);
                        childObject.draw();
                    }
                }

            }

            for (Object object : bezier5) {
                object.drawLine();
            }
            for (Object object : bezier6) {
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