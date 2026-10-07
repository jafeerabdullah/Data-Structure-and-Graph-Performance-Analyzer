/*
 * CIT300 - Data Structures and Algorithms
 * Data Structure and Graph Performance Analyzer
 *
 * Contributor: MTF.Nifra
 * Student ID: 23DA2-0729
 * Responsibility: Graph implementation and traversal
 */
package graph_traversal;

public class TraversalResult {
    private final String algorithmName;
    private final String traversalOrder;
    private final int steps;
    private final long executionTime;
    private final String startVertex;
    private final int verticesVisited;

    public TraversalResult(String algorithmName, String traversalOrder, int steps,
                           long executionTime, String startVertex, int verticesVisited) {
        this.algorithmName = algorithmName;
        this.traversalOrder = traversalOrder;
        this.steps = steps;
        this.executionTime = executionTime;
        this.startVertex = startVertex;
        this.verticesVisited = verticesVisited;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public String getTraversalOrder() {
        return traversalOrder;
    }

    public int getSteps() {
        return steps;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public String getStartVertex() {
        return startVertex;
    }

    public int getVerticesVisited() {
        return verticesVisited;
    }

    @Override
    public String toString() {
        return "=============================================\n"
                + " " + algorithmName + " Traversal:\n"
                + "=============================================\n"
                + traversalOrder + "\n"
                + "Start vertex     : " + startVertex + "\n"
                + "Vertices visited : " + verticesVisited + "\n"
                + "Steps            : " + steps + "\n"
                + "Time             : " + executionTime + " ns\n"
                + "Complexity       : O(V + E)\n"
                + "=============================================";
    }
}
