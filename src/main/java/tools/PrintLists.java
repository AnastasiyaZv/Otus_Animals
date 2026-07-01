package tools;

import java.util.List;
import java.util.Map;

public class PrintLists<T>  {
    public void printList(List<T> list) {
        if (list.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (T item : list) {
            System.out.println(item);
        }
    }

    public void printDataFromDB(List<Map<String, String>> list) {
        if (list.isEmpty()) {
            System.out.println("Список пуст");
        }

        for (Map<String, String> row : list) {
            for (String column : row.keySet()) {
                System.out.println(column + ": " + row.get(column) + "\t");
            }
            System.out.println();
        }
    }
}
