package controller;

import model.persistence.ApplicationState;
import controller.commandpattern.ShapeCreate;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseTracking extends MouseAdapter {
    private final PaintCanvas paintCanvas;
    private final ApplicationState appState;
    Point clickPoint, leftPoint;


    public MouseTracking(PaintCanvas paintCanvas, ApplicationState appState) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;

    }


    @Override
    public void mousePressed(MouseEvent e) {
        clickPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        leftPoint = e.getPoint();
        {
            ShapeCreate shapeCreateNew = new ShapeCreate(clickPoint, leftPoint, paintCanvas, appState);
            shapeCreateNew.run();
        }

    }
}
