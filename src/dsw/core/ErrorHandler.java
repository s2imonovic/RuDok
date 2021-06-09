package dsw.core;

import dsw.errorHandler.ErrorType;
import dsw.errorHandler.MyError;
import dsw.observer.IPublisher;

public interface ErrorHandler extends IPublisher {
    void generateError(ErrorType errorType);
}
