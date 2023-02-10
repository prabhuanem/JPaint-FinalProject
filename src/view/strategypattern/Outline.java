package view.strategypattern;

import view.interfaces.InterColoring;
import view.interfaces.InterShape;

import java.awt.*;

public class Outline implements InterColoring {

    private final InterShape shape;
    private final java.awt.Shape shapeToBeDrawn;
    private final Graphics2D g2D;

    public Outline(Shape ShapeToBeDrawn, InterShape Shape, Graphics2D G2D) {
        this.shape = Shape;
        this.shapeToBeDrawn = ShapeToBeDrawn;
        this.g2D = G2D;
    }
    @Override
    public void shadeDrawing() {
        g2D.setColor(shape.getPrimaryColor());
        g2D.setStroke(new BasicStroke(4));
        g2D.draw(shapeToBeDrawn);
    }
}
