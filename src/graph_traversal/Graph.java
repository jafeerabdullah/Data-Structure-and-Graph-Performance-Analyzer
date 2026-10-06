/*
 * CIT300 - Data Structures and Algorithms
 * Data Structure and Graph Performance Analyzer
 *
 * Contributor: MTF.Nifra
 * Student ID: 23DA2-0729
 * Responsibility: Graph implementation and traversal
 */
package graph_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    // Insertion order makes display and traversal order predictable.
    private final Map<String, List<String>> adjacencyList;
    private int edgeCount;

    public Graph() {
        adjacencyList = new LinkedHashMap<>();
        edgeCount = 0;
    }

    public boolean addVertex(String vertex) {
        vertex = validateName(vertex);
        if (adjacencyList.containsKey(vertex)) {
            return false;
        }
        adjacencyList.put(vertex, new ArrayList<>());
        return true;
    }

    public boolean addEdge(String first, String second) {
        first = validateName(first);
        second = validateName(second);
        if (!adjacencyList.containsKey(first) || !adjacencyList.containsKey(second)) {
            throw new IllegalArgumentException("One or both vertices do not exist.");
        }
        if (adjacencyList.get(first).contains(second)) {
            return false;
        }
        adjacencyList.get(first).add(second);
        // A self-loop needs only one adjacency entry.
        if (!first.equals(second)) {
            adjacencyList.get(second).add(first);
        }
        edgeCount++;
        return true;
    }

    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }

    public int getVertexCount() {
        return adjacencyList.size();
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public List<String> getNeighbors(String vertex) {
        vertex = requireStart(vertex);
        return new ArrayList<>(adjacencyList.get(vertex));
    }

    public TraversalResult bfs(String startVertex) {
        startVertex = requireStart(startVertex);
        int steps = 0;
        long start = System.nanoTime();
        Set<String> visited = new HashSet<>();
        List<String> order = new ArrayList<>();
        ArrayDeque<String> pending = new ArrayDeque<>();

        visited.add(startVertex);
        pending.addLast(startVertex);
        while (!pending.isEmpty()) {
            String current = pending.removeFirst();
            order.add(current);
            steps++; // One step per vertex visit.
            for (String neighbor : adjacencyList.get(current)) {
                steps++; // One step per adjacency entry examined.
                if (visited.add(neighbor)) {
                    pending.addLast(neighbor);
                }
            }
        }
        long time = System.nanoTime() - start;
        return new TraversalResult("BFS", String.join(" -> ", order),
                steps, time, startVertex, order.size());
    }

    public TraversalResult dfs(String startVertex) {
        startVertex = requireStart(startVertex);
        int steps = 0;
        long start = System.nanoTime();
        Set<String> visited = new HashSet<>();
        List<String> order = new ArrayList<>();
        ArrayDeque<String> pending = new ArrayDeque<>();

        // An explicit stack avoids recursion depth limits on long paths.
        pending.push(startVertex);
        while (!pending.isEmpty()) {
            String current = pending.pop();
            if (!visited.add(current)) {
                continue;
            }
            order.add(current);
            steps++;
            List<String> neighbors = adjacencyList.get(current);
            // Push in reverse so the first inserted neighbor is visited first.
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                steps++;
                String neighbor = neighbors.get(i);
                if (!visited.contains(neighbor)) {
                    pending.push(neighbor);
                }
            }
        }
        long time = System.nanoTime() - start;
        return new TraversalResult("DFS", String.join(" -> ", order),
                steps, time, startVertex, order.size());
    }

    private String validateName(String vertex) {
        if (vertex == null || vertex.trim().isEmpty()) {
            throw new IllegalArgumentException("Vertex name cannot be empty.");
        }
        return vertex.trim();
    }

    private String requireStart(String vertex) {
        vertex = validateName(vertex);
        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Starting vertex does not exist.");
        }
        return vertex;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("=============================================");
        System.out.println(" GRAPH");
        System.out.println("=============================================");
        System.out.println(this);
        System.out.println("=============================================");
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Graph is empty.";
        }
        StringBuilder text = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            if (text.length() > 0) {
                text.append("\n");
            }
            text.append(entry.getKey()).append(" -> ");
            text.append(entry.getValue().isEmpty()
                    ? "(no neighbors)" : String.join(", ", entry.getValue()));
        }
        return text.toString();
    }
}
