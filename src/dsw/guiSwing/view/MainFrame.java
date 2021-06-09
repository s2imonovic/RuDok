package dsw.guiSwing.view;

import dsw.AppCore;
import dsw.core.Repository;
import dsw.errorHandler.ErrorType;
import dsw.errorHandler.MyError;
import dsw.guiSwing.controller.ActionManager;
import dsw.guiSwing.editor.RuEditor;
import dsw.guiSwing.editor.model.EditorImpl;
import dsw.guiSwing.tree.RuTree;
import dsw.guiSwing.tree.view.RuTreeImplementation;
import dsw.guiSwing.view.repositoryView.DocumentView;
import dsw.guiSwing.view.repositoryView.PageView;
import dsw.guiSwing.view.repositoryView.ProjectView;
import dsw.guiSwing.view.repositoryView.painters.SlotPainter;
import dsw.observer.ISubscriber;
import dsw.repository.Document;
import dsw.repository.Page;
import dsw.repository.Project;
import dsw.repository.node.RuNode;
import dsw.repository.slot.Slot;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MainFrame extends JFrame implements ISubscriber {

    private static MainFrame instance;
    private MenuBar menuBar;
    private ToolBar toolBar;
    private ActionManager actionManager;
    private Repository documentRepository;
    private RuTree tree;
    private RuEditor editor;
    private JTree workspaceTree;
    private JPanel jPanel;
    private JSplitPane split;
    private Map<Project, ProjectView> proejkti = new HashMap<>();
    private Map<Document, DocumentView> dokumenti = new HashMap<>();
    private Map<Page, PageView> pagevi = new HashMap<>();
    private Map<Slot, SlotPainter> slotovi = new HashMap<>();

    private MainFrame(){

    }
    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
            instance.initialise();
        }

        return instance;
    }

    @Override
    public void update(Object notification, String akcija) {
        Project project = (Project) notification;
        ProjectView view = new ProjectView(project);
    }

    public void initialiseWorkSpaceTree(){
        tree = new RuTreeImplementation();
        editor = new EditorImpl();
        workspaceTree = tree.generateTree(documentRepository.getWorkspace());
        documentRepository.getWorkspace().addSubscriber(this);
        jPanel = new JPanel();
        initialiseGui();
    }

    public JSplitPane getSplit() {
        return split;
    }

    private void initialiseGui(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new OpenWorkspaceFrame(this));
        addWindowListener(new SaveWorkspaceFrame(this));
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("RuDok");

        Palette palette = new Palette();
        getContentPane().add(palette, BorderLayout.EAST);

        JScrollPane scroll = new JScrollPane(workspaceTree);
        scroll.setMinimumSize(new Dimension(200,150));
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, jPanel);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

        menuBar = new MenuBar();
        setJMenuBar(menuBar);

        toolBar = new ToolBar();
        add(toolBar,BorderLayout.NORTH);

    }

    public Project getProjectByName(String name){
        for(Project project : getProejkti().keySet()){
            if(name.equals(project.getName()))
                return project;
        }

        return null;
    }

    public String[] getNames(Document document){
        String res[] = new String[getProejkti().size()];
        int br = 0;
        boolean ok = false;

        for(Project project : getProejkti().keySet()){
            for(RuNode node : project.getChildren()){
                Document document1 = (Document) node;
                if(document1.equals(document))
                    ok = true;

            }

            if(ok == false){
                res[br] = project.getName();
                br++;
            }
            ok = false;
        }

        return res;
    }

    public ProjectView getProjectView(Project project){
        for(ProjectView view : proejkti.values()){
            if(view.getProject().equals(project))
                return view;
        }

        return null;
    }

    public DocumentView getDocumentView(Document document) {
        for (DocumentView view : dokumenti.values()) {
            if (view.getDocument().equals(document))
                return view;
        }

        return null;
    }

    public PageView getPageView(Page page) {
        for (PageView view : pagevi.values()) {
            if (view.getPage().equals(page))
                return view;
        }

        return null;
    }

    public SlotPainter getSlotPainter(Slot slot) {
        for (SlotPainter slotPainter : slotovi.values()) {
            if (slotPainter.getSlot().equals(slot))
                return slotPainter;
        }

        return null;
    }

    public Slot getSlot(SlotPainter painter) {
        for (Slot slot : slotovi.keySet()) {
            if (painter.getSlot().equals(slot))
                return slot;
        }

        return null;
    }

    public List<SlotPainter> getSlotPaintersByPage(Page page) {

        List<SlotPainter> painters = new ArrayList<>();

        for(RuNode node : page.getChildren()){
            Slot slot = (Slot) node;
            painters.add(getSlotPainter(slot));
        }

        return painters;
    }

    private void initialise(){
        actionManager = new ActionManager();
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setDocumentRepository(Repository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Repository getDocumentRepository() {
        return documentRepository;
    }

    public JTree getWorkspaceTree() {
        return workspaceTree;
    }

    public void setWorkspaceTree(JTree workspaceTree) {
        this.workspaceTree = workspaceTree;
    }

    public RuTree getTree() {
        return tree;
    }

    public RuEditor getEditor() {
        return editor;
    }

    public void showError(MyError myError){
        JOptionPane.showMessageDialog(this, myError.getMessage());
    }

    public Map<Project, ProjectView> getProejkti() {
        return proejkti;
    }

    public Map<Document, DocumentView> getDokumenti() {
        return dokumenti;
    }

    public Map<Page, PageView> getPagevi() {
        return pagevi;
    }

    public Map<Slot, SlotPainter> getSlotovi() {
        return slotovi;
    }

    public PageView getOpenPageView() {
        if(!(getTree().getSelected() instanceof Page)){
            AppCore.getInstance().getErrorHandler().generateError(ErrorType.SELEKT);
            return null;
        }
        return getPageView((Page)getTree().getSelected());
    }

}
