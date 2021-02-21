package Data_Strutures.GRAPHS;

public class Vertex {

    private int uniqueLabel;

    public Vertex(int uniqueLabel){
        this.uniqueLabel = uniqueLabel;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Vertex)){
            return false;
        }

        Vertex objVertex = (Vertex) obj;
        return objVertex.uniqueLabel == uniqueLabel;
    }

    @Override
    public int hashCode(){
        return uniqueLabel;
    }

    public int getUniqueLabel(){
        return uniqueLabel;
    }

    public void setUniqueLabel(int uniqueLabel){
        this.uniqueLabel = uniqueLabel;
    }

    @Override
    public String toString(){
        return uniqueLabel+"";
    }
}
