package controller;

import controller.commandpattern.*;
import controller.compositepattern.GroupShape;
import controller.compositepattern.UngroupShape;
import model.interfaces.IApplicationState;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    private final PaintCanvas paintCanvas;
    private final Point clickPoint;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, PaintCanvas paintCanvas, Point clickPoint)
    {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
        this.clickPoint = clickPoint;
        paintCanvas.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                final Point pasteClickPoint = e.getPoint();
                clickPoint.setLocation(pasteClickPoint);
            }
        });
    }

    @Override
    public void setup()
    {
        setupEvents();
    }

    private void setupEvents()
    {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, applicationState::setActiveShape);
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, applicationState::setActivePrimaryColor);
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, applicationState::setActiveSecondaryColor);
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, applicationState::setActiveShadingType);
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, applicationState::setActiveStartAndEndPointMode);
        uiModule.addEvent(EventName.UNDO, () -> new Undo().run());
        uiModule.addEvent(EventName.REDO, () -> new Redo().run());
        uiModule.addEvent(EventName.COPY, () -> new Copy().run());
        uiModule.addEvent(EventName.PASTE, () ->
        {
            if (clickPoint != null)
            {
                new PasteShape(paintCanvas, clickPoint).run();
            }
        });
        uiModule.addEvent(EventName.DELETE, () -> new Delete(paintCanvas).run());
        uiModule.addEvent(EventName.GROUP, () -> new GroupShape(paintCanvas).run());
        uiModule.addEvent(EventName.UNGROUP, () -> new UngroupShape(paintCanvas).run());
    }
}
