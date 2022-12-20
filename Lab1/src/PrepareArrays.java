import java.util.Random;

public class PrepareArrays {
    int[][] createBigArray(int countOfArrays, int arraySize, int maxValue){
        int[][] arrays = new int[countOfArrays][arraySize];
        for (int i = 0; i < countOfArrays; i++){
            createArray(arraySize, maxValue, arrays[i]);
        }
        return arrays;
    }


    int[] createArray(int arraySize, int maxValue, int[]array){
        final Random random = new Random();
        for (int j = 0; j < arraySize; j++){
            array[j] = random.nextInt(maxValue);
        }
        return array;
    }
}