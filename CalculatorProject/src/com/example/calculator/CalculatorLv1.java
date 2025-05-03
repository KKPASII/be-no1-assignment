package com.example.calculator;

import java.util.List;
import java.util.Scanner;

public class CalculatorLv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result1, firstNum = 0, secondNum = 0;
        boolean success;
        char op = '+';

        // Lv1
        System.out.println("-----Lv1-----");
        while (true) {
            success = false;
            try {
                System.out.println("첫 번째 숫자를 입력하세요(0, 양의 정수): ");
                String firstNumber = scanner.nextLine();
                firstNum = Integer.parseInt(firstNumber);
                System.out.println("두 번째 숫자를 입력하세요(0, 양의 정수): ");
                String secondNumber = scanner.nextLine();
                secondNum = Integer.parseInt(secondNumber);
                success = true;
                System.out.print("사칙연산 기호를 입력하세요: ");
                String operator = scanner.nextLine();
                op = operator.charAt(0);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다! 0과 양의 정수를 입력해주세요 :D");
            }


            // 연산하기
            if (success) {
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
            success = false;
            try {
                System.out.println("첫 번째 숫자를 입력하세요(0, 양의 정수): ");
                String firstNumber = scanner.nextLine();
                firstNum = Integer.parseInt(firstNumber);
                System.out.println("두 번째 숫자를 입력하세요(0, 양의 정수): ");
                String secondNumber = scanner.nextLine();
                secondNum = Integer.parseInt(secondNumber);
                success = true;
                System.out.print("사칙연산 기호를 입력하세요: ");
                String operator = scanner.nextLine();
                op = operator.charAt(0);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다! 0과 양의 정수를 입력해주세요 :D");
            }

            if (success) {
                try {
                    result2 = calculatorLv2.calculate(firstNum, secondNum, op);
                    System.out.println("연산 결과 : " + result2);
                }
                catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

                // Lv2 기능 활용
                // 연산 기록이 5개가 되면 맨 앞 기록 삭제
                if (calculatorLv2.getResultListSize() > 4) {
                    calculatorLv2.removeFirstResult();
                }
                // 연산 기록 출력
                List<Integer> resultList = calculatorLv2.getResultList();
                System.out.println("연산 결과 저장 리스트: ");
                for (int result : resultList) {
                    System.out.print(result + " ");
                }
                System.out.println();
            }

            System.out.println("[Lv2] 더 계산할까요? (종료하려면 exit을 입력하세요)");
            String next = scanner.nextLine();
            if (next.equals("exit")) {
                break;
            }
        }

        // Lv3
        System.out.println("-----Lv3-----");
        double result3 = 0;
        CalculatorLv3<Number> calculatorLv3 = new CalculatorLv3<>();
        int intFirst = 0;
        double doubleSecond = 0;

        while (true) {
            success = false;
            try {
                System.out.println("첫 번째 숫자(정수)를 입력하세요: ");
                String a = scanner.nextLine();
                intFirst = Integer.parseInt(a);
                System.out.println("두 번째 숫자(실수)를 입력하세요: ");
                String b = scanner.nextLine();
                doubleSecond = Double.parseDouble(b);
                success = true;
                System.out.print("사칙연산 기호를 입력하세요: ");
                String operator = scanner.nextLine();
                op = operator.charAt(0);

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다! 숫자를 입력해주세요! :D");
            }

            OperatorType myOp;
            switch (op) { // op는 char 변수
                case '+': myOp = OperatorType.PLUS; break;
                case '-': myOp = OperatorType.MINUS; break;
                case '*': myOp = OperatorType.MULTIPLY; break;
                case '/': myOp = OperatorType.DIVIDE; break;
                default: throw new IllegalArgumentException("모르는 기호 ㅇㅅㅇ");
            }

            result3 = calculatorLv3.calculate(intFirst, doubleSecond, myOp);
            if (success) {
                calculatorLv3.printResultList(Math.max(intFirst, doubleSecond));
            }

            System.out.println("[Lv3] 더 계산할까요? (종료하려면 exit을 입력하세요)");
            String next = scanner.nextLine();
            if (next.equals("exit")) {
                break;
            }
        }
        System.out.println("계산 종료");
    }
}