package lesson3;

import java.util.*;

public class Phonebook {

    private Map<String, List<Integer>> pb = new HashMap<>();

    public void add(String surname, Integer number) {
        for (Map.Entry<String, List<Integer>> e : pb.entrySet()) {
            String key = e.getKey();
            if (e.getKey().equals(surname)) {
                pb.get(key).add(number);
            }
        }
        pb.putIfAbsent(surname, new ArrayList<>(Arrays.asList(number)));
    }

    public void get(String surname) {
        List<Integer> list = pb.get(surname);
        System.out.println(surname + "   " + list);
    }

}
