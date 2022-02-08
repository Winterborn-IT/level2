package lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strArr = new ArrayList<>(Arrays.asList(
                "Red", "Blue", "Green", "Yellow",
                "Red", "Orange", "Purple", "Black",
                "Green", "Red", "Brown", "White",
                "Pink", "Grey", "Blue", "Black"));

        Set<String> stringSet = new HashSet<>(strArr); // Гарантия отсутствия дубликатов
        System.out.println(stringSet);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strArr.size(); i++) {
            Integer num = map.getOrDefault(strArr.get(i), 0);
            map.put(strArr.get(i), num + 1);
        }
        System.out.println(map);

        // С использованием frequency
        for (String str : stringSet) {
            System.out.printf("%s - %d, ", str, Collections.frequency(strArr, str));
        }
        System.out.println();

        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", 455645);
        phonebook.add("Петров", 675634);
        phonebook.add("Медведева", 982345);
        phonebook.add("Сидоров", 565378);
        phonebook.add("Иванов", 879534);
        phonebook.add("Петров", 903411);
        phonebook.add("Кузнецова", 451213);

        phonebook.get("Иванов");
        phonebook.get("Петров");
        phonebook.get("Кузнецова");
    }
}
