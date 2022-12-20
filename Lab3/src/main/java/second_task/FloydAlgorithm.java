package second_task;

public class FloydAlgorithm {
    private final int inf = 1000;
    private int[][] adjacencyMatrix;
    private int[][] referenceMatrix;

    public FloydAlgorithm() {
    }


    public FloydAlgorithm(int[][] adjacencyMatrix){
        this.adjacencyMatrix = new int[adjacencyMatrix.length][];
        this.referenceMatrix = new int[adjacencyMatrix.length][];
        for (int i = 0; i < adjacencyMatrix.length; i++){
            this.adjacencyMatrix[i] = new int[adjacencyMatrix[i].length];
            this.referenceMatrix[i] = new int[adjacencyMatrix[i].length];
            for (int j = 0; j < adjacencyMatrix[i].length; j++){
                this.adjacencyMatrix[i][j] = adjacencyMatrix[i][j];
                this.referenceMatrix[i][j] = j + 1;
            }
        }
    }


    public void findShortestPath() {
        System.out.println();
        System.out.println("L0");
        printMatrix(adjacencyMatrix);
        System.out.println("S0");
        printMatrix(referenceMatrix);
        for (int element = 0; element < adjacencyMatrix.length; element++) {
            System.out.println();
            System.out.println("-----------");
            for (int i = 0; i < adjacencyMatrix.length;i++){
                for (int j = 0; j < adjacencyMatrix[i].length;j++){
                    if(adjacencyMatrix[i][j]>adjacencyMatrix[i][element] + adjacencyMatrix[element][j]
                            && adjacencyMatrix[i][element]!=inf && adjacencyMatrix[element][j]!=inf){
                        adjacencyMatrix[i][j] = adjacencyMatrix[i][element] + adjacencyMatrix[element][j];
                        referenceMatrix[i][j] = referenceMatrix[i][element];
                    }
                }
            }
            System.out.println("L: "+(element+1));
            printMatrix(adjacencyMatrix);
            System.out.println("S: "+(element+1));
            printMatrix(referenceMatrix);
            System.out.println("-----------");
        }
    }


    public int findVertexWithShortestPath(){
        int min = inf;
        int vertex = 0;
        for (int i = 0; i < adjacencyMatrix.length;i++){
            int sum = 0;
            for(int j = 0; j < adjacencyMatrix[i].length;j++){
                sum+=adjacencyMatrix[i][j];
            }
            if (sum < min){
                min = sum;
                vertex = i;
            }
        }
        return vertex;
    }


    public void printMatrix(int[][] matrix){
        System.out.println();
        for (int[] ints : matrix) {
            System.out.print("[ ");
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == inf) {
                    System.out.print("inf");
                } else {
                    System.out.printf("%2d", ints[j]);
                }
                if (j != matrix.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
        System.out.println();
    }


    public int[][] initRandomAdjacencyMatrix(int size){
        int[][] matrix = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j<size; j++){
                if(i == j){
                    matrix[i][j]=0;
                }else{
                    matrix[i][j]=(int)(Math.random()*20)+1;
                }
            }
        }
        return matrix;
    }
}
