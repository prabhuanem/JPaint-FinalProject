package controller;

import controller.commandpattern.AllShape;
import view.gui.PaintCanvas;
import view.interfaces.InterShape;

import java.awt.*;
import java.util.ArrayList;

public class Eraser {
    private final Point clickedPoint;
    private final Point leftPoint;
    private final PaintCanvas paintCanvas;

    /**
     * @param clickedPoint - Captures/Reads the location of the mouse click point
     * @param leftPoint - Captures/Reads the location of the mouse left point
     * @param paintCanvas - Draw the shape on the PaintCanvas
     */
    public Eraser(Point clickedPoint, Point leftPoint, PaintCanvas paintCanvas){
        this.clickedPoint = clickedPoint;
        this.leftPoint = leftPoint;
        this.paintCanvas = paintCanvas;
    }

    /**
     * Creates the Eraser shape here and when the eraser rectangle intersects with the Shape, then the shape will get erased and it is updated in "INTER_SHAPE_ARRAY_LIST"
     */
    public void run(){
        Graphics2D graphics2D = paintCanvas.getGraphics2D();
        graphics2D.setColor(Color.red);
        graphics2D.fill3DRect(
                Math.min(clickedPoint.x, leftPoint.x),
                Math.min(clickedPoint.y, leftPoint.y),
                Math.abs(leftPoint.x- clickedPoint.x),
                Math.abs(leftPoint.y - clickedPoint.y),
                true
        );

        ArrayList<InterShape> shapeList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();
        for(InterShape shape : shapeList){
            Rectangle shapeBounds = shape.getBounds();
            Rectangle eraseBounds = new Rectangle(
                    Math.min(clickedPoint.x, leftPoint.x),
                    Math.min(clickedPoint.y, leftPoint.y),
                    Math.abs(leftPoint.x - clickedPoint.x),
                    Math.abs(leftPoint.y - clickedPoint.y)
                    );
            if(shapeBounds.intersects(eraseBounds)){
                EraseShape erasheShapeCommand = new EraseShape(shape, paintCanvas);
                CommandHistory.add(erasheShapeCommand);
            }
        }
        AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes().removeIf(shape -> {
            Rectangle shapeBounds = shape.getBounds();
            Rectangle eraseBounds = new Rectangle(
                    Math.min(clickedPoint.x, leftPoint.x),
                    Math.min(clickedPoint.y, leftPoint.y),
                    Math.abs(leftPoint.x - clickedPoint.x),
                    Math.abs(leftPoint.y - clickedPoint.y)
            );
            return shapeBounds.intersects(eraseBounds);
        });
        paintCanvas.repaint();
    }

}
