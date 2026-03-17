import Animals.Animal;
import Animals.AnimalType;
import Animals.Color;
import Animals.Command;
import Animals.factory.AnimalFactory;
import Animals.pets.Cat;
import Animals.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AnimalApp {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        AnimalFactory factory = new AnimalFactory();

        Scanner scanner = new Scanner(System.in);
        Command currentCommand = null;

        do{
           currentCommand = getCommand(scanner);

           if (currentCommand == Command.LIST){
               if (animals.isEmpty()){
                   System.out.println("Список пуст");
               }
               for (Animal animal : animals){
                   System.out.println(animal);
               }
           } else if (currentCommand == Command.ADD){
               AnimalType animalType = getAnimalType(scanner);
               Animal animal = factory.create(animalType); //создаем животное

               animal.setName(getName(scanner));
               animal.setAge(getAge(scanner));
               animal.setWeight(getWeight(scanner));
               animal.setColor(getColor(scanner));

               animals.add(animal); //добавляем животное в список
               animal.say();
           }
        } while (currentCommand != Command.EXIT);


    }

    //запрашиваем у пользователя команду
    private static Command getCommand(Scanner scanner){
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

    //запрашиваем у пользователя тип животного
    private static AnimalType getAnimalType(Scanner scanner){
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

    //запрашиваем у пользователя имя животного
    private static String getName(Scanner scanner){
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

    //запрашиваем у пользователя возраст животного
    private static int getAge(Scanner scanner){
        String animalAgeInput;
        do {
            System.out.println("Введите возраст животного в годах: ");
            animalAgeInput = scanner.next();
            if (isNotNumber(animalAgeInput)){
                System.out.println("Возраст животного должен быть указан числом!");
            }
        } while (isNotNumber(animalAgeInput));
        return Integer.parseInt(animalAgeInput);
    }

    //запрашиваем у пользователя вес животного
    private static int getWeight (Scanner scanner){
        String animalWeightInput;
        do {
            System.out.println("Введите вес животного в кг: ");
            animalWeightInput = scanner.next();
            if (isNotNumber(animalWeightInput)){
                System.out.println("Вес животного должен быть указан числом!");
            }
        } while (isNotNumber(animalWeightInput));
        return Integer.parseInt(animalWeightInput);
    }

    //проверка введенного пользователем значения на число
    private static boolean isNotNumber(String value) {
        if (value == null) {
            return true;
        }
        return !value.matches("\\d+");
    }

    //запрашиваем у пользователя цвет животного
    private static Color getColor (Scanner scanner){
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