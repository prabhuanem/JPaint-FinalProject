package view.strategypattern;

import view.interfaces.InterColoring;

public class Coloring {
    private InterColoring interColoring;

    public void shadingColoring(InterColoring interColoring) {
        this.interColoring = interColoring;
    }

    public void implementShading() {
        interColoring.shadeDrawing();
    }
}
