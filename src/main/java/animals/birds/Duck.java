package animals.birds;

import animals.AbsAnimal;
import data.Color;

public class Duck extends AbsAnimal implements Flying {

    public Duck(int age, int weight, String name, Color color) {
        super(age, weight, name, color);
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
