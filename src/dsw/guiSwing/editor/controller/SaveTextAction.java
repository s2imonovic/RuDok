package dsw.guiSwing.editor.controller;

import dsw.guiSwing.controller.AbstractRudokAction;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.Workspace;
import dsw.repository.slot.Slot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveTextAction extends AbstractRudokAction {

    private JTextPane jTextPane;
    private Slot slot;

    public SaveTextAction(JTextPane textPane, Slot slot){
        this.jTextPane = textPane;
        this.slot = slot;
        putValue(SMALL_ICON, loadIcon("image/save.png"));
        putValue(NAME, "Save");
        putValue(SHORT_DESCRIPTION, "Save");
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        Workspace workspace = MainFrame.getInstance().getDocumentRepository().getWorkspace();

        try{
            File file = new File(slot.getName());
            FileWriter writer = new FileWriter(file, false);
            writer.write(jTextPane.getText());
            writer.close();
            slot.setFile(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
