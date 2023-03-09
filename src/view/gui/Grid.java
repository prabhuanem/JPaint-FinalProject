package view.gui;

import java.awt.*;

public class Grid {
    private boolean visible;
    private int gridSize;

    public Grid(int gridSize) {
        this.gridSize = gridSize;
        this.visible = false;
    }

    public void toggleVisibility() {
        visible = !visible;
    }

    public void draw(Graphics g, int canvasWidth, int canvasHeight) {
        if (visible) {
            g.setColor(Color.LIGHT_GRAY);

            // Using this loop to Draw vertical grid lines
            for (int x = 0; x < canvasWidth; x += gridSize) {
                g.drawLine(x, 0, x, canvasHeight);
            }

            // Using this loop to Draw horizontal grid lines
            for (int y = 0; y < canvasHeight; y += gridSize) {
                g.drawLine(0, y, canvasWidth, y);
            }
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }
}
