import fifth_task.GaleShapleyAlgorithm;
import first_task.Graph;
import fourth_task.HungarianAlgorithm;
import second_task.FloydAlgorithm;
import third_task.Edge;
import third_task.GraphWithNoDirection;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //first task
        Graph graph = new Graph(6);
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 4);
        ArrayList<ArrayList<Integer>> a = graph.getConnectedCompenents();
        for(ArrayList<Integer> i : a) {
            System.out.println(i.toString());
        }
        graph.isGraphEuler();
        graph.findEulerCycle();

        Graph graph2 = new Graph(5);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 4);
        graph2.addEdge(4, 0);
        graph2.printGraph();
        System.out.println(graph2.findEulerCycle().toString());
        graph2.printGraph();

        Graph graph3 = new Graph(5);
        graph3.addEdge(0,2);
        graph3.addEdge(1,3);
        graph3.addEdge(2,4);
        graph3.addEdge(2,3);
        graph3.addEdge(3,2);
        graph3.printGraph();
        System.out.println(graph3.isBiPartitioned() + " "+ graph3.findPartition()[0].toString()+ " "+ graph3.findPartition()[1].toString());

        //second task
        FloydAlgorithm Floyd = new FloydAlgorithm();
        FloydAlgorithm fl = new FloydAlgorithm(Floyd.initRandomAdjacencyMatrix(5));
        fl.findShortestPath();
        System.out.println(fl.findVertexWithShortestPath());

        //third task
        GraphWithNoDirection ndg = new GraphWithNoDirection(5);
        ndg.addEdge(new Edge(0,2,4));
        ndg.addEdge(new Edge(1,1,6));
        ndg.addEdge(new Edge(2, 3,4));
        ndg.addEdge(new Edge(3,2,3));
        ndg.addEdge(new Edge(3,4,9));
        ndg.printGraph();
        ndg.kruskalMST();
        ndg.printGraph();

        //fourth task
        int[][] array = {{1,3,7,4,8},{4,8,2,4,9},{5,2,7,3,6},{5,4,2,8,5},{7,2,4,6,8}};
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm(array);
        Arrays.stream(array).forEach(i -> System.out.println(Arrays.toString(i)));
        hungarianAlgorithm.print(hungarianAlgorithm.findOptimalAssigment());

        //fifth task
        int[][] array1 = {{1,0,2,3},{2,3,1,0},{2,1,3,0},{0,3,2,1}};
        int[][] array2 = {{2,3,1,0},{2,1,0,3},{0,1,2,3},{3,2,1,0}};
        new GaleShapleyAlgorithm().moreEffectiveEmployeeForTask(array1, array2);
    }
}