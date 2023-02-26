package controller.commandpattern;

import controller.CommandHistory;
import controller.IUndoable;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.util.ArrayList;

public class PasteShape implements IEventCallback, IUndoable {
    private final PaintCanvas paintCanvas;
    private final ArrayList<InterShape> pastedShapes = new ArrayList<>();
    private final ArrayList<InterShape> allList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();
    private final ArrayList<InterShape> copiedItemsHistory = AllShape.copiedItems_History.getInterShapes();

    public PasteShape(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
        for (InterShape shape : copiedItemsHistory) {
            Shape copiedShape = new Shape(shape.clickedPoint(), shape.leftPoint(), shape.getShapeType(), shape.getShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor(),false, shape.pasteIncrease());
            copiedShape.pointSetXCoord(shape.coordX() + 125 * shape.getPastedCount());
            copiedShape.pointSetYCoord(shape.coordY() + 45 * shape.getPastedCount());
            pastedShapes.add(copiedShape);
        }
        allList.addAll(pastedShapes);
        paintCanvas.repaint();
        CommandHistory.add(this);
    }


    @Override
    public void undo() {
        for (InterShape shape : copiedItemsHistory) {
            if (shape.getPastedCount() > 0) {
                shape.pasteDecrease();
            }
        }
        allList.removeAll(pastedShapes);
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        allList.addAll(pastedShapes);
        for (InterShape shape : copiedItemsHistory) {
            Shape copiedShape = new Shape(shape.clickedPoint(), shape.leftPoint(), shape.getShapeType(), shape.getShadingType(), shape.getPrimaryColor(), shape.getSecondaryColor(),false, shape.pasteIncrease());
            copiedShape.pointSetXCoord(shape.coordX() + 50 * shape.getPastedCount());
            copiedShape.pointSetYCoord(shape.coordY() + 50 * shape.getPastedCount());
            pastedShapes.add(copiedShape);
        }
        paintCanvas.repaint();
    }
}
