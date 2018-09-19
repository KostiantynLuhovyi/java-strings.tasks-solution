package com.lugowoy.tasks.determineNumbersOfStringsContainingOnlyLatinCharacters;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayUnknown;
import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 16.09.2018. */

public class Main {

    private static final int LENGTH_STRING = 5;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<String> stringArray = FactoryArray.getFactoryArray(new CreatorArrayUnknown<String>()).create(
                                                                     new FillingArrayRandomValueStrings("english+russian").fill(lengthArray, LENGTH_STRING));

        System.out.println("Strings : " + stringArray);

        determineNumbersOfStringsContainingOnlyLatinCharacters(stringArray);
    }

    private static void determineNumbersOfStringsContainingOnlyLatinCharacters(Array<String> stringArray) {
        int countOfStrings = 0;
        for (int i = 0; i < stringArray.getLength(); i++) {
            String str = stringArray.get(i);
            if (str.matches("[a-zA-Z]+")) {
                System.out.println("Result : " + str);
                countOfStrings++;
            }
        }
        if (countOfStrings == 0) {
            System.out.println("No strings were found containing only Latin characters.");
        }
    }

}
