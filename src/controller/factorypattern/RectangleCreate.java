package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class RectangleCreate implements InterShapeCreate {
    private final InterShape shape;

    public RectangleCreate(InterShape Shape ) {
        this.shape = Shape;
    }

    @Override
    public Shape shapeDrawing() {
        Rectangle2D.Double rectangle;
        rectangle = new Rectangle2D.Double(shape.coordX(), shape.coordY(), shape.breadthDrawing(), shape.lengthDrawing());
        return rectangle;
    }
}
