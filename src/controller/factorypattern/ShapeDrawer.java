package controller.factorypattern;

import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;
import view.strategypattern.Coloring;
import view.strategypattern.Outline;
import view.strategypattern.SolidColor;

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
        ShapeShadingType shadingType = shape.getShadingType();
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
        if (shadingType == ShapeShadingType.FILLED_IN)
        {
            coloring.shadingColoring(new SolidColor(drawShape, shape, g2D));
        }
        else if (shadingType == ShapeShadingType.OUTLINE)
        {
            coloring.shadingColoring(new Outline(drawShape, shape, g2D));
        }
        coloring.implementShading();
    }
}
