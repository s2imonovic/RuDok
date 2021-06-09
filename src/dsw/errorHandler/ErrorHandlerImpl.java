package dsw.errorHandler;

import dsw.core.ErrorHandler;
import dsw.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandlerImpl implements ErrorHandler {

    private List<ISubscriber> subscribers;

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(ISubscriber listener : subscribers){
            listener.update(notification, null);
        }
    }

    @Override
    public void generateError(ErrorType errorType) {
        if(errorType == ErrorType.PRAZAN_STRING){
            notifySubscribers(new MyError(1, "Morate popuniti polje za ime", "Greska prilikom unosa imena"));
            return;
        }

        if(errorType == ErrorType.ISTO_IME) {
            notifySubscribers(new MyError(1, "Ime vec postoji, morate uneti drugo ime", "Greska prilikom unosa imena"));
            return;
        }

        if(errorType == ErrorType.SELEKT){
            notifySubscribers(new MyError(1, "Morate selektovati odgovarajuci cvor", "Greska prilikom selektovanja cvora"));
            return;
        }

        if(errorType == ErrorType.ROOT){
            notifySubscribers(new MyError(1, "Ne mozete obrisati workspace", "Greska prilikom brisanja"));
            return;
        }

        if(errorType == ErrorType.SHAPE){
            notifySubscribers(new MyError(1, "Greska prilikom selektovanja slota", "Greska"));
            return;
        }
    }
}
