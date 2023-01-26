package view.drawing;

import view.interfaces.InterColoring;

public class Coloring {
    private InterColoring interColoring;

    public void setInterColoring(InterColoring interColoring) {
        this.interColoring = interColoring;
    }

    public void executeShadingStrategy() {
        interColoring.drawWithSelectedShadingType();
    }
}
