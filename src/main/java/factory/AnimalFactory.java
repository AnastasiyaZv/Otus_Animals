package factory;

import animals.AbsAnimal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalType;
import data.Color;

public class AnimalFactory {

    private final int age;
    private final int weight;
    private final String name;
    private final Color color;

    public AnimalFactory(int age, int weight, String name, Color color) {
        this.age = age;
        this.weight = weight;
        this.name = name;
        this.color = color;
    }

    public AbsAnimal create(AnimalType type) {
        if (type == AnimalType.CAT) {
            return new Cat(age, weight, name, color, type);
        }
        if (type == AnimalType.DOG) {
            return new Dog(age, weight, name, color, type);
        }
        if (type == AnimalType.DUCK) {
            return new Duck(age, weight, name, color, type);
        }
        return null;
    }
}
