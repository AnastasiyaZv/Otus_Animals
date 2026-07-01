import animals.AbsAnimal;
import data.AnimalType;
import data.Color;
import data.Command;
import database.PostgresqlConnector;
import factory.AnimalFactory;
import input.MessageData;
import input.validators.*;
import tables.AnimalTable;
import tools.PrintLists;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AnimalApp {

    public static void main(String[] args) throws SQLException {

        NameInput nameInput = new NameInput();
        ColorInput colorInput = new ColorInput();
        List<AbsAnimal> animals = new ArrayList<>();
        AnimalTable animalTable = new AnimalTable();

        do {
            Command currentCommand = new CommandInput().getCommand();

            if (currentCommand == Command.EXIT) {
                System.exit(0);
            }

            if (currentCommand == Command.LIST) {
                new PrintLists<AbsAnimal>().printList(animals);
                new PrintLists<>().printDataFromDB(animalTable.listDataFromTable("", "id", "name", "type", "color", "age", "weight"));
                continue;
            }

            //запрашиваем тип животного
            AnimalType animalType = new AnimalTypeInput().getAnimalType();

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
            animalTable.addAnimal(animal);
            animal.say();

        } while (true);
    }
}