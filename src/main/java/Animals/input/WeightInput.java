package Animals.input;

import java.util.Scanner;

public class WeightInput {
    //запрашиваем у пользователя вес животного
    public static int getWeight (Scanner scanner){
        String animalWeightInput;
        int weight = 0;
        do {
            System.out.println("Введите вес животного в кг: ");
            animalWeightInput = scanner.next();
            if (Animals.utils.NumberUtils.isNotNumber(animalWeightInput)){
                System.out.println("Вес животного должен быть указан числом!");
            } else {
                weight = Integer.parseInt(animalWeightInput);
                if (weight == 0){
                    System.out.println("Вес животного должен быть больше 0!");
                }
            }
        } while (Animals.utils.NumberUtils.isNotNumber(animalWeightInput) || weight ==0);
        return Integer.parseInt(animalWeightInput);
    }
}
