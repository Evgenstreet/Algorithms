package bsu.evg.m;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle(){}

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Rectangle: " + "width = " + width + " ,height = " + height;
    }

    public List<Rectangle> generateRandomRectangle(int size, int widthContainer) {
        List<Rectangle> rect = new ArrayList<>();
        Random rand = new Random(System.currentTimeMillis());
        for(int i = 0; i < size; i++)
            rect.add(new Rectangle(rand.nextInt(rand.nextInt(widthContainer) + 1) + 1, rand.nextInt(rand.nextInt(widthContainer) + 1) + 1));
        return rect;
    }
}
