package dsw.guiSwing.controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public abstract class AbstractRudokAction extends AbstractAction {

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

    public Image setImage(File file) {
        Image image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            URL imageURL = getClass().getResource("");
            try {
                image = ImageIO.read(imageURL);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return image;
    }

}
