package input;

import data.Color;

import java.util.Scanner;

public class ColorInput {
    //запрашиваем у пользователя цвет животного
    public Color getColor (Scanner scanner){
        String animalColorInput = null;
        while (Color.doesNotColor(animalColorInput)) {
            if (animalColorInput != null) {
                System.out.println("Введенный цвет отсутствует в списке цветов, попробуйте еще раз");
            }
            System.out.printf("Выберете один из цветов (%s): ",
                    String.join("/", Color.VALUES));
            animalColorInput = scanner.next();
        }
        return Color.fromString(animalColorInput);
    }
}
