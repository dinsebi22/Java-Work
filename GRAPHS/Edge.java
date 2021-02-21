package Data_Strutures.GRAPHS;

public class Edge {

    private static final int DEFAULT_WEIGHT = 1;

    private Vertex v1;
    private Vertex v2;
    private int weight;

    public Edge(Vertex v1, Vertex v2) {
        this(v1, v2, DEFAULT_WEIGHT);
    }

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Edge)){
            return false;
        }

        Edge edgeObj = (Edge) obj;
        return edgeObj.v1.equals(v1) &&
                edgeObj.v2.equals(v2) &&
                edgeObj.weight == weight;
    }

    @Override
    public int hashCode(){
        int result = v1.hashCode();
        result = 31 * result + v2.hashCode();
        result = 31 * result + weight;
        return result;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" + v1 +
                "<->" + v2 +'}' ;
    }
}
