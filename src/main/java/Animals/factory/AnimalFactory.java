package Animals.factory;

import Animals.Animal;
import Animals.AnimalType;
import Animals.birds.Duck;
import Animals.pets.Cat;
import Animals.pets.Dog;


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
