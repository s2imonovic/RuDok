package dsw.guiSwing.editor.view;

import dsw.guiSwing.editor.controller.EditAction;
import dsw.guiSwing.editor.controller.SaveImageAction;
import dsw.repository.slot.Slot;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageEditor extends JDialog {

    private Slot slot;
    private JToolBar toolBar = new JToolBar();
    private JPanel jPanel = new JPanel();
    private File file;

    public ImageEditor(Slot slot){
        this.slot = slot;

        EditAction editAction = new EditAction(slot, jPanel, this);
        JButton edit = new JButton(editAction);

        JButton save = new JButton(new SaveImageAction(slot, this));

        toolBar.add(edit);
        toolBar.addSeparator(new Dimension(10,5));;
        toolBar.add(save);

        add(toolBar, BorderLayout.NORTH);

        if(slot.getFile() != null){
            ImageIcon image = new ImageIcon(editAction.setImage(slot.getFile()));
            JLabel jLabel = new JLabel(image);
            jPanel.add(jLabel);
        }

        add(jPanel);

        setSize(400,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
