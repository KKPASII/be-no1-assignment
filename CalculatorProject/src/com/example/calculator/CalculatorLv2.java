package com.example.calculator;

import java.util.LinkedList;
import java.util.List;

public class CalculatorLv2 {
    private List<Integer> resultList = new LinkedList<>();

    public int calculate(int a, int b, char op) {
        int result;

        switch(op) {
            case '+':
                result = a+b;

                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                if (b == 0) {
                    result = 0;
                    throw new ArithmeticException("0으로 나눌 수 없음!!!");
                }
                result = a/b;
                break;
            default:
                result = 0;
                throw new IllegalArgumentException("연산할 수 없는 기호입니다 ㅇㅅㅇ");
        }

        this.resultList.add(result);
        return result;
    }

    public List<Integer> getResultList() {
        return resultList;
    }

    public int getResultListSize() {
        return resultList.size();
    }

    public void setResultList(List<Integer> resultList) {
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
        int firstElement = resultList.remove(0);
        System.out.println("삭제한 맨 앞의 값 : " + firstElement);
    }
}
