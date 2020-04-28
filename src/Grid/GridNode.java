package Grid;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class GridNode {

    public static List<GridNode> nodesList = new ArrayList<>();


    protected boolean isObstacle;
    protected boolean isStart;
    protected boolean isEnd;

    protected double x, y, shapeSize;
    protected Circle shape;

    public GridNode() {
        shape = new Circle();
        shape.setCenterX(x);   //réglage de la position, de la taille et de la couleur du cercle
        shape.setCenterY(y);
        shape.setRadius(shapeSize);
        nodesList.add(this);

    }

    public GridNode(double x, double y, boolean isObstacle) {
        shape = new Circle();
        this.x = x;
        this.y = y;
        shape.setCenterX(x);
        shape.setCenterY(y);
        shape.setRadius(shapeSize);
        nodesList.add(this);

    }

    public GridNode(double x, double y, boolean isObstacle, double radius) {
        shape = new Circle();
        this.x = x;
        this.y = y;
        shapeSize = radius;
        shape.setCenterX(x);
        shape.setCenterY(y);
        shape.setRadius(shapeSize);
        nodesList.add(this);
        shape.setRadius(shapeSize);

    }

    public GridNode(int x, int y, boolean isObstacle, double radius, int red, int green, int blue) {
        shape = new Circle();
        this.x = x;
        this.y = y;
        shapeSize = radius;
        shape.setRadius(shapeSize);
        nodesList.add(this);
        shape.setRadius(shapeSize);
        shape.setFill(Color.rgb(red, green, blue));

    }

    public GridNode(int x, int y, boolean isObstacle, boolean isEnd, boolean isStart,
                    double radius, Color color) { //used only this
        this.x = x;
        this.y = y;
        this.isObstacle = isObstacle;
        this.isStart = isStart;
        this.isEnd = isEnd;

        constructShape(radius, color);

        nodesList.add(this);

    }

    public void constructShape(double radius, Color color) {
        shape = new Circle();
        shapeSize = radius;
        shape.setRadius(shapeSize);
        shape.setFill(color);
    }


    public void setSize(int size) {
        shapeSize = size;
        shape.setRadius(shapeSize);
    }

    public void setColor(int red, int green, int blue) {
        shape.setFill(Color.rgb(red, green, blue));

    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        shape.setCenterX(x);
    }

    public double getY() {
        return y;

    }

    public void setY(int y) {
        this.y = y;
        shape.setCenterY(y);
    }

    public Circle getShape() {
        return shape;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public void setObstacle(boolean obstacle) {
        isObstacle = obstacle;
    }


}









