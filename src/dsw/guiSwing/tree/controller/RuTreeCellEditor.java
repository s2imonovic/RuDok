package dsw.guiSwing.tree.controller;

import dsw.AppCore;
import dsw.errorHandler.ErrorType;
import dsw.guiSwing.tree.model.RuTreeItem;
import dsw.guiSwing.view.MainFrame;
import dsw.repository.*;
import dsw.repository.node.RuNode;
import dsw.repository.slot.Slot;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class RuTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn =null;
    private JTextField edit=null;

    public RuTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        clickedOn =arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent){
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent e){

        if (!(clickedOn instanceof RuTreeItem))
            return;

        RuTreeItem clicked = (RuTreeItem) clickedOn;
        String s;

        if (clicked.getNodeModel() instanceof Workspace) {
            s = (String) e.getActionCommand();
            if(s.length() == 0){
                AppCore.getInstance().getErrorHandler().generateError(ErrorType.PRAZAN_STRING);
                return;
            }
            clicked.setName(e.getActionCommand());
        } else if (clicked.getNodeModel() instanceof Project) {
            Project project = (Project) clicked.getNodeModel();
            s = (String) e.getActionCommand();
            if(s.length() == 0){
                AppCore.getInstance().getErrorHandler().generateError(ErrorType.PRAZAN_STRING);
                return;
            }
            for(RuNode node : MainFrame.getInstance().getDocumentRepository().getWorkspace().getChildren()){
                Project project1 = (Project) node;
                if(project1.getName().equals(s)){
                    AppCore.getInstance().getErrorHandler().generateError(ErrorType.ISTO_IME);
                    return;
                }
            }
            clicked.setName(e.getActionCommand());
        } else if (clicked.getNodeModel() instanceof Document) {
            Document document = (Document) clicked.getNodeModel();
            s = (String) e.getActionCommand();
            if(s.length() == 0){
                AppCore.getInstance().getErrorHandler().generateError(ErrorType.PRAZAN_STRING);
                return;
            }
            Project project = (Project) document.getParent();
            for(RuNode node : project.getChildren()){
                Document document1 = (Document) node;
                if(document1.getName().equals(s)){
                    AppCore.getInstance().getErrorHandler().generateError(ErrorType.ISTO_IME);
                    return;
                }
            }
            clicked.setName(e.getActionCommand());
        } else if (clicked.getNodeModel() instanceof Page) {
            Page page = (Page) clicked.getNodeModel();
            s = (String) e.getActionCommand();
            if(s.length() == 0){
                AppCore.getInstance().getErrorHandler().generateError(ErrorType.PRAZAN_STRING);
                return;
            }

            Document document = (Document) page.getParent();

            for(RuNode node : document.getChildren()){
                Page page1 = (Page) node;
                if(page1.getName().equals(s)){
                    AppCore.getInstance().getErrorHandler().generateError(ErrorType.ISTO_IME);
                    return;
                }
            }
            clicked.setName(e.getActionCommand());
        } else if (clicked.getNodeModel() instanceof Slot) {
            Slot slot = (Slot) clicked.getNodeModel();
            s = (String) e.getActionCommand();
            if(s.length() == 0){
                AppCore.getInstance().getErrorHandler().generateError(ErrorType.PRAZAN_STRING);
                return;
            }

            Page page = (Page) slot.getParent();

            for(RuNode node : page.getChildren()){
                Slot slot1 = (Slot) node;
                if(slot1.getName().equals(s)){
                    AppCore.getInstance().getErrorHandler().generateError(ErrorType.ISTO_IME);
                    return;
                }
            }
            clicked.setName(e.getActionCommand());
        }

    }

}
