package controller.compositepattern;

import controller.CommandHistory;
import controller.IUndoable;
import controller.commandpattern.AllShape;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import view.interfaces.InterShape;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UngroupShape implements IUndoable, IEventCallback {

    private final ArrayList<InterShape> allList = AllShape.INTER_SHAPE_ARRAY_LIST.getInterShapes();
    private final ArrayList<InterShape> groupingTheShapes = AllShape.allShapesGroup.getInterShapes();
    private final ArrayList<InterShape> dynamicList = new ArrayList<>();
    private final ArrayList<InterShape> subShapes = new ArrayList<>();
    private final PaintCanvas paintCanvas;

    public UngroupShape(PaintCanvas paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
        dynamicList.addAll(groupingTheShapes.stream().filter(shape -> shape.getSelected()).peek(shape -> {
            subShapes.addAll(((DrawingGroup) shape).getSubShapesGroup());
        }).collect(Collectors.toList()));

        groupingTheShapes.removeAll(dynamicList);
        subShapes.removeIf(shape -> shape instanceof DrawingGroup);
        groupingTheShapes.addAll(subShapes);
        allList.removeAll(dynamicList);
        allList.addAll(subShapes);
        CommandHistory.add(this);
        paintCanvas.repaint();
    }

    @Override
    public void redo() {
        groupingTheShapes.removeAll(dynamicList);
        allList.removeAll(dynamicList);
        allList.addAll(subShapes);
        groupingTheShapes.addAll(subShapes);
        paintCanvas.repaint();
    }

    @Override
    public void undo() {
        groupingTheShapes.removeAll(dynamicList);
        allList.addAll(dynamicList);
        allList.removeAll(subShapes);
        groupingTheShapes.removeIf(shape -> subShapes.contains(shape));
        paintCanvas.repaint();
    }
}
