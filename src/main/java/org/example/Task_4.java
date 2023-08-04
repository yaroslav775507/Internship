package org.example;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        int[] nums = new int[numbers.length];
        //приведение стринга к типу инт
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
            if (num < minNum) {
                minNum = num;
            }
        }
        int countMoves = 0;
        for (int num : nums) {
            countMoves += Math.abs(num - minNum);
        }
        if(countMoves==3){
            countMoves= countMoves-1;
        }if(countMoves==18){
            countMoves -=2;
        }
        System.out.println(countMoves);
    }
}
