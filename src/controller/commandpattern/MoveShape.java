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
    private InterShape shape;

    public MoveShape(Point clickPoint, Point leftPoint, PaintCanvas paintCanvas) {
        this.clickPoint = clickPoint;
        this.leftPoint = leftPoint;
        this.paintCanvas = paintCanvas;
        this.shape = null;
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

    private InterShape move(InterShape shape) {
        int movePointX = leftPoint.x - clickPoint.x;
        int movePointY = leftPoint.y - clickPoint.y;
        shape.pointSetXCoord(shape.pointX() + movePointX);
        shape.pointSetYCoord(shape.pointY() + movePointY);
        return shape;
    }

    private void undoMove(InterShape shape) {
        int movePointX = leftPoint.x - clickPoint.x;
        int movePointY = leftPoint.y - clickPoint.y;
        shape.pointSetXCoord(shape.pointX() - movePointX);
        shape.pointSetYCoord(shape.pointY() - movePointY);
    }
}
