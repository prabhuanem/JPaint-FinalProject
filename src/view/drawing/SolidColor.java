package view.drawing;

import view.interfaces.InterColoring;
import view.interfaces.InterShape;

import java.awt.Shape;
import java.awt.*;

public class SolidColor implements InterColoring {
    private final InterShape shape;
    private final java.awt.Shape shapeToBeDrawn;
    private final Graphics2D g2D;

    public SolidColor(Shape ShapeToBeDrawn, InterShape Shape, Graphics2D G2D) {
        this.shape = Shape;
        this.shapeToBeDrawn = ShapeToBeDrawn;
        this.g2D = G2D;
    }
    @Override
    public void drawWithSelectedShadingType() {
        // g2D.setColor(shape.getPrimaryColor());
        g2D.fill(shapeToBeDrawn);
    }
}
