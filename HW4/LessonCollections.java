package HomeWork__1.HW4;

import java.util.*;

public class LessonCollections {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        Map<String, Integer> hm = new HashMap<>();
        String[] words = {
                "Coffee", "Potato", "Alpha",
                "Cheese", "Beta", "Coffee",
                "Dog", "Cat", "Java",
                "fork", "mock", "golf", "lock",
                "Coffee", "Potato", "Alpha"
        };

        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        System.out.println(hm);

        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        System.out.println();
    }

    private static void task2() {
        Directory directory = new Directory();

        directory.add("Ivanov", "8999123321");
        directory.add("Petrov", "8912155326");
        directory.add("Petrov", "8917155552");


        System.out.println(directory.get("Petrov"));

    }

}

class Directory {
    private Map<String, List<String>> directory_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (directory_hm.containsKey(surname)) {
            phone_number_list = directory_hm.get(surname);
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return directory_hm.get(surname);
    }

}
