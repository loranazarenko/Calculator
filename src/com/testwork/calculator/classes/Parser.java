package com.testwork.calculator.classes;

import com.testwork.calculator.exceptions.RangeDigitException;
import java.util.ArrayList;

public class Parser {

    private static final int MAX_LENGTH = 10;

    public static void parsing(String formula) {

        Utils.operatorsNew = new ArrayList<>();
        String operatorsOld = formula.trim();
        int i = 0;

        try {
            while (i < operatorsOld.length()) {
                char sign = operatorsOld.charAt(i);
                {
                    StringBuilder lexeme = new StringBuilder();
                    boolean isDigit = false;
                    for (; i < operatorsOld.length() && Character.isDigit(operatorsOld.charAt(i)); i++) {
                        lexeme.append(operatorsOld.charAt(i));
                        isDigit = true;
                    }
                    if (isDigit) {
                        int enteredDigit = Integer.parseInt(lexeme.toString());
                        if (enteredDigit <= MAX_LENGTH && lexeme.length() > 0) {
                            Utils.operatorsNew.add(lexeme.toString());
                        } else if (enteredDigit < 1 || enteredDigit > MAX_LENGTH) {
                            throw new RangeDigitException("The number is not in the acceptable range");
                        }
                    }
                }

                if (Utils.isSeparator(String.valueOf(sign))) {
                    Utils.operatorsNew.add(String.valueOf(sign));
                    i++;
                }

                if (!Character.isDigit(sign) && !Utils.isSeparator(String.valueOf(sign))) {
                    throw new NumberFormatException("Wrong symbol");
                }
            }
        } catch (NumberFormatException err) {
            System.out.println(err.getMessage());
            System.out.println("Incorrect data entered, please enter correct data.");
            System.exit(0);
        }
    }
}
