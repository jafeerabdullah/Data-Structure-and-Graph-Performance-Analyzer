/*
 * CIT300 - Data Structures and Algorithms
 * Data Structure and Graph Performance Analyzer
 *
 * Contributor: J.Abdullah
 * Student ID: 23DA2-0575
 * Responsibility: Array and Searching implementation
 */
package array_searching;

public class SearchResult {
    private final String algorithmName;
    private final int target;
    private final boolean found;
    private final int index;
    private final int steps;
    private final long executionTime;
    private final int[] valuesUsed;

    public SearchResult(String algorithmName, int target, boolean found,
                        int index, int steps, long executionTime, int[] valuesUsed) {
        this.algorithmName = algorithmName;
        this.target = target;
        this.found = found;
        this.index = index;
        this.steps = steps;
        this.executionTime = executionTime;
        this.valuesUsed = valuesUsed.clone();
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public int getTarget() {
        return target;
    }

    public boolean isFound() {
        return found;
    }

    public int getIndex() {
        return index;
    }

    public int getSteps() {
        return steps;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public int[] getValuesUsed() {
        return valuesUsed.clone();
    }

    @Override
    public String toString() {
        return "=============================================\n"
                + " " + algorithmName.toUpperCase() + " RESULT\n"
                + "=============================================\n"
                + "Search Value : " + target + "\n"
                + "Result       : " + (found ? "Found" : "Not found") + "\n"
                + "Index        : " + index + "\n"
                + "Steps        : " + steps + "\n"
                + "Time         : " + executionTime + " ns\n"
                + "=============================================";
    }
}
