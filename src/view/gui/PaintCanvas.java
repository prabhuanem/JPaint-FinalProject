package view.gui;

import controller.commandpattern.AllShape;
import view.interfaces.InterShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class PaintCanvas extends PaintCanvasBase {

    public Graphics2D getGraphics2D() {return (Graphics2D) getGraphics();}

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        ArrayList<InterShape> interShapes = AllShape.allShape.getInterShapes();
        for (InterShape shape : interShapes)
        {
            shape.draw(g2d);
        }
    }
}