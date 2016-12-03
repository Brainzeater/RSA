package exchanges;

/**
 * Created by Александр on 03.12.2016.
 */
public class Message {
    private String author;
    private String typeOfMessage;
    private int value;

    public Message(String author, String typeOfMessage, int value) {
        this.author = author;
        this.typeOfMessage = typeOfMessage;
        this.value = value;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTypeOfMessage() {
        return typeOfMessage;
    }

    public void setTypeOfMessage(String typeOfMessage) {
        this.typeOfMessage = typeOfMessage;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Author: " + author + "; Type of message: "
                + typeOfMessage + "; Value: " + value;
    }
}
