package third_task;

public class Edge implements Comparable<Edge>{
    private int source;
    private int dest;
    private int weight;

    public Edge(int source, int dest, int weight){
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int src) {
        this.source = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source: " + source +
                ", dest: " + dest +
                ", weight: " + weight +
                '}';
    }
    @Override
    public int compareTo(Edge otherEdge){
        return this.getWeight() - otherEdge.getWeight();
    }
}
