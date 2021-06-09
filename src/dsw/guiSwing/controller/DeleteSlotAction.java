package dsw.guiSwing.controller;

import dsw.guiSwing.view.MainFrame;

import java.awt.event.ActionEvent;

public class DeleteSlotAction extends AbstractRudokAction{

    public DeleteSlotAction() {
        putValue(SMALL_ICON, loadIcon("imagess/delete2.png"));
        putValue(NAME, "Delete slot");
        putValue(SHORT_DESCRIPTION, "Delete slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getOpenPageView() == null){
            return;
        }
        MainFrame.getInstance().getOpenPageView().startDeleteState();
    }

}
