package animals.pets;

import animals.AbsAnimal;
import data.AnimalType;
import data.Color;

public class Cat extends AbsAnimal {

    public Cat(int age, int weight, String name, Color color, AnimalType type) {
        super(age, weight, name, color, type);
    }

    @Override
    public void say() {
        System.out.println("Мяу");
    }
}
