package dsw.core;

import dsw.commands.CommandManager;
import dsw.observer.IPublisher;

public interface Command extends IPublisher {
    CommandManager getCommandManager();
}
