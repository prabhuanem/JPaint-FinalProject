package controller.commandpattern;

import controller.CommandHistory;
import view.interfaces.IEventCallback;

public class Redo implements IEventCallback {

    @Override
    public void run() { CommandHistory.redo(); }
}
