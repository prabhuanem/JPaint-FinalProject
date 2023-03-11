package controller.commandpattern;

import controller.CommandHistory;
import controller.IUndoable;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.awt.*;
import java.util.ArrayList;

public class ShapeCreate implements IEventCallback, IUndoable {
    private final PaintCanvas paintCanvas;
    private final Shape shape;

    /**
     * @param clickedPoint - Captures/Reads the location where mouse is clicked
     * @param leftPoint - Captures/Reads the location where mouse is left (released)
     * @param paintCanvas - Interface where the shape drawn is painted/displayed
     * @param appState - Has the value of the current state of the application
     *                 This is where the magic happens and the shapes are being created
     */
    public ShapeCreate(Point clickedPoint, Point leftPoint, PaintCanvas paintCanvas, ApplicationState appState) {
        this.paintCanvas = paintCanvas;

        shape = new ConstructShape()
                .clickedPoint(clickedPoint)
                .leftPoint(leftPoint)
                .shapeType(appState.getActiveShapeType())
                .shadingType(appState.getActiveShapeShadingType())
                .firstColor(appState.getActivePrimaryColor().getColor())
                .secondColor(appState.getActiveSecondaryColor().getColor())
                .selectedStatus(false)
                .buildShape();
    }

    @Override
    public void run() {
        AllShape.INTER_SHAPE_ARRAY_LIST.add(shape);
        paintCanvas.repaint();
        CommandHistory.add(this);

        ArrayList<InterShape> interShapes = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();
        int i = 0;
        while (i < interShapes.size()) {
            InterShape shape = interShapes.get(i);
            shape.setSelected(false);
            i++;
        }

    }

    @Override
    public void undo() {
        AllShape.INTER_SHAPE_ARRAY_LIST.remove(shape);
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        AllShape.INTER_SHAPE_ARRAY_LIST.add(shape);
        paintCanvas.repaint();

    }
}
