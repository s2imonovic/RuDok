package dsw.guiSwing.tree.model;

import dsw.repository.node.RuNode;
import dsw.repository.node.RuNodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.*;

public class RuTreeItem extends DefaultMutableTreeNode{

    private String name;
    private RuNode nodeModel;

    public RuTreeItem(RuNode nodeModel) {
        this.nodeModel = nodeModel;
        this.name = nodeModel.getName();
    }

    public RuTreeItem(RuNode ruNode, String name) {
        this.name = name;
        this.nodeModel = ruNode;
    }

    @Override
    public int getIndex(TreeNode node) {
        return findIndexByChild((RuTreeItem)node);
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return findChildByIndex(childIndex);
    }

    @Override
    public int getChildCount() {
        if(nodeModel instanceof RuNodeComposite)
            return ((RuNodeComposite) nodeModel).getChildren().size();
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {

        if(nodeModel instanceof RuNodeComposite)
            return true;
        return false;

    }

    @Override
    public boolean isLeaf() {
        if(nodeModel instanceof RuNodeComposite)
            return false;
        return true;
    }

    @Override
    public Enumeration children() {
        if(nodeModel instanceof RuNodeComposite)
            return (Enumeration) ((RuNodeComposite) nodeModel).getChildren();
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj != null && obj instanceof RuTreeItem) {
            RuTreeItem otherObj = (RuTreeItem) obj;
            return this.nodeModel.equals(otherObj.nodeModel);
        }
        return false;
    }

    public RuTreeItem findChildByName(String name){

        if(nodeModel instanceof RuNodeComposite){
            RuTreeItem toLookFor = new RuTreeItem(((RuNodeComposite) nodeModel).getChildByName(name));

            Iterator childrenIterator = children.iterator();
            TreeNode current;

            while (childrenIterator.hasNext()){
                current = (TreeNode) childrenIterator.next();
                if (current.equals(toLookFor)){
                    return (RuTreeItem) current;
                }

            }
        }

        return null;
    }

    private TreeNode findChildByIndex(int childIndex){

        if(nodeModel instanceof RuNodeComposite){
            RuTreeItem toLookFor = new RuTreeItem(((RuNodeComposite) nodeModel).getChildren().get(childIndex));

            if(children == null){
                children = new Vector<>();
                for(RuNode node : ((RuNodeComposite) nodeModel).getChildren()){
                    children.add(new RuTreeItem(node));
                }
            }


            Iterator childrenIterator = children.iterator();
            TreeNode current;

            while (childrenIterator.hasNext()){
                current = (TreeNode) childrenIterator.next();
                if (current.equals(toLookFor))
                    return current;
            }
        }

        return null;
    }

    @Override
    public void insert(MutableTreeNode newChild, int childIndex) {
        if(children == null)
            children = new Vector<>();
        children.insertElementAt(newChild, childIndex);
    }

    private int findIndexByChild(RuTreeItem node){

        if(this.nodeModel instanceof RuNodeComposite){
            return  ((RuNodeComposite) this.nodeModel).getChildren().indexOf(node.getNodeModel());
        }
        return -1;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.nodeModel.setName(name);
    }

    public String getName() {
        return name;
    }

    public RuNode getNodeModel() {
        return nodeModel;
    }

}
