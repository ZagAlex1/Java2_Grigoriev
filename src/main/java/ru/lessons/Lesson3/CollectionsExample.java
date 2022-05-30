package ru.lessons.Lesson3;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
//        listExample();
//        setExample();
//        mapExample();
    }

    private static void mapExample() {
        //        Map<String, Integer> map = new HashMap<>();
//        Map<String, Integer> map = new LinkedHashMap<>(); //запоминает порядок добавления
        Map<String, Integer> map = new TreeMap<>(); //не важен hashCode,
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
//        map.put("A",5); // значение перезапишется на 5
//        map.putIfAbsent("A", 5); // добавить значение, если оно пустое

        System.out.println(map.get("B"));
//        System.out.println(map.get("Z")); // получим null, что не совсем хорошо
        System.out.println(map.getOrDefault("Z", 99));
//        map.replaceAll((k, v) -> v += 5);
//        Set<String> keys = map.keySet();  // создать список ключей
//        System.out.println(keys);         // напечатать список ключей
//        Collection<Integer> values = map.values(); // создать список значений
//        System.out.println(values);                // напечатать список значений
//        System.out.println(map);
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

    private static void setExample() {
        Set<String> set = new HashSet<>();        //Внутри использует HashMap, порядок
        // добавления не запоминает, нужен equals и hashCode;
        Set<String> set1 = new LinkedHashSet<>(); //Запоминает порядок добавления;
        Set<String> set2 = new TreeSet<>();       //Внутри использует TreeMap, hashCode не важен, необходима
        set.add("January");                       //реализация интерфейса Comparable<>;
        set.add("February");
//        set.add(null);        //null хранить можно, но в данном примере можно словить exception
        set.add("March");
        set.add("February");    //не попадет в список, т.к. он хранит только уникальные значения
//        set.add(null);

        set.addAll(Arrays.asList("June", "July", "May", "April"));
        set.remove("May");
        set.removeAll(List.of("May", "April"));
        set.removeIf(s -> s.length() < 5);
        System.out.println(set);


//        for (int i = 0; i < list.size(); i++) {    //Циклом for i обойти нельзя, т.к нет индекса
//        System.out.println(set);
//        }

//        for (String s : set) {
//            System.out.println(s);
//        }

//        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//            iterator.remove();
//        }
//        System.out.println(set);

//        set.forEach(System.out::println);

//        Set<Box> boxes = new HashSet<>();
//        Set<Box> boxes = new LinkedHashSet<>();
//        Set<Box> boxes = new TreeSet<>();
        Set<Box> boxes = new TreeSet<>((o1, o2)
                -> o1.width * o1.height - o2.width * o2.height); //можно передать компоратор в конструктор
        boxes.add(new Box(3, 3));
        boxes.add(new Box(2, 2));
        boxes.add(new Box(1, 1));
        boxes.add(new Box(1, 1));

        System.out.println(boxes);
    }

    private static void listExample() {
        List<String> list = new ArrayList<>();
        List<String> list1 = new Vector<>();
        List<String> list2 = new LinkedList<>();
        list.add("January");
        list.add("February");
//        list.add(null);
        list.add("March");
        list.add("February");
//        list.add(null);
        list.add(3, "April");
        list.set(4, "May"); //тоже самое, что и add только с заменой элемента
        list.addAll(Arrays.asList("June", "July", "May", "April")); //добавление всех элементов в конец списка
        list.remove(0);
//        list.remove("May"); //будет удалено первое совпадение
//        list.removeAll(List.of("May", "April"));// удалятся все совпадающие элементы
//        list.removeIf(s -> s.length() < 5);
//        list.sort(String::compareTo);
//        list.sort((e1, e2) -> e1.compareTo(e2));// тоже самое, что и выше
//        list.replaceAll(s -> s + " month");
//        System.out.println(list);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        for (String s : list) {
//            System.out.println(s);
//        }
//        Iterator<String> iterator = list.iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//            iterator.remove();
//        }
//        System.out.println(list);

//        ListIterator<String> iterator = list.listIterator();
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//            iterator.remove();
//            iterator.hasPrevious();
//        }
//        System.out.println(list);

        list.forEach(System.out::println);
    }

    public static class Box implements Comparable<Box> {
        private int width;
        private int height;

        public Box(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Box box = (Box) o;
            return width == box.width && height == box.height;
        }

        @Override
        public int hashCode() {
            return Objects.hash(width, height);
        }

        @Override
        public String toString() {
            return String.format("(Box: width: %s height: %s)", width, height);
        }

        @Override
        public int compareTo(Box o) {
            return width * height - o.width * o.height;
        }
    }
}
