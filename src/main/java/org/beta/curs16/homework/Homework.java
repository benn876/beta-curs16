package org.beta.curs16.homework;

public class Homework {
    public static void main(String[] args) {
        boolean wordIsPalindrom = isPalindrom("madfam");

        /*
         0 1 2 3 4 5
         m a d d a m    length = 6
         maddam -> m == m
         adda -> a == a
         dd -> d == d
         ""  == empty -> return


          madam -> m == m
         ada -> a == a
         d -> return
         */
        System.out.println(wordIsPalindrom);
    }

    private static boolean isPalindrom(String input) {
        if(input.length() <= 1){
            return true;
        }

        char leftChar = input.charAt(0);
        char rightChar = input.charAt(input.length() - 1);
        boolean extremitiesAreEqual = leftChar == rightChar;
        if(extremitiesAreEqual){
            return isPalindrom(input.substring(1, input.length() - 1));
        }
        return false;
    }
}
