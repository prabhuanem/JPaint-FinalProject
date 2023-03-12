package view.gui;

import controller.commandpattern.AllShape;
import view.decoratoroutline.ShapeOutline;
import view.interfaces.InterShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaintCanvas extends PaintCanvasBase {
    private final Grid grid = new Grid(10);
    private final List<InterShape> erasedShapes = new ArrayList<>();

    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }

    public void toggleGrid()
    {
        grid.toggleVisibility();
        repaint();
    }

    public void addShape(InterShape shape){
        erasedShapes.add(shape);
        repaint();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        grid.draw(g,getWidth(),getHeight());
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