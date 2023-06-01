package bsu.evg.m.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Graph {
        private int vertexCount;
        private ArrayList<Integer>[] adjancentList;
        public Graph(){}
        public Graph(int v) {
            vertexCount = v;
            adjancentList = new ArrayList[v];
            for (int i = 0; i < v; i++){
                adjancentList[i] = new ArrayList<>();
            }
        }
        public void addEdge(int first, int second) {
            adjancentList[first].add(second);
            adjancentList[second].add(first);
        }
        public void greedyColoring(Graph graph) {
            int[] result = new int[graph.vertexCount];
            Arrays.fill(result, -1);
            boolean[] colorAvailable = new boolean[graph.vertexCount];
            Arrays.fill(colorAvailable, true);
            for (int i = 0; i < graph.vertexCount; i++) {
                for (Integer vertex : graph.adjancentList[i]) {
                    if (result[vertex]!=-1) {
                        colorAvailable[result[vertex]] = false;
                    }
                }
                int j;
                for (j = 0; j < colorAvailable.length; j++) {
                    if(colorAvailable[j]) break;
                }
                result[i] = j;
                Arrays.fill(colorAvailable, true);
            }
            for (int i = 1; i <= graph.vertexCount; i++){
                System.out.println("Vertex " + i + " --->  Color: " + result[i-1]);
            }
        }

        public void generateRandomGraph(Graph graph) {
            int vertex = 15;
            graph.vertexCount = vertex;
            graph.adjancentList = new ArrayList[graph.vertexCount];
            for (int i = 0; i < graph.vertexCount; i++){
                adjancentList[i] = new ArrayList<>();
            }
            Random random = new Random();
            for (int i = 0; i < vertexCount; i++) {
                int firstRand = random.nextInt(graph.vertexCount);
                int secondRand = random.nextInt(graph.vertexCount);
                if ((firstRand == secondRand)
                        || graph.adjancentList[firstRand].contains(secondRand)) {
                    i = i - 1;
                    continue;
                }
                addEdge(firstRand, secondRand);
            }
        }

        public void dsaturImpl(Graph graph) {
            int[] saturationDegrees = new int[graph.vertexCount];
            Arrays.fill(saturationDegrees, 0);
            List<Integer> fillingNodes = new ArrayList<>();
            int[] result = new int[graph.vertexCount];
            Arrays.fill(result, -1);
            boolean[] colorAvailable = new boolean[graph.vertexCount];
            Arrays.fill(colorAvailable, true);
            while (fillingNodes.size() < graph.vertexCount) {
                int maxIndex = getMaxSaturation(saturationDegrees);
                for (Integer vertex : graph.adjancentList[maxIndex]) {
                    if (result[vertex]!=-1) {
                        colorAvailable[result[vertex]] = false;
                    }
                }
                int b;
                for (b = 0; b < colorAvailable.length; b++) {
                    if(colorAvailable[b]) break;
                }
                result[maxIndex] = b;
                Arrays.fill(colorAvailable, true);
                fillingNodes.add(maxIndex);
                saturationDegrees[maxIndex] = -1;
                for (Integer vertex : graph.adjancentList[maxIndex]) {
                    if (saturationDegrees[vertex]!=-1) saturationDegrees[vertex] += 1;
                }
            }

            for (int i = 1; i <= graph.vertexCount; i++){
                System.out.println("Vertex " + i + " --->  Color: " + result[i-1]);
            }
        }

        public int getMaxSaturation(int[] s) {
            int max = 0;
            for (int i = 0; i < s.length; i++){
                if(s[i] > s[max]) max = i;
            }
            return max;
        }


        @Override
        public String toString() {
            StringBuilder string = new StringBuilder(" graph: " + "vertexCount = " + vertexCount + ", adjancentList: \n");
            for (int i = 0; i < vertexCount; i++){
                string.append(i).append(" -> ").append(adjancentList[i].toString()).append("\n");
            }
            return string.toString();
        }
}
