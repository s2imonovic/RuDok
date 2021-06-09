package dsw.guiSwing.view.repositoryView;

import dsw.guiSwing.view.MainFrame;
import dsw.observer.ISubscriber;
import dsw.repository.Document;
import dsw.repository.Page;
import dsw.repository.Project;
import dsw.repository.Workspace;
import dsw.repository.node.RuNode;
import dsw.repository.slot.Slot;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentView extends JPanel implements ISubscriber {

    private Document document;
    private List<Page> otvoreni = new ArrayList<>();
    private BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
    private ProjectView view;

    public DocumentView(Document document, ProjectView view){
        this.document = document;
        this.document.addSubscriber(this);

        this.view = view;
        this.setLayout(box);
        MainFrame.getInstance().getDokumenti().put(document, this);
    }

    @Override
    public void update(Object notification, String akcija) {

        Project project = ((Project) document.getParent());
        project.setChanged(true);

        if(notification instanceof Page){
            Page page = (Page) notification;

            switch (akcija){
                case "ADD":
                    PageView pageView = new PageView(page, this);
                    otvoreni.add(page);
                    this.add(pageView);
                    this.view.getTabbedPane().setSelectedComponent(this);
                    this.updateUI();
                    break;
                case "DELETE":
                    this.remove(MainFrame.getInstance().getPageView(page));
                    this.otvoreni.remove(page);
                    this.view.getTabbedPane().setSelectedComponent(this);
                    this.updateUI();
                    deleteSlot(page);
                    MainFrame.getInstance().getPagevi().remove(page);
                    break;
                default:
                    break;
            }
        }

        if (notification instanceof Document){
            Document document = (Document) notification;
            switch (akcija){
                case "RENAME":
                    this.view.getTabbedPane().removeAll();
                    for(DocumentView documentView : this.view.getOtvoreni()){
                        this.view.getTabbedPane().addTab(documentView.getDocument().getName(), documentView);
                    }
                    //  this.view.getTabbedPane().setSelectedComponent(MainFrame.getInstance().getDocumentView(document));
                    break;
                default:
                    break;
            }
        }
    }

    public Document getDocument() {
        return document;
    }

    public ProjectView getView() {
        return view;
    }

    public void deleteSlot(Page page){
        for(RuNode node : page.getChildren()){
            Slot slot = (Slot) node;
            MainFrame.getInstance().getSlotovi().remove(slot);
            repaint();
        }
        repaint();
    }
}
