package dsw.guiSwing.view.repositoryView;

import dsw.guiSwing.view.MainFrame;
import dsw.observer.ISubscriber;
import dsw.repository.Document;
import dsw.repository.Page;
import dsw.repository.Project;
import dsw.repository.Workspace;
import dsw.repository.node.RuNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {

    private JLabel jLabel;
    private Project project;
    private JTabbedPane tabbedPane;
    private BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
    private List<DocumentView> otvoreni = new ArrayList<>();

    public ProjectView(Project project){
        this.project = project;
        this.project.addSubscriber(this);

        this.setLayout(box);
        jLabel = new JLabel(project.getName());

        createTabbedPane();

        this.add(jLabel);
        this.add(tabbedPane);
        MainFrame.getInstance().getSplit().setRightComponent(this);
        MainFrame.getInstance().getProejkti().put(project, this);
    }

    @Override
    public void update(Object notification, String akcija) {

        if(notification instanceof Project){
            Project project = (Project) notification;
            project.setChanged(true);
            switch (akcija){
                case "DELETE":
                    this.tabbedPane.removeAll();
                    otvoreni.clear();
                    MainFrame.getInstance().getSplit().setRightComponent(new JPanel());
                    for(RuNode node : project.getChildren()){
                        Document document = (Document) node;
                        for(RuNode ruNode : document.getChildren()){
                            Page page = (Page) ruNode;
                            MainFrame.getInstance().getDocumentView(document).deleteSlot(page);
                        }
                    }
                    MainFrame.getInstance().getProejkti().remove(project);
                    updateUI();
                    break;
                case "RENAME":
                    this.jLabel.setText(project.getName());
                    updateUI();
                    break;
            }
            return;
        }

        if(notification instanceof Document){
            Document document = (Document) notification;
            ((Project)document.getParent()).setChanged(true);
            switch (akcija){
                case "ADD":
                    DocumentView documentView = new DocumentView(document, this);
                    otvoreni.add(documentView);
                    this.tabbedPane.addTab(document.getName(), documentView);
                    this.tabbedPane.setSelectedComponent(documentView);
                    break;
                case "DELETE":
                    this.tabbedPane.remove(MainFrame.getInstance().getDocumentView(document));
                    otvoreni.remove(MainFrame.getInstance().getDocumentView(document));
                    for(RuNode node : document.getChildren()){
                        Page page = (Page) node;
                        MainFrame.getInstance().getDocumentView(document).deleteSlot(page);
                    }

                    updateUI();
                    MainFrame.getInstance().getProejkti().remove(document);
                    break;
                default:
                    break;
            }
        }
    }

    private void createTabbedPane(){
        this.tabbedPane = new JTabbedPane();
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public List<DocumentView> getOtvoreni() {
        return otvoreni;
    }

    public Project getProject() {
        return project;
    }

    @Override
    public String toString() {
        return project.getName();
    }
}
