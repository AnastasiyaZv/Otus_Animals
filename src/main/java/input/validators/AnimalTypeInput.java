package input.validators;

import data.AnimalType;

public class AnimalTypeInput extends AbsInput {

    //запрашиваем у пользователя тип животного
    public AnimalType getAnimalType() {
        String animalTypeInput = null;

        while (AnimalType.doesNotAnimalType(animalTypeInput)) {
            if (animalTypeInput != null) {
                System.out.println("Введен неверный тип животного, попробуйте еще раз");
            }
            System.out.printf("Введите одно из животных (%s): ",
                    String.join("/", AnimalType.VALUES));
            animalTypeInput = scanner.next();
        }
        return AnimalType.fromStringAnimalType(animalTypeInput);
    }
}
