package dsw.guiSwing.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OpenWorkspaceFrame extends WindowAdapter {

    private MainFrame mainFrame;

    public OpenWorkspaceFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

        String[] options = {"Yes","No"};

        int res = JOptionPane.showOptionDialog(mainFrame, "Do you want to open previous workspace?", "Open previous workspace", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if(res == JOptionPane.YES_OPTION) {
            MainFrame.getInstance().getActionManager().getOpenWorkspaceAction().action();
        }
        else if(res == JOptionPane.NO_OPTION) {
            return;
        }
    }
}
