package com.student.app;

import java.util.Scanner;

public class App {
    void main() {
        System.out.println("\nWelcome to the Expense Tracker App!");

        Scanner scanner = new Scanner(System.in);
        ExpenseList expenses = new ExpenseList();

        int choice;
        do {
            UserInstruction.printUserInstructions();
            choice = UserInstruction.getChoiceFromUser(scanner);

            if (!UserChoice.isValid(choice)) {
                System.out.println("Invalid input, please try again.");
                continue;
            }

            try { // to avoid crashing program if user delivers bad input
                switch (choice) {
                    case UserChoice.ADD_EXPENSE -> expenses.addExpense(generateExpenseFromUser(scanner));
                    case UserChoice.REMOVE_EXPENSE ->
                            expenses.removeExpense(UserInstruction.getExpenseNameFromUser(scanner));
                    case UserChoice.VIEW_EXPENSES -> expenses.displayExpenses();
                    case UserChoice.FILTER_EXPENSES ->
                            expenses.displayCategoryExpenses(UserInstruction.getCategoryNameFromUser(scanner));
                    case UserChoice.EXIT -> System.out.println("Exiting app, goodbye!");
                }
            } catch (Exception err) {
                //don't care
            }
        } while (choice != UserChoice.EXIT);

        scanner.close();
    }

    public Expense generateExpenseFromUser(Scanner scanner) {
        final String name = UserInstruction.getExpenseNameFromUser(scanner);
        final String category = UserInstruction.getCategoryNameFromUser(scanner);
        final double amount = UserInstruction.getExpenseAmountFromUser(scanner);

        System.out.print("Enter expense description (optional): ");
        String description = scanner.nextLine().trim();

        return new Expense(name, amount, category, description);
    }

}
