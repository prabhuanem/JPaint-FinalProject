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
        Shape drawShape;
        ShapeType shapeType = shape.getShapeType();
        if (Objects.requireNonNull(shapeType) == ShapeType.RECTANGLE)
        {
            InterShapeCreate shapeFactory = new RectangleCreate(shape);
            drawShape = shapeFactory.shapeDrawing();
        }
        else if (shapeType == ShapeType.ELLIPSE)
        {
            InterShapeCreate shapeFactory = new EllipseCreate(shape);
            drawShape = shapeFactory.shapeDrawing();
        }
        else if (shapeType == ShapeType.TRIANGLE)
        {
            InterShapeCreate shapeFactory = new TriangleCreate(shape);
            drawShape = shapeFactory.shapeDrawing();
        }
        else
        {
            throw new IllegalStateException("Unexpected value: " + shape.getShapeType());
        }
        Coloring coloring = new Coloring();
        switch (shape.getShadingType()) {
            default -> coloring.setInterColoring(new SolidColor(drawShape, shape, g2D));
        }
        coloring.executeShadingStrategy();
    }
}
