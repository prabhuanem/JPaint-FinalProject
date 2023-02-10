package view.drawing;

import view.interfaces.InterColoring;
import view.interfaces.InterShape;

import java.awt.Shape;
import java.awt.*;

public class SolidColor implements InterColoring {
    private final InterShape shape;
    private final Shape shapeCreated;
    private final Graphics2D g2D;

    public SolidColor(Shape shapeCreated, InterShape Shape, Graphics2D G2D) {
        this.shape = Shape;
        this.shapeCreated = shapeCreated;
        this.g2D = G2D;
    }
    @Override
    public void solidColor() {
        g2D.setColor(shape.getPrimaryColor());
        g2D.fill(shapeCreated);
    }
}
