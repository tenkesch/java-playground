package com.student.app;

import java.util.Scanner;

public class App {

    void main() {
        System.out.println("Welcome to the Expense Tracker App!");

        Scanner scanner = new Scanner(System.in);
        ExpenseList expenses = new ExpenseList();

        final class Signal {
            final static int ADD_EXPENSE = 1;
            final static int REMOVE_EXPENSE = 2;
            final static int VIEW_EXPENSES = 3;
            final static int FILTER_EXPENSES = 4;
            final static int EXIT = 5;
        }

        {
            int choice;
            do {
                printUserInstructions();
                choice = getChoice(scanner);

                if (choice == 0) {
                    System.out.println("Invalid input, please try again.");
                    continue;
                }

                try {

                    switch (choice) {
                        case Signal.ADD_EXPENSE -> expenses.addExpense(generateExpense(scanner));
                        case Signal.REMOVE_EXPENSE -> expenses.removeExpense(getName(scanner));
                        case Signal.VIEW_EXPENSES -> expenses.displayExpenses();
                        case Signal.FILTER_EXPENSES -> {
                            System.out.print("Enter category to filter by: ");
                            final var categorizedExpenses = expenses.getExpensesByCategory(getName(scanner));
                            if (categorizedExpenses != null)
                                for (var expense : categorizedExpenses)
                                    System.out.println(expense);
                            else System.out.println("No expenses found in such category.");
                        }
                        case Signal.EXIT -> System.out.println("Exiting app, goodbye!");
                        default -> System.out.println("Invalid choice. Please try again.");
                    }

                } catch (Exception err) {
                    //don't care
                }

            } while (choice != Signal.EXIT);
        }

        scanner.close();
    }

    public Expense generateExpense(Scanner scanner) {
        try {
            System.out.print("Enter expense name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter expense amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            System.out.print("Enter expense category: ");
            String category = scanner.nextLine().trim();

            System.out.print("Enter expense description (optional): ");
            String description = scanner.nextLine().trim();

            return new Expense(name, amount, category, description);
        } catch (Exception e) {
            System.err.println("Error creating expense: " + e.getMessage());
        }
        return null;
    }

    public void printUserInstructions() {
        System.out.println("\nWelcome to the Expense Tracker App!");
        System.out.println("Please choose an option:");
        System.out.println("1. Add Expense");
        System.out.println("2. Remove Expense");
        System.out.println("3. View Expenses");
        System.out.println("4. Filter Expenses by Category");
        System.out.println("5. Exit");
    }

    public int getChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");

        int choice = scanner.hasNextInt() ? scanner.nextInt() : 0;
        scanner.nextLine(); // consume newline

        return choice;
    }

    public String getName(Scanner scanner) {
        System.out.print("Enter expense name: ");

        String name = scanner.nextLine().trim();
        scanner.nextLine(); // consume newline

        return name;
    }

}
