package view.decoratoroutline;

import controller.factorypattern.OctagonCreate;
import controller.factorypattern.RectangleCalloutCreate;
import controller.factorypattern.StarCreate;
import model.ShapeType;
import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class ShapeOutline {
    private InterShape drawing;

    public ShapeOutline(InterShape drawing) {
        this.drawing = drawing;

    }

    public void selectShape(Graphics2D g2D, ShapeType shapeType) {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 2, new float[]{10}, 2);
        g2D.setStroke(stroke);
        g2D.setColor(Color.BLACK);
        Shape shapeToDraw;
        int x, y, breadth, length,arcWidth = 0, arcHeight=0;

        switch (shapeType) {
            case RECTANGLE:
            case ELLIPSE:
            case TRIANGLE:
                x = drawing.coordX() - 5;
                y = drawing.coordY() - 5;
                breadth = drawing.breadthDrawing() + 10;
                length = drawing.lengthDrawing() + 10;
                break;
            case STAR:
                InterShapeCreate starCreate = new StarCreate(drawing);
                Shape starShape = starCreate.shapeDrawing();
                Rectangle bounds = starShape.getBounds();
                x = bounds.x - 15;
                y = bounds.y - 15;
                breadth = bounds.width + 30;
                length = bounds.height + 30;

                break;
            case DIAMOND:
                x = drawing.coordX() - 5;
                y = drawing.coordY() - 5;
                breadth = drawing.breadthDrawing() + 10;
                length = drawing.lengthDrawing() + 10;
                break;
            case ROUNDED_RECTANGLE:
                x = drawing.coordX() - 5;
                y = drawing.coordY() - 5;
                breadth = drawing.breadthDrawing() + 10;
                length = drawing.lengthDrawing() + 10;
                arcWidth = 30;
                arcHeight = 30;
                break;
            case RECTANGLE_CALLOUT:
                InterShapeCreate cloudCalloutCreate = new RectangleCalloutCreate(drawing);
                shapeToDraw = cloudCalloutCreate.shapeDrawing();
                Rectangle bounds1 = shapeToDraw.getBounds();
                x = bounds1.x - 5;
                y = bounds1.y - 5;
                breadth = bounds1.width + 10;
                length = bounds1.height + 10;
                g2D.draw(shapeToDraw);
                break;
            case OCTAGON:
                InterShapeCreate octagonCreate = new OctagonCreate(drawing);
                shapeToDraw = octagonCreate.shapeDrawing();
                Rectangle bounds2 = shapeToDraw.getBounds();
                x = bounds2.x - 10;
                y = bounds2.y - 10;
                breadth = bounds2.width + 20;
                length = bounds2.height + 20;
                break;
            default:
                return;
        }

        switch (shapeType) {
            case RECTANGLE -> shapeToDraw = new Rectangle2D.Double(x, y, breadth, length);
            case ELLIPSE -> shapeToDraw = new Ellipse2D.Double(x, y, breadth, length);
            case TRIANGLE -> {
                int[] xPoints = new int[]{(x + (x + breadth)) / 2, x - 10, (x + breadth) + 10};
                int[] yPoints = new int[]{y - 10, (y + length) + 5, (y + length) + 5};
                shapeToDraw = new Polygon(xPoints, yPoints, 3);
            }
            case STAR -> {
                    InterShapeCreate starCreate = new StarCreate(drawing);
                    shapeToDraw = starCreate.shapeDrawing();
            }
            case DIAMOND -> {
                int[] aPoints = new int[]{x + breadth / 2, x + breadth, x + breadth / 2, x};
                int[] bPoints = new int[]{y, y + length / 2, y + length, y + length / 2};
                shapeToDraw = new Polygon(aPoints, bPoints, 4);
            }
            case ROUNDED_RECTANGLE -> {
                shapeToDraw = new RoundRectangle2D.Double(x, y, breadth, length, arcWidth, arcHeight);
                g2D.draw(shapeToDraw);
            }
            case OCTAGON -> {
                InterShapeCreate octagonCreate = new OctagonCreate(drawing);
                shapeToDraw = octagonCreate.shapeDrawing();
            }

            default -> {
                return;
            }
        }
        g2D.draw(shapeToDraw);
    }
}
