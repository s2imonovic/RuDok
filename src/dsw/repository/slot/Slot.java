package dsw.repository.slot;

import dsw.repository.node.RuNode;

import java.awt.*;
import java.io.File;
import java.io.Serializable;

public abstract class Slot extends RuNode implements Serializable {

    private Dimension size;
    private Point position;
    private SlotType type;
    private int angle;
    private File file;
    private ContentType contentType;

    public Slot(String name, RuNode parent) {
        super(name, parent);
    }

    public void setType(SlotType type) {
        this.type = type;
    }

    public SlotType getType() {
        return type;
    }

    public Dimension getSize() {
        return size;
    }

    public Point getPosition() {
        return position;
    }

    public void setSize(Dimension size) {
        this.size = size;
        setAkcija("HANDLER");
        notifySubscribers(this);
    }

    public void setPosition(Point position) {
        this.position = position;
        setAkcija("HANDLER");
        notifySubscribers(this);
    }

    public void setAngle(int angle) {
        this.angle = angle;
        setAkcija("HANDLER");
        notifySubscribers(this);
    }

    public int getAngle() {
        return angle;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
