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
    private int movePointX, movePointY;
    private final ShapeDesign shapeMoved = new ShapeDesign();
    private final ArrayList<InterShape> shapeArrayList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();

    public MoveShape(Point clickPoint, Point leftPoint, PaintCanvas PaintCanvas) {
        this.clickPoint = clickPoint;
        this.leftPoint = leftPoint;
        this.paintCanvas = PaintCanvas;
        newMovePoint();
    }

    public void newMovePoint() {
        movePointX = leftPoint.x - clickPoint.x;
        movePointY = leftPoint.y - clickPoint.y;
    }

    @Override
    public void run() {
        for (InterShape shape : shapeArrayList) {
            if (shape.getSelected()) {
                shape.movingShapeDrawn(movePointX, movePointY);
                shapeMoved.add(shape);
            }
        }
        CommandHistory.add(this);
        paintCanvas.repaint();
    }

    @Override
    public void undo() {
        for (InterShape shape : shapeMoved.getInterShapes()) {
            shape.undoingMovedShape(movePointX, movePointY);
        }
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        for (InterShape shape : shapeMoved.getInterShapes()) {
            shape.movingShapeDrawn(movePointX, movePointY);
        }
        paintCanvas.repaint();
    }
}
