

public class QuickSort {
    public void quickSort(int[] array, int begin, int end) {
        if (array.length == 0 || begin >= end)
            return;
        int mediana = begin + (end - begin) / 2;
        int basedElement = array[mediana];
        int i = begin, j = end;
        while (i <= j) {
            while (array[i] < basedElement) {
                i++;
            }
            while (array[j] > basedElement) {
                j--;
            }
            if (i <= j) {
                swap(array, array[i], array[j]);
                i++;
                j--;
            }
        }
        if (begin < j)
            quickSort(array, begin, j);
        if (end > i)
            quickSort(array, i, end);
    }


    public void swap(int[] array, int leftElement, int rightElement) {
        int temp = array[leftElement];
        array[leftElement] = array[rightElement];
        array[rightElement] = temp;
    }

}
