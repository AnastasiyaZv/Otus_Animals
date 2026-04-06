package input;

import java.util.Scanner;

public class NameInput {
    //запрашиваем у пользователя имя животного
    public String getName(Scanner scanner){
        String animalNameInput = null;
        do {
            System.out.println("Введите имя животного: ");
            animalNameInput = scanner.next();
            if (animalNameInput == null){
                System.out.println("Имя животного не может быть пустым!");
            }
        }
        while (animalNameInput == null);
        return animalNameInput;
    }
}
