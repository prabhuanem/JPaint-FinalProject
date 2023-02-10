package controller.factorypattern;

import model.ShapeType;
import view.drawing.Coloring;
import view.drawing.SolidColor;
import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.Shape;
import java.awt.*;
import java.util.Objects;

public class ShapeDrawer {
    private final Graphics2D g2D;

    public ShapeDrawer(Graphics2D g2D) {
        this.g2D = g2D;
    }

    public void draw(InterShape shape) {
        Shape shapeToBeDrawn;
        ShapeType shapeType = shape.getShapeType();
        if (Objects.requireNonNull(shapeType) == ShapeType.RECTANGLE)
        {
            InterShapeCreate shapeFactory = new RectangleCreate(shape);
            shapeToBeDrawn = shapeFactory.shapeDrawing();
        }
        else if (shapeType == ShapeType.ELLIPSE)
        {
            InterShapeCreate shapeFactory = new EllipseCreate(shape);
            shapeToBeDrawn = shapeFactory.shapeDrawing();
        }
        else
        {
            throw new IllegalStateException("Unexpected value: " + shape.getShapeType());
        }
        Coloring coloring = new Coloring();
        switch (shape.getShadingType()) {
            default -> coloring.setInterColoring(new SolidColor(shapeToBeDrawn, shape, g2D));
        }
        coloring.executeShadingStrategy();
    }
}
