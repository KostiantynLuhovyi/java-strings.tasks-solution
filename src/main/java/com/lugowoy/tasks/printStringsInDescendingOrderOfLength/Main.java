package com.lugowoy.tasks.printStringsInDescendingOrderOfLength;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomLengthValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthArray;

/** Created by Konstantin Lugowoy on 09.08.2018. */

public class Main {

    private static final int BOUND_STRINGS_LENGTH = 30;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthArray.getLengthOfArray(new ReadingConsole());

        Array<String> stringsArray = Array.create(new FillingArrayRandomLengthValueStrings("english").fill(lengthOfArray, BOUND_STRINGS_LENGTH));

        System.out.println("Strings in an array : " + stringsArray);

        printNumbersInDescendingOrdersOfLength(stringsArray);

        System.out.println("Result : " + stringsArray);

    }

    private static void printNumbersInDescendingOrdersOfLength(Array<String> stringsArray) {
        boolean toSort = true;
        while (toSort) {
            toSort = false;
            for (int j = 0; j < stringsArray.getLength() - 1; j++) {
                if (stringsArray.get(j).length() < stringsArray.get(j + 1).length()) {
                    String tmp = stringsArray.get(j + 1);
                    stringsArray.set(j + 1, stringsArray.get(j));
                    stringsArray.set(j, tmp);
                    toSort = true;
                }
            }
        }
    }

}
