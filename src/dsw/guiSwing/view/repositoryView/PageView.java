package dsw.guiSwing.view.repositoryView;

import dsw.guiSwing.view.MainFrame;
import dsw.guiSwing.view.repositoryView.painters.CirclePainter;
import dsw.guiSwing.view.repositoryView.painters.RectanglePainter;
import dsw.guiSwing.view.repositoryView.painters.SlotPainter;
import dsw.guiSwing.view.repositoryView.painters.TrianglePainter;
import dsw.guiSwing.view.state.StateManager;
import dsw.observer.ISubscriber;
import dsw.repository.Document;
import dsw.repository.Page;
import dsw.repository.Project;
import dsw.repository.node.RuNode;
import dsw.repository.slot.RectangleSlot;
import dsw.repository.slot.Slot;
import dsw.repository.slot.SlotType;
import dsw.repository.slot.TriangleSlot;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class PageView extends JPanel implements ISubscriber {

    private Page page;
    private JLabel jLabel = new JLabel();
    private DocumentView view;
    private StateManager manager = new StateManager(this);
    private Point2D lastPosition = null;
    private Rectangle2D selectionRec = null;

    public PageView(Page page, DocumentView view){
        this.page = page;
        this.page.addSubscriber(this);
        this.view = view;

        jLabel.setText(page.getName());
        this.add(jLabel);
        this.setBorder(new BevelBorder(BevelBorder.LOWERED));
        PageViewController controller = new PageViewController(this);
        this.addMouseListener(controller);
        this.addMouseMotionListener(controller);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

        MainFrame.getInstance().getPagevi().put(page, this);
    }

    @Override
    public void update(Object notification, String akcija) {
        ((Project)((Document) page.getParent()).getParent()).setChanged(true);
        if (notification instanceof Page){
            Page page = (Page) notification;

            switch (akcija){
                case "RENAME":
                    jLabel.setText(page.getName());
                    this.view.getView().getTabbedPane().setSelectedComponent(this.view);
                    break;
                case "SELECT":
                    repaint();
                    break;
            }
        }

        if(notification instanceof Slot){
            Slot slot = (Slot) notification;
            SlotPainter painter = null;

            switch (akcija){
                case "TREE":
                    MainFrame.getInstance().getTree().addSlot(slot);
                    break;
                case "ADD":
                    if(slot.getType() == SlotType.RECTANGLE){
                        painter = new RectanglePainter(slot);
                    } else if(slot.getType() == SlotType.CIRCLE){
                        painter = new CirclePainter(slot);
                    } else{
                        painter = new TrianglePainter(slot);
                    }

                    MainFrame.getInstance().getSlotovi().put(slot, painter);
                    repaint();
                    break;
                case "DELETE":
                    MainFrame.getInstance().getTree().delete(slot);
                    MainFrame.getInstance().getSlotovi().remove(slot);
                    repaint();
                    break;
                case "HANDLER":

                    if(slot instanceof RectangleSlot){
                        painter = new RectanglePainter(slot);

                    }else if(slot instanceof TriangleSlot){
                        painter = new TrianglePainter(slot);
                    }else{
                        painter = new CirclePainter(slot);
                    }

                    MainFrame.getInstance().getSlotovi().put(slot, painter);
                    painter.setPaint(Color.YELLOW);
                    repaint();
                    break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setComposite(AlphaComposite.getInstance((AlphaComposite.SRC_OVER), 0.8f));

        for (SlotPainter painter : MainFrame.getInstance().getSlotPaintersByPage(page)) {
            painter.paint(graphics2D, painter.getSlot());
        }

        if(selectionRec != null){
            graphics2D.draw(selectionRec);
        }

    }

    public List<Point> getPoints(){
        List<Point> points = new ArrayList<>();

        for(RuNode node : page.getChildren()){
            Slot slot = (Slot) node;
            points.add(slot.getPosition());
        }

        return points;
    }

    public List<Dimension> getDimensions(){
        List<Dimension> dimensions = new ArrayList<>();

        for(RuNode node : page.getChildren()){
            Slot slot = (Slot) node;
            dimensions.add(slot.getSize());
        }

        return dimensions;
    }

    public List<Integer> getAngles(){
        List<Integer> angles = new ArrayList<>();

        for(RuNode node : page.getChildren()){
            Slot slot = (Slot) node;
            angles.add(slot.getAngle());
        }

        return angles;
    }

    public Page getPage() {
        return page;
    }

    public DocumentView getView() {
        return view;
    }

    public StateManager getManager() {
        return manager;
    }

    public void startCircleState() {
        repaint();
        manager.setCircleState();
    }

    public void startSelectState() {
        repaint();
        manager.setSelectState();
    }

    public void startRectangleState(){
        repaint();
        manager.setRectangleState();
    }

    public void startTriangleState(){
        repaint();
        manager.setTriangleState();
    }

    public void startMoveState(){
        repaint();
        manager.setMoveState();
    }

    public void startResizeState(){
        repaint();
        manager.setResizeState();
    }

    public void startRotateState(){
        repaint();
        manager.setRotateState();
    }

    public void startDeleteState(){
        repaint();
        manager.setDeleteState();
    }

    public void startLassoState(){
        repaint();
        manager.setLassoState();
    }

    public StateManager getStateManager() {
        return manager;
    }

    public Point2D getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(Point2D lastPosition) {
        this.lastPosition = lastPosition;
    }

    public Rectangle2D getSelectionRec() {
        return selectionRec;
    }

    public void setSelectionRec(Rectangle2D selectionRec) {
        this.selectionRec = selectionRec;
    }
}
