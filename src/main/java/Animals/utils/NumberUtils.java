package Animals.utils;

public class NumberUtils {
    //проверка введенного пользователем значения на число
    public static boolean isNotNumber(String value){
        if (value == null){
            return true;
        }
        return !value.matches("\\d+");
    }

}
