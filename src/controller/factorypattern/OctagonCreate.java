package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;
import java.awt.geom.Path2D;

public class OctagonCreate implements InterShapeCreate {
    private final InterShape drawing;

    public OctagonCreate(InterShape drawing) {
        this.drawing = drawing;
    }

    /**
     * @return - Using Path2D double to draw the Octagon by calculating the dimensions and closing the path accordingly to create the shape
     */
    @Override
    public Shape shapeDrawing() {
        Path2D.Double octagon = new Path2D.Double();

        int x = drawing.coordX();
        int y = drawing.coordY();
        int width = drawing.breadthDrawing();
        int height = drawing.lengthDrawing();
        int sideLength = Math.min(width, height);

        int cx = x + width / 2;
        int cy = y + height / 2;
        int r = sideLength / 2;
        double theta = Math.PI / 4.0;

        octagon.moveTo(cx + r * Math.cos(theta), cy + r * Math.sin(theta));

        for (int i = 1; i <= 8; i++) {
            double angle = i * Math.PI / 4.0;
            octagon.lineTo(cx + r * Math.cos(theta + angle), cy + r * Math.sin(theta + angle));
        }

        octagon.closePath();

        return octagon;
    }
}
