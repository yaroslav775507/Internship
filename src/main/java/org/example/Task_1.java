package org.example;

import java.util.*;

public class Task_1 {
    public static void main(String[] args) {
        //Круговой массив
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число n: ");
        int n = scanner.nextInt();

        System.out.print("Введите число m: ");
        int m = scanner.nextInt();

        if (n <= 0 || m <= 0) {
            System.out.println("Аргументы n и m должны быть положительными числами");
            return;
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        int currentIndex = 0;
        StringBuilder path = new StringBuilder();

        while (path.length() < n+m) {
            if (currentIndex >= n) {
                currentIndex -= n;
            }

            for (int i = currentIndex; i < currentIndex + m; i++) {
                int index = i >= n ? i - n : i;
                path.append(array[index]);
            }

            currentIndex += m;
        }
       // System.out.println("сейчас"+ currentIndex);


//        for (int i = 0; i < path.length(); i++) {
//            currentIndex = (currentIndex+n)%m;
//            //if(cu)
//            System.out.print(currentIndex+" ");
//        }

        System.out.println("Полученный путь: " + path);
    }
}




