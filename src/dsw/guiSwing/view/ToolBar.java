package dsw.guiSwing.view;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {

    public ToolBar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getSaveAsAction());
        addSeparator(new Dimension(10,5));
        add(MainFrame.getInstance().getActionManager().getSaveAction());
        addSeparator(new Dimension(10,5));
        add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        addSeparator(new Dimension(10,5));
        add(MainFrame.getInstance().getActionManager().getNewDocumentAction());
        addSeparator(new Dimension(10,5));
        add(MainFrame.getInstance().getActionManager().getNewPageAction());
        addSeparator(new Dimension(10,5));
        add(MainFrame.getInstance().getActionManager().getOpenAction());
        addSeparator(new Dimension(10,5));
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        addSeparator(new Dimension(10,5));
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        addSeparator(new Dimension(10,5));
        add(MainFrame.getInstance().getActionManager().getShareAction());
        addSeparator(new Dimension(10,5));
        add(MainFrame.getInstance().getActionManager().getSwitchWorkspace());
        addSeparator(new Dimension(10,5));
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
        add(Box.createHorizontalGlue());
        add(MainFrame.getInstance().getActionManager().getExitAction());
    }

}
