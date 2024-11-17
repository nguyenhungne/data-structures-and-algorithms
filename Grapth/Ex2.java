import java.io.IOException;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        AdjacencyList graph = new AdjacencyList(5);
        try {
                graph.readFromFile("AL.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

        // (a) In danh sách kề
        graph.printGraph();

        // (b) Đếm số đỉnh
        System.out.println("Number of vertices: " + graph.countVertices());

        // (c) Đếm số cạnh
        System.out.println("Number of edges: " + graph.countEdges());

        // (d) Liệt kê các đỉnh kề của đỉnh 3
        System.out.println("Neighbors of vertex 3: " + graph.getNeighbors(3));

        // (e) Kiểm tra cạnh (3, 4)
        System.out.println("Edge (3, 4) exists: " + graph.hasEdge(3, 4));
    }
}
