package tools;

import java.util.List;

public class PrintLists<T> {
    public void printList(List<T> list) {
        if (list.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (T item : list) {
            System.out.println(item);
        }
    }

    //TODO вывод данных из БД
    public void printDataFromDB() {

    }
}
