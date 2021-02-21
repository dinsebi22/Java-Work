package Data_Strutures.GRAPHS;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,7);
        graph.addEdge(1,8);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,6);
        graph.addEdge(1,3);
        graph.addEdge(2,5);
        graph.addEdge(2,5);
        graph.addEdge(5,7);
        graph.addEdge(5,8);
        graph.addEdge(8,6);


        graph.printAdjMatrix();

        System.out.println(graph.DFS(2,6));


        graph.printAdjList();

        System.out.println(graph.BFS(0,5));

    }

}
