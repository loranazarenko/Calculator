package com.testwork.calculator.classes;

import java.util.List;

public class Computer {

    private static int operation(int first, int second, char symbol) {
        int result;
        switch (symbol) {
            case '/' -> result = first / second;
            case '*' -> result = first * second;
            case '-' -> result = first - second;
            case '+' -> result = first + second;
            default -> result = 0;
        }
        return result;
    }

    private static void calcMultDiv() {
        for (int i = 0; i < Utils.operatorsNew.size() - 1; i++) {
            char ch = Utils.operatorsNew.get(i).charAt(0);
            if (ch == '*' || ch == '/') {
                manipulator(Utils.operatorsNew, i);
                i = 0;
            }
        }
    }

    private static void calcSumDif() {
        for (int i = 1; i < Utils.operatorsNew.size() - 1; i++) {
            char ch = Utils.operatorsNew.get(i).charAt(0);
            if (ch == '+' || ch == '-') {
                manipulator(Utils.operatorsNew, i);
                i = 0;
            }
        }
    }

    public static void manipulator(List<String> operatorsNew, int idx) throws NumberFormatException, IndexOutOfBoundsException {
        int expression;
        try {
            expression = operation(Integer.parseInt(operatorsNew.get(idx - 1)),
                    Integer.parseInt(operatorsNew.get(idx + 1)), operatorsNew.get(idx).charAt(0));
            operatorsNew.set(idx + 1, "" + expression);
            operatorsNew.remove(idx - 1);
            operatorsNew.remove(idx - 1);
        } catch (NumberFormatException err) {
            System.out.println(err.getMessage());
            System.out.println("Incorrect data entered, please enter correct data.");
            System.exit(0);
        } catch (IndexOutOfBoundsException err) {
            System.out.println(err.getMessage());
            System.out.println("Index out of bounds, please enter correct data.");
            System.exit(0);
        }
    }

    public static void calculateResult() {
        calcMultDiv();
        calcSumDif();
    }
}
