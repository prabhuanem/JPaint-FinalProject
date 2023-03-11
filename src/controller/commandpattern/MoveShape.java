package controller.commandpattern;

import controller.CommandHistory;
import controller.IUndoable;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.awt.*;
import java.util.ArrayList;

public class MoveShape implements IEventCallback, IUndoable {
    private final Point clickPoint;
    private final Point leftPoint;
    private final PaintCanvas paintCanvas;
    private final ShapeDesign movedShapes = new ShapeDesign();
    private final ArrayList<InterShape> shapeArrayList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();


    /**
     * @param clickPoint - Point where the mouse is clicked/Pressed on the shape to move
     * @param leftPoint - Point where the mouse is left/Released after moving the shape
     * @param paintCanvas - Shape will be repainted after the shape is moved
     */
    public MoveShape(Point clickPoint, Point leftPoint, PaintCanvas paintCanvas) {
        this.clickPoint = clickPoint;
        this.leftPoint = leftPoint;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
        for (InterShape shape : shapeArrayList) {
            if (shape.getSelected()) {
                InterShape movedShape = move(shape);
                movedShapes.add(movedShape);
            }
        }
        CommandHistory.add(this);
        paintCanvas.repaint();
    }

    @Override
    public void undo() {
        for (InterShape shape : movedShapes.getInterShapes()) {
            undoMove(shape);
        }
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        for (InterShape shape : movedShapes.getInterShapes()) {
            move(shape);
        }
        paintCanvas.repaint();
    }

    /**
     * @param shape - X & Y locations are calculated for moving the shapes
     * @return - Shape is returned after updating the location of the Shape
     */
    private InterShape move(InterShape shape) {
        int movePointX = leftPoint.x - clickPoint.x;
        int movePointY = leftPoint.y - clickPoint.y;
        shape.pointSetXCoord(shape.coordX() + movePointX);
        shape.pointSetYCoord(shape.coordY() + movePointY);
        return shape;
    }

    /**
     * @param shape - Undo of the moved shape is executed here. Original coordinates are updated for the shape
     *              That's how the shape is restored back to original position(Last position before moving the shape)
     */
    private void undoMove(InterShape shape) {
        int movePointX = leftPoint.x - clickPoint.x;
        int movePointY = leftPoint.y - clickPoint.y;
        shape.pointSetXCoord(shape.coordX() - movePointX);
        shape.pointSetYCoord(shape.coordY() - movePointY);
    }
}
