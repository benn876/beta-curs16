package org.beta.curs16.code.lambda;

import java.util.function.Function;

public class FunctionalProgrammingMain {
    public static void main(String[] args) {
        // trySomethingToLowerCase("Test");
        // trySomethingToUpperCase("Test");

        String testString = trySomething("Test", new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        });
        System.out.println(testString);

        String lowerCaseString = trySomething("Test", (s) -> s.toLowerCase());
        System.out.println(lowerCaseString);

        System.out.println(doMathStuff(5, input -> input * 2));
        System.out.println(doMathStuff(5, input -> input + 2));

        System.out.println(doMathStuffAdvanced(5,4, (input, input1) -> input * input1));
    }

    private static Integer doMathStuffAdvanced(Integer someNumber, Integer anotherNumber, MyFunctionalInterface myFunction){
        return myFunction.beniIiJmecher(someNumber, anotherNumber);
    }

    private static Integer doMathStuff(Integer request, Function<Integer, Integer> function) {
        return function.apply(request);
    }

    private static String trySomething(String input, Function<String, String> function) {
        System.out.println(input);
        return function.apply(input);
    }

    private static void trySomethingToLowerCase(String input) {
        System.out.println(input.toLowerCase());
    }

    private static void trySomethingToUpperCase(String input) {
        System.out.println(input.toUpperCase());
    }
}
