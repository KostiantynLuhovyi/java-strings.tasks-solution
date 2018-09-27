package com.lugowoy.tasks.determineStringsInWhichCharactersGoInOrderOfIncreasingTheirCodes;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayUnknown;
import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 27.09.2018. */

public class Main {

    private static final int LENGTH_STRING = 5;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<String> stringArray = FactoryArray.getFactoryArray(new CreatorArrayUnknown<String>()).create(
                                                                     new FillingArrayRandomValueStrings("english").fill(lengthArray, LENGTH_STRING));

        System.out.println("Strings in an array : " + stringArray);

        System.out.println("Result : ");
        determineStringsInWhichCharactersGoInOrderOfIncreasingTheirCodes(stringArray);

    }

    private static void determineStringsInWhichCharactersGoInOrderOfIncreasingTheirCodes(Array<String> stringArray) {
        String resultString = "";
        int countNumberOfResult = 0;
        int codeOfCharValue = Integer.MIN_VALUE;
        for (int i = 0; i < stringArray.getLength(); i++) {
            String strValue = stringArray.get(i);
            for (int j = 0; j < strValue.length(); j++) {
                int codeOfCurrentChar = (int) strValue.charAt(j);
                if (codeOfCurrentChar > codeOfCharValue) {
                    codeOfCharValue = codeOfCurrentChar;
                    resultString = strValue;
                } else {
                    resultString = "";
                    break;
                }
            }
            if ( ! resultString.equals("")) {
                System.out.println(resultString);
                countNumberOfResult++;
            }
            codeOfCharValue = Integer.MIN_VALUE;
        }
        if (countNumberOfResult == 0) {
            System.out.println("No strings matching the condition.");
        }
    }
    
}