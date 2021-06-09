package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.errorHandler.ErrorType;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.Document;
import dsw.repository.Page;

import java.awt.event.ActionEvent;
import java.util.Random;

public class NewPageAction extends AbstractRudokAction{

    public NewPageAction() {
        putValue(SMALL_ICON, loadIcon("imagess/pageR.png"));
        putValue(NAME, "New Page");
        putValue(SHORT_DESCRIPTION, "New Page");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int label = new Random().nextInt(100);
        Page page = new Page("Page " + label, MainFrame.getInstance().getTree().getSelected());

        if(!(page.getParent() instanceof Document)){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.SELEKT);
            return;
        }

        MainFrame.getInstance().getTree().addPage(page);

    }

}
