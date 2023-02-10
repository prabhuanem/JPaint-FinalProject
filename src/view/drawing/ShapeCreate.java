package view.drawing;

import controller.CommandHistory;
import controller.IUndoable;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;

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
                .buildShape();
    }

    @Override
    public void run() {
        AllShape.allShape.add(shape);
        paintCanvas.repaint();
        CommandHistory.add(this);

    }

    @Override
    public void undo() {
        AllShape.allShape.remove(shape);
        paintCanvas.repaint();
    }

    @Override
    public void redo()
    {
        AllShape.allShape.add(shape);
        paintCanvas.repaint();
    }
}
