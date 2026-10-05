# Data Structure and Graph Performance Analyzer

## Course

CIT300 - Data Structures and Algorithms  
Graded Practical Assignment 2

## Project Description

One integrated Java console application for working with arrays, stacks, queues,
singly linked lists, searching algorithms, and an undirected graph. Users can
insert and remove data, run linear and binary search, traverse graphs with BFS
and DFS, and compare actual step counts and execution times.

The application uses standard Java only. It has no external dependencies.
Data stays available while navigating menus and is held in memory until exit.

## Team Members

| Member | Student ID | Source Folder | Suggested Responsibility |
|---|---|---|---|
| J.Abdullah | 23DA2-0575 | `src/array_searching` | Array and Searching implementation |
| SMF.Asra | 23DA2-0826 | `src/stack_queue` | Stack and Queue implementation |
| MSM.Dilsath | 23DA2-0576 | `src/linked_list` | Linked List implementation |
| MTF.Nifra | 23DA2-0729 | `src/graph_traversal` | Graph implementation and traversal |

Names and IDs are recorded exactly as supplied. The module descriptions below
document the assigned responsibilities; they are not a record of completed
individual student development. Each member should review their assigned code
and keep their contribution description accurate as they work on the project.

## Individual Contributions

### J.Abdullah - 23DA2-0575

Assigned responsibility: Array and Searching implementation.

Files:

- `src/array_searching/ArrayManager.java`
- `src/array_searching/SearchManager.java`
- `src/array_searching/SearchResult.java`

Assigned contribution: Maintain the manually resized integer array, insertion,
first-match deletion, display, and searching. Explain the manual linear and
binary searches, sorted-copy preparation, result snapshots, step counts, and
search performance comparison.

### SMF.Asra - 23DA2-0826

Assigned responsibility: Stack and Queue implementation.

Files:

- `src/stack_queue/StackManager.java`
- `src/stack_queue/QueueManager.java`

Assigned contribution: Maintain the array-backed LIFO stack and circular FIFO
queue. Explain push/pop/peek, enqueue/dequeue/front, display, empty-operation
handling, wraparound, and manual capacity growth.

### MSM.Dilsath - 23DA2-0576

Assigned responsibility: Linked List implementation.

File:

- `src/linked_list/LinkedListManager.java`

Assigned contribution: Maintain the singly linked list and its private Node
class. Explain insertion at the end, first-match deletion at the head, middle,
or end, sequential search, display, and empty-list handling.

### MTF.Nifra - 23DA2-0729

Assigned responsibility: Graph implementation and traversal.

Files:

- `src/graph_traversal/Graph.java`
- `src/graph_traversal/TraversalResult.java`

Assigned contribution: Maintain the undirected adjacency-list graph, vertex and
edge validation, duplicate prevention, graph display, BFS, iterative DFS, and
traversal performance results.

### Shared Integration

`src/Main.java` connects all modules, retains their objects, provides all menus,
and displays performance and current data. `src/InputValidator.java` handles
integer, menu-range, and nonempty string input. Integration, testing, and README
review are shared responsibilities.

## Main Features

- Array: insert, delete the first match, search, and display.
- Stack: push, pop, peek, and display from top to bottom.
- Circular queue: enqueue, dequeue, peek/front, and display in FIFO order.
- Singly linked list: insert at the end, delete the first match, search, display.
- Manual linear search and binary search with measured steps and time.
- Binary search on a sorted copy, preserving the original array order.
- Undirected graph: add vertices, add edges, display, BFS, and DFS.
- Performance comparison using the latest actual results of four algorithms.
- Display all current structures and detailed latest algorithm results.
- Validation of text, empty input, out-of-range menu choices, and integers.
- Clear messages for empty structures, missing values, and invalid graph inputs.
- Load sample datasets for all five structures using main-menu option 10.

## Technology

Java console application, using classes, constructors, private fields, public
methods, and encapsulation. A JDK is required, including both `java` and `javac`.
The source uses Java 8-compatible language features. It was compiled and run
locally using JDK 23.0.2.

The array, stack, queue, and linked list are implemented manually. Java
collections are used only within the graph component. `Arrays.sort()` prepares
the binary-search copy; binary search itself is implemented manually.

## Project Structure

```text
CIT300-Data-Structure-Graph-Analyzer/
|-- README.md
|-- src/
|   |-- Main.java
|   |-- InputValidator.java
|   |-- array_searching/
|   |   |-- ArrayManager.java
|   |   |-- SearchManager.java
|   |   `-- SearchResult.java
|   |-- stack_queue/
|   |   |-- StackManager.java
|   |   `-- QueueManager.java
|   |-- linked_list/
|   |   `-- LinkedListManager.java
|   `-- graph_traversal/
|       |-- Graph.java
|       `-- TraversalResult.java
`-- out/                         (generated by compilation)
    |-- Main.class
    |-- InputValidator.class
    |-- array_searching/         (three compiled classes)
    |-- stack_queue/             (two compiled classes)
    |-- linked_list/             (manager and nested Node classes)
    `-- graph_traversal/         (two compiled classes)
