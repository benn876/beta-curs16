package org.beta.curs16.code.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaFunctionalInterfaces {
    public static void main(String[] args) {
        System.out.println(tryFunction(4, a -> a + 1));

        System.out.println(trySupplier(() -> "ceva"));

        tryConsumer("test", System.out::println);

        System.out.println(tryPredicate("something", param-> param.length() > 10));
        System.out.println(tryPredicate("something", param-> param.length() > 2));
    }

    private static boolean tryPredicate(String something, Predicate<String> predicate){
        return predicate.test(something);
    }

    private static void tryConsumer(String input, Consumer<String> consumer) {
        consumer.accept(input);
    }

    private static String trySupplier(Supplier<String> supplier){
        String s = supplier.get();
        if(s.startsWith("c")){
            return "Starts with c";
        }
        return s;
    }

    private static Integer tryFunction(int input, Function<Integer, Integer> function) {
        return function.apply(input);
    }
}
