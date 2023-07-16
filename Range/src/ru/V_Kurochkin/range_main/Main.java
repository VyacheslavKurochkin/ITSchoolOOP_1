package ru.V_Kurochkin.range_main;

import ru.V_Kurochkin.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(2.1, 2.5);
        Range range2 = new Range(2.2, 2.8);

        System.out.println("Диапазоны: ");
        System.out.printf("[%.2f .. %.2f] \r\n", range1.getFrom(), range1.getTo());
        System.out.printf("[%.2f .. %.2f] \r\n", range2.getFrom(), range2.getTo());

        Range[] rangeUnion = range1.getUnion(range2);

        System.out.println("Объединение: ");

        for (int i = 0; i < rangeUnion.length; i++) {
            System.out.printf("%d : ", i + 1);
            System.out.printf("[%.2f .. %.2f]\r\n", rangeUnion[i].getFrom(), rangeUnion[i].getTo());
        }

        Range[] rangeSubtraction = range1.getSubtraction(range2);

        System.out.println("Разность: ");

        if (rangeSubtraction != null) {
            for (int i = 0; i < rangeSubtraction.length; i++) {
                System.out.printf("%d : ", i + 1);
                System.out.printf("[%.2f .. %.2f]\r\n", rangeSubtraction[i].getFrom(), rangeSubtraction[i].getTo());
            }
        } else {
            System.out.println("Пустой диапазон");
        }

        Range rangeIntersection = range1.getIntersection(range2);

        System.out.println("Пересечение: ");

        if (rangeIntersection != null) {
            System.out.printf("[%.2f .. %.2f]\r\n", rangeIntersection.getFrom(), rangeIntersection.getTo());
        } else {
            System.out.println("Пустой диапазон");
        }
    }
}
