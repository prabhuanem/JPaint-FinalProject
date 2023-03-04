package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;

public class TriangleCreate implements InterShapeCreate {
    private final InterShape drawing;

    public TriangleCreate(InterShape drawing) {
        this.drawing = drawing;
    }

    public Shape shapeDrawing()
    {

        Polygon triangle;
        int nPoints = 3;
        int[] xPoints;
        int[] yPoints;

        int newPointX = drawing.coordX();
        int newPointY = drawing.coordY();
        int newBreadth = drawing.breadthDrawing();
        int newLength = drawing.lengthDrawing();

        xPoints = new int[] {(newPointX + (newPointX + newBreadth)) / 2, newPointX, newPointX + newBreadth };
        yPoints = new int[] {newPointY , newPointY + newLength, newPointY + newLength};
        triangle = new Polygon(xPoints, yPoints, nPoints);
        return triangle;

    }
}
