package dsw.guiSwing.controller;

import dsw.guiSwing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SelectionAction extends AbstractRudokAction{

    public SelectionAction() {
        putValue(SMALL_ICON, loadIcon("imagess/hand.png"));
        putValue(NAME, "Hand cursor");
        putValue(SHORT_DESCRIPTION, "Hand cursor");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getOpenPageView() == null){
            return;
        }
        MainFrame.getInstance().getOpenPageView().startSelectState();
    }
}
