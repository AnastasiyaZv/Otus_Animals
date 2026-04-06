package input;

import utils.NumberUtils;

import java.util.Scanner;

public class AgeInput {
    //запрашиваем у пользователя возраст животного
    public int getAge(Scanner scanner){
        String animalAgeInput;
        int age = 0;

        do {
            System.out.println("Введите возраст животного в годах: ");
            animalAgeInput = scanner.next();
            if (NumberUtils.isNotNumber(animalAgeInput)){
                System.out.println("Возраст животного должен быть указан числом!");
            } else {
                age = Integer.parseInt(animalAgeInput);
                if (age == 0){
                    System.out.println("Возраст животного должен быть больше 0!");
                }
            }
        } while (NumberUtils.isNotNumber(animalAgeInput) || age == 0);
        return Integer.parseInt(animalAgeInput);
    }
}
