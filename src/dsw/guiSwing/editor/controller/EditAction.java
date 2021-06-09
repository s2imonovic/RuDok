package dsw.guiSwing.editor.controller;

import dsw.guiSwing.controller.AbstractRudokAction;
import dsw.guiSwing.editor.view.ImageEditor;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.slot.Slot;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class EditAction extends AbstractRudokAction {

    private Slot slot;
    private JPanel jPanel;
    private ImageEditor editor;

    public EditAction(Slot slot, JPanel jPanel, ImageEditor editor){
        this.slot = slot;
        this.jPanel = jPanel;
        this.editor = editor;
        putValue(SMALL_ICON, loadIcon("image/edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.png", "png");
        jfc.setFileFilter(filter);

        int value = jfc.showOpenDialog(MainFrame.getInstance());
        if(value == JFileChooser.APPROVE_OPTION) {
            File file = new File(jfc.getSelectedFile().getAbsoluteFile().toString());
            editor.setFile(file);
            ImageIcon image = new ImageIcon(setImage(jfc.getSelectedFile().getAbsoluteFile()));
            JLabel jLabel = new JLabel(image);
            jPanel.add(jLabel);
            editor.setjPanel(jPanel);
            editor.setSize(500,400);
        }

    }


}
