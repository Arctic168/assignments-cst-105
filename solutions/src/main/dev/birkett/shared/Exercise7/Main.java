package com.company;

// Only import what you need, don't use the star `*` unless you want everything,
// usually when you just import all of your own submodule.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    // Rather than void, `main` returns an error code.
    public static int main(String[] args) {
        String fileName = "input.txt";
//        // First argument is always the program name. Usually a file path.
//        if (args.length != 2) {
//            // Error code 100 means that we got the wrong number of arguments.
//            return 100;
//        }
//
//        // Assume the second argument is the file path.
//        Path input_path = Path.of(args[1]);
        Path input_path = Path.of(fileName);

        // Read the file into a `String`.
        String input_string;
        try {
            input_string = Files.readString(input_path);
        } catch (IOException e) {
            // Error code 101 means that we couldn't read the file.
            return 101;
        }

        boolean result = testA(input_string);


        if (result) {
            int[] array = testB(input_string);

            if (array[1] != -1) {
                int[] arrayCopy = methodC(array);
                int sum = methodD(array);
                result = testE(sum, array[array.length - 1]);
            } else {
                result = false;
            }

            if (result) {
                for
            }
        }
    }

//        Program
//        Define a file path
//        Open a file
//        While there is a string
//                Str = reads in a strings of digits from a file
//// calls the methods you’ve designed to determine whether or not each string of digits has the desired property
//        Result = TestA(str): Boolean
//        If (Result == true)
//        Array = TestB(Str): integer array
//        If(Array[1] != -1)
//        MethodC (array:integer) : integer arrayCopy
//        Sum = MethodD(array:integer) : integer sum
//        Result = TestE(sum:integer, array[array.length()-1] : integer)Boolean Result
//        Else
//                Result = false






//        If(Result == true)
//        outputs each string of digits that satisfies the property, one per line.






//        TestA(str): boolean
//            Result = false
//            If str.length()=13
//                Result = true
//            Else
//                Result = false
//            Return Result
    public static boolean testA(String input) {
        return input.length() == 13;
    }

// DIRECT TRANSLATE, NOT PRETTY
////        TestB(str): integer array
//    public static int[] testB(String input) {
////            Result = true
//        boolean result = true;
////            Define array[13];integer
//        int[] array = new int[13];
//
////            If(TestA(str))
//        if (Tests.testA(input)) {
////            For I = 0, I < str.length(), I = I + 1
//            for (int i = 0; i < input.length(); i++) {
////            Try
////                    Array[I] = str.subString(I,I+1).parseInt()
//                try {
//                    array[i] = Integer.parseInt(input.substring(i, i + 1));
////            Catch(exception e)
//                } catch (IndexOutOfBoundsException e) {
//                    result = false;
//                }
//            }
//        } else {
//            result = false;
//        }
//
//  //  If(result == false)
//        if (!result) {
//            // fill array with -1
//            Arrays.fill(array, -1);
//        }
//
//        return array;
//    }

    public static int[] testB(String input) {
        // This here is setting the exit status of the state machine.
        // In the pseudocode this is true by default.
        // This is not correct, because if your state machine retains the exit code 0
        // by default throughout all states, we return an incorrect result.
        // If we failed to consider something that would make this test fail,
        // the default should not be to report success.
        // Rather than letting undefined behavior happen, we should return a failure
        // with array uninitialized. Hence, it has a length, and no assigned values.
//        boolean result; // NEVER USED!
        // And of course making the return value.
        int[] array = new int[13];

        // Set the default return code (this is that the -1 functions as).
        Arrays.fill(array, -1);

        // Three possible states:
        // 1. The string is not 13 characters long.
        // 2. The string is 13 characters long, but it is not a number.
        // 3. The string is 13 characters long, and it is a number.

        if (!testA(input)) {
            // We are in state 1.
            // Return the default failure return code.
            return array;
        }

        // We are in prelude to state 2 and 3.

        // It doesn't need to be included, it is merely a sanity check.
        // Notice that the IDE tells you that the comparison is redundant,
        // and we can verify that the array is always the length 13.
        assert array.length == input.length() && array.length == 13;

        try {
            // We are in state 3.
            for (int i = 0; i < input.length(); i++) {
                    array[i] = Integer.parseInt(input.substring(i, i + 1));
            }

            // We are done. Return with implied success and valid data.
        } catch (NumberFormatException e) {
            // We are in state 2.
            // This is the only exception that can be thrown.
            // Return failure code.
            // We only caught this exception because it's the one we expect to occur.
            // Don't catch exceptions you aren't prepared for, they are by definition an exception
            // to the rules of your code. Do not handle gracefully.
        }

        // There are only two mutations of the `array` variable.
        // Keeping track of the state machine's success code was unnecessary.
        return array;
    }

    //    MethodC(array:integer) : integer arrayCopy
    public static int[] methodC(int[] array) {
        int[] arrayCopy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayCopy[i] = (i % 2 == 0) ? array[i] : array[i] * 3;
        }
        return arrayCopy;
    }

    //    Sum = MethodD(array:integer) : integer sum
    public static int methodD(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    //    Result = TestE(sum:integer, array[array.length()-1] : integer)Boolean Result
    public static boolean testE(int sum, int lastDigit) {
        boolean result = false;
        if (sum == 0 && lastDigit == 0) {
            result = true;
        } else if ((10 - (sum % 10)) == lastDigit) {
            result = true;
        }
        return result;
    }
}
