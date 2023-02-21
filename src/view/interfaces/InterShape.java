package view.interfaces;

import controller.commandpattern.ShapeBorder;
import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public interface InterShape {
    void draw(Graphics2D g);
    int pointX();
    int pointY();
    int shapeBreadth();
    int shapeLength();
    Color getPrimaryColor();
    ShapeType getShapeType();
    ShapeShadingType getShadingType();
    Point leftPoint();
    Point clickedPoint();
    Color getSecondaryColor();
    void selectShape(ShapeBorder shapeBorder);
    void movingShapeDrawn(int deltaX, int deltaY);
    void undoingMovedShape(int deltaX, int deltaY);
    boolean getSelected();
    void setSelected(boolean selectedStatus);
    void pointSetXCoord(int newX);
    void pointSetYCoord(int newY);
    int getPastedCount();
    Shape getShape();
    InterShape clone();

}
