package controller.commandpattern;

import controller.CommandHistory;
import controller.IUndoable;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class PasteShape implements IEventCallback, IUndoable {
    private final PaintCanvas paintCanvas;
    private final ArrayList<InterShape> pastedShapes = new ArrayList<>();
    private final ArrayList<InterShape> allList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();
    private final ArrayList<InterShape> copiedItemsHistory = AllShape.copiedItems_History.getInterShapes();
    private final Point clickPoint;

    /**
     * @param paintCanvas - Shape will be repainted here when it is pasted
     * @param clickPoint - Copied shape will be pasted at the location where Mouse is clicked
     *                   In this way user can paste the shape anywhere on the screen as desired
     */
    public PasteShape(PaintCanvas paintCanvas, Point clickPoint) {
        this.paintCanvas = paintCanvas;
        this.clickPoint = clickPoint;
    }

    /**
     * run() - Here is the copied shape is extracted from the "copiedItemsHistory" and the location is calculated
     * based on the "clickPoint" and the shape will be pasted there
     */
    @Override
    public void run() {
        int index = 0;
        for (InterShape shape : copiedItemsHistory) {
            Shape copiedShape = new Shape(shape.clickedPoint(), shape.leftPoint(), shape.getShapeType(), shape.getShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor(),false, shape.pasteIncrease());
            copiedShape.pointSetXCoord(clickPoint.x + 125 * index);
            copiedShape.pointSetYCoord(clickPoint.y + 45 * index);
            copiedShape.setPastedCount(shape.getPastedCount() + index);
            pastedShapes.add(copiedShape);
            index++;
        }
        allList.addAll(pastedShapes);
        paintCanvas.repaint();
        CommandHistory.add(this);
    }


    /**
     * undo() - Here Undoing of the pasted shapes is executed. All the pasted shapes are stored in the array and using the loop
     * one by one can be Undone
     */
    @Override
    public void undo() {
        Iterator<InterShape> iterator = copiedItemsHistory.iterator();
        if (iterator.hasNext()) {
            do {
                InterShape shape = iterator.next();
                if (shape.getPastedCount() > 0) {
                    shape.pasteDecrease();
                }
            } while (iterator.hasNext());
        }
        allList.removeAll(pastedShapes);
        paintCanvas.repaint();
    }

    /**
     * redo() - Here redo of the Undo operation is executed
     */

    @Override
    public void redo() {
        allList.addAll(pastedShapes);
        Iterator<InterShape> iterator = copiedItemsHistory.iterator();
        if (iterator.hasNext()) {
            do {
                InterShape shape = iterator.next();
                Shape copiedShape = new Shape(shape.clickedPoint(), shape.leftPoint(), shape.getShapeType(), shape.getShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor(), false, shape.pasteIncrease());
                copiedShape.pointSetXCoord((clickPoint.x) + shape.getPastedCount());
                copiedShape.pointSetYCoord((clickPoint.y) + shape.getPastedCount());
                pastedShapes.add(copiedShape);
            } while (iterator.hasNext());
        }
        paintCanvas.repaint();
    }
}
