package animals.pets;

import animals.AbsAnimal;
import data.Color;

public class Cat extends AbsAnimal {

    public Cat(int age, int weight, String name, Color color) {
        super(age, weight, name, color);
    }

    @Override
    public void say() {
        System.out.println("Мяу");
    }
}
