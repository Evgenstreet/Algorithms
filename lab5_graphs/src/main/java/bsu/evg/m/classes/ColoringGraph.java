package bsu.evg.m.classes;

public class ColoringGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 0);
        graph.addEdge(2, 0);
        graph.addEdge(1, 2);
        graph.addEdge(4, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println("Graph greedy coloring" + graph);
        graph.greedyColoring(graph);
        System.out.println("Graph DSATUR coloring" + graph);
        graph.dsaturImpl(graph);

        Graph g2 = new Graph();
        g2.generateRandomGraph(g2);
        System.out.println("Graph greedy coloring"+g2);
        g2.greedyColoring(g2);
        System.out.println("Graph DSATUR coloring"+g2);
        g2.dsaturImpl(g2);
    }


}
