package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedRectangleCreate implements InterShapeCreate {
    private final InterShape drawing;

    public RoundedRectangleCreate(InterShape drawing) {
        this.drawing = drawing;
    }

    @Override
    public Shape shapeDrawing() {
        int x = drawing.coordX();
        int y = drawing.coordY();
        int width = drawing.breadthDrawing();
        int height = drawing.lengthDrawing();
        int arcWidth = 30;
        int arcHeight = 30;
        return new RoundRectangle2D.Double(x, y, width, height, arcWidth, arcHeight);
    }
}
