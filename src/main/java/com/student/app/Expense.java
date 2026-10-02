package com.student.app;

public class Expense {
    private String name; // name of the expense, etc. groceries
    private double amount; // amount of the expense
    private String category; // category of the expense, etc. food, transportation, entertainment
    private String description; // description of the expense

    public Expense(String name, double amount, String category, String description) {
        this.name = name;
        this.amount = amount;
        this.category = category.toUpperCase();
        this.description = description != null ? description : "no description";
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category.toUpperCase();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description != null ? description : "no description";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "name='" + name + "'\n" +
                        "amount=" + amount + "'\n" +
                        "category='" + category + "'\n" +
                        "description='" + description + "'\n";
    }

}