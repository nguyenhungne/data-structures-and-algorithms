import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrix {
    private int[][] adj;
    private int NUMBER_OF_VERTICES;

    public AdjacencyMatrix() {
        this.NUMBER_OF_VERTICES = 0;
        this.adj = new int[0][0];
    }

    public AdjacencyMatrix(int numberOfVertices) {
        this.NUMBER_OF_VERTICES = numberOfVertices;
        this.adj = new int[numberOfVertices][numberOfVertices];
    }

    public void addEdge(int vertexSource, int vertexDestination, int weight) {
        try {
            adj[vertexSource][vertexDestination] = weight;
            adj[vertexDestination][vertexSource] = weight;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Vertex does not exist");
        }
    }

    public void printGraph() {
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");

            for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
                if (adj[x][i] != 0 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void DFS_recur(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if (adj[v][i] != 0 && visited[i] == false) {
                DFS_recur(i, visited);
            }
        }
    }

    public void DFS(int s) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        DFS_recur(s, visited);
    }

    public int countVertices() {
        return NUMBER_OF_VERTICES;
    }

    public int countEdges() {
        int count = 0;
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                count += adj[i][j];
            }
        }
        return count / 2;
    }

    public List<Integer> getNeighbors(int u) {
        List<Integer> neighbors = new ArrayList<>();
        for (int v = 0; v < NUMBER_OF_VERTICES; v++) {
            if (adj[u][v] == 1) {
                neighbors.add(v);
            }
        }
        return neighbors;
    }

    public boolean hasEdge(int u, int v) {
        return adj[u][v] == 1;
    }

    public void readFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        NUMBER_OF_VERTICES = Integer.parseInt(br.readLine());
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                adj[i][j] = Integer.parseInt(line[j]);
            }
        }
        br.close();
    }

    public AdjacencyList convertToAL() {
        AdjacencyList adjList = new AdjacencyList(NUMBER_OF_VERTICES);

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                if (adj[i][j] == 1) {
                    adjList.addEdge(i, j);
                }
            }
        }

        return adjList;
    }

    public void DFSIterative(int start) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        System.out.print("DFS Traversal (Non-Recursive): ");
        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
            }

            for (int v = NUMBER_OF_VERTICES - 1; v >= 0; v--) {
                if (adj[u][v] == 1 && !visited[v]) {
                    stack.push(v);
                }
            }
        }
        System.out.println();
    }

    public boolean IsReachable(int u, int v) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        Queue<Integer> queue = new LinkedList<>();

        visited[u] = true;
        queue.offer(u);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == v) {
                return true; // Tìm thấy đỉnh v
            }

            for (int neighbor = 0; neighbor < NUMBER_OF_VERTICES; neighbor++) {
                if (adj[current][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(5);
        adjacencyMatrix.addEdge(0, 1, 1);
        adjacencyMatrix.addEdge(0, 2, 1);
        adjacencyMatrix.addEdge(1, 2, 1);
        adjacencyMatrix.addEdge(3, 4, 1);
        adjacencyMatrix.addEdge(4, 0, 1);
        // adjacencyMatrix.printGraph();
        adjacencyMatrix.BFS(0);
        adjacencyMatrix.DFS(0);
    }

}
