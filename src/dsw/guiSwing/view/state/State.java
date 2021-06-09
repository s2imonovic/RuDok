package dsw.guiSwing.view.state;

import java.awt.event.MouseEvent;

public interface State {
    void mousePressed(MouseEvent e);
    void mouseDragged(MouseEvent e);
    void mouseReleased(MouseEvent e);
}
