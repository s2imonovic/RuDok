package dsw.guiSwing.controller;

import dsw.AppCore;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractRudokAction{

    public RedoAction() {
        putValue(SMALL_ICON, loadIcon("imagess/redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AppCore.getInstance().getCommand().getCommandManager().doCommand();
    }

}
