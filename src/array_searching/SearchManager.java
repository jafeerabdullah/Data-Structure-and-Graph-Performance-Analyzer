/*
 * CIT300 - Data Structures and Algorithms
 * Data Structure and Graph Performance Analyzer
 *
 * Contributor: J.Abdullah
 * Student ID: 23DA2-0575
 * Responsibility: Array and Searching implementation
 */
package array_searching;

import java.util.Arrays;

public class SearchManager {
    public SearchResult linearSearch(int[] values, int target) {
        int steps = 0;
        int index = -1;
        long start = System.nanoTime();
        for (int i = 0; i < values.length; i++) {
            steps++; // One step means inspecting one array element.
            if (values[i] == target) {
                index = i;
                break;
            }
        }
        long time = System.nanoTime() - start;
        return new SearchResult("Linear Search", target, index != -1,
                index, steps, time, values);
    }

    public SearchResult binarySearch(int[] values, int target) {
        // Preparation is outside the timer, and the original order is preserved.
        int[] sorted = values.clone();
        Arrays.sort(sorted);

        int low = 0;
        int high = sorted.length - 1;
        int index = -1;
        int steps = 0;
        long start = System.nanoTime();
        while (low <= high) {
            int middle = low + (high - low) / 2;
            steps++; // One step means inspecting one midpoint.
            if (sorted[middle] == target) {
                index = middle;
                break;
            }
            if (sorted[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        long time = System.nanoTime() - start;
        return new SearchResult("Binary Search", target, index != -1,
                index, steps, time, sorted);
    }
}
