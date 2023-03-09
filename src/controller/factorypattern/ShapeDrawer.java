package controller.factorypattern;

import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;
import view.strategypattern.Coloring;
import view.strategypattern.Outline;
import view.strategypattern.OutlineAndSolidFill;
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
            InterShapeCreate shapeDraw = new RectangleCreate(shape);
            drawShape = shapeDraw.shapeDrawing();
        }
        else if (shapeType == ShapeType.ELLIPSE)
        {
            InterShapeCreate shapeDraw = new EllipseCreate(shape);
            drawShape = shapeDraw.shapeDrawing();
        }
        else if (shapeType == ShapeType.TRIANGLE)
        {
            InterShapeCreate shapeDraw = new TriangleCreate(shape);
            drawShape = shapeDraw.shapeDrawing();
        }
        else if (shapeType == ShapeType.STAR)
        {
            InterShapeCreate shapeDraw = new StarCreate(shape);
            drawShape = shapeDraw.shapeDrawing();
        }
        else if (shapeType == ShapeType.DIAMOND)
        {
            InterShapeCreate shapeDraw = new DiamondCreate(shape);
            drawShape = shapeDraw.shapeDrawing();
        }
        else if (shapeType == ShapeType.ROUNDED_RECTANGLE)
        {
            InterShapeCreate shapeDraw = new RoundedRectangleCreate(shape);
            drawShape = shapeDraw.shapeDrawing();
        }
        else if (shapeType == ShapeType.RECTANGLE_CALLOUT)
        {
            InterShapeCreate shapeDraw = new RectangleCalloutCreate(shape);
            drawShape = shapeDraw.shapeDrawing();
        }
        else if (shapeType == ShapeType.OCTAGON)
        {
            InterShapeCreate shapeDraw = new OctagonCreate(shape);
            drawShape = shapeDraw.shapeDrawing();
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
        else if (shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN)
        {
            coloring.shadingColoring(new OutlineAndSolidFill(drawShape, shape, g2D));
        }
        coloring.implementShading();
    }
}
