package com.student.app;

import org.jspecify.annotations.NonNull;

import java.util.ArrayList;

public record ExpenseList(ArrayList<Expense> expenses) {
    public ExpenseList() {
        this(new ArrayList<>());
    }

    public void addExpense(@NonNull Expense expense) {
        expenses.add(expense);
    }

    public void removeExpense(@NonNull String name) {
        Expense expense = findExpenseByName(name);
        if (expense != null)
            expenses.remove(expense);
    }

    public Expense findExpenseByName(String name) {
        for (Expense expense : expenses)
            if (expense.getName().equalsIgnoreCase(name))
                return expense;

        return null;
    }

    public void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
            return;
        }

        for (Expense expense : expenses)
            System.out.println(expense);
    }

    public ArrayList<Expense> getExpensesByCategory(String category) {
        if (expenses.isEmpty())
            return null;

        ArrayList<Expense> categoryExpenses = new ArrayList<>();

        for (Expense expense : expenses)
            if (expense.getCategory().equalsIgnoreCase(category))
                categoryExpenses.add(expense);

        return categoryExpenses;
    }

    public double sumExpensesAmount(ArrayList<Expense> expenses) {
        double total = 0.0;
        for (Expense expense : expenses)
            total += expense.getAmount();

        return total;
    }

    public void displayCategoryExpenses(String category) {
        System.out.print("Enter category to filter by (Caps ignored): ");
        final var categorizedExpenses = this.getExpensesByCategory(category);
        if (categorizedExpenses == null) {
            System.out.println("No expenses found in such category.");
            return;
        }

        final var totalAmount = sumExpensesAmount(categorizedExpenses);
        System.out.println("Total amount spent in this category: " + totalAmount);
        for (Expense expense : categorizedExpenses)
            System.out.println(expense);
    }

}

