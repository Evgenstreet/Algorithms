
import java.util.Arrays;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lengthOfArrays; //N
        int countOfArrays; //R
        int maxValue; //M
        System.out.println("Enter length of arrays");
        lengthOfArrays = input.nextInt();
        System.out.println("Enter count of arrays");
        countOfArrays = input.nextInt();
        System.out.println("Enter a random generation max number");
        maxValue = input.nextInt();
        PrepareArrays arrayCreation = new PrepareArrays();
        int[][] arrays = arrayCreation.createBigArray(countOfArrays, lengthOfArrays, maxValue);
        AdditionalTasks callFunctions = new AdditionalTasks();
        int[] resultForQuickSortArray = callFunctions.quickSortMiddleElement(arrays[0]);
        System.out.println("Quicksort by middle element: " + Arrays.toString(resultForQuickSortArray));
        long timeOfSort = AdditionalTasks.measureTime(()->callFunctions.quickSortMiddleElement(arrays[0]));
        System.out.println("Completed in: " + timeOfSort + " ms");
        resultForQuickSortArray = callFunctions.quickSortBySecondElement(arrays[1]);
        System.out.println("Quicksort by second element: " + Arrays.toString(resultForQuickSortArray));
        timeOfSort = AdditionalTasks.measureTime(()->callFunctions.quickSortBySecondElement(arrays[1]));
        System.out.println("Completed in: " + timeOfSort + " ms");
        resultForQuickSortArray = callFunctions.quickSortMedianByThreeElem(arrays[2]);
        System.out.println("Quicksort by median of three elements: " + Arrays.toString(resultForQuickSortArray));
        timeOfSort = AdditionalTasks.measureTime(()->callFunctions.quickSortMedianByThreeElem(arrays[2]));
        System.out.println("Completed in: " + timeOfSort + " ms");
        resultForQuickSortArray = callFunctions.quickSortByRandomElement(arrays[3]);
        System.out.println("Quicksort by random element: " + Arrays.toString(resultForQuickSortArray));
        timeOfSort = AdditionalTasks.measureTime(()->callFunctions.quickSortByRandomElement(arrays[3]));
        System.out.println("Completed in: " + timeOfSort + " ms");
        resultForQuickSortArray = callFunctions.quickSortByHoar(arrays[4], 0, arrays[4].length - 1);
        System.out.println("Quicksort by Hoar division: " + Arrays.toString(resultForQuickSortArray));
        timeOfSort = AdditionalTasks.measureTime(()->callFunctions.quickSortByHoar(arrays[4], 0, arrays[4].length-1));
        System.out.println("Completed in: " + timeOfSort + " ms");
        resultForQuickSortArray = callFunctions.quickSortByLomuto(arrays[5], 0, arrays[5].length - 1);
        System.out.println("Quicksort by Lomuto division: " + Arrays.toString(resultForQuickSortArray));
        timeOfSort = AdditionalTasks.measureTime(()->callFunctions.quickSortByLomuto(arrays[5], 0, arrays[5].length-1));
        System.out.println("Completed in: " + timeOfSort + " ms");
    //    arrays.length//кол-во массивов
    //    arrays[1].length//кол-во элементов
    }
}
