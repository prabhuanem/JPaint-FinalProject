package view.drawing;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.Shape;
import java.awt.*;

public class ShapeDrawer {
    private final Graphics2D g2D;
    private InterShapeCreate shapeFactory;
    private Coloring coloring;
    private Shape shapeToBeDrawn;

    public ShapeDrawer(Graphics2D g2D) {
        this.g2D = g2D;
    }

    public void draw(InterShape shape) {
        switch (shape.getShapeType()) {
            default:
                shapeFactory = new RectangleCreate(shape);
                shapeToBeDrawn = shapeFactory.Shapedrawing();
                break;
        }
        coloring = new Coloring();
        switch (shape.getShadingType()) {
            default:
                coloring.setInterColoring(new SolidColor(shapeToBeDrawn, shape, g2D));
                break;
        }
        coloring.executeShadingStrategy();
    }
}
