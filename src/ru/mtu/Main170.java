package ru.mtu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main170 {

    /**
     * Задача 7. Вывести на экран все натуральные шестизначные числа
     * из диапазона от А до В, у которых совпадают сумма трех младших и
     * трех старших цифр. При отсутствии чисел с указанными свойствами
     * сформировать сообщение «Требуемых чисел нет».
     * Границы диапазона А и В вводятся с клавиатуры.
     */
    public static void main(String[] args) {
        List<Integer> list = generateListByRange(1000, 555555);
        System.out.println(list);
        List<Integer> cleanedList = cleanIntList(list);
        if (cleanedList.size() == 0) {
            System.out.println("Требуемых чисел нет");
        } else {
            System.out.println(cleanedList);
        }
    }

    /**
     * @param list с элементами, которые нужно отфильтровать
     * @return список чисел, у которых совпадают суммы первых 3 и последних 3 цифр
     */
    private static List<Integer> cleanIntList(List<Integer> list) {
        return list.stream().filter(integer ->
                sumOFNumbers(integer / 1000).equals(sumOFNumbers(integer % 1000)))
                .collect(Collectors.toList());
    }

    /**
     * @param low  нижняя границы диапазона (включительно)
     * @param high верхняя границы диапазона (включительно)
     * @return
     */
    private static List<Integer> generateListByRange(Integer low, Integer high) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = low; i < high; i++) {
            if (i >= 100000 && i <= 999999) {
                integerList.add(i);
            }
        }
        return integerList;
    }

    /**
     * @param number натуральное положительное число
     * @return сумма отдельных цифр числа
     */
    private static Integer sumOFNumbers(Integer number) {
        return number == 0 ? 0 : number % 10 +
                sumOFNumbers(number / 10);
    }
}
