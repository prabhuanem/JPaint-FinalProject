package controller;

import controller.commandpattern.MoveShape;
import controller.commandpattern.SelectShape;
import controller.commandpattern.ShapeCreate;
import model.persistence.ApplicationState;
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
            switch (appState.getActiveMouseMode()) {
                case DRAW -> {
                    ShapeCreate newShape = new ShapeCreate(clickPoint, leftPoint, paintCanvas, appState);
                    newShape.run();
                }
                case SELECT -> {
                    SelectShape selectShape = new SelectShape(clickPoint, leftPoint, paintCanvas);
                    selectShape.run();
                }
                case MOVE -> {
                    MoveShape moveShape = new MoveShape(clickPoint, leftPoint, paintCanvas);
                    moveShape.run();
                }
            }

        }
    }
}
