package com.lugowoy.tasks.printShortestString;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthReader;

/**
 * Enter n strings. Find the shortest string. Print the string and its length.
 * <p>
 * Created by LugowoyKonstantin on 26.07.2018.
 */

public class Main {

    private static final int LENGTH_STRING = 30;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthReader.readLength(new ReadingConsole());

        Array<String> stringArray = new Array<>(new FillingArrayRandomValueStrings("english").fill(lengthOfArray, LENGTH_STRING));

        System.out.println("Strings in an array : " + stringArray);

        print(Determinant::determineShortestString, stringArray);

    }

    private static void print(Determinant determinant, Array<String> stringArray) {
        String resultString = determinant.determine(stringArray);
        System.out.println("Result string : " + resultString);
        System.out.println("Length of the string : " + resultString.length());
    }

}
