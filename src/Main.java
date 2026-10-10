/*
 * CIT300 - Data Structures and Algorithms
 * Data Structure and Graph Performance Analyzer
 *
 * Purpose: Shared application integration
 */
import array_searching.ArrayManager;
import array_searching.SearchManager;
import array_searching.SearchResult;
import stack_queue.StackManager;
import stack_queue.QueueManager;
import linked_list.LinkedListManager;
import graph_traversal.Graph;
import graph_traversal.TraversalResult;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private final InputValidator input;
    private final ArrayManager arrayManager = new ArrayManager();
    private final SearchManager searchManager = new SearchManager();
    private final StackManager stackManager = new StackManager();
    private final QueueManager queueManager = new QueueManager();
    private final LinkedListManager linkedListManager = new LinkedListManager();
    private final Graph graph = new Graph();

    private SearchResult latestLinearSearch;
    private SearchResult latestBinarySearch;
    private TraversalResult latestBfs;
    private TraversalResult latestDfs;

    private Main(InputValidator input) {
        this.input = input;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Main application = new Main(new InputValidator(scanner));
            try {
                application.run();
            } catch (NoSuchElementException error) {
                System.out.println("\nInput ended. Closing the application.");
            }
        }
        System.out.println("=============================================");
        System.out.println(" Thank you for using the");
        System.out.println(" Data Structure & Graph Performance Analyzer");
        System.out.println("=============================================");
    }

    private void run() {
        while (true) {
            showMainMenu();
            int choice = input.readMenuChoice(1, 10);
            switch (choice) {
                case 1:
                    handleArrayMenu();
                    break;
                case 2:
                    handleStackMenu();
                    break;
                case 3:
                    handleQueueMenu();
                    break;
                case 4:
                    handleLinkedListMenu();
                    break;
                case 5:
                    handleSearchingMenu();
                    break;
                case 6:
                    handleGraphMenu();
                    break;
                case 7:
                    showPerformanceComparison();
                    break;
                case 8:
                    displayAllResults();
                    break;
                case 9:
                    return;
                case 10:
                    loadSampleData();
                    break;
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n=============================================");
        System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
        System.out.println("10. Load Sample Data");
        System.out.println("=============================================");
    }

    // Fill only empty structures so loading samples preserves existing user data.
    private void loadSampleData() {
        System.out.println("\n--------------- LOAD SAMPLE DATA ---------------");
        if (arrayManager.isEmpty()) {
            int[] values = {40, 10, 30, 20, 50, 60, 70, 80, 90, 100};
            for (int value : values) {
                arrayManager.insert(value);
            }
            System.out.println("Array sample loaded (also used for searching).");
        } else {
            System.out.println("Array already contains data. Sample loading skipped.");
        }

        if (stackManager.isEmpty()) {
            int[] values = {10, 20, 30, 40, 50};
            for (int value : values) {
                stackManager.push(value);
            }
            System.out.println("Stack sample loaded. Top value: " + stackManager.peek());
        } else {
            System.out.println("Stack already contains data. Sample loading skipped.");
        }

        if (queueManager.isEmpty()) {
            int[] values = {100, 200, 300, 400, 500};
            for (int value : values) {
                queueManager.enqueue(value);
            }
            System.out.println("Queue sample loaded. Front value: " + queueManager.peek());
        } else {
            System.out.println("Queue already contains data. Sample loading skipped.");
        }

        if (linkedListManager.isEmpty()) {
            int[] values = {5, 15, 25, 35, 45};
            for (int value : values) {
                linkedListManager.insert(value);
            }
            System.out.println("Linked List sample loaded.");
        } else {
            System.out.println("Linked List already contains data. Sample loading skipped.");
        }

        if (graph.isEmpty()) {
            String[] vertices = {"A", "B", "C", "D", "E"};
            for (String vertex : vertices) {
                graph.addVertex(vertex);
            }
            String[][] edges = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"C", "D"}, {"D", "E"}};
            for (String[] edge : edges) {
                graph.addEdge(edge[0], edge[1]);
            }
            System.out.println("Graph sample loaded with 5 vertices and 5 undirected edges.");
        } else {
            System.out.println("Graph already contains data. Sample loading skipped.");
        }
        System.out.println("Choose 8 to display all current data.");
        System.out.println("For the sample array, search for 100 (found) or 999 (not found).");
        System.out.println("For the sample graph, run BFS and DFS from A.");
    }

    private void showSubmenu(String title, String... options) {
        System.out.println("\n--------------- " + title + " ---------------");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private void handleArrayMenu() {
        while (true) {
            showSubmenu("ARRAY OPERATIONS", "Insert Element", "Delete Element",
                    "Search Element", "Display Array", "Return to Main Menu");
            int choice = input.readMenuChoice(1, 5);
            switch (choice) {
                case 1:
                    arrayManager.insert(input.readInt("Enter value to insert: "));
                    System.out.println("Value inserted into the array.");
                    break;
                case 2:
                    if (arrayManager.delete(input.readInt("Enter value to delete: "))) {
                        System.out.println("Value deleted from the array.");
                    } else {
                        System.out.println("Value not found in the array.");
                    }
                    break;
                case 3:
                    int index = arrayManager.search(input.readInt("Enter value to search: "));
                    System.out.println(index == -1 ? "Value not found in the array."
                            : "Value found at index " + index + ".");
                    break;
                case 4:
                    arrayManager.display();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void handleStackMenu() {
        while (true) {
            showSubmenu("STACK OPERATIONS", "Push", "Pop", "Peek", "Display Stack",
                    "Return to Main Menu");
            int choice = input.readMenuChoice(1, 5);
            switch (choice) {
                case 1:
                    stackManager.push(input.readInt("Enter value to push: "));
                    System.out.println("Value pushed onto the stack.");
                    break;
                case 2:
                case 3:
                    if (stackManager.isEmpty()) {
                        System.out.println("Stack is empty. Operation cannot be performed.");
                    } else if (choice == 2) {
                        System.out.println("Popped value: " + stackManager.pop());
                    } else {
                        System.out.println("Top value: " + stackManager.peek());
                    }
                    break;
                case 4:
                    stackManager.display();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void handleQueueMenu() {
        while (true) {
            showSubmenu("QUEUE OPERATIONS", "Enqueue", "Dequeue", "Peek / Front",
                    "Display Queue", "Return to Main Menu");
            int choice = input.readMenuChoice(1, 5);
            switch (choice) {
                case 1:
                    queueManager.enqueue(input.readInt("Enter value to enqueue: "));
                    System.out.println("Value enqueued.");
                    break;
                case 2:
                case 3:
                    if (queueManager.isEmpty()) {
                        System.out.println("Queue is empty. Operation cannot be performed.");
                    } else if (choice == 2) {
                        System.out.println("Dequeued value: " + queueManager.dequeue());
                    } else {
                        System.out.println("Front value: " + queueManager.peek());
                    }
                    break;
                case 4:
                    queueManager.display();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void handleLinkedListMenu() {
        while (true) {
            showSubmenu("LINKED LIST OPERATIONS", "Insert", "Delete", "Search", "Display",
                    "Return to Main Menu");
            int choice = input.readMenuChoice(1, 5);
            switch (choice) {
                case 1:
                    linkedListManager.insert(input.readInt("Enter value to insert: "));
                    System.out.println("Value inserted at the end of the linked list.");
                    break;
                case 2:
                    if (linkedListManager.isEmpty()) {
                        System.out.println("Linked List is empty.");
                    } else if (linkedListManager.delete(input.readInt("Enter value to delete: "))) {
                        System.out.println("Value deleted from the linked list.");
                    } else {
                        System.out.println("Value not found in the linked list.");
                    }
                    break;
                case 3:
                    if (linkedListManager.isEmpty()) {
                        System.out.println("Linked List is empty.");
                    } else {
                        int index = linkedListManager.search(input.readInt("Enter value to search: "));
                        System.out.println(index == -1 ? "Value not found in the linked list."
                                : "Value found at index " + index + ".");
                    }
                    break;
                case 4:
                    linkedListManager.display();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void handleSearchingMenu() {
        while (true) {
            showSubmenu("SEARCHING OPERATIONS", "Linear Search", "Binary Search",
                    "Compare Linear and Binary Search", "Return to Main Menu");
            int choice = input.readMenuChoice(1, 4);
            if (choice == 4) {
                return;
            }
            if (arrayManager.isEmpty()) {
                System.out.println("Array is empty. Please insert data before searching.");
                continue;
            }
            int target = input.readInt("Enter search value: ");
            int[] values = arrayManager.getValues();
            if (choice == 1) {
                latestLinearSearch = searchManager.linearSearch(values, target);
                showSearchResult(latestLinearSearch);
            } else if (choice == 2) {
                latestBinarySearch = searchManager.binarySearch(values, target);
                showSearchResult(latestBinarySearch);
            } else {
                latestLinearSearch = searchManager.linearSearch(values, target);
                latestBinarySearch = searchManager.binarySearch(values, target);
                showSearchComparison(target);
            }
        }
    }

    private void showSearchResult(SearchResult result) {
        boolean binary = result.getAlgorithmName().equals("Binary Search");
        System.out.println(binary ? "Sorted Array Used:" : "Array Used:");
        System.out.println(Arrays.toString(result.getValuesUsed()));
        System.out.println(result);
        System.out.println(binary ? "Index is zero-based in the sorted copy."
                : "Index is zero-based in the original array.");
    }

    private void showSearchComparison(int target) {
        System.out.println("\n============================================================");
        System.out.println("          SEARCH PERFORMANCE COMPARISON");
        System.out.println("============================================================");
        System.out.println("Search Value: " + target);
        System.out.println("Original Array: " + Arrays.toString(latestLinearSearch.getValuesUsed()));
        System.out.println("Sorted Array Used:");
        System.out.println(Arrays.toString(latestBinarySearch.getValuesUsed()));
        System.out.printf("%-18s %-10s %-12s %s%n", "Algorithm", "Found", "Steps", "Time(ns)");
        System.out.println("------------------------------------------------------------");
        printSearchRow(latestLinearSearch);
        printSearchRow(latestBinarySearch);
        System.out.println("============================================================");
        System.out.println("Linear Search index (original array): " + latestLinearSearch.getIndex());
        System.out.println("Binary Search index (sorted copy): " + latestBinarySearch.getIndex());
        System.out.println("\nLinear Search");
        System.out.println("Best Case    : O(1)");
        System.out.println("Average Case : O(n)");
        System.out.println("Worst Case   : O(n)");
        System.out.println("\nBinary Search");
        System.out.println("Best Case    : O(1)");
        System.out.println("Average Case : O(log n)");
        System.out.println("Worst Case   : O(log n)");
        showMeasurementNotes();
    }

    private void printSearchRow(SearchResult result) {
        System.out.printf("%-18s %-10s %-12d %d%n", result.getAlgorithmName(),
                result.isFound() ? "Yes" : "No", result.getSteps(), result.getExecutionTime());
    }

    private void handleGraphMenu() {
        while (true) {
            showSubmenu("GRAPH OPERATIONS", "Add Vertex", "Add Edge", "Display Graph",
                    "BFS Traversal", "DFS Traversal", "Return to Main Menu");
            int choice = input.readMenuChoice(1, 6);
            try {
                switch (choice) {
                    case 1:
                        String vertex = input.readString("Enter vertex name: ");
                        System.out.println(graph.addVertex(vertex)
                                ? "Vertex added." : "Vertex already exists.");
                        break;
                    case 2:
                        String first = input.readString("First Vertex: ");
                        String second = input.readString("Second Vertex: ");
                        System.out.println(graph.addEdge(first, second)
                                ? "Undirected edge added." : "Edge already exists.");
                        break;
                    case 3:
                        graph.display();
                        break;
                    case 4:
                    case 5:
                        if (graph.isEmpty()) {
                            System.out.println("Graph is empty.");
                            break;
                        }
                        String start = input.readString("Enter starting vertex: ");
                        if (choice == 4) {
                            latestBfs = graph.bfs(start);
                            System.out.println(latestBfs);
                        } else {
                            latestDfs = graph.dfs(start);
                            System.out.println(latestDfs);
                        }
                        System.out.println("Steps = vertex visits + adjacency entries examined.");
                        System.out.println("Only vertices reachable from the start are visited.");
                        break;
                    case 6:
                        return;
                }
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private void showPerformanceComparison() {
        System.out.println("\n=======================================================================");
        System.out.println("                 PERFORMANCE COMPARISON");
        System.out.println("=======================================================================");
        System.out.printf("%-18s %-18s %-16s %s%n", "Operation", "Algorithm", "Steps", "Time(ns)");
        System.out.println("-----------------------------------------------------------------------");
        printPerformanceRow("Search", "Linear Search",
                latestLinearSearch == null ? null : latestLinearSearch.getSteps(),
                latestLinearSearch == null ? null : latestLinearSearch.getExecutionTime());
        printPerformanceRow("Search", "Binary Search",
                latestBinarySearch == null ? null : latestBinarySearch.getSteps(),
                latestBinarySearch == null ? null : latestBinarySearch.getExecutionTime());
        printPerformanceRow("Graph Traversal", "BFS",
                latestBfs == null ? null : latestBfs.getSteps(),
                latestBfs == null ? null : latestBfs.getExecutionTime());
        printPerformanceRow("Graph Traversal", "DFS",
                latestDfs == null ? null : latestDfs.getSteps(),
                latestDfs == null ? null : latestDfs.getExecutionTime());
        System.out.println("=======================================================================");
        System.out.println("Linear Search: O(n)     Binary Search: O(log n)");
        System.out.println("BFS: O(V + E)           DFS: O(V + E)");
        System.out.println("n = array size; V = vertices; E = edges.");
        System.out.println("Rows retain the latest run of each algorithm, even after data changes.");
        System.out.println("Use Display All Results for the target, input snapshot, start and order.");
        showMeasurementNotes();
    }

    private void printPerformanceRow(String operation, String algorithm, Integer steps, Long time) {
        System.out.printf("%-18s %-18s %-16s %s%n", operation, algorithm,
                steps == null ? "Not tested yet" : steps.toString(),
                time == null ? "-" : time.toString());
    }

    private void showMeasurementNotes() {
        System.out.println("Search steps = array elements inspected; graph steps = visits + neighbor checks.");
        System.out.println("Binary search timing excludes copying and sorting the input.");
        System.out.println("Sorting adds preparation cost; small single-run times vary with JVM warm-up.");
        System.out.println("Compare results using the same input and target or starting vertex.");
    }

    private void displayAllResults() {
        System.out.println("\n============================================================");
        System.out.println("                    CURRENT SYSTEM DATA");
        System.out.println("============================================================");
        System.out.println(arrayManager.isEmpty() ? "Array: Empty" : "\nARRAY:");
        if (!arrayManager.isEmpty()) {
            arrayManager.display();
        }
        System.out.println(stackManager.isEmpty() ? "Stack: Empty" : "\nSTACK:");
        if (!stackManager.isEmpty()) {
            stackManager.display();
        }
        System.out.println(queueManager.isEmpty() ? "Queue: Empty" : "\nQUEUE:");
        if (!queueManager.isEmpty()) {
            queueManager.display();
        }
        System.out.println(linkedListManager.isEmpty() ? "Linked List: Empty" : "\nLINKED LIST:");
        if (!linkedListManager.isEmpty()) {
            linkedListManager.display();
        }
        System.out.println(graph.isEmpty() ? "Graph: Empty" : "\nGRAPH:");
        if (!graph.isEmpty()) {
            graph.display();
        }
        System.out.println("\nLATEST PERFORMANCE RESULTS:");
        System.out.println("These results describe the data at the time each algorithm ran.");
        if (latestLinearSearch == null) {
            System.out.println("Linear Search: Not tested yet");
        } else {
            showSearchResult(latestLinearSearch);
        }
        if (latestBinarySearch == null) {
            System.out.println("Binary Search: Not tested yet");
        } else {
            showSearchResult(latestBinarySearch);
        }
        System.out.println(latestBfs == null ? "BFS: Not tested yet" : latestBfs);
        System.out.println(latestDfs == null ? "DFS: Not tested yet" : latestDfs);
        System.out.println("============================================================");
    }
}
