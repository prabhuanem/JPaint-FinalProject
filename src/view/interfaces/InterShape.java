package view.interfaces;

import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public interface InterShape {
    void draw(Graphics2D g);
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    Color getPrimaryColor();
    ShapeType getShapeType();
    ShapeShadingType getShadingType();
}
