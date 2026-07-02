import animals.AbsAnimal;
import data.AnimalType;
import data.Color;
import data.Command;
import factory.AnimalFactory;
import input.MessageData;
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
        PredicatesWhereInput predicatesWhereInput = new PredicatesWhereInput();
        PredicatesSetInput predicatesSetInput = new PredicatesSetInput();

        do {
            Command currentCommand = new CommandInput().getCommand();

            if (currentCommand == Command.EXIT) {
                System.exit(0);
            }

            if (currentCommand == Command.LIST) {
                new PrintLists<AbsAnimal>().printList(animals);
                String predicates = predicatesWhereInput.getPredicatesWhere();
                try {
                    new PrintLists<>().printDataFromDB(new AnimalTable().listDataFromTable(predicates, "id", "name", "type", "color", "age", "weight"));
                } catch (SQLException e) {
                    System.out.println("Указано некорректное условие.");
                }
                continue;
            }

            if (currentCommand == Command.UPDATE){
                String predicatesWhere = predicatesWhereInput.getPredicatesWhere();
                String predicatesSet = predicatesSetInput.getPredicatesSet();
                try{
                    new AnimalTable().updateTable(predicatesWhere, predicatesSet);
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