import animals.Animal;
import data.AnimalType;
import data.Command;
import factory.AnimalFactory;
import input.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AnimalApp {

    private static NameInput nameInput = new NameInput();
    private static WeightInput weightInput = new WeightInput();
    private static AgeInput ageInput = new AgeInput();
    private static ColorInput colorInput = new ColorInput();

    private static List<Animal> animals = new ArrayList<>();
    private static AnimalFactory factory = new AnimalFactory();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Command currentCommand = null;

        do{
            //запрашиваем команду
           currentCommand = CommandInput.getCommand(scanner);

           if (currentCommand == Command.LIST){
               if (animals.isEmpty()){
                   System.out.println("Список пуст");
               }
               for (Animal animal : animals){
                   System.out.println(animal);
               }
           } else if (currentCommand == Command.ADD){

               //запрашиваем тип животного
               AnimalType animalType = AnimalTypeInput.getAnimalType(scanner);
               //создаем животное
               Animal animal = factory.create(animalType);

               //запрашиваем параметры животного
               animal.setName(nameInput.getName(scanner));
               animal.setAge(ageInput.getAge(scanner));
               animal.setWeight(weightInput.getWeight(scanner));
               animal.setColor(colorInput.getColor(scanner));

               //добавляем животное в список
               animals.add(animal);

               animal.say();
           }
        } while (currentCommand != Command.EXIT);
    }
}