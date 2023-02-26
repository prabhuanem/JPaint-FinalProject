package controller.commandpattern;

import controller.Collision;
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
    private boolean selected;

    private int pastedCount;

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

    public void movingShapeDrawn(int deltaX, int deltaY) {
        new MoveShape(clickedPoint(), new Point(leftPoint().x + deltaX, leftPoint().y + deltaY), null).run();
    }

    @Override
    public void undoingMovedShape(int deltaX, int deltaY) {
        new MoveShape(clickedPoint(), new Point(leftPoint().x + deltaX, leftPoint().y + deltaY), null).undo();
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
    public void copy() {
        this.resetPastedCount();
        AllShape.copiedItems.add(this);
    }
    @Override
    public void resetPastedCount() {
        pastedCount = 0;
    }
}
