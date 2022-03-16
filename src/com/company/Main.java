package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    /**
     * Get a random integer in range
     *
     * @param min - the min number in the range
     * @param max - the max number in the range
     * @return - a random integer number between the min number and max number inclusive.
     */
    public static int randomInRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }


    public static void printAllRandomNumbers(int min, int max) {
        List<Range> rangeList = new ArrayList<>();
        rangeList.add(new Range(min, max));
        while (rangeList.size() > 0) {
            int indexToRemove = randomInRange(0, rangeList.size() - 1);
            Range rangeToGet = rangeList.remove(indexToRemove);
            int randomNumber = randomInRange(rangeToGet.min, rangeToGet.max);
            System.out.println(randomNumber);
            if (randomNumber < rangeToGet.max) {
                rangeList.add(new Range(randomNumber + 1, rangeToGet.max));
            }
            if (randomNumber > rangeToGet.min) {
                rangeList.add(new Range(rangeToGet.min, randomNumber - 1));
            }
        }
    }

    public static void main(String[] args) {
        printAllRandomNumbers(1, 10);
    }

}

class Range {
    int max;
    int min;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
