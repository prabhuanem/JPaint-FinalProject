package controller.prototypedesign;

import controller.commandpattern.AllShape;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.util.ArrayList;

public class Copy implements IEventCallback {
    private final ArrayList<InterShape> allList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();
    private final ArrayList<InterShape> copiedItemsHistory = AllShape.copiedItemsHistory.getInterShapes();

    @Override
    public void run() {
        copiedItemsHistory.clear();
        for (InterShape shape : allList) {
            if (shape.getSelected()) {
                copiedItemsHistory.add(shape.clone());
            }
        }
    }
}