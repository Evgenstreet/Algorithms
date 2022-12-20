package first_task;

import java.util.Arrays;

public class InterpolationSearch {

    public int interpolationSearchInArray(int[] array, int element){
        Arrays.sort(array);
        int leftIndex = 0;
        int rightIndex = array.length-1;
        int counter = 0;
        int position = -1;

        while (array[leftIndex]<=element && array[rightIndex]>=element){
            int median = leftIndex + ((element-array[leftIndex])*(rightIndex-leftIndex)) / (array[rightIndex]-array[leftIndex]);
            if(array[median] == element){
                counter++;
                position = median;
                break;
            }else if(array[median] < element){
                leftIndex = median + 1;
                counter++;
            }else if(array[median] > element){
                rightIndex = median - 1;
                counter++;
            }
        }
        System.out.println("Count of operations = " + counter);
        if(position==-1){
            System.out.println("Array is empty!");
        }
        return position;
    }
}
