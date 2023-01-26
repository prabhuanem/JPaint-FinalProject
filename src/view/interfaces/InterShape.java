package view.interfaces;

import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public interface InterShape {
    void draw(Graphics2D g);

    boolean getSelected();

    int getX();

    int getY();

    int getWidth();

    int getHeight();

    Point getReleasedPoint();

    Point getPressedPoint();

    ShapeType getShapeType();

    ShapeShadingType getShadingType();
}
