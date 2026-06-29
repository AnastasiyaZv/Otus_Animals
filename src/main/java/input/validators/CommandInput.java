package input.validators;

import data.Command;

public class CommandInput extends AbsInput {

    public Command getCommand() {
        String commandInput = null;

        while (Command.doesNotContain(commandInput)) {
            if (commandInput != null) {
                System.out.println("Введена неверная команда, попробуйте еще раз");
            }
            System.out.printf("Введите одну из команд (%s): ",
                    String.join("/", Command.VALUES));
            commandInput = scanner.next();
        }
        return Command.fromString(commandInput);
    }
}
