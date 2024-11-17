import java.io.IOException;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        EdgeList graph = new EdgeList();
        graph.readFromFile("Edge.txt");

        // (a) In danh sách cạnh
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
