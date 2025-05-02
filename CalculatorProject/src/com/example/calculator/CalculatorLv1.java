package com.example.calculator;

import java.util.Scanner;

public class CalculatorLv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result1;
        boolean success;

        // Lv1
        System.out.println("-----Lv1-----");
        while (true) {
            System.out.println("첫 번째 숫자를 입력하세요: ");
            String firstNumber = scanner.nextLine();
            System.out.println("두 번째 숫자를 입력하세요: ");
            String secondNumber = scanner.nextLine();
            int firstNum = Integer.parseInt(firstNumber);
            int secondNum = Integer.parseInt(secondNumber);
            System.out.print("사칙연산 기호를 입력하세요: ");
            String operator = scanner.nextLine();
            char op = operator.charAt(0);

            // 연산하기
            success = true;
            try {
                switch(op) {
                    case '+':
                        result1 = firstNum + secondNum;
                        break;
                    case '-':
                        result1 = firstNum - secondNum;
                        break;
                    case '*':
                        result1 = firstNum * secondNum;
                        break;
                    case '/':
                        if (secondNum == 0) {
                            result1 = 0;
                            throw new ArithmeticException("0으로 나눌 수 없음!!!");
                        }
                        result1 = firstNum / secondNum;
                        break;
                    default:
                        result1 = 0;
                        throw new IllegalArgumentException("연산할 수 없는 기호입니다 ㅇㅅㅇ");
                }

                System.out.println("연산 결과: " + result1);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("[Lv1] 더 계산할까요? (종료하려면 exit을 입력하세요)");
            String next = scanner.nextLine();
            if (next.equals("exit")) {
                break;
            }
        }

        // Lv2
        System.out.println("-----Lv2-----");
        int result2 = 0;
        CalculatorLv2 calculatorLv2 = new CalculatorLv2();
        while (true) {
            success = true;
            System.out.println("첫 번째 숫자를 입력하세요 (0, 양의 정수): ");
            String firstNumber = scanner.nextLine();
            System.out.println("두 번째 숫자를 입력하세요 (0, 양의 정수): ");
            String secondNumber = scanner.nextLine();
            int firstNum = Integer.parseInt(firstNumber);
            int secondNum = Integer.parseInt(secondNumber);
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            String operator = scanner.nextLine();
            char op = operator.charAt(0);

            try {
                result2 = calculatorLv2.calculate(firstNum, secondNum, op);
                System.out.println("연산 결과 : " + result2);
            }
            catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("[Lv2] 더 계산할까요? (종료하려면 exit을 입력하세요)");
            String next = scanner.nextLine();
            if (next.equals("exit")) {
                break;
            }
        }





    }
}