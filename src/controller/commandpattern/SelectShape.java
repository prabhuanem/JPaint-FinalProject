package controller.commandpattern;

import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.awt.*;
import java.util.ArrayList;

public class SelectShape implements IEventCallback {
    private final Point clickPoint;
    private final Point leftPoint;
    private final PaintCanvas paintCanvas;
    private final ArrayList<InterShape> allList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();

    public SelectShape(Point clickPoint, Point leftPoint, PaintCanvas PaintCanvas) {
        this.clickPoint = clickPoint;
        this.leftPoint = leftPoint;
        this.paintCanvas = PaintCanvas;
    }

    @Override
    public void run() {
        ShapeBorder shapeBorder = new ShapeBorder(clickPoint, leftPoint);
        allList.forEach(shape -> shape.selectShape(shapeBorder));
        paintCanvas.repaint();
    }
}
