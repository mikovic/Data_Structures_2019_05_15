import java.util.Objects;

public class Vertex {

    private final String label;
    private boolean visited;
    private double minDistance = 0;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    public void setVisited() {
        this.visited = true;
    }

    public boolean wasVisited() {
        return visited;
    }

    public void resetState() {
        visited = false;
    }


    public double getMinDistance() {
        return minDistance;
    }

    public boolean setMintDistance(double distance) {
        boolean flag = false;
       if (minDistance == 0 ){
           minDistance = distance;
           flag = true;

       }else {
           if(minDistance > distance){
               minDistance = distance;
               flag = true;
           }
       }
       return flag;
    }
}
