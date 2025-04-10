package com.java8.lamda;


// have my own functional interface

@FunctionalInterface
interface Calculator {

    //void switchOn();
    //void switchON(int input);
    int sumOfTwoNumber(int a, int b);
}

public class LambdaFunction {
    public static void main(String[] args) {

        // to call switchOn() method
        // () -> {body}

        /*Calculator calculator = () -> System.out.println("SwitchON method invoked"); // since its one statement so call without {}
        calculator.switchOn();*/

       /* Calculator calculator = (input) -> System.out.println("Argument method call input = 500 ");
        calculator.switchON(500);*/

        Calculator calculator = (a,b) -> a+b; //  since its one line statement so no need to add return explicitly
        int result = calculator.sumOfTwoNumber(20, 10) ;
        System.out.println("Result of sum is " + result);

        // now i want to throw some exception based on the condition

        Calculator calculator1 = (a,b) -> {
            if (a < b) {
                throw new RuntimeException("Simulate Exception");
            } else {
                return a+b;
            }
        };
        int result1 = calculator1.sumOfTwoNumber(10,20);
        System.out.println("Result of sum is " + result1);


    }
}
