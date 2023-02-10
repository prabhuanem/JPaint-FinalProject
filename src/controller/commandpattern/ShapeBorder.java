package controller.commandpattern;

import view.interfaces.IBorder;

import java.awt.*;

public class ShapeBorder implements IBorder {
    private final Point clickPoint;
    private final Point leftPoint;
    private int X, Y, breadth, length;

    public ShapeBorder(Point clickPoint, Point leftPoint) {
        this.clickPoint = clickPoint;
        this.leftPoint = leftPoint;
        CoordinateXAndY();
    }

    public void CoordinateXAndY() {
        int x1 = clickPoint.x;
        int y1 = clickPoint.y;
        int x2 = leftPoint.x;
        int y2 = leftPoint.y;

        this.X = Math.min(x1, x2);
        this.Y = Math.min(y1, y2);
        this.breadth = Math.abs(x1 - x2);
        this.length = Math.abs(y1 - y2);
    }

    @Override
    public int coordX() {
        return this.X;
    }
    @Override
    public int coordY() {
        return this.Y;
    }
    @Override
    public int getLength() {
        return this.length;
    }
    @Override
    public int getBreadth() {
        return this.breadth;
    }
}
