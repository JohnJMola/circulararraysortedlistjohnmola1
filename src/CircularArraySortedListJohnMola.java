package org.example;

import java.util.Scanner;

public class CircularArraySortedListJohnMola {

    public int[] array;
    private int capacity;
    private int size;
    private int start;

    public CircularArraySortedListJohnMola(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
        this.start = 0;
    }

    public void add(int x) {
        if (size == capacity) {
            throw new IllegalStateException("List is full");
        }

        if (size == 0) {
            array[start] = x;
        } else {
            int index = (start + size) % capacity;
            int i = size - 1;

            while (i >= 0 && array[(start + i) % capacity] > x) {
                array[(start + i + 1) % capacity] = array[(start + i) % capacity];
                i--;
            }
            array[(start + i + 1) % capacity] = x;
        }
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        int removedValue = array[start];
        start = (start + 1) % capacity;
        size--;

        return removedValue;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        int lastIndex = (start + size - 1) % capacity;
        int removedValue = array[lastIndex];
        array[lastIndex] = 0;
        size--;


        return removedValue;
    }

    public boolean exists(int x) {
        for (int i = 0; i < size; i++) {
            int currentIndex = (start + i) % capacity;


            if (array[currentIndex] == x) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[(start + i) % capacity]);
            if (i < size - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Programming Fundamentals");
        System.out.println("John Mola");
        System.out.println("Programming Assignment Four");
        System.out.println("\nwelcome to John's circular array!\n");


        Scanner scanner = new Scanner(System.in);
        org.example.CircularArraySortedListJohnMola list = new org.example.CircularArraySortedListJohnMola(5);

        System.out.println("Commands:\na(Add), rf (Remove First), rl (Remove Last), e(Exist), q(Quit)) (keep in mind the list can only hold 5 items)\n");
        while (true) {
            System.out.print("Enter command, separate with space : ");
            String command = scanner.next();
            switch (command) {
                case "a":
                    int value = scanner.nextInt();
                    list.add(value);
                    System.out.println("Current list: " + list);
                    break;
                case "rf":
                    int removedFirst = list.removeFirst();
                    System.out.println("Removed: " + removedFirst);
                    System.out.println("Current list: " + list);
                    break;
                case "rl":
                    int removedLast = list.removeLast();
                    System.out.println("Removed: " + removedLast);
                    System.out.println("Current list: " + list);
                    break;
                case "e":
                    int val = scanner.nextInt();
                    System.out.println(val + " exists: " + list.exists(val));
                    break;
                case "q":
                    System.out.println("See ya!");
                    return;
                default:
                    System.out.println("Invalid command");
                    System.out.println("Current list: " + list);
            }
        }
    }
}

