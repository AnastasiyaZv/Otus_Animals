package input.validators;

import input.messageForUser.MessageData;
import utils.NumberUtils;

public class NumberInput extends AbsInput {

    private final MessageData messageData;

    public NumberInput(MessageData messageData) {
        this.messageData = messageData;
    }

    public int parseStrToNumber() {
        String stringInput = "";
        int number = 0;

        do {
            System.out.println(messageData.getIfoMessage());
            stringInput = scanner.next();

            if (NumberUtils.isNotNumber(stringInput)) {
                System.out.println(messageData.getMessageIsNumber());
                continue;
            }

            number = Integer.parseInt(stringInput);
            if (number != 0) {
                return number;
            }
            System.out.println(messageData.getMessageNumberIsZero());
        } while (true);
    }
}
