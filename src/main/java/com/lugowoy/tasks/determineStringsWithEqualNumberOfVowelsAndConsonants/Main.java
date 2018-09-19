package com.lugowoy.tasks.determineStringsWithEqualNumberOfVowelsAndConsonants;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayUnknown;
import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 19.09.2018. */

public class Main {

    private static final int LENGTH_STRING = 10;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<String> stringArray = FactoryArray.getFactoryArray(new CreatorArrayUnknown<String>()).create(
                                                                     new FillingArrayRandomValueStrings("english").fill(lengthArray, LENGTH_STRING));

        System.out.println("Strings in an array : " + stringArray);

        determineStringsWithEqualNumberOfVowelsAndConsonants(stringArray);

    }

    private static void determineStringsWithEqualNumberOfVowelsAndConsonants(Array<String> stringArray) {
        System.out.print("Result : ");
        int countOfVowels = 0, countOfConsonants = 0;
        int countOfStrings = 0;
        for (int i = 0; i < stringArray.getLength(); i++) {
            char[] chars = stringArray.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                String str = String.valueOf(chars[j]);
                if (str.matches("[AaEeIiOoUuYy]")) {
                    countOfVowels++;
                } else {
                    countOfConsonants++;
                }
            }
            if (countOfVowels == countOfConsonants) {
                countOfStrings++;
                System.out.println(stringArray.get(i) + " ");
            }
            countOfVowels = 0;
            countOfConsonants = 0;
        }
        if (countOfStrings == 0) {
            System.out.println("No strings were found with an equal number of vowels and consonants.");
        }
    }

}