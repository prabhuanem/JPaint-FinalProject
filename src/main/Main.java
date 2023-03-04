package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseTracking;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState, paintCanvas, new Point(0,0));
        controller.setup();
        MouseTracking mouseTracking = new MouseTracking(paintCanvas, appState);
        paintCanvas.addMouseListener(mouseTracking);

    }
}
