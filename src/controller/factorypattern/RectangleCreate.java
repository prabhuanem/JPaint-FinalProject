package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class RectangleCreate implements InterShapeCreate {
    private final InterShape drawing;

    public RectangleCreate(InterShape drawing) {
        this.drawing = drawing;
    }

    /**
     * @return - Returns the rectangle shape which is created using "Rectangle2D.Double" method
     */
    @Override
    public Shape shapeDrawing() {
        Rectangle2D.Double rectangle;
        rectangle = new Rectangle2D.Double(drawing.coordX(), drawing.coordY(), drawing.breadthDrawing(), drawing.lengthDrawing());
        return rectangle;
    }
}
