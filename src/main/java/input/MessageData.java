package input;

/**
 * класс хранящий сообщения для пользователя
 */

public class MessageData {
    private final String ifoMessage;
    private final String messageIsNumber;
    private final String messageNumberIsZero;

    public MessageData(String infoMessage, String messageIsNumber, String messageNumberIsZero) {
        this.ifoMessage = infoMessage;
        this.messageIsNumber = messageIsNumber;
        this.messageNumberIsZero = messageNumberIsZero;

    }

    public String getIfoMessage() {
        return ifoMessage;
    }

    public String getMessageIsNumber() {
        return messageIsNumber;
    }

    public String getMessageNumberIsZero() {
        return messageNumberIsZero;
    }
}
