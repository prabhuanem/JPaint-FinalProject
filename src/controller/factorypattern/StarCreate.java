package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;
import java.awt.geom.Path2D;

public class StarCreate implements InterShapeCreate {
    private final InterShape drawing;

    public StarCreate(InterShape drawing) {
        this.drawing = drawing;
    }

    @Override
    public Shape shapeDrawing() {
        Path2D.Double star = new Path2D.Double();

        // calculate the points of the star
        int centerX = drawing.coordX() + drawing.breadthDrawing() / 2;
        int centerY = drawing.coordY() + drawing.lengthDrawing() / 2;
        int outerRadius = Math.min(drawing.breadthDrawing(), drawing.lengthDrawing()) / 2;
        int innerRadius = outerRadius / 2;
        int numPoints = 5;
        double angle = Math.PI / 2;
        double deltaAngle = Math.PI / numPoints;

        star.moveTo(centerX + outerRadius * Math.cos(angle), centerY + outerRadius * Math.sin(angle));
        for (int i = 0; i < numPoints; i++) {
            angle += deltaAngle;
            star.lineTo(centerX + innerRadius * Math.cos(angle), centerY + innerRadius * Math.sin(angle));
            angle += deltaAngle;
            star.lineTo(centerX + outerRadius * Math.cos(angle), centerY + outerRadius * Math.sin(angle));
        }
        star.closePath();
        return star;
    }
}
