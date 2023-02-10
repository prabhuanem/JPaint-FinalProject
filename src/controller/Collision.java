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
        return (iBorder.coordX() < shapeBorderOutline.pointX() + shapeBorderOutline.shapeBreadth() &&
                iBorder.coordX() + iBorder.getBreadth() > shapeBorderOutline.pointX() &&
                iBorder.coordY() < shapeBorderOutline.pointY() + shapeBorderOutline.shapeLength() &&
                iBorder.coordY() + iBorder.getLength() > shapeBorderOutline.pointY());
    }

}
