package dsw.guiSwing.tree.view;

import dsw.repository.Workspace;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class RuTreeCellRenderer extends DefaultTreeCellRenderer {

    public RuTreeCellRenderer() {

    }

    public Component getTreeCellRendererComponent(RuTreeView tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        return this;
    }

}
