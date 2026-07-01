package animals.birds;

import animals.AbsAnimal;
import data.AnimalType;
import data.Color;

public class Duck extends AbsAnimal implements Flying {

    public Duck(int age, int weight, String name, Color color, AnimalType type) {
        super(age, weight, name, color, type);
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }
}
