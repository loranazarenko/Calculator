package com.testwork.calculator;

import com.testwork.calculator.classes.Computer;
import com.testwork.calculator.classes.Parser;
import com.testwork.calculator.classes.Utils;
import com.testwork.calculator.exceptions.CharacterLimitExceededException;

import java.util.Scanner;

public class Calculator {

    private static final int MAXARGS = 7;
    private static final int MINARGS = 3;

    public static void main(String[] args) {
        String enterString;
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER please your formula and press ENTER, if you want to escape, enter 'STOP'");
        while (true) {
            enterString = scan.nextLine();
            if (enterString.equals("STOP")) break;
            if (enterString.length() > MAXARGS || enterString.length() < MINARGS) {
                throw new CharacterLimitExceededException("Character limit for enter string is exceeded");
            }
            Parser.parsing(enterString);
            Utils.checkForMinus();
            Computer.calculateResult();
            System.out.println("Result of formula is   " + Utils.operatorsNew.get(0));
            System.out.println("ENTER please your formula and press ENTER, if you want to escape, enter 'STOP'");
        }
    }
}
