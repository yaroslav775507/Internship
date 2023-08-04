package org.example;

import java.util.*;

import static javax.swing.text.html.HTML.Tag.MAP;

public class Task_1 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        //заполнение длинны массива
        System.out.println("Введите длину интервала");
        int n = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.print("длина массива равна: ");
        System.out.println(Arrays.toString(array));


        System.out.println("Введите количество интервалов");
        int m = s.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            while (!(array[i] == 1)) {
                for (int j = 0; j < m; j++) {
                    System.out.println(m);

                }
            }
        }
    }
}