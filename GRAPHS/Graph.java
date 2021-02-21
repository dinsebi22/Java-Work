package Data_Strutures.GRAPHS;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    Set<Vertex> vertices;
    Set<Edge> edges;
    private Map<Vertex , Set<Edge>> adjList;

    public Graph() {
        this.vertices = new HashSet<>();
        this.edges = new HashSet<>();
        this.adjList = new HashMap<>();
    }

    public boolean addVertex(int label){
        return this.vertices.add(new Vertex(label));
    }

    public boolean addVertex(Vertex v){
        return this.vertices.add(v);
    }

    public boolean addVertices(Collection<Vertex> vertices){
        return this.vertices.addAll(vertices);
    }

    public boolean removeVertex(int label){
        return this.vertices.remove(new Vertex(label));
    }

    public boolean removeVertex(Vertex v){
        return this.vertices.remove(v);
    }

    public boolean addEdge(Edge e){
        // Returns false if the edge is present
        if(!edges.add(e)){
            return false;
        }

        Vertex v1 = e.getV1();
        Vertex v2 = e.getV2();

        adjList.putIfAbsent(v1, new HashSet<>());
        adjList.putIfAbsent(v2, new HashSet<>());

        adjList.get(v1).add(e);
        adjList.get(v2).add(e);

        return true;
    }

    public boolean addEdge(int vertexLabel1, int vertexLabel2){
        return this.addEdge(new Edge(
                new Vertex(vertexLabel1),
                new Vertex(vertexLabel2)
        ));
    }

    public boolean removeEdge(Edge e){
        // If the edge is not present false is returned which is Negated ==> true
        if(!edges.remove(e)){
            return false;
        }

        Set<Edge> edgesOfVertex1 = adjList.get(e.getV1());
        Set<Edge> edgesOfVertex2 = adjList.get(e.getV2());

        if(edgesOfVertex1 != null){
            edgesOfVertex1.remove(e);
        }
        if(edgesOfVertex2 != null){
            edgesOfVertex2.remove(e);
        }
        return true;
    }

    public boolean removeEdge(int vertexLabel1, int vertexLabel2){
        return this.removeEdge(new Edge(
                new Vertex(vertexLabel1),
                new Vertex(vertexLabel2)
        ));
    }

    public Set<Vertex> getAdjVertices(Vertex v){
        return adjList.get(v)
                .stream()
                .map(e -> e.getV1().equals(v) ? e.getV2() : e.getV1())
                .collect(Collectors.toSet());
    }

    public Set<Vertex> getVertices(){
        return Collections.unmodifiableSet(vertices);
    }

    public Set<Edge> getEdges(){
        return Collections.unmodifiableSet(edges);
    }

    public Map<Vertex, Set<Edge>> getAdjList(){
        return Collections.unmodifiableMap(adjList);
    }


    public boolean DFS(int source , int destination){

        Vertex sourceVertex = new Vertex(source);
        Vertex destinationVertex = new Vertex(destination);
        HashSet<Vertex> visited = new HashSet<>();
        List<Vertex> resultList = new ArrayList<>();
        resultList.add(sourceVertex);
        return this.hasPathDFS(sourceVertex, destinationVertex , visited, resultList);
    }

    private boolean hasPathDFS(Vertex source, Vertex destination,
                               HashSet<Vertex> visited, List<Vertex> resultList){
        if(visited.contains(source)){
            return false;
        }
        visited.add(source);
        if(source.equals(destination)){
            return true;
        }
        for(Edge child : adjList.get(source)){
            if(hasPathDFS(child.getV2() , destination , visited, resultList)){
                resultList.add(1, child.getV2());
                System.out.println(resultList);
                return true;
            }
        }
        return false;
    }

    public boolean BFS(int source , int destination){
        Vertex sourceVertex = new Vertex(source);
        Vertex destinationVertex = new Vertex(destination);

        return this.hasPathBFS(sourceVertex, destinationVertex );

    }

    private boolean hasPathBFS(Vertex sourceVertex, Vertex destination ){

        HashSet<Vertex> visited = new HashSet<>();
        Stack<Vertex> nextToVisit = new Stack<>();
        nextToVisit.push(sourceVertex);

        while(!nextToVisit.isEmpty()){
            Vertex v = nextToVisit.pop();
            if(v.equals(destination)){
                return true;
            }

            if(visited.contains(v)){
                continue;
            }
            visited.add(v);

            for (Edge edge: adjList.get(v)) {
                nextToVisit.add(edge.getV2());
            }
        }
        return false;
    }


    public void printAdjList(){
        Map<Vertex, Set<Edge>> adjList = this.getAdjList();
        Set<Vertex> vertexList =  adjList.keySet();

        for (Vertex v : vertexList) {
            String val = "";
            for(Edge e : adjList.get(v)){
                val = v+ "->"+ (e.getV1().equals(v) ? e.getV2() : e.getV1());
                System.out.println(val);
            }
            System.out.println("----------------------------------------------");


        }
    }

    public void printAdjMatrix(){
        int verticesSize = this.vertices.size();;

        int[][] matrix = new int[verticesSize][verticesSize];

        for(Set<Edge> edges : adjList.values() ){
            for (Edge edge: edges) {
                matrix[edge.getV1().getUniqueLabel()][edge.getV2().getUniqueLabel()] = 1;
            }
        }
        printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
