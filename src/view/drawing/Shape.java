package view.drawing;

import controller.factorypattern.ShapeDrawer;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.InterShape;

import java.awt.*;

public class Shape implements InterShape {
    private final Point pressedPoint, releasedPoint;
    private final ShapeType shapeType;
    private final ShapeShadingType shadingType;
    private int X, Y, width, height;
    private final Color firstColor;

    public Shape(Point pressedPoint, Point releasedPoint, ShapeType shapeType, ShapeShadingType shadingType, Color firstColor) {
        this.pressedPoint = pressedPoint;
        this.releasedPoint = releasedPoint;
        this.shapeType = shapeType;
        this.shadingType = shadingType;
        this.firstColor = firstColor;

        getCoordinates();
    }

    public void getCoordinates() {
        this.X = Math.min(pressedPoint.x, releasedPoint.x);
        this.Y = Math.min(pressedPoint.y, releasedPoint.y);
        this.width = Math.max(pressedPoint.x, releasedPoint.x) - X;
        this.height = Math.max(pressedPoint.y, releasedPoint.y) - Y;
    }

    @Override
    public int pointX() {
        return X;
    }

    @Override
    public int pointY() {
        return Y;
    }

    @Override
    public int shapeBreadth() {
        return width;
    }

    @Override
    public int shapeLength() {
        return height;
    }

    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }

    @Override
    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    @Override
    public void draw(Graphics2D g2D) {
        ShapeDrawer shapeDrawer = new ShapeDrawer(g2D);
        shapeDrawer.draw(this);
    }

    @Override
    public Color getPrimaryColor() {
        return firstColor;
    }
}
