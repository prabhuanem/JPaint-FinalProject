package controller.commandpattern;

import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public class ConstructShape {
    private Point clickPoint, leftPoint;
    private ShapeType shapeType;
    private ShapeShadingType shadingType;
    private Color firstColor;

    public ConstructShape shapeType(ShapeType shapetype) {
        this.shapeType = shapetype;
        return this;
    }

    public ConstructShape shadingType(ShapeShadingType shapeShadingType) {
        this.shadingType = shapeShadingType;
        return this;
    }

    public ConstructShape pressedPoint(Point pPoint) {
        this.clickPoint = pPoint;
        return this;
    }

    public ConstructShape releasedPoint(Point rPoint) {
        this.leftPoint = rPoint;
        return this;
    }
    public ConstructShape firstColor(Color firstColor) {
        this.firstColor = firstColor;
        return this;
    }

    public Shape buildShape() {
        return new Shape(clickPoint, leftPoint, shapeType, shadingType, firstColor);
    }

}
