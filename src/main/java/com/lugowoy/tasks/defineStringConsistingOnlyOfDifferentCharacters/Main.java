package com.lugowoy.tasks.defineStringConsistingOnlyOfDifferentCharacters;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.CheckerLengthArray;
import com.lugowoy.helper.other.LengthReader;

import java.util.Objects;

/**
 * Define a string consisting only of different characters.
 * If there are several such lines, determine the first one.
 * <p>
 * Created by LugowoyKonstantin on 28.09.2018.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthReader.readLength(new ReadingConsole());

        Array<String> stringArray = new Array<>(new FillingArrayRandomValueStrings("english").fill(lengthOfArray));

        System.out.println("Strings in an array : " + stringArray);

        System.out.println("Result string : " + defineStringConsistingOnlyOfDifferentCharacters(stringArray));

    }

    private static String defineStringConsistingOnlyOfDifferentCharacters(Array<String> stringArray) {
        String resultString = "";
        int counterDifferentChar = 0;
        char[] chars;
        if (Objects.nonNull(stringArray) && CheckerLengthArray.checkLengthArray(stringArray)) {
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
