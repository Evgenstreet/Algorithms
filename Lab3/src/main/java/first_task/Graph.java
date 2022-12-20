package first_task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int countOfVertices;
    private LinkedList<Integer>[] adjacencyLists;

    
    public Graph(int vertices)
    {
        countOfVertices = vertices;
        adjacencyLists = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++)
            adjacencyLists[i] = new LinkedList();
    }
    

    public void addEdge(int src, int dest)
    {
        adjacencyLists[src].add(dest);
        adjacencyLists[dest].add(src);
    }
    
    
    public void removeEdge(int src, int dest){
        adjacencyLists[src].remove((Integer) dest);
        adjacencyLists[dest].remove((Integer) src);
    }
    
    
    public ArrayList<Integer> doDFS(int vertex, boolean[] visited){
        ArrayList<Integer> component = new ArrayList<>();
        DFS(vertex, visited, component);
        return component;
    }
    
    
    private ArrayList<Integer> DFS(int vertex, boolean[] visited, ArrayList<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        for (int adj : adjacencyLists[vertex]) {
            if (!visited[adj])
                DFS(adj, visited, component);
        }
        return component;
    }
    
    
    public  ArrayList<ArrayList<Integer>> getConnectedCompenents(){
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[countOfVertices];
        for (int i = 0; i< countOfVertices; i++){
            if(!visited[i]){
                components.add(doDFS(i, visited));
            }
        }
        return components;
    }
    
    
    public int countOddVertices()
    {
        int count = 0;
        for (List<Integer> list : adjacencyLists)
        {
            if ((list.size() & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    
    public boolean isGraphEuler(){
        return (countOddVertices() == 0 || countOddVertices() == 2) && getConnectedCompenents().size() == 1;
    }
    
    
    public boolean hasEulerCycle(){
        return countOddVertices() == 0 && getConnectedCompenents().size() == 1;
    }
    
    
    public int countAllEdges(){
        int count = 0;
        for(List<Integer> i : adjacencyLists){
            count+=i.size();
        }
        return count;
    }


    public int countEdges(int vertex){
        return adjacencyLists[vertex].size();
    }
    public ArrayList<Integer> findEulerCycle(){
        if(hasEulerCycle()){
            ArrayList<Integer> cycle = new ArrayList<>();
            ArrayList<Integer> tempCycle = new ArrayList<>();
            int currentVertex = (int)(Math.random() * (countOfVertices-1));
            tempCycle.add(currentVertex);
            Graph graph = new Graph(this.countOfVertices);
            graph.copy(this);
            while(graph.countAllEdges()!=0){
                int nextVertex;
                if(graph.countEdges(currentVertex)!=0){
                    nextVertex = graph.adjacencyLists[currentVertex].get(0);
                    graph.removeEdge(currentVertex,nextVertex);
                    currentVertex = nextVertex;
                    tempCycle.add(currentVertex);
                }else{
                    int i = tempCycle.size()-1;
                    while(graph.countEdges(tempCycle.get(i))==0){
                        cycle.add(tempCycle.get(i));
                        tempCycle.remove(i);
                        i--;
                    }
                    currentVertex = tempCycle.get(i);
                }
            }
            if(tempCycle.size()!=0){
                while(tempCycle.size()!=0){
                    cycle.add(tempCycle.get(tempCycle.size()-1));
                    tempCycle.remove(tempCycle.size()-1);
                }
            }
            return cycle;
        }
        System.out.println("No euler cycles!");
        return new ArrayList<>(0);
    }
    
    
    public boolean isBiPartitioned(){
        int[] visited = new int[countOfVertices];
        return isBeingParticiedRec(0, visited, 1);
    }
    
    
    public boolean isBeingParticiedRec(int vertex, int[] visited, int currentNum){
        visited[vertex] = currentNum;
        for (int adj : adjacencyLists[vertex]) {
            if (visited[adj] == 0)
                isBeingParticiedRec(adj, visited, (currentNum == 1) ? 2 : 1);
            else if (visited[adj] == currentNum)
                return false;
        }
        return true;
    }
    
    
    public ArrayList<Integer>[] findPartition(){
        if (this.isBiPartitioned()){
            int[] visited = new int[countOfVertices];
            isBeingParticiedRec(0, visited, 1);
            ArrayList<Integer>[] fractional = new ArrayList[2];
            fractional[0] = new ArrayList<>();
            fractional[1] = new ArrayList<>();
            for (int i = 0; i<visited.length; i++){
                if(visited[i]==1){
                    fractional[0].add(i);
                }else{
                    fractional[1].add(i);
                }
            }
            return fractional;
        }else{
            return new ArrayList[2];
        }
    }
    
    
    public void printGraph(){
        System.out.println("\n--------");
        for(int i = 0; i < countOfVertices; i++){
            System.out.println(i+": " + adjacencyLists[i].toString());
        }
    }
    
    
    public void copy(Graph graph){
        this.countOfVertices = graph.countOfVertices;
        for (int i = 0; i < countOfVertices;i++){
            for (int j : graph.adjacencyLists[i]){
                this.adjacencyLists[i].add(j);
            }
        }
    }
}
