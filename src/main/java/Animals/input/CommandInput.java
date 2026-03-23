package Animals.input;

import Animals.Command;

import java.util.Scanner;

public class CommandInput {
    //запрашиваем у пользователя команду
    public static Command getCommand(Scanner scanner){
        String commandInput = null;

        while (Command.doesNotContain(commandInput)){
            if (commandInput != null){
                System.out.println("Введена неверная команда, попробуйте еще раз");
            }
            System.out.printf("Введите одну из команд (%s): ",
                    String.join("/", Command.VALUES));
            commandInput = scanner.next();
        }
        return Command.fromString(commandInput);
    }
}
