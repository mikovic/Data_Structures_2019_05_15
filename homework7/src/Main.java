public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("K");
        graph.addVertex("F");
        graph.addEdge("A", "B", 20);
        graph.addEdge("B", "C", 20);
        graph.addEdge("C", "D", 10);
        graph.addEdge("A", "E", 15);
        graph.addEdge("E", "D", 30);
        graph.addEdge("A", "K", 15);
        graph.addEdge("K", "F", 15);
        graph.addEdge("F", "D", 17);

      graph.bfsDistance("A", "D");



    }
}
