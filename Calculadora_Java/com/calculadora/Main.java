package com.calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        print("Basic Calculator 1.0 \n");

        print("Inform the first value: ");
        double value1 = scanner.nextDouble();

        print("Inform the second value: ");
        double value2 = scanner.nextDouble();

        print("Inform the operation [+, -, *, /]: ");
        char operation = scanner.next().charAt(0);

        Calculadora calculadora = new Calculadora();

        switch (operation) {
        case '+':
            print("Result: " + calculadora.sum(value1, value2));
            break;
        case '-':
            print("Result: " + calculadora.minus(value1, value2));
            break;
        case '*':
            print("Result: " + calculadora.multiply(value1, value2));
            break;
        case '/':
            print("Result: " + calculadora.divide(value1, value2));
            break;
        default:
            print("Please inform a valid operator");
            main(null);
            break;
        }

    }

    public static void print(String content) {
        System.out.print(content);
    }
}
