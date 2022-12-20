package fifth_task;

import java.util.Arrays;

public class GaleShapleyAlgorithm {

    public GaleShapleyAlgorithm() { }


    public void moreEffectiveEmployeeForTask(int[][] arrayOfFirstTable, int[][] arrayOfSecondTable){
        int[] listForFirstTable = new int[arrayOfFirstTable.length];
        int[] listForSecondTable = new int[arrayOfSecondTable.length];
        fillArray(listForFirstTable, listForSecondTable);
        while(!coverAllArray(listForSecondTable) && !coverAllArray(listForFirstTable)){
            for(int i = 0; i < arrayOfFirstTable.length; i++){
                if (listForFirstTable[i] == -1){
                    if(listForSecondTable[arrayOfFirstTable[i][0]] == -1){
                        listForSecondTable[arrayOfFirstTable[i][0]] = i;
                        listForFirstTable[i] = arrayOfFirstTable[i][0];
                    }
                    else {
                    int iterator = 0;
                    while(listForFirstTable[i] == -1){
                        if((listForSecondTable[arrayOfFirstTable[i][iterator]]!=-1)) {
                            if (getPosition(arrayOfSecondTable[arrayOfFirstTable[i][iterator]], i)
                                    < getPosition(arrayOfSecondTable[arrayOfFirstTable[i][iterator]], listForSecondTable[arrayOfFirstTable[i][iterator]])) {
                                listForFirstTable[listForSecondTable[arrayOfFirstTable[i][iterator]]] = -1;
                                listForSecondTable[arrayOfFirstTable[i][iterator]] = i;
                                listForFirstTable[i] = arrayOfFirstTable[i][iterator];
                            }
                        }
                        else {
                            listForSecondTable[arrayOfFirstTable[i][iterator]] = i;
                            listForFirstTable[i] = arrayOfFirstTable[i][iterator];
                        }
                        iterator++;
                        }
                    }
                }
            }
        }
        System.out.println("Array from first to second: " + Arrays.toString(listForFirstTable));
        System.out.println("Array from second to first: " + Arrays.toString(listForSecondTable));
    }


    private int getPosition(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++){
            if(arr[i]==element) {
                return i;
            }
        }
        return -1;
    }


    private void fillArray(int[] arr1, int[] arr2){
        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);
    }


    private boolean coverAllArray(int[] arr){
        for (int i : arr) if (i == -1) return false;
        return true;
    }
}
