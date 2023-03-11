package controller;

import controller.commandpattern.MoveShape;
import controller.commandpattern.SelectShape;
import controller.commandpattern.ShapeCreate;
import model.MouseMode;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;

import java.awt.*;
import java.awt.event.*;

public class MouseTracking extends MouseAdapter {
    private final PaintCanvas paintCanvas;
    private final ApplicationState appState;
    Point clickPoint, leftPoint;

    private final IGuiWindow gui;


    public MouseTracking(PaintCanvas paintCanvas, ApplicationState appState, IGuiWindow gui) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
        this.gui = gui;
        addKeyListener();

    }

public void addKeyListener(){
if(appState.getActiveMouseMode() == MouseMode.DRAW){
    KeyListener keyListener =new KeyAdapter() {
        /**
         * Invoked when a key has been pressed.
         *
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            ShapeType shapeType =null;
            switch (e.getKeyCode()){
                case KeyEvent.VK_E:
                    shapeType =ShapeType.ELLIPSE;
                    break;
                case KeyEvent.VK_R:
                    shapeType = ShapeType.RECTANGLE;
                    break;
                case KeyEvent.VK_T:
                    shapeType = ShapeType.TRIANGLE;
                    break;
                case KeyEvent.VK_S:
                    shapeType = ShapeType.STAR;
                    break;
                case KeyEvent.VK_D:
                    shapeType = ShapeType.DIAMOND;
                    break;
                case KeyEvent.VK_O:
                    shapeType = ShapeType.OCTAGON;
                    break;
                case KeyEvent.VK_C:
                    shapeType = ShapeType.ROUNDED_RECTANGLE;
                    break;
                case KeyEvent.VK_L:
                    shapeType = ShapeType.RECTANGLE_CALLOUT;
                    break;

            }
            if(shapeType!=null){
                appState.setActiveShapeType(shapeType);
            }
        }
    };
    gui.addKeyListener(keyListener);
    gui.requestFocus();
}
}


    @Override
    public void mousePressed(MouseEvent e) {
        clickPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        leftPoint = e.getPoint();
        {
            MouseMode[] modes = MouseMode.values();
            for(MouseMode mode : modes) {
                if (appState.getActiveMouseMode() == mode) {
                    switch (mode) {
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
    }
}
