package bsu.evg.m;

import java.util.ArrayList;

public class Backpack    {
        public static void main(String[] args) {
        ArrayList<Item> item = new ArrayList<>();
        item.add(new Item(6,36,6));
        item.add(new Item(8,44,4));
        item.add(new Item(4,21,1));
        item.add(new Item(2,14,2));
        runBackpackAlgorithm(item, 16);
        }

        public static void runBackpackAlgorithm(ArrayList<Item> items, int bagVolume) {
            int[][] matrixForPrice = new int[items.size()][bagVolume+1];
            int[][] matrixForWeight = new int[items.size()][bagVolume+1];
            int loop = 0;
            for (Item item : items) {
                for(int i = 0; i <= bagVolume; i++) {
                    int helper = Math.min(item.getCount(), i / item.getWeight());
                    if(loop == 0){
                        matrixForPrice[loop][i] = item.getPrice() * helper;
                        matrixForWeight[loop][i] = item.getWeight() * helper;
                    }else{
                        int maxValue = 0;
                        int currentWeight = 0;
                        for (int j = 0; j <= i; j++) {
                            int countForItems = Math.min(item.getCount(), j / item.getWeight());
                            int totalPrice = item.getPrice() * countForItems + matrixForPrice[loop-1][i-j];
                            if (totalPrice > maxValue) {
                                maxValue = totalPrice;
                                currentWeight = j;
                            }
                        }
                        matrixForPrice[loop][i] = maxValue;
                        matrixForWeight[loop][i] = currentWeight;
                    }
                }
                loop++;
            }
            printResult(matrixForPrice);
        }

        public static void printResult(int[][] matrixOfPrice) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < matrixOfPrice[0].length; i++) {
                str.append("\t").append(i);
            }
            str.append("\n");
            for(int i = 0; i < matrixOfPrice.length; i++) {
                str.append("I").append(i+1).append("\t");
                for (int j = 0; j < matrixOfPrice[i].length; j++) {
                    str.append(matrixOfPrice[i][j]).append("\t");
                }
                str.append("\n");
            }
            System.out.println(str);
        }
}