package view.gui;

import controller.commandpattern.AllShape;
import view.decoratoroutline.ShapeOutline;
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
        ArrayList<InterShape> shapeList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();

        for (InterShape shape : shapeList) {
            shape.draw(g2d);
            if (shape.getSelected()) {
                new ShapeOutline(shape).selectShape(g2d, shape.getShapeType());
            }
        }
    }
}