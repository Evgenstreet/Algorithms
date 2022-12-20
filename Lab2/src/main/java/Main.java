import first_task.BinarySearch;
import first_task.InterpolationSearch;
import second_task.BinaryTree;
import third_task.HashTableChain;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int size = 50;
        int seed = 80;
        int[] array = new int[size];
        PrepareArrays creation = new PrepareArrays();
        array = creation.fillArray(size, seed, array);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        BinarySearch callFunc = new BinarySearch();
        InterpolationSearch callFunc2 = new InterpolationSearch();
        System.out.println(callFunc.binarySearchInArray(array, 10));
        System.out.println(callFunc2.interpolationSearchInArray(array, 10));

        int[] secondArray = new int[10];
        secondArray = creation.fillArray(secondArray.length, seed, secondArray);
        System.out.println(Arrays.toString(secondArray));
        BinaryTree tree = new BinaryTree().insertArrayOfValuesInBinaryTree(secondArray);
        tree.print();
        System.out.println("Travel route in order: " + tree.traversalInOrder().toString());
        System.out.println("Travel route pre order: " + tree.traversalPreOrder().toString());
        System.out.println("Travel route post order: " + tree.traversalPostOrder().toString());
        System.out.println("Second Min key: " + tree.findKeyMin(2));
        System.out.println("Value to search: " + tree.findNodeByValue(tree.findKeyMin(4)));
        System.out.println();
        tree.balanceTree();
        tree.print();

        AdditionalTasks additional = new AdditionalTasks();
        additional.AdditionalTasksForBinaryTree();


        final HashTableChain table = new HashTableChain();
        table.add(16, 356);
        table.add(32, 10824);
        table.add(9, -8245);
        table.add(3, 241);
        table.add(2, 152);
        table.add(7, 836);
        table.add(6, 943);
        table.add(13, -68);
        table.add(21, 91);
        table.add(53, 740);
        System.out.println("\n-------------\n");
        System.out.println(table.print());
        table.printMaxOfCollision();
        table.printNumOfCollision();
        System.out.println("\n-------------\n");


        for(int i = 0; i < size; i++) {
            final HashTableChain table2 = new HashTableChain();
            table2.constOfKnut = table2.constOfKnut+(double)(i)/1000;
            table.add(16, 356);
            table.add(32, 10824);
            table.add(9, -8245);
            table.add(3, 241);
            table.add(2, 152);
            table.add(7, 836);
            table.add(6, 943);
            table.add(13, -68);
            table.add(21, 91);
            table.add(53, 740);
            System.out.println("\n-------------");
            System.out.println(table2.print());
            table2.printMaxOfCollision();
            table2.printNumOfCollision();
            System.out.println("Const: "+ table2.constOfKnut +"\n-------------\n");
        }
    }
}
