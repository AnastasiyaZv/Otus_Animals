package data;

import java.util.ArrayList;
import java.util.List;

public enum Command {
    ADD,
    LIST,
    EXIT;

    //список команд в строком виде для удобства поиска
    public static final List<String> VALUES = collectValues();

    private static List<String> collectValues(){
        List<String> result = new ArrayList<>();
        for (Command type : Command.values()){
            result.add(type.name());
        }
        return result;
    }

    //проверяем пользовательский ввод одной из команд с учетом регистра toUpperCase()
    //и обрезания пробелов trim().
    public static boolean doesNotContain(String value){
        if (value == null){
            return true;
        }
        return !VALUES.contains(value.toUpperCase().trim());
    }

    // возвращаем строковое представление команды с учетом регистра toUpperCase()
    //и обрезания пробелов trim()
    public static Command fromString(String value){
        if (value == null){
            return null; //либо вернуть Exception
        }
        return Command.valueOf(value.toUpperCase().trim());
    }
}
