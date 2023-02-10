package controller.commandpattern;

import controller.factorypattern.ShapeDrawer;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.InterShape;

import java.awt.*;

public class Shape implements InterShape {
    private final Point clickedPoint, leftPoint;
    private final ShapeType shapeType;
    private final ShapeShadingType shadingType;
    private int X, Y, width, height;
    private final Color firstColor, secondColor;

    public Shape(Point clickedPoint, Point leftPoint, ShapeType shapeType, ShapeShadingType shadingType, Color firstColor, Color secondColor) {
        this.clickedPoint = clickedPoint;
        this.leftPoint = leftPoint;
        this.shapeType = shapeType;
        this.shadingType = shadingType;
        this.firstColor = firstColor;
        this.secondColor = secondColor;

        getCoordinates();
    }

    public void getCoordinates() {
        this.X = Math.min(clickedPoint.x, leftPoint.x);
        this.Y = Math.min(clickedPoint.y, leftPoint.y);
        this.width = Math.max(clickedPoint.x, leftPoint.x) - X;
        this.height = Math.max(clickedPoint.y, leftPoint.y) - Y;
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

    @Override
    public Point clickedPoint() {
        return clickedPoint;
    }

    @Override
    public Color getSecondaryColor() {
        return secondColor;
    }

    @Override
    public Point leftPoint() {
        return leftPoint;
    }
}
