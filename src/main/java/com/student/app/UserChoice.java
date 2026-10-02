package com.student.app;

public class UserChoice {
    public static final int ADD_EXPENSE = 1;
    public static final int REMOVE_EXPENSE = 2;
    public static final int VIEW_EXPENSES = 3;
    public static final int FILTER_EXPENSES = 4;
    public static final int EXIT = 5;

    public static boolean isValid(int choice) {
        return choice >= ADD_EXPENSE && choice <= EXIT;
    }
}
