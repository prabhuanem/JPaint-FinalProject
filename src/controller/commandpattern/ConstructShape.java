package controller.commandpattern;

import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public class ConstructShape {
    private Point clickPoint, leftPoint;
    private ShapeType shapeType;
    private ShapeShadingType shadingType;
    private Color firstColor, secondColor;

    private boolean selected;

    public ConstructShape shapeType(ShapeType shapetype) {
        this.shapeType = shapetype;
        return this;
    }

    public ConstructShape shadingType(ShapeShadingType shapeShadingType) {
        this.shadingType = shapeShadingType;
        return this;
    }

    public ConstructShape clickedPoint(Point clickPoint) {
        this.clickPoint = clickPoint;
        return this;
    }

    public ConstructShape leftPoint(Point leftPoint) {
        this.leftPoint = leftPoint;
        return this;
    }
    public ConstructShape firstColor(Color firstColor) {
        this.firstColor = firstColor;
        return this;
    }
    public ConstructShape secondColor(Color secondColor) {
        this.secondColor = secondColor;
        return this;
    }
    public ConstructShape selectedStatus(boolean status) {
        this.selected = status;
        return this;
    }

    /**
     * @return - Shape will be build here and returned accordingly
     */
    public Shape buildShape() {
        return new Shape(clickPoint, leftPoint, shapeType, shadingType, firstColor, secondColor,selected, 0);
    }

}
