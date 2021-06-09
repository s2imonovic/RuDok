package dsw.guiSwing.controller;

import dsw.AppCore;
import dsw.errorHandler.ErrorType;
import dsw.guiSwing.tree.model.RuTreeItem;
import dsw.guiSwing.view.MainFrame;
import dsw.guiSwing.view.repositoryView.ProjectView;
import dsw.repository.Project;
import dsw.repository.Workspace;
import dsw.repository.node.RuNode;

import java.awt.event.ActionEvent;
import java.util.Random;

public class NewProjectAction extends AbstractRudokAction {

    public NewProjectAction() {
        putValue(SMALL_ICON, loadIcon("imagess/newP.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int label = new Random().nextInt(100);

        if(!(MainFrame.getInstance().getTree().getSelected() instanceof Workspace)){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.SELEKT);
            return;
        }

        Project project = new Project("Project " + label, (RuNode) ((RuTreeItem) MainFrame.getInstance().getWorkspaceTree().getModel().getRoot()).getNodeModel());

        MainFrame.getInstance().getTree().addProject(project);
        //ProjectView view = new ProjectView(project);
    }

}
