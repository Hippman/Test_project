package Service;

public class ServiceException extends Exception {
    private String message;

    public String getText() {
        return message;
    }

    public void setText(String message) {
        this.message = message;
    }

    public ServiceException(Integer exnum)
    {
        switch (exnum)
        {
            case 1: message="The database connection has not yet been established. Try again later."; break;
            case 2: message="Empty table."; break;
            default:message="Unknown exception.";
        }

    }
}
