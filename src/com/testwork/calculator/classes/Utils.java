package com.testwork.calculator.classes;

import java.util.List;

public class Utils {

    public static List<String> operatorsNew;

    public static void checkForMinus() {
        if (operatorsNew.get(0).charAt(0) == '-' && Character.isDigit(operatorsNew.get(1).charAt(0))) {
            operatorsNew.set(1, "" + -1 * Integer.parseInt(operatorsNew.get(1)));
            operatorsNew.remove(0);
        }
    }
      public static boolean isSeparator(String str) {
        return str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-");
    }

}
