package bsu.evg.m;

import java.util.List;

class ResultContainer {
    private List<Rectangle> rectangleList;
    List<Integer>[] layers;
    int widthContainer;

    public ResultContainer(List<Rectangle> rectangleList, List<Integer>[] layers, int widthContainer) {
        this.rectangleList = rectangleList;
        this.layers = layers;
        this.widthContainer = widthContainer;
    }

    public List<Rectangle> getRectangleList() {
        return rectangleList;
    }
    public List<Integer>[] getLayers() {
        return layers;
    }
}