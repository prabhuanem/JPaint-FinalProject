package controller.compositepattern;

import controller.CommandHistory;
import controller.IUndoable;
import controller.commandpattern.AllShape;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.util.ArrayList;
import java.util.List;

public class GroupShape implements IEventCallback, IUndoable {
    private DrawingGroup shapeGroup;
    private final ArrayList<InterShape> allList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();
    private final ArrayList<InterShape> groupingTheShapes = AllShape.allShapesGroup.getInterShapes();
    private final ArrayList<InterShape> dynamicList = new ArrayList<>();
    private final PaintCanvas paintCanvas;

    public GroupShape(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void run(){
        List<InterShape> allShapesCopy = new ArrayList<>(allList);
        dynamicList.addAll(allShapesCopy.stream().filter(shape -> shape != null && shape.getSelected()).peek(allList::remove).toList());

        if (dynamicList.size() > 1){
            shapeGroup = new DrawingGroup(dynamicList);
            shapeGroup.setSelected(true);
            groupingTheShapes.add(shapeGroup);
            dynamicList.removeIf(shape -> shape instanceof DrawingGroup);
            allList.add(shapeGroup);
        }
        else {
            return;
        }
        paintCanvas.repaint();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        allList.addAll(shapeGroup.getSubShapesGroup());
        allList.remove(shapeGroup);
        groupingTheShapes.remove(shapeGroup);
        dynamicList.removeIf(shape -> shape instanceof DrawingGroup);
        groupingTheShapes.addAll(dynamicList);
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        allList.removeAll(dynamicList);
        allList.add(shapeGroup);
        groupingTheShapes.add(shapeGroup);
        dynamicList.removeIf(shape -> shape instanceof DrawingGroup);
        groupingTheShapes.removeAll(dynamicList);
        paintCanvas.repaint();
    }
}
