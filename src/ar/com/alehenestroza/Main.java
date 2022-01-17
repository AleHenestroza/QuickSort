package ar.com.alehenestroza;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Create array of 10 to 20 elements to sort
        Random rand = new Random();
        int[] numbers = new int[rand.nextInt(10, 20)];

        // Populate the array with numbers from 0 to 100
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        quicksort(numbers, 0, numbers.length - 1);

        System.out.println("\nAfter:");
        printArray(numbers);
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return; // If array has only one element, return

        int pivot = array[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        // Partitioning
        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);

        // Recursively sort the partitions
        quicksort(array, lowIndex, leftPointer - 1); // Left partition
        quicksort(array, leftPointer + 1, highIndex); // Right partition
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
