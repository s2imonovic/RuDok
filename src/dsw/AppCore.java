package dsw;

import dsw.commands.CommandManager;
import dsw.core.*;
import dsw.errorHandler.ErrorHandlerImpl;
import dsw.guiSwing.SwingGui;
import dsw.repository.RepositoryImpl;
import dsw.serialization.SerializationImpl;
import dsw.slotHandler.SlotHandlerImpl;

public class AppCore extends ApplicationFramework {

    private static AppCore instance;

    private AppCore(){

    }

    public static AppCore getInstance(){
        if(instance == null){
            instance= new AppCore();
        }
        return instance;
    }

    @Override
    public void run() {
        this.gui.start();
    }

    public static void main(String[] args) {
        Repository repository = new RepositoryImpl();
        Gui gui = new SwingGui(repository);
        ErrorHandler errorHandler = new ErrorHandlerImpl();
        SlotHandler slotHandler = new SlotHandlerImpl();
        Serialization serialization = new SerializationImpl();
        Command command = new CommandManager();
        ApplicationFramework myApp = AppCore.getInstance();
        myApp.initialise(gui, repository, errorHandler, slotHandler, serialization, command);
        myApp.run();
    }
}
