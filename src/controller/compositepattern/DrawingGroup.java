package controller.compositepattern;

import controller.Collision;
import controller.commandpattern.AllShape;
import controller.commandpattern.ShapeBorder;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.InterShape;

import java.awt.*;
import java.util.ArrayList;

public class DrawingGroup implements InterShape {
    private final ArrayList<InterShape> subShapesGroup = new ArrayList<>();
    private int X,Y,breadth, length,pastedCount;
    private boolean selected;
    public DrawingGroup(ArrayList<InterShape> shapeArrayList){
        for(InterShape drawing : shapeArrayList)
        {
            addSubShapes(drawing);
        }
        this.X = coordX();
        this.Y = coordY();
        this.breadth = breadthDrawing();
        this.length = lengthDrawing();
        this.selected = getSelected();
    }

    public void addSubShapes(InterShape drawing)
    {
        if(!subShapesGroup.contains(drawing))
        {
            subShapesGroup.add(drawing);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        subShapesGroup.forEach(shape -> shape.draw(g));
    }

    @Override
    public int coordX() {
        return subShapesGroup.stream().mapToInt(InterShape::coordX).min().orElse(0);
    }

    @Override
    public int coordY() {
        return subShapesGroup.stream().mapToInt(InterShape::coordY).min().orElse(0);
    }

    @Override
    public int breadthDrawing() {
        int pointX = coordX();
        return subShapesGroup.stream().mapToInt(drawing -> {
            int drawingX = drawing.coordX() - pointX;
            return drawingX + drawing.breadthDrawing();
        }).max().orElse(0);
    }

    @Override
    public int lengthDrawing() {
        int pointY = coordY();
        return subShapesGroup.stream().mapToInt(drawing -> {
            int drawingY = drawing.coordY()-pointY;
            return drawingY + drawing.lengthDrawing();
        }).max().orElse(0);
    }

    @Override
    public Color getPrimaryColor() {
        subShapesGroup.forEach(InterShape::getPrimaryColor);
        return Color.red;
    }

    @Override
    public ShapeType getShapeType() {
        subShapesGroup.forEach(InterShape ::getShapeType);
        return ShapeType.RECTANGLE;
    }

    @Override
    public ShapeShadingType getShadingType() {
        subShapesGroup.forEach(InterShape :: getShadingType);
        return ShapeShadingType.OUTLINE;
    }

    @Override
    public Point leftPoint() {
        for (InterShape interShape : subShapesGroup)
        {
            interShape.leftPoint();
        }
        return new Point(X+breadth, Y+length);
    }

    @Override
    public Point clickedPoint() {
        for (InterShape interShape : subShapesGroup)
        {
            interShape.clickedPoint();
        }
        return new Point(X,Y);
    }

    @Override
    public Color getSecondaryColor() {
        subShapesGroup.forEach(InterShape::getSecondaryColor);
        return null;
    }

    @Override
    public void selectShape(ShapeBorder shapeBorder) {
        Collision collision = new Collision(shapeBorder, this);
        this.setSelected(collision.run());

    }

    @Override
    public boolean getSelected() {
        for (InterShape interShape : subShapesGroup)
        {
            interShape.getSelected();
        }
        return this.selected;
    }

    @Override
    public void setSelected(boolean selectedStatus) {
        for (InterShape interShape : subShapesGroup)
        {
            interShape.setSelected(selectedStatus);
        }
        selected = selectedStatus;

    }

    @Override
    public void pointSetXCoord(int locationX) {
        subShapesGroup.forEach(shape -> shape.pointSetXCoord(locationX));
        X = locationX;
    }

    @Override
    public void pointSetYCoord(int locationY) {
        subShapesGroup.forEach(shape -> shape.pointSetYCoord(locationY));
        Y = locationY;
    }

    @Override
    public int getPastedCount() {
        return subShapesGroup.stream().mapToInt(InterShape::getPastedCount).sum();
    }

    @Override
    public void copy() {
        this.zeroCount();
        AllShape.copiedItems_History.add(this);

    }

    @Override
    public void zeroCount() {
        subShapesGroup.forEach(InterShape::zeroCount);
        pastedCount = 0;

    }

    @Override
    public int pasteDecrease() {
        subShapesGroup.forEach(InterShape::pasteDecrease);
        return pastedCount -= subShapesGroup.size();
    }

    @Override
    public int pasteIncrease() {
        subShapesGroup.forEach(InterShape::pasteIncrease);
        return pastedCount += subShapesGroup.size();
    }

    @Override
    public void shapeMoving(int locationX, int locationY) {
        subShapesGroup.forEach(shape -> shape.shapeMoving(locationX,locationY));

    }

    @Override
    public void undoingMovedShape(int locationX, int locationY) {
        subShapesGroup.forEach(shape -> shape.undoingMovedShape(locationX,locationY));
    }

    public ArrayList<InterShape> getSubShapesGroup(){
        return subShapesGroup;
    }
}
