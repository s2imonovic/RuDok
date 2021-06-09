package dsw.guiSwing.editor.controller;

import dsw.guiSwing.controller.AbstractRudokAction;
import dsw.guiSwing.editor.view.ImageEditor;
import dsw.repository.slot.Slot;

import java.awt.event.ActionEvent;

public class SaveImageAction extends AbstractRudokAction {

    private Slot slot;
    private ImageEditor editor;

    public SaveImageAction(Slot slot, ImageEditor editor){
        this.slot = slot;
        this.editor = editor;
        putValue(SMALL_ICON, loadIcon("image/save.png"));
        putValue(NAME, "Save");
        putValue(SHORT_DESCRIPTION, "Save");
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if(editor.getFile() != null){
            slot.setFile(editor.getFile());
        }

    }
}
