package dsw.guiSwing.view;

import javax.swing.*;
import java.awt.*;

public class Palette extends JToolBar {

    public Palette(){
        super(JToolBar.VERTICAL);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(MainFrame.getInstance().getActionManager().getSelectionAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getRectangleAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getTriangleAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getCircleAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getMoveAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getResizeAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getRotateAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getDeleteSlotAction());
    }

}
