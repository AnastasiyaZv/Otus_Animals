package factory;

import animals.Animal;
import data.AnimalType;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;


//создаем животное
public class AnimalFactory {
    public Animal create(AnimalType type){
        if (type == AnimalType.CAT){
            return new Cat();
        }
        if (type == AnimalType.DOG){
            return new Dog();
        }
        if (type == AnimalType.DUCK){
            return new Duck();
        }
        return null;
    }
}
