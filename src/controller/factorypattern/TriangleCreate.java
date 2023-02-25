package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;

public class TriangleCreate implements InterShapeCreate {
    private final InterShape shape;

    public TriangleCreate(InterShape Shape ) {
        this.shape = Shape;
    }

    public Shape shapeDrawing()
    {

        Polygon triangle;
        int nPoints = 3;
        int[] xPoints;
        int[] yPoints;

        int newPointX = shape.pointX();
        int newPointY = shape.pointY();
        int newBreadth = shape.shapeBreadth();
        int newLength = shape.shapeLength();

        xPoints = new int[] {(newPointX + (newPointX + newBreadth)) / 2, newPointX, newPointX + newBreadth };
        yPoints = new int[] {newPointY , newPointY + newLength, newPointY + newLength};
        triangle = new Polygon(xPoints, yPoints, nPoints);
        return triangle;

    }
}
