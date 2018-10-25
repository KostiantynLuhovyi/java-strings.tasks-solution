package com.lugowoy.tasks.determineStringInWhichNumberOfDifferentSymbolsIsMinimum;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 14.09.2018. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<String> stringArray = Array.create(new FillingArrayRandomValueStrings("english").fill(lengthOfArray));

        System.out.println("Strings in an array : " + stringArray);

        System.out.println("Result string : " + determineStringInWhichNumberOfDifferentSymbolsIsMinimum(stringArray));

        System.out.println();

    }

    private static String determineStringInWhichNumberOfDifferentSymbolsIsMinimum(Array<String> stringArray) {
        String resultString = "";
        int counter = 0, generalCounter = Integer.MAX_VALUE;
        for (int i = 0; i < stringArray.getLength(); i++) {
            char[] chars = stringArray.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                for (int k = 0; k < chars.length; k++) {
                    if (chars[j] == chars[k]) {
                        counter++;
                    }
                }
            }
            if (counter < generalCounter) {
                generalCounter = counter;
                resultString = stringArray.get(i);
            }
            counter = 0;
        }
        return resultString;
    }

}
