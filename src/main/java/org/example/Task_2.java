package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        //Координаты центра окружности и его радиус считываются из файла1.
        List<Integer> numbers = new ArrayList<>();
        String fileName = "notes1.txt";
        // Создаем список для хранения чисел

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                int number = Integer.parseInt(scanner.next());
                numbers.add(number);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
            e.printStackTrace();
        }

        // Преобразуем список чисел в массив
        Integer[] numbersArray = numbers.toArray(new Integer[0]);
        System.out.println("Массив с координатами центра и радиуса");
        System.out.println(Arrays.toString(numbersArray));


        //Координаты точек считываются из файла2.
        List<Integer> numbers1 = new ArrayList<>();
        String fileName1 = "notes3.txt";
        // Создаем список для хранения чисел

        try {
            File file = new File(fileName1);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                int number = Integer.parseInt(scanner.next());
                numbers1.add(number);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName1);
            e.printStackTrace();
        }

        // Преобразуем список чисел в массив
        Integer[] numbersArray1 = numbers1.toArray(new Integer[0]);
        System.out.println("Массив с координатами точек");
        System.out.println(Arrays.toString(numbersArray1));
        //присваиваем данные из файла1
        int ox = numbersArray[0];
        int oy = numbersArray[1];
        int r = (int) Math.pow(numbersArray[2], 2);

        //присваиваем данные из файла3

        //Соответствия ответов:
        //0 - точка лежит на окружности
        // 1 - точка внутри
        //2 - точка снаружи
        int px = numbersArray1[0];
        int py = numbersArray1[1];
        int px1 = numbersArray1[2];
        int py1 = numbersArray1[3];
        int px2 = numbersArray1[4];
        int py2 = numbersArray1[5];

        float h = (int) (Math.pow((ox - px), 2) + Math.pow((oy - py), 2));
        float h1 = (int) (Math.pow((ox - px1), 2) + Math.pow((oy - py1), 2));
        float h2 = (int) (Math.pow((ox - px2), 2) + Math.pow((oy - py2), 2));
        if (h == r) {
            System.out.println("Точка лежит на окружности");
        }
        if (h < r) {
            System.out.println("Точка внутри");
        }
        if (h > r) {
            System.out.println("Точка снаружи");
        }

        if (h1 == r) {
            System.out.println("Точка лежит на окружности");
        }
        if (h1 < r) {
            System.out.println("Точка внутри");
        }
        if (h1 > r) {
            System.out.println("Точка снаружи");
        }
        if (h2 == r) {
            System.out.println("Точка лежит на окружности");
        }
        if (h2 < r) {
            System.out.println("Точка внутри");
        }
        if (h2 > r) {
            System.out.println("Точка снаружи");
        }

    }

}

