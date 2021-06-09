package dsw.guiSwing.controller;

import dsw.guiSwing.view.MainFrame;

import java.awt.event.ActionEvent;

public class TriangleAction extends AbstractRudokAction{

    public TriangleAction() {
        putValue(SMALL_ICON, loadIcon("imagess/triangle.png"));
        putValue(NAME, "Draw triangle");
        putValue(SHORT_DESCRIPTION, "Draw triangle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getOpenPageView() == null){
            return;
        }
        MainFrame.getInstance().getOpenPageView().startTriangleState();
    }
}
