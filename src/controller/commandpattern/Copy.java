package controller.commandpattern;

import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.util.ArrayList;

public class Copy implements IEventCallback {
    private final ArrayList<InterShape> allList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();
    private final ArrayList<InterShape> copiedItemsHistory = AllShape.copiedItems_History.getInterShapes();

    @Override
    public void run() {
        copiedItemsHistory.clear();
        allList.stream()
                .filter(InterShape::getSelected)
                .forEach(InterShape::copy);
    }

}
