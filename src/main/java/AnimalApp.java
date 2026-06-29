import animals.AbsAnimal;
import data.AnimalType;
import data.Color;
import data.Command;
import factory.AnimalFactory;
import input.*;
import input.validators.NumberInput;
import tools.PrintLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AnimalApp {
    public static void main(String[] args) {

        NameInput nameInput = new NameInput();
        ColorInput colorInput = new ColorInput();
        List<AbsAnimal> animals = new ArrayList<>();

        do {
            //запрашиваем команду
            Command currentCommand = CommandInput.getCommand();

            if (currentCommand == Command.EXIT) {
                System.exit(0);
            }

            if (currentCommand == Command.LIST) {
                new PrintLists<AbsAnimal>().printList(animals);
                continue;
            }

            //запрашиваем тип животного
            AnimalType animalType = AnimalTypeInput.getAnimalType();

            //запрашиваем параметры животного
            String name = nameInput.getName();

            MessageData ageMessageData = new MessageData(
                    "Введите возраст животного в годах: ",
                    "Возраст животного должен быть указан числом!",
                    "Возраст животного должен быть больше 0!"
            );
            NumberInput ageNumberInput = new NumberInput(ageMessageData);
            int age = ageNumberInput.parseStrToNumber();

            MessageData weightMessageData = new MessageData(
                    "Введите вес животного в кг: ",
                    "Вес животного должен быть указан числом!",
                    "Вес животного должен быть больше 0!"
            );
            NumberInput weightNumberInput = new NumberInput(weightMessageData);
            int weight = weightNumberInput.parseStrToNumber();

            Color color = colorInput.getColor();

            AbsAnimal animal = new AnimalFactory(age, weight, name, color).create(animalType);
            animals.add(animal);
            animal.say();

        } while (true);
        //TODO PostgresqlConnector().close - добавить
    }
}