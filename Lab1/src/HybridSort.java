public class HybridSort {

    public int[] hybridQuickInsertionSort(int[] array, int leftElement, int rightElement, int k) {
        if (rightElement - leftElement <= k) {
            InsertionSort sortFunctions = new InsertionSort();
            sortFunctions.insertionSort(array, leftElement, rightElement);
        }
        else if (leftElement < rightElement) {
            int divideIndex = division(array, leftElement, rightElement);
            hybridQuickInsertionSort(array, leftElement, divideIndex - 1, k);
            hybridQuickInsertionSort(array, divideIndex, rightElement, k);
        }
        return array;
    }


    public int[] hybridMergeInsertionSort(int[] array, int k) {
        InsertionSort insertFunc = new InsertionSort();
        MergeSort mergeFunc = new MergeSort();
        if (array == null) {
            return null;
        }
        else if (array.length < 2) {
            return array;
        }
        else {
            int halfSize = array.length / 2;
            int[] leftArray = new int[halfSize];
            System.arraycopy(array, 0, leftArray, 0, halfSize);
            int[] rightArray = new int[array.length - leftArray.length];
            System.arraycopy(array, leftArray.length, rightArray, 0, array.length - leftArray.length);
            if (leftArray.length < k) {
                insertFunc.insertionSort(leftArray, 0, leftArray.length - 1);
            } else {
                hybridMergeInsertionSort(leftArray, k);
            }
            if (rightArray.length < k) {
                insertFunc.insertionSort(rightArray, 0, rightArray.length - 1);
            } else {
                hybridMergeInsertionSort(rightArray, k);
            }
            mergeFunc.mergeSort(array, leftArray, rightArray);
            return array;
        }
    }


    private int division(int[] arr, int startElement, int endElement) {
        int rightIndex = endElement;
        int leftIndex = startElement;
        int divider = arr[startElement + (endElement - startElement) / 2];
        while(leftIndex <= rightIndex) {
            while(arr[leftIndex] < divider) {
                ++leftIndex;
            }
            while(arr[rightIndex] > divider) {
                --rightIndex;
            }
            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                ++leftIndex;
                --rightIndex;
            }
        }
        return leftIndex;
    }


    private void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
