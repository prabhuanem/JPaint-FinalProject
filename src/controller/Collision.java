package controller;

import view.interfaces.IBorder;
import view.interfaces.InterShape;

public class Collision {
    private final IBorder iBorder;
    private final InterShape shapeBorderOutline;

    public Collision(IBorder iBorder, InterShape shapeBorderOutline) {
        this.iBorder = iBorder;
        this.shapeBorderOutline = shapeBorderOutline;
    }

    public boolean run() {
        int iCoordX = iBorder.coordX();
        int iCoordY = iBorder.coordY();
        int iBreadth = iBorder.breadth();
        int iLength = iBorder.length();
        int shapeCoordX = shapeBorderOutline.coordX();
        int shapeCoordY = shapeBorderOutline.coordY();
        int shapeBreadth = shapeBorderOutline.breadthDrawing();
        int shapeLength = shapeBorderOutline.lengthDrawing();

        boolean intersectX = iCoordX < shapeCoordX + shapeBreadth && iCoordX + iBreadth > shapeCoordX;
        boolean intersectY = iCoordY < shapeCoordY + shapeLength && iCoordY + iLength > shapeCoordY;

        return intersectX && intersectY;
    }

}
