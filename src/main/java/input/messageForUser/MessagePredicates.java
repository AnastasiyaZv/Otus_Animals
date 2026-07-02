package input.messageForUser;

public class MessagePredicates {
    private final String infoMessage;
    private  final String messageIsNull;

    public MessagePredicates(String infoMessage, String messageIsNull){
        this.infoMessage = infoMessage;
        this.messageIsNull = messageIsNull;
    }

    public String getInfoMessage() {
        return infoMessage;
    }

    public String getMessageIsNull() {
        return messageIsNull;
    }
}
