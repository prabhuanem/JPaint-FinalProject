package controller.commandpattern;

import controller.Collision;
import controller.factorypattern.ShapeDrawer;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.InterShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Shape implements InterShape, Cloneable {
    private final Point clickedPoint, leftPoint;
    private final ShapeType shapeType;
    private final ShapeShadingType shadingType;
    private int X, Y, width, height;
    private final Color firstColor, secondColor;
    private boolean selected;

    private final int pastedCount;

    public Shape(Point clickedPoint, Point leftPoint, ShapeType shapeType, ShapeShadingType shadingType, Color firstColor, Color secondColor,boolean selected, int pastedCount) {
        this.clickedPoint = clickedPoint;
        this.leftPoint = leftPoint;
        this.shapeType = shapeType;
        this.shadingType = shadingType;
        this.firstColor = firstColor;
        this.secondColor = secondColor;
        this.selected = selected;
        this.pastedCount = pastedCount;

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

    @Override
    public boolean getSelected() {
        return this.selected;
    }
    @Override
    public void selectShape(ShapeBorder shapeBorder) {
        Collision collision = new Collision(shapeBorder, this);
        this.setSelected(collision.run());
    }
    @Override
    public void setSelected(boolean selectedStatus) {
        this.selected = selectedStatus;
    }

    @Override
    public void movingShapeDrawn(int deltaX, int deltaY) {
        new Move(deltaX, deltaY, this).run();
    }
    @Override
    public void undoingMovedShape(int deltaX, int deltaY) {
        new Move(deltaX, deltaY, this).undo();
    }
    @Override
    public void pointSetXCoord(int newX) { this.X = newX; }
    @Override
    public  void pointSetYCoord(int newY) { this.Y = newY; }
    @Override
    public int getPastedCount() {
        return this.pastedCount;
    }

    @Override
    public java.awt.Shape getShape() {
        if (shapeType == ShapeType.RECTANGLE) {
            return new Rectangle2D.Double(X, Y, width, height);
        } else if (shapeType == ShapeType.ELLIPSE) {
            return new Ellipse2D.Double(X, Y, width, height);
        } else if (shapeType == ShapeType.TRIANGLE) {
            int[] xPoints = {X + width / 2, X, X + width};
            int[] yPoints = {Y, Y + height, Y + height};
            return new Polygon(xPoints, yPoints, 3);
        } else {
            throw new IllegalStateException("Unexpected value: " + shapeType);
        }
    }

    public InterShape clone() {
        try {
            return (InterShape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
