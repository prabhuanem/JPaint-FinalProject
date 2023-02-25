package view.decoratoroutline;

import model.ShapeType;
import view.interfaces.InterShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class ShapeOutline {
    private InterShape shape;

    public ShapeOutline(InterShape Shape) {
        this.shape = Shape;

    }

    public void selectShape(Graphics2D g, ShapeType shapeType) {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 2, new float[]{10}, 2);
        g.setStroke(stroke);
        g.setColor(Color.BLACK);
        Shape shapeToDraw;
        int x = shape.pointX() - 5;
        int y = shape.pointY() - 5;
        int breadth = shape.shapeBreadth() + 10;
        int length = shape.shapeLength() + 10;

        switch (shapeType) {
            case RECTANGLE -> shapeToDraw = new Rectangle2D.Double(x, y, breadth, length);
            case ELLIPSE -> shapeToDraw = new Ellipse2D.Double(x, y, breadth, length);
            case TRIANGLE -> {
                int[] xPoints = new int[]{(x + (x + breadth)) / 2, x - 10, (x + breadth) + 10};
                int[] yPoints = new int[]{y - 10, (y + length) + 5, (y + length) + 5};
                shapeToDraw = new Polygon(xPoints, yPoints, 3);
            }
            default -> {
                return;
            }
        }
        g.draw(shapeToDraw);
    }
}
