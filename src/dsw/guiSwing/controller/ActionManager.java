package dsw.guiSwing.controller;

public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private NewDocumentAction newDocumentAction;
    private NewPageAction newPageAction;
    private DeleteAction deleteAction;
    private AboutAction aboutAction;
    private OpenAction openAction;
    private ShareAction shareAction;
    private SelectionAction selectionAction;
    private TriangleAction triangleAction;
    private CircleAction circleAction;
    private RectangleAction rectangleAction;
    private DeleteSlotAction deleteSlotAction;
    private RotateAction rotateAction;
    private ResizeAction resizeAction;
    private MoveAction moveAction;
    private SaveAction saveAction;
    private OpenProjectAction openProjectAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private SaveWorkspaceAction saveWorkspaceAction;
    private OpenWorkspaceAction openWorkspaceAction;
    private SwitchWorkspace switchWorkspace;

    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions() {
        newProjectAction = new NewProjectAction();
        exitAction = new ExitAction();
        newDocumentAction = new NewDocumentAction();
        newPageAction = new NewPageAction();
        deleteAction = new DeleteAction();
        aboutAction = new AboutAction();
        openAction = new OpenAction();
        shareAction = new ShareAction();
        selectionAction = new SelectionAction();
        triangleAction = new TriangleAction();
        circleAction = new CircleAction();
        rectangleAction = new RectangleAction();
        deleteSlotAction = new DeleteSlotAction();
        rotateAction = new RotateAction();
        resizeAction = new ResizeAction();
        moveAction = new MoveAction();
        saveAction = new SaveAction();
        openProjectAction = new OpenProjectAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        saveWorkspaceAction = new SaveWorkspaceAction();
        openWorkspaceAction = new OpenWorkspaceAction();
        switchWorkspace = new SwitchWorkspace();
    }

    public ShareAction getShareAction() {
        return shareAction;
    }

    public OpenAction getOpenAction() {
        return openAction;
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public NewDocumentAction getNewDocumentAction() {
        return newDocumentAction;
    }

    public NewPageAction getNewPageAction() {
        return newPageAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public AboutAction getAboutAction() { return aboutAction; }

    public SelectionAction getSelectionAction() {
        return selectionAction;
    }

    public CircleAction getCircleAction() {
        return circleAction;
    }

    public RectangleAction getRectangleAction() {
        return rectangleAction;
    }

    public TriangleAction getTriangleAction() {
        return triangleAction;
    }

    public DeleteSlotAction getDeleteSlotAction() {
        return deleteSlotAction;
    }

    public MoveAction getMoveAction() {
        return moveAction;
    }

    public ResizeAction getResizeAction() {
        return resizeAction;
    }

    public RotateAction getRotateAction() {
        return rotateAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public OpenProjectAction getSaveAsAction() {
        return openProjectAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public SaveWorkspaceAction getSaveWorkspaceAction() {
        return saveWorkspaceAction;
    }

    public OpenWorkspaceAction getOpenWorkspaceAction() {
        return openWorkspaceAction;
    }

    public SwitchWorkspace getSwitchWorkspace() {
        return switchWorkspace;
    }
}
