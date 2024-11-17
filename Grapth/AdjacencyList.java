import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AdjacencyList {
    private int V; // No. of vertices
    ArrayList<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();

    public AdjacencyList(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; ++i) {
            adj.add(new LinkedList<>());
        }
    }

    public void readFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        V = Integer.parseInt(br.readLine()); // Đọc số đỉnh
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(":");
            int vertex = Integer.parseInt(parts[0].trim());
            String[] neighbors = parts[1].trim().split(" ");
            for (String neighbor : neighbors) {
                adj.get(vertex).add(Integer.parseInt(neighbor));
            }
        }

        br.close();
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            System.out.print("head");
            for (Integer v : adj.get(i)) {
                System.out.print("->" + v);
            }
            System.out.println();
        }
    }

    public int countVertices() {
        return V;
    }

    public int countEdges() {
        int count = 0;
        for (LinkedList<Integer> neighbors : adj) {
            count += neighbors.size();
        }
        return count / 2;
    }

    public List<Integer> getNeighbors(int u) {
        return adj.get(u);
    }

    public boolean hasEdge(int u, int v) {
        return adj.get(u).contains(v);
    }
    

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(5);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(3, 4);
        adjacencyList.addEdge(4, 0);
        adjacencyList.printGraph();
    }
}
