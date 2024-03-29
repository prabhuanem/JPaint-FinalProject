package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;
import java.awt.geom.Path2D;

public class DiamondCreate implements InterShapeCreate {
    private final InterShape drawing;

    /**
     * @param drawing - Drawing the Diamond shape
     */
    public DiamondCreate(InterShape drawing) {
        this.drawing = drawing;
    }

    /**
     * @return - Using Path2D double to draw the diamond by calculating the dimensions and closing the path accordingly to create the shape
     */
    @Override
    public Shape shapeDrawing() {
        Path2D.Double diamond = new Path2D.Double();

        // calculate the points of the diamond
        int centerX = drawing.coordX() + drawing.breadthDrawing() / 2;
        int centerY = drawing.coordY() + drawing.lengthDrawing() / 2;
        int halfWidth = drawing.breadthDrawing() / 2;
        int halfHeight = drawing.lengthDrawing() / 2;

        diamond.moveTo(centerX, centerY - halfHeight);
        diamond.lineTo(centerX + halfWidth, centerY);
        diamond.lineTo(centerX, centerY + halfHeight);
        diamond.lineTo(centerX - halfWidth, centerY);
        diamond.closePath();

        return diamond;
    }
}
