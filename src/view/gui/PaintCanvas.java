package view.gui;

import view.drawing.AllShape;
import view.interfaces.InterShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class PaintCanvas extends PaintCanvasBase {

    public Graphics2D getGraphics2D() {return (Graphics2D) getGraphics();}

    @Override
    /**
     * This is an event handler.  If this function gets called, its time to
     * draw the entire picture.
     * It you want to force a paint event, call aPaintCanvas.repaint()
     */
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        ArrayList<InterShape> shapeList = AllShape.allShape.getInterShapes();

        for (InterShape shape : shapeList) {
            shape.draw(g2d);
        }
    }
}