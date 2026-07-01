package animals;

import data.AnimalType;
import data.Color;

public abstract class AbsAnimal {
    private String name;
    private int age;
    private int weight;
    private Color color;
    private AnimalType type;

    public AbsAnimal(int age, int weight, String name, Color color, AnimalType type) {
        this.age = age;
        this.weight = weight;
        this.name = name;
        this.color = color;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return String.format("Привет! Меня зовут %s, мне %d %s, мой вес - %d кг, мой цвет - %s",
                name, age, getYearWord(age), weight, color.getValue());
    }

    private String getYearWord(int age) {
        int lastNum = age % 10;
        int lastTwoNum = age % 100;
        if (lastTwoNum >= 11 && lastTwoNum <= 13) {
            return "лет";
        }
        if (lastNum == 1) {
            return "год";
        }
        if (lastNum >= 2 && lastNum <= 4) {
            return "года";
        }
        return "лет";
    }

}
