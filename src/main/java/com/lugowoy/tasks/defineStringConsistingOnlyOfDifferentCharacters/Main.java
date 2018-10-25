package com.lugowoy.tasks.defineStringConsistingOnlyOfDifferentCharacters;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerArray;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 28.09.2018. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<String> stringArray = Array.create(new FillingArrayRandomValueStrings("english").fill(lengthOfArray));

        System.out.println("Strings in an array : " + stringArray);

        System.out.println("Result string : " + defineStringConsistingOnlyOfDifferentCharacters(stringArray));

    }

    private static String defineStringConsistingOnlyOfDifferentCharacters(Array<String> stringArray) {
        String resultString = "";
        int counterDifferentChar = 0;
        char[] chars;
        if (CheckerArray.checkArrayNonNull(stringArray)
                && CheckerArray.checkLengthOfArrayIsGreaterZero(stringArray.getLength())) {
            for (int i = 0; i < stringArray.getLength(); i++) {
                String str = stringArray.get(i);
                chars = str.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    for (int k = 0; k < chars.length; k++) {
                        if (j != k) {
                            if (chars[j] == chars[k]) {
                                counterDifferentChar++;
                                if (counterDifferentChar >= 2) {
                                    break;
                                }
                            } else {
                                resultString = str;
                            }
                        }
                    }
                }
                if (counterDifferentChar >= 2) {
                    counterDifferentChar = 0;
                    resultString = "";
                } else {
                    break;
                }
            }
        } else {
            System.err.println("Incorrect arguments.");
        }
        return resultString;
    }

}
