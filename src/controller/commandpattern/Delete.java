package controller.commandpattern;

import controller.CommandHistory;
import controller.IUndoable;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.util.ArrayList;
import java.util.List;

public class Delete implements IEventCallback, IUndoable {
    PaintCanvas paintCanvas;
    private final ArrayList<InterShape> masterList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();
    private final ArrayList<InterShape> deletedShapes = new ArrayList<>();

    public Delete(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void run() {
        List<InterShape> selectedShapes = masterList.stream()
                .filter(InterShape::getSelected)
                .toList();
        masterList.removeAll(selectedShapes);
        deletedShapes.addAll(selectedShapes);
        paintCanvas.repaint();
        CommandHistory.add(this);
    }


    public void undo() {
        masterList.addAll(deletedShapes);
        paintCanvas.repaint();

    }

    public void redo() {
        masterList.removeAll(deletedShapes);
        paintCanvas.repaint();
    }
}
