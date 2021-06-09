package dsw.errorHandler;

public class MyError {
    private int type;
    private String message;
    private String title;

    public MyError(int type, String message, String title){
        this.type = type;
        this.message = message;
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }
}
