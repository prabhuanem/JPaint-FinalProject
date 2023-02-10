package view.interfaces;

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
}
