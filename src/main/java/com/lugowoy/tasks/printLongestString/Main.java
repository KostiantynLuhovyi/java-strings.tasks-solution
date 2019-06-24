package com.lugowoy.tasks.printLongestString;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthReader;
import com.lugowoy.tasks.printShortestString.Determinant;

/**
 * Enter n strings. Find the longest string. Print the string and its length.
 * <p>
 * Created by LugowoyKonstantin on 08.06.2018.
 */

public class Main {

    private static final int LENGTH_STRING = Byte.MAX_VALUE - 1;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthReader.readLength(new ReadingConsole());

        Array<String> stringArray = new Array<>(new FillingArrayRandomValueStrings("english").fill(lengthOfArray, LENGTH_STRING));

        System.out.println("Strings in an array : " + stringArray);

        printLongestString(Determinant::determineLongestString, stringArray);

    }

    //The functional interface Determinant from the package com.lugowoy.tasks.printShortestString .
    private static void printLongestString(Determinant determinant, Array<String> stringArray) {
        String resultString = determinant.determine(stringArray);
        System.out.println("Result string : " + resultString);
        System.out.println("Length of the string : " + resultString.length());
    }

}
