package bsu.evg.m;

import javax.swing.*;
import java.util.*;
import java.util.List;


//        [[0, 1, 5, 6], [2, 3, 8, 12], [4, 7, 9], [10, 11], [13, 15, 18], [14], [16, 19], [17]] 8
//        [Rectangle: width = 6 ,height = 21, Rectangle: width = 17 ,height = 15, Rectangle: width = 13 ,height = 10, Rectangle: width = 7 ,height = 10, Rectangle: width = 12 ,height = 8, Rectangle: width = 1 ,height = 7, Rectangle: width = 1 ,height = 6, Rectangle: width = 7 ,height = 6, Rectangle: width = 3 ,height = 6, Rectangle: width = 5 ,height = 5, Rectangle: width = 18 ,height = 4, Rectangle: width = 7 ,height = 2, Rectangle: width = 1 ,height = 2, Rectangle: width = 16 ,height = 2, Rectangle: width = 18 ,height = 2, Rectangle: width = 4 ,height = 2, Rectangle: width = 10 ,height = 1, Rectangle: width = 20 ,height = 1, Rectangle: width = 5 ,height = 1, Rectangle: width = 11 ,height = 1]
//        [[0, 1, 5, 6], [2, 3, 8], [4, 7, 9, 12], [10, 11], [13], [14, 15], [16, 19], [17, 18]] 8
//        [Rectangle: width = 6 ,height = 21, Rectangle: width = 17 ,height = 15, Rectangle: width = 13 ,height = 10, Rectangle: width = 7 ,height = 10, Rectangle: width = 12 ,height = 8, Rectangle: width = 1 ,height = 7, Rectangle: width = 1 ,height = 6, Rectangle: width = 7 ,height = 6, Rectangle: width = 3 ,height = 6, Rectangle: width = 5 ,height = 5, Rectangle: width = 18 ,height = 4, Rectangle: width = 7 ,height = 2, Rectangle: width = 1 ,height = 2, Rectangle: width = 16 ,height = 2, Rectangle: width = 18 ,height = 2, Rectangle: width = 4 ,height = 2, Rectangle: width = 10 ,height = 1, Rectangle: width = 20 ,height = 1, Rectangle: width = 5 ,height = 1, Rectangle: width = 11 ,height = 1]
public class Container {
    public static void main(String[] args) {
        new Container().print();
    }


    public ResultContainer FirstFitDecreasingHigh (List<Rectangle> rectangleList, int containerWidth) {
        int level = 0;
        int[] widthOfLevels = new int[rectangleList.size()];
        Arrays.fill(widthOfLevels, containerWidth);
        List<Integer>[] resultOfRectangle = new ArrayList[1];
        resultOfRectangle[0] = new ArrayList<>();
        rectangleList.sort(Comparator.comparingInt(Rectangle::getHeight).reversed());
        resultOfRectangle[level].add(0);
        widthOfLevels[0] -= rectangleList.get(0).getWidth();
        for(int i = 1; i < rectangleList.size(); i++) {
            level = 0;
            if(widthOfLevels[level]>=rectangleList.get(i).getWidth()){
                resultOfRectangle[level].add(i);
                widthOfLevels[level]-=rectangleList.get(i).getWidth();
            } else {
                while(true) {
                    level++;
                    if(level >= resultOfRectangle.length) resultOfRectangle = Arrays.copyOf(resultOfRectangle, level+1);
                    if(widthOfLevels[level]>=rectangleList.get(i).getWidth()){
                        if(resultOfRectangle[level]==null) resultOfRectangle[level] = new ArrayList<>();
                        resultOfRectangle[level].add(i);
                        widthOfLevels[level]-=rectangleList.get(i).getWidth();
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(resultOfRectangle) + " " + resultOfRectangle.length);
        System.out.println(rectangleList);
        return new ResultContainer(rectangleList, resultOfRectangle, containerWidth);
    }

    public ResultContainer BestFitDecreasingHigh (List<Rectangle> rectangleList, int containerWidth) {
        int level = 0;
        int[] widthOfLevels = new int[1];
        Arrays.fill(widthOfLevels, containerWidth);
        List<Integer>[] resultOfRectangle = new ArrayList[1];
        resultOfRectangle[0] = new ArrayList<>();
        rectangleList.sort(Comparator.comparingInt(Rectangle::getHeight).reversed());
        resultOfRectangle[level].add(0);
        widthOfLevels[0] -= rectangleList.get(0).getWidth();
        for(int i = 1; i < rectangleList.size(); i++) {
            int bestLevel = widthOfLevels.length;
            int bestWidth = containerWidth + 1;
            for(level = 0; level < widthOfLevels.length; level++){
                if(widthOfLevels[level]>=rectangleList.get(i).getWidth()){
                    if ((widthOfLevels[level]-rectangleList.get(i).getWidth() < bestWidth) && (widthOfLevels[level]-rectangleList.get(i).getWidth() >= 0)) {
                        bestLevel = level;
                        bestWidth = widthOfLevels[level]-rectangleList.get(i).getWidth();
                    }
                }else if(level+1 >= widthOfLevels.length){
                    widthOfLevels = Arrays.copyOf(widthOfLevels, widthOfLevels.length+1);
                    widthOfLevels[widthOfLevels.length-1] = containerWidth;
                }
            }
            if(bestLevel >= resultOfRectangle.length) resultOfRectangle = Arrays.copyOf(resultOfRectangle, bestLevel+1);
            if(resultOfRectangle[bestLevel]==null) resultOfRectangle[bestLevel] = new ArrayList<>();
            resultOfRectangle[bestLevel].add(i);
            widthOfLevels[bestLevel]-=rectangleList.get(i).getWidth();
        }
        System.out.println(Arrays.toString(resultOfRectangle) + " " + resultOfRectangle.length);
        System.out.println(rectangleList);
        return new ResultContainer(rectangleList, resultOfRectangle, containerWidth);

    }

    public void print() {
        JFrame j = new JFrame();
        j.setSize(800, 800);
        j.setVisible(true);
        j.add(new Drawables(j.getWidth(),j.getHeight()));
    }
}


