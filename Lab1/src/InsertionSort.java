public class InsertionSort {

    public void insertionSort(int[] array, int startElement, int endElement) {
        for(int i = startElement + 1; i <= endElement; ++i) {
            for(int j = i - 1; j >= startElement && array[j] > array[j + 1]; --j) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}
