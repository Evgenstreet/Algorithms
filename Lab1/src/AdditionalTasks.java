import java.util.Arrays;
import java.util.Random;

public class AdditionalTasks {

    //1. generate a random array
    public int[] createRandomArray(int[] array, int seed){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * seed);
        }
        return array;
    }


    //2. generate a random array with elements, belonging to a Gauss normal distribution
    public int[] createArrayUsingGauss(int[] array, int seed) {
        double difference = 1.0D;
        double avg = 0.5D;
        Random rng = new Random(seed);
        for(int i = 0; i < array.length; i++) {
            array[i] = (int)((difference + avg * rng.nextGaussian()) * (double)seed);
        }
        return array;
    }


    //3. many types of quicksort
    public int[] quickSortMiddleElement(int[] arr){
        if (arr.length <= 1) {
            return arr;
        }
        int divider = arr[arr.length/2];
        int[] leftArray = Arrays.stream(arr)
                .filter(i -> i < divider)
                .toArray();
        int[] centerArray = Arrays.stream(arr)
                .filter(i -> i == divider)
                .toArray();
        int[] rightArray = Arrays.stream(arr)
                .filter(i -> i > divider)
                .toArray();
        int[][] arrayForConcat = new int[][]{quickSortMiddleElement(leftArray),centerArray,quickSortMiddleElement(rightArray)};
        return Arrays.stream(arrayForConcat)
                .flatMapToInt(Arrays::stream)
                .toArray();
    }


    public int[] quickSortBySecondElement(int[] array){
        if (array.length <= 1) {
            return array;
        }
        int divider = array[1];
        int[] leftArray = Arrays.stream(array)
                .filter(i -> i < divider)
                .toArray();
        int[] centerArray = Arrays.stream(array)
                .filter(i -> i == divider)
                .toArray();
        int[] rightArray = Arrays.stream(array)
                .filter(i -> i > divider)
                .toArray();
        int[][] arrayForConcat = new int[][]{quickSortBySecondElement(leftArray),centerArray,quickSortBySecondElement(rightArray)};
        return Arrays.stream(arrayForConcat)
                .flatMapToInt(Arrays::stream)
                .toArray();
    }


    public int[] quickSortMedianByThreeElem(int[] array){
        if (array.length <= 1) {
            return array;
        }
        int divider = findMedianOfThreeElements(array[0],array[(array.length-1)/2],array[array.length-1]);
        int[] leftArray = Arrays.stream(array)
                .filter(i -> i < divider)
                .toArray();
        int[] centerArray = Arrays.stream(array)
                .filter(i -> i == divider)
                .toArray();
        int[] rightArray = Arrays.stream(array)
                .filter(i -> i > divider)
                .toArray();
        int[][] concatedArray = new int[][]{quickSortMedianByThreeElem(leftArray),centerArray,quickSortMedianByThreeElem(rightArray)};
        return Arrays.stream(concatedArray)
                .flatMapToInt(Arrays::stream)
                .toArray();
    }


    public int findMedianOfThreeElements(int first, int second, int third) {
        if(first > second) {
            if(first < third) return first;
            else return Math.max(second, third);
        }
        else if(second > third)
            return Math.max(third, first);
        else return second;
    }


    public int[] quickSortByRandomElement(int[] array){
        if (array.length <= 1) {
            return array;
        }
        int divider = array[(int) (Math.random() * (array.length - 1))];
        int[] leftArray = Arrays.stream(array)
                .filter(i -> i < divider)
                .toArray();
        int[] centerArray = Arrays.stream(array)
                .filter(i -> i == divider)
                .toArray();
        int[] rightArray = Arrays.stream(array)
                .filter(i -> i > divider)
                .toArray();
        int[][] arrayForConcat = new int[][]{quickSortByRandomElement(leftArray),centerArray,quickSortByRandomElement(rightArray)};
        return Arrays.stream(arrayForConcat)
                .flatMapToInt(Arrays::stream)
                .toArray();
    }


    public int[] quickSortByHoar(int[] array, int first, int second){
        if (second - first > 1) {
            int divisionIndex = divisionByHoar(array, first, second);
            quickSortByHoar(array, first, (divisionIndex - 1));
            quickSortByHoar(array, divisionIndex, second);
        }
        return array;
    }


    private int divisionByHoar(int[] array, int startElement, int endElement){
        int rightIndex = endElement;
        int leftIndex = startElement;
        int counter = array[(startElement + (endElement)) / 2];
        while (leftIndex <= rightIndex) {
            while (array[leftIndex] < counter) {
                leftIndex++;
            }
            while (array[rightIndex] > counter) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(array, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }


    public int[] quickSortByLomuto(int[] array, int first, int second){
        if (second - first > 1) {
            int divisionIndex = partitionByLomuto(array, first, second);
            quickSortByLomuto(array, first, (divisionIndex - 1));
            quickSortByLomuto(array, divisionIndex, second);
        }
        return array;
    }


    private int partitionByLomuto(int[] array, int first, int second){
        int counter = array[second];
        int i = first;
        for (int j = first; j < second; j++){
            if(array[j] <= counter){
                swap(array,i,j);
                i++;
            }
        }
        swap(array,i,second);
        return i;
    }


    private void swap(int[] array, int firstElement, int secondElement) {
        int temp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = temp;
    }


    public static long measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long difference = System.currentTimeMillis() - startTime;
        return difference;
    }
}
