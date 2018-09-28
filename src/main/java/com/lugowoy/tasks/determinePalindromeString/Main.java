package com.lugowoy.tasks.determinePalindromeString;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayUnknown;
import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.filling.array.strings.FillingArrayReadValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 28.09.2018. */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        System.out.println("Enter strings : ");
        Array<String> stringArray = FactoryArray.getFactoryArray(new CreatorArrayUnknown<String>()).create(
                                                                     new FillingArrayReadValueStrings(new ReadingConsole()).fill(lengthArray));

        System.out.println("Strings in an array : " + stringArray);

        System.out.println("Result : " + determinePalindromeString(stringArray));

    }

    private static String determinePalindromeString(Array<String> stringArray) {
        int countResultString = 0;
        String resultString = "";
        for (int i = 0; i < stringArray.getLength(); i++) {
            String str = stringArray.get(i);
            char[] chars = str.toCharArray();
            int firstIndex = 0;
            int secondIndex = chars.length - 1;
            while (secondIndex > firstIndex) {
                if (chars[firstIndex] == chars[secondIndex]) {
                    resultString = str;
                } else {
                    resultString = "";
                    break;
                }
                ++firstIndex;
                --secondIndex;
            }
            if ( ! resultString.equals("")) {
                countResultString++;
                if (countResultString == 2) {
                    break;
                }
            }
        }
        return resultString;
    }

}