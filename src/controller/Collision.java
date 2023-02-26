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
        return (iBorder.coordX() < shapeBorderOutline.coordX() + shapeBorderOutline.breadthDrawing() &&
                iBorder.coordX() + iBorder.getBreadth() > shapeBorderOutline.coordX() &&
                iBorder.coordY() < shapeBorderOutline.coordY() + shapeBorderOutline.lengthDrawing() &&
                iBorder.coordY() + iBorder.getLength() > shapeBorderOutline.coordY());
    }

}
