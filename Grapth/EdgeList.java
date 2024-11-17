import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class EdgeList {
    private Vector<IntegerTriple> edges;
    private int numVertices;

    public EdgeList() {
        edges = new Vector<>();
    }

    public void readFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        numVertices = Integer.parseInt(br.readLine()); // Đọc số đỉnh
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            int w = Integer.parseInt(parts[0]); // Trọng số
            int u = Integer.parseInt(parts[1]); // Đỉnh nguồn
            int v = Integer.parseInt(parts[2]); // Đỉnh đích
            edges.add(new IntegerTriple(w, u, v));
        }

        br.close();
    }

    public void addEdge(Integer weight, Integer source, Integer destination) {
        edges.add(new IntegerTriple(weight, source, destination));
    }

    public void printGraph() {
        for (int i = 0; i < edges.size(); i++) {
            System.out.println(edges.get(i));
        }
    }

    public int countVertices() {
        return numVertices;
    }

    public int countEdges() {
        return edges.size();
    }

    public List<Integer> getNeighbors(int u) {
        List<Integer> neighbors = new ArrayList<>();
        for (IntegerTriple edge : edges) {
            if (edge.getSource() == u) {
                neighbors.add(edge.getDestination());
            } else if (edge.getDestination() == u) {
                neighbors.add(edge.getSource());
            }
        }
        return neighbors;
    }

    public boolean hasEdge(int u, int v) {
        for (IntegerTriple edge : edges) {
            if ((edge.getSource() == u && edge.getDestination() == v)
                    || (edge.getSource() == v && edge.getDestination() == u)) {
                return true;
            }
        }
        return false;
    }

}
