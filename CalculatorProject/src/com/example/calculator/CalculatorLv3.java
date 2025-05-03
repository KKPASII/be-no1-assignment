package com.example.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorLv3 <T extends Number> {
    private List<Double> resultList = new ArrayList<>();

    public void printResultList(T big) {
        List<Double> filteredList = resultList.stream()
                                                .filter(num -> num > big.doubleValue())
                                                .collect(Collectors.toList());
        for (double num : filteredList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public double calculate(T a, T b, OperatorType op) {
        double result;
        double dA = a.doubleValue();
        double dB = b.doubleValue();
        switch(op) {
            case PLUS:
                result = dA+dB;
                break;
            case MINUS:
                result = dA-dB;
                break;
            case MULTIPLY:
                result = dA*dB;
                break;
            case DIVIDE:
                if (dB == 0.0) {
                    result = 0;
                    throw new ArithmeticException("0으로 나눌 수 없음!!!");
                }
                result = dA/dB;
                break;
            default:
                result = 0;
                throw new IllegalArgumentException("연산할 수 없는 기호입니다 ㅇㅅㅇ");
        }

        this.resultList.add(result);
        return result;
    }

    public List<Double> getResultList() {
        return resultList;
    }

    public int getResultListSize() {
        return resultList.size();
    }

    public void setResultList(List<Double> resultList) {
        if (this.resultList == resultList) {
            System.out.println("바꿀 필요 없음!!");
            return;
        }
        this.resultList = resultList;
    }

    public void removeFirstResult() {
        if (resultList.isEmpty()) {
            System.out.println("요소가 없음! 삭제 불가");
            return;
        }
        double firstElement = resultList.remove(0);
        System.out.println("삭제한 맨 앞의 값 : " + firstElement);
    }
}
