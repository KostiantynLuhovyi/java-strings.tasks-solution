package com.lugowoy.tasks.determineStringsWithEqualNumberOfVowelsAndConsonants;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthReader;

/**
 * Determine strings with an equal number of vowels and consonants.
 * <p>
 * Created by LugowoyKonstantin on 19.09.2018.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthReader.readLength(new ReadingConsole());

        System.out.println("Enter length of all strings : ");
        int lengthStrings = new ReadingConsole().readInt();

        if (lengthStrings % 2 == 0) {
            Array<String> stringArray = new Array<>(new FillingArrayRandomValueStrings("english").fill(lengthOfArray, lengthStrings));
            System.out.println("Strings in an array : " + stringArray);
            determineStringsWithEqualNumberOfVowelsAndConsonants(stringArray);
        } else {
            System.out.println("The entered strings length is not an even number " +
                                            "and therefore there can not be the same number of vowels and consonants.");
        }

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
