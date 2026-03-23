import Animals.Animal;
import Animals.AnimalType;
import Animals.Command;
import Animals.factory.AnimalFactory;

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
            //запрашиваем команду
           currentCommand = Animals.input.CommandInput.getCommand(scanner);

           if (currentCommand == Command.LIST){
               if (animals.isEmpty()){
                   System.out.println("Список пуст");
               }
               for (Animal animal : animals){
                   System.out.println(animal);
               }
           } else if (currentCommand == Command.ADD){

               //запрашиваем тип животного
               AnimalType animalType = Animals.input.AnimalTypeInput.getAnimalType(scanner);
               //создаем животное
               Animal animal = factory.create(animalType);

               //запрашиваем параметры животного
               animal.setName(Animals.input.NameInput.getName(scanner));
               animal.setAge(Animals.input.AgeInput.getAge(scanner));
               animal.setWeight(Animals.input.WeightInput.getWeight(scanner));
               animal.setColor(Animals.input.ColorInput.getColor(scanner));

               //добавляем животное в список
               animals.add(animal);

               animal.say();
           }
        } while (currentCommand != Command.EXIT);
    }
}