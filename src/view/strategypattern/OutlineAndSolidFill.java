package view.strategypattern;

import view.interfaces.InterColoring;
import view.interfaces.InterShape;

import java.awt.*;

public class OutlineAndSolidFill implements InterColoring {

    private final InterShape drawing;
    private final Shape shapeCreated;
    private final Graphics2D g2D;

    public OutlineAndSolidFill(Shape shapeCreated, InterShape drawing, Graphics2D G2D) {
        this.drawing = drawing;
        this.shapeCreated = shapeCreated;
        this.g2D = G2D;
    }

    @Override
    public void shadeDrawing() {
        g2D.setColor(drawing.getPrimaryColor());
        g2D.fill(shapeCreated);
        g2D.setStroke(new BasicStroke(4));
        g2D.setColor(drawing.getSecondaryColor());
        g2D.draw(shapeCreated);

    }
}
