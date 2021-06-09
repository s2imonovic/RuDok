package dsw.guiSwing.tree;

import dsw.guiSwing.tree.view.RuTreeView;
import dsw.repository.*;
import dsw.repository.node.RuNode;
import dsw.repository.slot.Slot;

import javax.swing.*;

public interface RuTree {
    JTree generateTree(Workspace workspace);
    void addProject(Project project);
    void addDocument(Document document);
    RuNode getSelected();
    void addPage(Page page);
    void addSlot(Slot slot);
    void delete(RuNode select);
    void shareDocument(Document document, Project project);
}
