package data;

import java.util.ArrayList;
import java.util.List;

public enum Color {
    BLACK("черный"),
    GRAY("серый"),
    BLUE("голубой"),
    RED("рыжий"),
    WHITE("белый");

    public static final List<String> VALUES = collectValues();
    private final String value;

    Color(String value) {
        this.value = value;
    }

    public static List<String> collectValues() {
        List<String> result = new ArrayList<>();
        for (Color type : Color.values()) {
            result.add(type.name());
        }
        return result;
    }

    //проверяем пользовательский ввод одной из команд с учетом регистра toUpperCase()
    //и обрезания пробелов trim().
    public static boolean doesNotColor(String value) {
        if (value == null) {
            return true;
        }
        return !VALUES.contains(value.toUpperCase().trim());
    }

    // возвращаем строковое представление команды с учетом регистра toUpperCase()
    //и обрезания пробелов trim()
    public static Color fromString(String value) {
        if (value == null) {
            return null;
        }
        return Color.valueOf(value.toUpperCase().trim());
    }

    public String getValue() {
        return value;
    }
}
