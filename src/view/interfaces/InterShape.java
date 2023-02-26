package view.interfaces;

import controller.commandpattern.ShapeBorder;
import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public interface InterShape {
    void draw(Graphics2D g);
    int coordX();
    int coordY();
    int breadthDrawing();
    int lengthDrawing();
    Color getPrimaryColor();
    ShapeType getShapeType();
    ShapeShadingType getShadingType();
    Point leftPoint();
    Point clickedPoint();
    Color getSecondaryColor();
    void selectShape(ShapeBorder shapeBorder);

    boolean getSelected();
    void setSelected(boolean selectedStatus);
    void pointSetXCoord(int newX);
    void pointSetYCoord(int newY);
    int getPastedCount();
    void copy();
    void zeroCount();
    int pasteDecrease();
    int pasteIncrease();

}
