package dsw.guiSwing.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SaveWorkspaceFrame extends WindowAdapter {

    private MainFrame mainFrame;

    public SaveWorkspaceFrame(MainFrame frame) {
        this.mainFrame = frame;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {

        String[] option = {"Yes","No"};

        int res = JOptionPane.showOptionDialog(mainFrame, "Do you want to save this workspace", "Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

        if(res == JOptionPane.YES_OPTION) {
            MainFrame.getInstance().getActionManager().getSaveWorkspaceAction().action();
        }

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
