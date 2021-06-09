package dsw.guiSwing.view.repositoryView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

public class PageViewController extends MouseAdapter implements MouseMotionListener {

    private PageView view;

    public PageViewController(PageView view){
        this.view = view;
    }

    @Override
    public void mousePressed(MouseEvent e){
        view.setLastPosition(new Point2D.Double(e.getX(), e.getY()));
        view.getManager().getCurrentState().mousePressed(e);
    }

    @Override
    public void mouseDragged(MouseEvent e){
        view.getManager().getCurrentState().mouseDragged(e);
    }

    @Override
    public void mouseReleased(MouseEvent e){
        view.getManager().getCurrentState().mouseReleased(e);
    }
}
