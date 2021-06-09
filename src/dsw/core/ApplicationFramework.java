package dsw.core;

public abstract class ApplicationFramework {

    protected Gui gui;
    protected Repository repository;
    protected ErrorHandler errorHandler;
    protected SlotHandler slotHandler;
    protected Serialization serialization;
    protected Command command;

    public abstract void run();

    public void initialise(Gui gui, Repository repository, ErrorHandler errorHandler, SlotHandler slotHandler, Serialization serialization, Command command){
        this.gui = gui;
        this.repository = repository;
        this.errorHandler = errorHandler;
        this.errorHandler.addSubscriber(gui);
        this.slotHandler = slotHandler;
        this.serialization = serialization;
        this.command = command;
        this.command.addSubscriber(gui);
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }

    public Gui getGui() {
        return gui;
    }

    public Repository getRepository() {
        return repository;
    }

    public SlotHandler getSlotHandler() {
        return slotHandler;
    }

    public void setSlotHandler(SlotHandler slotHandler) {
        this.slotHandler = slotHandler;
    }

    public Serialization getSerialization() {
        return serialization;
    }

    public void setSerialization(Serialization serialization) {
        this.serialization = serialization;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
