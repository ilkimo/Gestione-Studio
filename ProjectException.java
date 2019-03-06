
public class ProjectException extends Exception {
    private String excMessage;

    public ProjectException() {excMessage = "Exception message not specified";}

    public ProjectException(String msg) {excMessage = msg;}

    public String getExcMessage() {
        return excMessage;
    }
}

class YearException extends ProjectException {
    public YearException(String msg) {
        super(msg);
    }
}

class MonthException extends ProjectException {
    public MonthException(String msg) {
        super(msg);
    }
}
