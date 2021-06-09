package dsw.guiSwing.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AboutAction extends AbstractRudokAction {

    public AboutAction() {
        putValue(NAME,"Studenti");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            JDialog dialog = new JDialog();
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();

            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setTitle("Studenti");

            panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
            panel1.add(new JLabel("Student: Filip Novakovic"));
            panel1.add(new JLabel("Indeks: RN 88/2020"));
            panel1.add(new JLabel("Slika: "));

            panel1.add(new JLabel(new ImageIcon("images/bold_22x22.jpg")));
            panel1.setMinimumSize(new Dimension(150,200));



             panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
              panel2.add(new JLabel("Student: Srdjan Simonovic"));
             panel2.add(new JLabel("Indeks: RN 92/2020"));
             panel2.add(new JLabel("Slika: "));
            panel2.add(new JLabel(new ImageIcon("images/bold_22x22.jpg")));
            panel2.setMinimumSize(new Dimension(150,200));
            JSplitPane sp1= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel1,panel2);
            sp1.setDividerLocation(250);

             dialog.add(sp1);
             dialog.setLocationRelativeTo(null);
             dialog.setSize(new Dimension(500, 500));
             dialog.setVisible(true);

    }
}
