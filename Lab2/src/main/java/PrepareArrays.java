import java.util.Random;

public class PrepareArrays {
        int[] fillArray(int arraySize, int maxValue, int[]array){
            final Random random = new Random();
            for (int j = 0; j < arraySize; j++){
                array[j] = random.nextInt(maxValue);
            }
            return array;
        }
    }
