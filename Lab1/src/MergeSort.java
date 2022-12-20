public class MergeSort {

    public void mergeSort(int[] array, int[] leftArray, int[] rightArray) {
        int positionB = 0;
        int positionC = 0;
        for(int c = 0; c < array.length; ++c) {
            if (positionB == leftArray.length) {
                array[c] = rightArray[positionC];
                ++positionC;
            } else if (positionC == rightArray.length) {
                array[c] = leftArray[positionB];
                ++positionB;
            } else if (leftArray[positionB] < rightArray[positionC]) {
                array[c] = leftArray[positionB];
                ++positionB;
            } else {
                array[c] = rightArray[positionC];
                ++positionC;
            }
        }
    }

}
