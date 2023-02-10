package controller.commandpattern;

import view.interfaces.InterShape;

import java.util.ArrayList;

public class ShapeDesign {
    private final ArrayList<InterShape> interShapes = new ArrayList<>();


    public void add(InterShape shape) {
        if(!interShapes.contains(shape))
            interShapes.add(shape);
    }

    public void remove(InterShape shape){

        interShapes.remove(shape);
    }

    public ArrayList<InterShape> getInterShapes() {
        return interShapes;
    }

}
