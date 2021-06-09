package dsw.guiSwing.controller;

import dsw.guiSwing.view.MainFrame;

import java.awt.event.ActionEvent;

public class MoveAction extends AbstractRudokAction{

    public MoveAction() {
        putValue(SMALL_ICON, loadIcon("imagess/move.png"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getOpenPageView() == null){
            return;
        }
        MainFrame.getInstance().getOpenPageView().startMoveState();
    }

}
