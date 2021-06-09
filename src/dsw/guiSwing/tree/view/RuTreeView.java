package dsw.guiSwing.tree.view;

import dsw.guiSwing.tree.controller.RuTreeCellEditor;
import dsw.guiSwing.tree.controller.RuTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class RuTreeView extends JTree{

    public RuTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        RuTreeCellRenderer ruTreeCellRenderer = new RuTreeCellRenderer();
        addTreeSelectionListener(new RuTreeSelectionListener());
        setCellEditor(new RuTreeCellEditor(this, ruTreeCellRenderer));
        setCellRenderer(ruTreeCellRenderer);
        setEditable(true);
    }

}
