package dsw.guiSwing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {

    public MenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAsAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewDocumentAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewPageAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getOpenAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getShareAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getSwitchWorkspace());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(MainFrame.getInstance().getActionManager().getUndoAction());
        editMenu.add(MainFrame.getInstance().getActionManager().getRedoAction());

        JMenu windowMenu = new JMenu("Window");
        JMenu helpMenu = new JMenu("Help");
        JMenu aboutMenu = new JMenu("About");

        this.add(fileMenu);
        this.add(editMenu);
        this.add(windowMenu);
        this.add(helpMenu);
        this.add(Box.createHorizontalGlue());
        this.add(aboutMenu);

        aboutMenu.add(MainFrame.getInstance().getActionManager().getAboutAction());
    }


}
