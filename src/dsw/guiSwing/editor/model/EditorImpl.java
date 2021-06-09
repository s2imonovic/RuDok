package dsw.guiSwing.editor.model;

import dsw.guiSwing.editor.RuEditor;
import dsw.guiSwing.editor.view.ImageEditor;
import dsw.guiSwing.editor.view.TextEditor;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.slot.ContentType;
import dsw.repository.slot.Slot;

import javax.swing.*;

public class EditorImpl implements RuEditor {

    @Override
    public void show(Slot slot) {

        if(slot.getContentType() == null){
            ContentType type = (ContentType) JOptionPane.showInputDialog(MainFrame.getInstance(), "Izaberite tip slota",
                    "Slot type", JOptionPane.QUESTION_MESSAGE, null, ContentType.values(), ContentType.valueOf("TEXT"));
            slot.setContentType(type);
        }

        if(slot.getContentType() == ContentType.IMAGE){
            ImageEditor editor = new ImageEditor(slot);
        }

        if(slot.getContentType() == ContentType.TEXT){
            TextEditor editor = new TextEditor(slot);
        }

    }
}
