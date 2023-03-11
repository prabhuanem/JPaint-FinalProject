package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;
import java.awt.geom.Path2D;

public class RectangleCalloutCreate implements InterShapeCreate {
    private final InterShape drawing;

    public RectangleCalloutCreate(InterShape drawing) {
        this.drawing = drawing;
    }

    /**
     * @return - Using Path2D double to draw the Rectangle Callout by calculating the dimensions and closing the path accordingly to create the shape
     */
    @Override
    public Shape shapeDrawing() {
        Path2D.Double cloudCallout = new Path2D.Double();

        int x = drawing.coordX();
        int y = drawing.coordY();
        int width = drawing.breadthDrawing();
        int height = drawing.lengthDrawing();

        int arcRadius = 20;

        // Drawing cloud body
        cloudCallout.moveTo(x + arcRadius, y);
        cloudCallout.quadTo(x, y, x, y + arcRadius);
        cloudCallout.lineTo(x, y + height - arcRadius);
        cloudCallout.quadTo(x, y + height, x + arcRadius, y + height);
        cloudCallout.lineTo(x + width - arcRadius, y + height);
        cloudCallout.quadTo(x + width, y + height, x + width, y + height - arcRadius);
        cloudCallout.lineTo(x + width, y + arcRadius);
        cloudCallout.quadTo(x + width, y, x + width - arcRadius, y);
        cloudCallout.closePath();

        // Drawing cloud callout
        int calloutWidth = 40;
        int calloutHeight = 30;
        int calloutX = x + width / 2 - calloutWidth / 2;
        int calloutY = y - calloutHeight;

        cloudCallout.moveTo(calloutX, calloutY + calloutHeight / 2);
        cloudCallout.lineTo(calloutX + calloutWidth / 2, calloutY);
        cloudCallout.lineTo(calloutX + calloutWidth, calloutY + calloutHeight / 2);
        cloudCallout.lineTo(calloutX + calloutWidth, calloutY + calloutHeight);
        cloudCallout.lineTo(calloutX, calloutY + calloutHeight);
        cloudCallout.closePath();

        return cloudCallout;
    }
}

