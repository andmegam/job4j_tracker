package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Элемент не найден");
    }

    public static void main(String[] args) {
        String[] city = {"Саратов", "Самара", "Волгоград", "Пенза"};
        try {
            int index = indexOf(city, "Волгоград");
            System.out.println("Индекс элемента: " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

        try {
            int index = indexOf(city, "Москва");
            System.out.println("Индекс элемента: " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
