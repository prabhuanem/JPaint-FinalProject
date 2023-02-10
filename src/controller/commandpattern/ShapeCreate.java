package controller.commandpattern;

import controller.CommandHistory;
import controller.IUndoable;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.awt.*;

public class ShapeCreate implements IEventCallback, IUndoable {
    private final PaintCanvas paintCanvas;
    private final Shape shape;

    public ShapeCreate(Point pressedPoint, Point releasedPoint, PaintCanvas paintCanvas, ApplicationState appState) {
        this.paintCanvas = paintCanvas;

        shape = new ConstructShape()
                .pressedPoint(pressedPoint)
                .releasedPoint(releasedPoint)
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

        for (InterShape shape : AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes()) {
            shape.setSelected(false);
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
