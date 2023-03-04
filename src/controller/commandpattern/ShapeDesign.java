package controller.commandpattern;

import view.interfaces.InterShape;

import java.util.ArrayList;

public class ShapeDesign {
    private final ArrayList<InterShape> interShapes = new ArrayList<>();


    public void add(InterShape drawing) {
        if(!interShapes.contains(drawing))
            interShapes.add(drawing);
    }

    public void remove(InterShape drawing){

        interShapes.remove(drawing);
    }

    public ArrayList<InterShape> getInterShapes() {
        return interShapes;
    }

}
