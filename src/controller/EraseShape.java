package controller;

import controller.commandpattern.AllShape;
import view.gui.PaintCanvas;
import view.interfaces.InterShape;

public class EraseShape implements IUndoable{
    private final InterShape shape;
    private final PaintCanvas paintCanvas;

    /**
     * @param shape - Create the shape of the eraser
     * @param paintCanvas - eraser drawn on the paint canvas
     */
    public EraseShape(InterShape shape, PaintCanvas paintCanvas){
        this.shape = shape;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void redo() {
        AllShape.INTER_SHAPE_ARRAY_LIST.add(shape);
        paintCanvas.addShape(shape);
        paintCanvas.repaint();
    }

    @Override
    public void undo() {
        paintCanvas.addShape(shape);
        paintCanvas.repaint();
    }
}
