package controller.commandpattern;

import controller.IUndoable;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.util.ArrayList;

public class Move implements IEventCallback, IUndoable {
    private final int movePointX;
    private final int movePointY;
    private final InterShape shape;
    private final ShapeDesign movedShapes = new ShapeDesign();
    private final ArrayList<InterShape> copiedItemsShapes = AllShape.copiedItems.getInterShapes();

    public Move(int movePointX, int movePointY, InterShape shape) {
        this.movePointX = movePointX;
        this.movePointY = movePointY;
        this.shape = shape;
    }

    public InterShape move(InterShape shape) {
        shape.pointSetXCoord(shape.pointX() + movePointX);
        shape.pointSetYCoord(shape.pointY() + movePointY);
        return shape;
    }

    public void undoMove(InterShape shape) {
        shape.pointSetXCoord(shape.pointX() - movePointX);
        shape.pointSetYCoord(shape.pointY() - movePointY);
    }

    @Override
    public void run() {
        InterShape movedShape = move(shape);
        movedShapes.add(movedShape);
        if (copiedItemsShapes.contains(shape)) {
            Shape copiedShape = new Shape(shape.leftPoint(), shape.clickedPoint(), shape.getShapeType(), shape.getShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor(),false, shape.getPastedCount());
            copiedShape.pointSetXCoord(movedShape.pointX() - movePointX);
            copiedShape.pointSetYCoord(movedShape.pointY() - movePointY);
            copiedItemsShapes.set(copiedItemsShapes.indexOf(shape),copiedShape);
        }
    }

    @Override
    public void undo() {
        undoMove(shape);
        if (copiedItemsShapes.contains(shape)) {
            Shape copiedShape = new Shape(shape.leftPoint(), shape.clickedPoint(), shape.getShapeType(), shape.getShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor(),false, shape.getPastedCount());
            copiedShape.pointSetXCoord(shape.pointX() - movePointX * shape.getPastedCount());
            copiedShape.pointSetYCoord(shape.pointY() - movePointY * shape.getPastedCount());
            copiedItemsShapes.set(copiedItemsShapes.indexOf(shape), move(copiedShape));
        }
    }

    @Override
    public void redo() {
        move(shape);
    }
}
