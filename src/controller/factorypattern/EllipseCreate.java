package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipseCreate implements InterShapeCreate {
    private final InterShape shape;

    public EllipseCreate(InterShape Shape ) {
        this.shape = Shape;
    }

    @Override
    public Shape shapeDrawing() {
        Shape ellipse;
        int x = shape.coordX();
        int y = shape.coordY();
        int width = shape.breadthDrawing();
        int height = shape.lengthDrawing();
        ellipse = new Ellipse2D.Double(x, y, width, height);
        return ellipse;
    }

}
