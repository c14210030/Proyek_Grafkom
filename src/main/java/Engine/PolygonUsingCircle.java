package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class PolygonUsingCircle extends Rectangle{
//    extends rectangle karena mau ambil index nya aja biar ga ush buat lg disini, sbnrnya extends Obj2d jg bisa
    double r, centerX, centerY, vertex;
    int ibo;

    //    polygon using circle class
    public PolygonUsingCircle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index,
                  double r, double centerX, double centerY, int vertex) {
        super(shaderModuleDataList, vertices, color, index);
        this.r = r;
        this.centerX = centerX;
        this.centerY = centerY;
        this.vertex = vertex;

        createPolygon(vertex);

        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    //    symmetric polygons
    public void createPolygon(double vertex){
        double delta = 360/vertex;
//        delta = 0.01f;
//        vertices -> clear
        vertices.clear();
        for(double i = 45; i < 405; i+=delta){
            double x = centerX + r * Math.cos(Math.toRadians(i));
            double y = centerY + r * Math.sin(Math.toRadians(i));
//            System.out.println(x + " ================= " + y);
            vertices.add(new Vector3f((float)x, (float)y, 0.0f));
        }

        setupVAOVBO();
    }

    public void draw(){
        drawSetup();
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
//        glDrawElements(GL_LINES, index.size(), GL_UNSIGNED_INT, 0);

        glDrawArrays(GL_POLYGON,
                0,
                vertices.size());
    }

    public void drawWithInput(int glInput){
        drawSetup();
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(glInput,
                0,
                vertices.size());
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void updateCP(double cpx, double cpy)
    {
        this.centerX = cpx;
        this.centerY = cpy;
        vertices.clear();
        createPolygon(vertex);
    }
}
