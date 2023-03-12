package controller.commandpattern;

import controller.Collision;
import controller.factorypattern.ShapeDrawer;
import model.ShapeShadingType;
import model.ShapeType;
import view.gui.PaintCanvas;
import view.interfaces.InterShape;

import java.awt.*;

public class Shape implements InterShape {
    private final Point clickedPoint, leftPoint;
    private final ShapeType shapeType;
    private final ShapeShadingType shadingType;
    private int X, Y, width, height;
    private final Color firstColor, secondColor;
    private boolean selected;
    private int pastedCount;
    private PaintCanvas paintCanvas;

    /**
     * @param clickedPoint - Captures the location where mouse is clicked
     * @param leftPoint - captures the location where mouse is left
     * @param shapeType - captures/reads the shapeType (Choose by user from the dropdown of 'ShapeType')
     * @param shadingType - captures/reads the shadingType (Choose by user from the dropdown of 'ShadingType')
     * @param firstColor - captures/reads the active primary color
     * @param secondColor - captures/reads the active secondary color
     * @param selected - Checks the boolean value whether the shape is selected or not?
     * @param pastedCount - Keeps the track of the pasted count of the shapes
     */
    public Shape(Point clickedPoint, Point leftPoint, ShapeType shapeType, ShapeShadingType shadingType, Color firstColor, Color secondColor,boolean selected, int pastedCount) {
        this.clickedPoint = clickedPoint;
        this.leftPoint = leftPoint;
        this.shapeType = shapeType;
        this.shadingType = shadingType;
        this.firstColor = firstColor;
        this.secondColor = secondColor;
        this.selected = selected;
        this.pastedCount = pastedCount;

        getCoordinates();
    }

    public void getCoordinates() {
        this.X = Math.min(clickedPoint.x, leftPoint.x);
        this.Y = Math.min(clickedPoint.y, leftPoint.y);
        this.width = Math.max(clickedPoint.x, leftPoint.x) - X;
        this.height = Math.max(clickedPoint.y, leftPoint.y) - Y;
    }

    @Override
    public int coordX() {
        return X;
    }

    @Override
    public int coordY() {
        return Y;
    }

    @Override
    public int breadthDrawing() {
        return width;
    }

    @Override
    public int lengthDrawing() {
        return height;
    }

    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }

    @Override
    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    /**
     * @param g2D - Shape is drawn using by calling the method "ShapeDrawer" using Graphics2D
     */
    @Override
    public void draw(Graphics2D g2D) {
        ShapeDrawer shapeDrawer = new ShapeDrawer(g2D);
        shapeDrawer.draw(this);
    }

    @Override
    public Color getPrimaryColor() {
        return firstColor;
    }

    @Override
    public Point clickedPoint() {
        return clickedPoint;
    }

    @Override
    public Color getSecondaryColor() {
        return secondColor;
    }

    @Override
    public Point leftPoint() {
        return leftPoint;
    }

    @Override
    public boolean getSelected() {
        return this.selected;
    }

    /**
     * @param shapeBorder - This is executed when the shape is selected and a border is created around the shape selected
     */
    @Override
    public void selectShape(ShapeBorder shapeBorder) {
        Collision collision = new Collision(shapeBorder, this);
        this.setSelected(collision.run());
    }
    @Override
    public void setSelected(boolean selectedStatus) {
        this.selected = selectedStatus;
    }

    @Override
    public void pointSetXCoord(int locationX) { this.X = locationX; }
    @Override
    public  void pointSetYCoord(int locationY) { this.Y = locationY; }
    @Override
    public int getPastedCount() {
        return this.pastedCount;
    }

    @Override
    public void copy() {
        this.zeroCount();
        AllShape.copiedItems_History.add(this);
    }
    @Override
    public void zeroCount() {
        pastedCount = 0;
    }
    @Override
    public int pasteDecrease() {
        return pastedCount--;
    }
    @Override
    public int pasteIncrease()
    {
        return pastedCount++;
    }
    public void setPastedCount(int pastedCount)
    {
        this.pastedCount = pastedCount;
    }

    /**
     * @param locationX - Captures the new LocationX where the shape is being moved
     * @param locationY - Captures the new LocationY where the shape is being moved
     */
    public void shapeMoving(int locationX, int locationY){
        new MoveShape(clickedPoint, leftPoint, paintCanvas).run();
    }

    public void undoingMovedShape(int locationX, int locationY){
        new MoveShape(clickedPoint, leftPoint,paintCanvas).undo();
    }

    public Rectangle getBounds(){
        return new Rectangle(X,Y,width,height);
    }
}
