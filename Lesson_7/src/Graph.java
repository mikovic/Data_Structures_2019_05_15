import java.util.*;

public class Graph {

    private final List<Vertex> vertexList = new ArrayList<>();
    private boolean[][] adjMat;
    private double[][] adjDist;

    private int size;

    public Graph(int maxVertexCount) {
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
        this.adjDist = new double[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * The same as {@link #addEdge(String, String)}
     *
     * @param start
     * @param second
     * @param others
     */
    public void addEdges(String start, String second, String... others) {
        addEdge(start, second);
        for (String another : others) {
            addEdge(start, another);
        }
    }

    public void addEdge(String start, String finish) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. breadth-first search, BFS
     *
     * @param startLabel
     */
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(vertex, queue);
            } else {
                queue.remove();
            }
        }

        resetVertexState();

    }

    /**
     * англ. Depth-first search, DFS
     *
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(vertex, stack);

        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(vertex, stack);
            } else {
                stack.pop();
            }
        }

        resetVertexState();

    }

    private void resetVertexState() {
        for (int i = 0; i < size; i++) {
            vertexList.get(i).resetState();
        }
    }


    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int vertexIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < size; i++) {
            if (adjMat[vertexIndex][i] && !vertexList.get(i).wasVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Vertex vertex, Stack<Vertex> stack) {

        stack.push(vertex);
        vertex.setVisited();
    }

    private void visitVertex(Vertex vertex, Queue<Vertex> queue) {
        displayVertex(vertex);
        queue.add(vertex);
        vertex.setVisited();
    }

    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }


    public void addEdge(String start, String finish, double distance) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
        adjDist[startIndex][finishIndex] = distance;
        adjDist[finishIndex][startIndex] = distance;

    }



    public void bfsDistance(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                int vertexIndex = indexOf(vertex.getLabel());
                Vertex vertexPrevios = queue.peek();
                startIndex = indexOf(vertexPrevios.getLabel());
                double edge = adjDist[startIndex][vertexIndex];
                double distance = vertexPrevios.getMinDistance() + edge;
                vertex.setMintDistance(distance);
                visitVertex(vertex, queue);
            } else {
                Vertex vertex1 = queue.remove();
                if(vertex1.getLabel().equals(finishLabel)){
                    System.out.println("Минимальное расстояние: "+vertex1.getMinDistance());
                    break;
                }
            }
        }

        resetVertexState();

    }
}
