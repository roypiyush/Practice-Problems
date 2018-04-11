package com.topcoder.greedy;

import java.util.Arrays;
import java.util.Collections;

public class TomekPhone {

    public static void main(String[] args) {
        Integer[] frequencies = {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
        Integer[] keySizes = {50};
        System.out.println(new TomekPhone().minKeystrokes(frequencies, keySizes));
    }

    int minKeystrokes(Integer[] frequencies, Integer[] keySizes) {

        int numberOfLetters = frequencies.length;

        int numberOfKeys = keySizes.length;

        int numberOfSupportedLettersOnKeys = 0;
        for (int i = 0; i < numberOfKeys; i++) {
            numberOfSupportedLettersOnKeys += keySizes[i];
        }

        if (numberOfSupportedLettersOnKeys < numberOfLetters) {
            return -1;
        }

        // Idea should be like most higher frequency letter should be
        // in the beginning of the key

        // Sort the frequencies desc
        Collections.sort(Arrays.asList(frequencies), Collections.reverseOrder());

        // Sort the keySizes desc
        Collections.sort(Arrays.asList(keySizes), Collections.reverseOrder());

        int numberOfTyping = 0;
        // Keep of assigning the letters in all keys sequentially
        int position = 1;
        int i = 0;
        for (int j = 0; j < numberOfLetters; j++) {

            if (i == keySizes.length || position > keySizes[i]) {
                // Go for next position
                position++;
                i = 0;
                j--;
                continue;
            }

            numberOfTyping += frequencies[j] * position;
            i++;

        }


        // You need to find the positions

        return numberOfTyping;
    }

}
