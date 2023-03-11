package controller.factorypattern;

import view.interfaces.InterShape;
import view.interfaces.InterShapeCreate;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipseCreate implements InterShapeCreate {
    private final InterShape drawing;

    public EllipseCreate(InterShape drawing ) {
        this.drawing = drawing;
    }

    /**
     * @return - Returns the ellipse shape which is created using "Ellipse2D.Double" method
     */
    @Override
    public Shape shapeDrawing() {
        Shape ellipse;
        int x = drawing.coordX();
        int y = drawing.coordY();
        int width = drawing.breadthDrawing();
        int height = drawing.lengthDrawing();
        ellipse = new Ellipse2D.Double(x, y, width, height);
        return ellipse;
    }

}
