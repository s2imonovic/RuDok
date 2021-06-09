package dsw.guiSwing.controller;

import dsw.guiSwing.view.MainFrame;
import dsw.guiSwing.view.repositoryView.PageView;
import dsw.repository.Page;

import java.awt.event.ActionEvent;

public class CircleAction extends AbstractRudokAction{

    public CircleAction() {
        putValue(SMALL_ICON, loadIcon("imagess/circle.png"));
        putValue(NAME, "Draw circle");
        putValue(SHORT_DESCRIPTION, "Draw circle");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getOpenPageView() == null){
            return;
        }
        MainFrame.getInstance().getOpenPageView().startCircleState();
    }
}
