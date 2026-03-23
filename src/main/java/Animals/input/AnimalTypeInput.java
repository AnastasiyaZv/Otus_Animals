package Animals.input;

import Animals.AnimalType;

import java.util.Scanner;

public class AnimalTypeInput {
    //запрашиваем у пользователя тип животного
    public static AnimalType getAnimalType(Scanner scanner){
        String animalTypeInput = null;

        while (AnimalType.doesNotAnimalType(animalTypeInput)){
            if (animalTypeInput != null) {
                System.out.println("Введен неверный тип животного, попробуйте еще раз");
            }
            System.out.printf("Введите одно из животных (%s): ",
                    String.join("/",AnimalType.VALUES));
            animalTypeInput = scanner.next();
        }
        return AnimalType.fromStringAnimalType(animalTypeInput);
    }
}
