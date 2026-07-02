import animals.AbsAnimal;
import data.AnimalType;
import data.Color;
import data.Command;
import factory.AnimalFactory;
import input.messageForUser.MessageData;
import input.messageForUser.MessagePredicates;
import input.validators.*;
import tables.AnimalTable;
import tools.PrintLists;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AnimalApp {

    public static void main(String[] args) {

        NameInput nameInput = new NameInput();
        ColorInput colorInput = new ColorInput();
        List<AbsAnimal> animals = new ArrayList<>();

        do {
            Command currentCommand = new CommandInput().getCommand();

            if (currentCommand == Command.EXIT) {
                System.exit(0);
            }

            if (currentCommand == Command.LIST) {
                new PrintLists<AbsAnimal>().printList(animals);
                MessagePredicates messagePredicates = new MessagePredicates(
                        "Введите условие для выборки данных, например type='CAT': ",
                        "Условие для выборки данных не может быть пустым");
                PredicatesInput predicatesWhere = new PredicatesInput(messagePredicates);
                String where = predicatesWhere.getPredicates();
                try {
                    new PrintLists<>().printDataFromDB(new AnimalTable().listDataFromTable(where, "id", "name", "type", "color", "age", "weight"));
                } catch (SQLException e) {
                    System.out.println("Указано некорректное условие.");
                }
                continue;
            }

            if (currentCommand == Command.UPDATE){
                MessagePredicates messagePredicatesWhere = new MessagePredicates(
                        "Введите условие для выборки данных",
                        "Условие для выборки данных не может быть пустым"
                );

                PredicatesInput predicatesWhere = new PredicatesInput(messagePredicatesWhere);
                String where = predicatesWhere.getPredicates();

                MessagePredicates messagePredicatesSet = new MessagePredicates(
                        "Введите условие для обновления данных",
                        "Условие для обновления данных не может быть пустым"
                );
                PredicatesInput predicatesSet = new PredicatesInput(messagePredicatesSet);
                String set = predicatesSet.getPredicates();

                try{
                    new AnimalTable().updateTable(where, set);
                } catch (SQLException e) {
                    System.out.println("Указано некорректное условие");
                }
                continue;
            }

            AnimalType animalType = new AnimalTypeInput().getAnimalType();

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
            try {
                new AnimalTable().addAnimal(animal);
            } catch (SQLException e) {
                System.out.println(e.getStackTrace());
            }
        } while (true);
    }
}