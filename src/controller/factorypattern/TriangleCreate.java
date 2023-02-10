package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;

public class TriangleCreate implements InterShapeCreate {
    private final InterShape shape;
    Polygon triangle;

    public TriangleCreate(InterShape Shape ) {
        this.shape = Shape;
    }

    public Shape shapeDrawing()
    {

        Point startPoint = shape.getPressedPoint();
        Point endPoint = shape.getReleasedPoint();

        int x1 = startPoint.x;
        int y1 = startPoint.y;
        int x2 = endPoint.x;
        int y2 = endPoint.y;
        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;
        int width = Math.abs(x2 - x1);
        int height = (int) Math.sqrt((width * width) - ((width / 2) * (width)));
        int[] xPoints = {midX - (width / 2), midX + (width / 2), midX};
        int[] yPoints = {midY + (height / 2), midY + (height / 2), midY - (height / 2)};
        triangle = new Polygon(xPoints, yPoints, 3);
        return triangle;

    }
}
