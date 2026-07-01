package animals.pets;

import animals.AbsAnimal;
import data.AnimalType;
import data.Color;

public class Dog extends AbsAnimal {

    public Dog(int age, int weight, String name, Color color, AnimalType type) {
        super(age, weight, name, color, type);
    }

    @Override
    public void say() {
        System.out.println("Гав");
    }
}
