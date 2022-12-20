package third_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class GraphWithNoDirection {
    private int numVertices;
    private LinkedList<Edge>[] adjacencyLists;


    public GraphWithNoDirection(int vertices)
    {
        numVertices = vertices;
        adjacencyLists = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++)
            adjacencyLists[i] = new LinkedList();
    }


    public void addEdge(Edge edge)
    {
        adjacencyLists[edge.getSource()].add(edge);
        adjacencyLists[edge.getDest()].add(edge);
    }


    public void removeEdge(Edge edge){
        int i = 0;
        for (Edge e : adjacencyLists[edge.getSource()]){
            if (e.getDest() == edge.getDest()){
                adjacencyLists[edge.getSource()].remove(i);
                break;
            }
            else i++;
        }
        i = 0;
        for (Edge e : adjacencyLists[edge.getDest()]){
            if (e.getSource() == edge.getSource()){
                adjacencyLists[edge.getDest()].remove(i);
                break;
            }
            else i++;
        }
    }


    public void kruskalMST(){
        GraphWithNoDirection graph = new GraphWithNoDirection(numVertices);
        graph.copy(this);
        ArrayList<Edge> listOfEdges = sortByWeight(graph);
        DisjointSet nodeSet = new DisjointSet(numVertices);
        ArrayList<Edge> mstEdges = new ArrayList<>();
        for(int i = 0; i<listOfEdges.size() && mstEdges.size()<(numVertices-1);i++){
            Edge currentEdge = listOfEdges.get(i);
            int root1 = nodeSet.find(currentEdge.getSource());
            int root2 = nodeSet.find(currentEdge.getDest());
            if(root1!=root2){
                mstEdges.add(currentEdge);
                nodeSet.union(root1,root2);
            }
        }
        int totalWeight = 0;
        for(Edge e : mstEdges){
            totalWeight+=e.getWeight();
        }
        System.out.println("Minimal spanning tree: "+ mstEdges + "\tWeight: " + totalWeight);
    }
    public ArrayList<Edge> sortByWeight(GraphWithNoDirection graph) {
        ArrayList<Edge> expected = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            expected.addAll(graph.adjacencyLists[i]);
            while (graph.adjacencyLists[i].size() > 0) {
                graph.removeEdge(graph.adjacencyLists[i].get(0));
            }
        }
        Collections.sort(expected);
        return expected;
    }


    public void printGraph(){
        System.out.println("\n--------");
        for(int i = 0; i < numVertices; i++){
            System.out.println(i+": " + adjacencyLists[i].toString());
        }
    }


    public void copy(GraphWithNoDirection g){
        this.numVertices = g.numVertices;
        for (int i = 0; i < numVertices;i++){
            for (Edge j : g.adjacencyLists[i]){
                this.adjacencyLists[i].add(j);
            }
        }
    }
}

    class DisjointSet{
        private int[] set;

        public int[] getSet(){
            return set;
        }


        public DisjointSet(int numElements) {
            set = new int [numElements];
            Arrays.fill(set, -1);
        }


        public void union(int root1, int root2) {
            if(set[root2] < set[root1]){
                set[root1] = root2;
            }
            else {
                if(set[root1] == set[root2]){
                    set[root1]--;
                }
                set[root2] = root1;
            }
        }


        public int find(int x) {
            if(set[x] < 0){
                return x;
            }
            int next = x;
            while(set[next] > 0){
                next=set[next];
            }
            return next;
        }
    }