```

There is one `Main.java`, directly inside `src`. Packaged source files match
their folder names. No build system or additional project configuration is
needed.

## How to Compile

Open a terminal in the project root, the folder containing this README and
`src`. Compile all source files:

```text
javac -d out src/Main.java src/InputValidator.java src/array_searching/*.java src/stack_queue/*.java src/linked_list/*.java src/graph_traversal/*.java
```

The command creates `out` and the required package directories. Recompile after
editing source files. If Java is not found, add your JDK's `bin` directory to
PATH and open a new terminal.

## How to Run

From the same project root:

```text
java -cp out Main
```

Choose a main-menu option from 1 to 10. Each structure has its own submenu and a
return option. Main-menu option 9 exits; option 10 loads sample data.
End-of-input also closes cleanly.

## Sample Datasets

Choose **10. Load Sample Data** from the main menu, then **8. Display All Results**
to view the data. Samples are loaded only into empty structures. Existing values,
vertices, edges, and algorithm results are preserved, and selecting option 10
again does not duplicate data. Draining a structure completely allows its sample
to be loaded again. The application still starts with empty structures.

| Component | Sample Dataset | Operations to Try |
|---|---|---|
| Array and Searching | `[40, 10, 30, 20, 50, 60, 70, 80, 90, 100]` | Display; insert `110`; search/delete `20`; compare searches for `100`; search for missing `999` |
| Stack | Push order: `10, 20, 30, 40, 50` | Peek returns `50`; pop returns `50`; push `60`; display from the top |
| Queue | Front to rear: `100, 200, 300, 400, 500` | Peek returns `100`; dequeue returns `100`; enqueue `600`; display FIFO order |
| Linked List | `5 -> 15 -> 25 -> 35 -> 45 -> null` | Search `25` at index `2`; delete head `5`, middle `25`, or last `45`; insert `55` |
| Graph | Vertices: `A, B, C, D, E`; edges: `A-B, A-C, B-D, C-D, D-E` | Display; BFS/DFS from `A`; add vertex `F` and edge `E-F`; try duplicate vertex `A` or missing vertex `Z` |

For the unchanged sample array, searching for `100` takes 10 linear-search steps
and 4 binary-search steps. Binary search displays the sorted copy
`[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]`; the original order is preserved.
Searching for `40` demonstrates linear search's best case with one step.

For the unchanged sample graph, BFS from `A` visits `A -> B -> C -> D -> E`,
and DFS visits `A -> B -> D -> C -> E`. Both use 15 steps under the documented
counting rule. Loading samples does not run algorithms: use Searching Operations
and Graph Operations first, then option 7 to compare their actual measurements.

## Using IntelliJ IDEA or VS Code

For IntelliJ IDEA, open this project folder, select an installed JDK as the
project SDK, and mark `src` as the Sources Root if it is not detected. Run
`Main.main()` in `src/Main.java`. The terminal commands above also work.

For VS Code, open this project folder, enable Java language support if needed,
and open `src/Main.java`. Run its `main` method or use the compile and run
commands in the integrated terminal. No Maven or Gradle project is required.

## Data and Error Handling

- Array, stack, and queue start with capacity 10 and double manually when full.
- All integer values, including negative values, zero, and repeated values,
  are accepted. Array and linked-list deletion remove the first match only.
- Array and linked-list search return a zero-based index, or `-1` when missing.
- Binary-search indices refer to the sorted copy. With duplicates, binary
  search may return any matching midpoint, while linear search returns the
  first match in original order.
- Vertex names are trimmed, nonempty, and case-sensitive. `A` and `a` are
  different vertices. Vertices must exist before an edge is added.
- Edges are undirected. Duplicate vertices and duplicate edges, including the
  reverse direction of an existing edge, are rejected. A self-loop is accepted
  once and stored as one adjacency entry.
- Graph display follows vertex insertion order. Traversals consider neighbors
  in edge insertion order, and visit only the starting vertex's connected
  component. A vertex is visited at most once despite cycles or self-loops.
- Invalid operations leave the data and previous successful results intact.
- Text at numeric prompts, decimal numbers, and out-of-range integers are
  rejected with a retry. Blank vertex names are also retried.

## Performance Measurement

Execution times are measured with `System.nanoTime()` and displayed in
nanoseconds. No sample timing values are hard-coded.

One search step means inspecting one element: an array position for linear
search or a midpoint for binary search. It does not count loop conditions or
every individual Java operator. An empty input has zero search steps.

One graph step means either visiting a vertex or examining one adjacency
entry. Both BFS and DFS use this definition. In a component with no self-loops,
the count is `visited vertices + 2 * edges in that component`, since an
undirected edge appears in both endpoints' lists. For the five-vertex example
below, both traversals have 15 steps, although their orders and times can differ.

Search timers cover the search loop. Binary-search copying and sorting occur
before its timer. Graph timers cover traversal, including working collections.
Result formatting, console output, and stored search snapshots are outside the
timers. Every binary-search invocation pays for copying and sorting, so the
complete operation includes that preparation cost in addition to its search.

Small single-run timings are illustrative and can vary with JVM warm-up,
measurement overhead, and system load; fewer steps need not mean a lower time
in a single run. Use the same data and target to compare searches, or the same
graph and starting vertex to compare traversals. Search and graph steps count
different kinds of work and should not be compared directly.

Options 7 and 8 show `Not tested yet` for algorithms not run. Latest results are
retained after data changes and describe their original runs. Search results
retain a defensive copy of their input, and traversal results retain the start
vertex and order. Option 8 shows this context alongside current system data.

## Algorithm Complexity

| Operation | Time Complexity |
|---|---|
| Array append | O(1) amortized; O(n) when resizing |
| Array search / first-match deletion | O(n) |
| Linear Search | Best O(1); average and worst O(n) |
| Binary Search loop, after sorting | Best O(1); average and worst O(log n) |
| Stack push | O(1) amortized; O(n) when resizing |
| Stack pop / peek | O(1) |
| Queue enqueue | O(1) amortized; O(n) when resizing |
| Queue dequeue / peek | O(1) |
| Linked List insert at end / search / delete | O(n) |
| BFS | O(V + E) |
| DFS | O(V + E) |

Here `n` is the number of stored elements, `V` is the number of vertices, and
`E` is the number of edges. Graph traversal visits the reachable component;
`O(V + E)` is its bound over the whole graph. Hash-based membership checks are
assumed to take constant time on average. Displaying a structure takes time
proportional to the data displayed.

Binary search uses O(n) additional space for the sorted copy and result
snapshot. Linear search stores an O(n) result snapshot after the timed loop.
Graph representation uses O(V + E) space. BFS uses O(V) working space. This
iterative DFS can have repeated pending vertices before their first visit, so
its working-space bound is O(V + E).

## Demonstration Example

1. In Array Operations, insert `40`, `10`, `30`, `20`, and `50` in that order.
2. In Searching Operations, compare both searches for `30`. Linear search uses
   `[40, 10, 30, 20, 50]`, and binary search uses `[10, 20, 30, 40, 50]`.
3. Return to Array Operations and display to confirm the order is unchanged.
4. Demonstrate stack LIFO by pushing `10`, `20`, `30`, then popping `30`.
5. Demonstrate queue FIFO by enqueueing `10`, `20`, `30`, then dequeuing `10`.
6. Insert `10`, `20`, `30` into the linked list, search for `20`, then delete
   its head, middle, and last values.
7. Add graph vertices `A`, `B`, `C`, `D`, `E`, then edges `A-B`, `A-C`, `B-D`,
   `C-D`, and `D-E` in that order.
8. BFS from `A` visits `A -> B -> C -> D -> E`. DFS from `A` visits
   `A -> B -> D -> C -> E`.
9. Select Performance Comparison and Display All Results from the main menu.
10. Enter `abc`, `0`, and `15` at the main-menu prompt to demonstrate validation,
    then choose `9` to exit.

## Testing

Local verification passed using JDK 23.0.2:

- 60,486 Java assertions across the structures, searches, graph, and input validator.
- 34 scripted console sessions with 351 assertions, including source-structure checks
  and eight sample-data sessions.
- BFS and DFS completed a 12,000-vertex path without recursion errors.
- Displayed performance rows matched the latest measured step counts and times.

Verification covers the required sample operations and additional edge cases:

- Array growth, first-match deletion, missing values, and defensive copies.
- Stack empty pop/peek, LIFO order, capacity growth, and reuse after draining.
- Queue empty dequeue/peek, FIFO order, wraparound, growth while wrapped, and
  repeated fill/drain cycles.
- Linked-list empty, head, middle, last, only-node, missing, and duplicate deletion.
- Searches on existing, missing, first, last, repeated, negative, and extreme
  integer values; empty inputs; exact step counts; original-order preservation.
- Graph display, duplicate vertices/edges, reverse edges, missing vertices,
  invalid starts, cycles, self-loops, isolated/disconnected vertices, and a long
  path; expected BFS/DFS orders and actual measured traversal results.
- Console coverage of every menu action, invalid numbers and menu ranges,
  blank names, data retention, empty/populated summaries, latest results, and
  clean exit or end-of-input.
- Sample loading into empty structures, repeated loading without duplicates,
  preservation of existing data, reloading after draining, and the documented
  sample operations and algorithm results.

Verification tools run separately from the application. They add no runtime
dependencies or extra application entry points.
