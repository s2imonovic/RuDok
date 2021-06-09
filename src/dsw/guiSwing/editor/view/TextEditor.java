package dsw.guiSwing.editor.view;

import dsw.guiSwing.editor.controller.SaveTextAction;
import dsw.repository.slot.Slot;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class TextEditor extends JDialog{

    private Slot slot;
    private JTextPane textPane = new JTextPane();
    private JToolBar toolBar = new JToolBar();

    public TextEditor(Slot slot){
        this.slot = slot;

        JButton bold = new JButton(new StyledEditorKit.BoldAction());
        Icon icon = loadIcon("images/bold.png");
        bold.setIcon(icon);
        bold.setText("");

        JButton italic = new JButton(new StyledEditorKit.ItalicAction());
        Icon icon1 = loadIcon("images/italic.png");
        italic.setIcon(icon1);
        italic.setText("");

        JButton underline = new JButton(new StyledEditorKit.UnderlineAction());
        Icon icon2 = loadIcon("images/underline.png");
        underline.setIcon(icon2);
        underline.setText("");

        toolBar.add(bold);
        toolBar.addSeparator(new Dimension(10,5));;
        toolBar.add(italic);
        toolBar.addSeparator(new Dimension(10,5));;
        toolBar.add(underline);
        toolBar.addSeparator(new Dimension(10,5));;
        toolBar.add(new SaveTextAction(textPane, slot));

        add(toolBar, BorderLayout.NORTH);

        if(slot.getFile() != null){
            try{
                Scanner scanner = new Scanner(slot.getFile());
                StringBuilder sb = new StringBuilder();
                while (scanner.hasNextLine()){
                    String data = scanner.nextLine();
                    sb.append(data);
                    sb.append("\n");
                }
                scanner.close();
                textPane.setText(sb.toString());
            }catch (FileNotFoundException exception){
                System.out.println("greska");
            }
        }

        add(textPane);
        setSize(400,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Icon loadIcon(String fileName){

        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }


}
