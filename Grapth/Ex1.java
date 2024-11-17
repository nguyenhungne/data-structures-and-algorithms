import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix();
        
        // Test all functionalities
        System.out.println("(a) Reading and printing the graph:");
        try {
            graph.readFromFile("AM.txt");
            graph.printGraph();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n(b) Number of vertices: " + graph.countVertices());
        
        System.out.println("\n(c) Number of edges: " + graph.countEdges());
        
        System.out.println("\n(d) Testing neighbor enumeration:");
        System.out.println("Neighbors of vertex 0: " + graph.getNeighbors(0));
        
        System.out.println("\n(e) Testing edge existence:");
        System.out.println("Edge between 0 and 1: " + graph.hasEdge(0, 1));
        System.out.println("Edge between 0 and 3: " + graph.hasEdge(0, 3));
    }
}
