package dsw.guiSwing.controller;

import dsw.AppCore;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractRudokAction{

    public UndoAction() {
        putValue(SMALL_ICON, loadIcon("imagess/undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AppCore.getInstance().getCommand().getCommandManager().undoCommand();
    }

}
