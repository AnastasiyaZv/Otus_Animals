package Animals;

import java.util.ArrayList;
import java.util.List;

public enum AnimalType {

    CAT,
    DOG,
    DUCK;

    //список животных в строковом виде для удобства поиска
    public static final List<String> VALUES= collectValues();

    private static List<String> collectValues(){
        List<String> result = new ArrayList<>();
        for (AnimalType type : AnimalType.values()){
            result.add(type.name());
        }
        return result;
    }

    //проверяем пользовательский ввод одной из команд с учетом регистра toUpperCase()
    //и обрезания пробелов trim().

    public static boolean doesNotAnimalType(String value){
        if (value == null){
            return true;
        }
        return !VALUES.contains(value.toUpperCase().trim());
    }

    // возвращаем строковое представление типа животного с учетом регистра toUpperCase()
    //и обрезания пробелов trim()
    public static AnimalType fromStringAnimalType(String value){
        if (value == null){
            return null;
        }
        return AnimalType.valueOf(value.toUpperCase().trim());
    }
}
