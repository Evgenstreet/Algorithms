package bsu.evg.m;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Random;

class Drawables extends JComponent {
    private int width;
    private int height;

    private int SIZE_OF_ARRAY = 20;

    private int WIDTH_OF_CONTAINER = 25;

    public Drawables(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        Rectangle r = new Rectangle();
        java.util.List<Rectangle> list = r.generateRandomRectangle(SIZE_OF_ARRAY,WIDTH_OF_CONTAINER);
        ResultContainer dto = new Container().FirstFitDecreasingHigh(list,WIDTH_OF_CONTAINER);
        java.util.List<Rectangle> rectangleList = dto.getRectangleList();
        int width = dto.widthContainer;

        List<Integer>[] layers = dto.getLayers();
        int scale = 10;
        Rectangle2D rect = new Rectangle2D.Double(0,0,width*scale, getHeight());
        g2d.setColor(Color.BLACK);
        g2d.fill(rect);
        int currentStartWidth = 0;
        int currentStartHeight = 0;
        for (List<Integer> layer : layers) {
            for (Integer integer : layer) {
                Rectangle2D rect2 = new Rectangle2D.Double(currentStartWidth, currentStartHeight, rectangleList.get(integer).getWidth() * scale, rectangleList.get(integer).getHeight() * scale);

                Random rand = new Random(System.currentTimeMillis());
                int randomValue = rand.nextInt(30);
                if (randomValue > 25) g2d.setColor(Color.BLUE);
                else if (randomValue > 20) g2d.setColor(Color.DARK_GRAY);
                else if (randomValue > 15) g2d.setColor(Color.RED);
                else if (randomValue > 10) g2d.setColor(Color.CYAN);
                else if (randomValue > 5) g2d.setColor(Color.ORANGE);
                else g2d.setColor(Color.MAGENTA);
                g2d.fill(rect2);
                g2d.setColor(Color.GREEN);
                g2d.drawRect(currentStartWidth, currentStartHeight, rectangleList.get(integer).getWidth() * scale, rectangleList.get(integer).getHeight() * scale);
                currentStartWidth += (rectangleList.get(integer).getWidth() * scale);
            }
            currentStartWidth = 0;
            currentStartHeight += rectangleList.get(layer.get(0)).getHeight() * scale;
        }

        dto = new Container().BestFitDecreasingHigh(list,WIDTH_OF_CONTAINER);
        layers = dto.getLayers();
        rectangleList = dto.getRectangleList();
        rect = new Rectangle2D.Double(width*scale*2,0,width*scale, getHeight());
        g2d.setColor(Color.BLACK);
        g2d.fill(rect);
        currentStartWidth = width*scale*2;
        currentStartHeight = 0;
        for (List<Integer> layer : layers) {
            for (Integer integer : layer) {
                Rectangle2D rect2 = new Rectangle2D.Double(currentStartWidth, currentStartHeight, rectangleList.get(integer).getWidth() * scale, rectangleList.get(integer).getHeight() * scale);
                Random rand = new Random(System.currentTimeMillis());
                int randomValue = rand.nextInt(30);
                if (randomValue > 25) g2d.setColor(Color.RED);
                else if (randomValue > 20) g2d.setColor(Color.DARK_GRAY);
                else if (randomValue > 15) g2d.setColor(Color.GREEN);
                else if (randomValue > 10) g2d.setColor(Color.CYAN);
                else if (randomValue > 5) g2d.setColor(Color.ORANGE);
                else g2d.setColor(Color.MAGENTA);
                g2d.fill(rect2);
                g2d.setColor(Color.BLUE);
                g2d.drawRect(currentStartWidth, currentStartHeight, rectangleList.get(integer).getWidth() * scale, rectangleList.get(integer).getHeight() * scale);
                currentStartWidth += (rectangleList.get(integer).getWidth() * scale);
            }
            currentStartWidth = width * scale * 2;
            currentStartHeight += rectangleList.get(layer.get(0)).getHeight() * scale;
        }
    }
}
