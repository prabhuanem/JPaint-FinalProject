package view.strategypattern;

import view.interfaces.InterColoring;
import view.interfaces.InterShape;

import java.awt.Shape;
import java.awt.*;

public class SolidColor implements InterColoring {
    private final InterShape drawing;
    private final Shape shapeCreated;
    private final Graphics2D g2D;

    public SolidColor(Shape shapeCreated, InterShape drawing, Graphics2D G2D) {
        this.drawing = drawing;
        this.shapeCreated = shapeCreated;
        this.g2D = G2D;
    }
    @Override
    public void shadeDrawing() {
        g2D.setColor(drawing.getPrimaryColor());
        g2D.fill(shapeCreated);
    }
}
