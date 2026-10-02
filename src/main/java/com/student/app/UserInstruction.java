package com.student.app;

import java.util.Scanner;

public class UserInstruction {

    static public void printUserInstructions() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add Expense");
        System.out.println("2. Remove Expense");
        System.out.println("3. View Expenses");
        System.out.println("4. Filter Expenses by Category");
        System.out.println("5. Exit");
    }

    //returns 0 if the input is invalid, otherwise returns the choice
    static public int getChoiceFromUser(Scanner scanner) {
        System.out.print("Enter your choice: ");

        int choice = scanner.hasNextInt() ? scanner.nextInt() : 0;
        scanner.nextLine(); // consume newline

        return choice;
    }

    static public String getExpenseNameFromUser(Scanner scanner) {
        System.out.print("Enter expense name: ");
        return scanner.nextLine().trim();
    }

    static public String getCategoryNameFromUser(Scanner scanner) {
        System.out.print("Enter expense category: ");
        return scanner.nextLine().trim();
    }

    static public double getExpenseAmountFromUser(Scanner scanner) {
        System.out.print("Enter expense amount: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); // consume invalid input
            System.out.print("Enter expense amount: ");
        }
        final double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        return amount;
    }

}
