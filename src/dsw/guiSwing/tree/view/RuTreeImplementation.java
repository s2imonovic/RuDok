package dsw.guiSwing.tree.view;

import dsw.guiSwing.tree.RuTree;
import dsw.guiSwing.tree.model.RuTreeItem;
import dsw.repository.*;
import dsw.repository.node.RuNode;
import dsw.repository.node.RuNodeComposite;
import dsw.repository.slot.Slot;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class RuTreeImplementation implements RuTree{

    private RuTreeView treeView;
    private DefaultTreeModel treeModel;


    @Override
    public JTree generateTree(Workspace workspace) {
        RuTreeItem root = new RuTreeItem(workspace);
        treeModel = new DefaultTreeModel(root);
        treeView = new RuTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addProject(Project project) {
        RuNode nodeModel = ((RuTreeItem)treeModel.getRoot()).getNodeModel();
        ((RuTreeItem)treeModel.getRoot()).add(new RuTreeItem(project));
        ((Workspace) nodeModel).addChild(project);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void addDocument(Document document) {
        RuNode project = ((RuTreeItem) treeView.getLastSelectedPathComponent()).getNodeModel();
        ((RuTreeItem)(treeView.getLastSelectedPathComponent())).add(new RuTreeItem(document));
        ((Project)project).addChild(document);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public RuNode getSelected() {
        if(treeView.getLastSelectedPathComponent() == null){
            return null;
        }

        return ((RuTreeItem) treeView.getLastSelectedPathComponent()).getNodeModel();
    }

    @Override
    public void addPage(Page page) {
        RuNode document = ((RuTreeItem) treeView.getLastSelectedPathComponent()).getNodeModel();
        ((RuTreeItem)(treeView.getLastSelectedPathComponent())).add(new RuTreeItem(page));
        ((Document)document).addChild(page);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void addSlot(Slot slot) {
        RuNode page = ((RuTreeItem) treeView.getLastSelectedPathComponent()).getNodeModel();
        ((RuTreeItem)(treeView.getLastSelectedPathComponent())).add(new RuTreeItem(slot));
        ((Page)page).addChild(slot);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void delete(RuNode child) {
        RuNode parent = ((RuTreeItem) treeView.getLastSelectedPathComponent()).getNodeModel().getParent();
        ((RuTreeItem)(treeView.getLastSelectedPathComponent())).removeFromParent();
        ((RuNodeComposite) parent).deleteChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void shareDocument(Document document, Project project) {

        RuTreeItem root = (RuTreeItem) treeModel.getRoot();
        RuTreeItem parent = root.findChildByName(document.getParent().getName());
        RuTreeItem item =  parent.findChildByName(document.getName());
        item.setName(item.getName() + "*");
        document.setName(document.getName());
        root.findChildByName(project.getName()).insert(item,0);

        treeView.expandPath(treeView.getSelectionPath());
        project.addChild(document);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

}


