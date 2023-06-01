package org.evg_min;

import java.util.ArrayList;
import java.util.Random;

public class Equation {
    public int x1;
    public int x2;
    public int x3;
    public int x4;
    public int x5;
    private final Random rand = new Random(System.currentTimeMillis());

    @Override
    public String toString() {
        return "{" + "x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + ", x4=" + x4 + ", x5=" + x5 + '}';
    }

    public Equation(int x1, int x2, int x3, int x4, int x5) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
    }
    public Equation(){}

    public Equation generateOne(int minValue, int maxValue) {
        return new Equation(rand.nextInt(maxValue) + minValue, rand.nextInt(maxValue) + minValue,rand.nextInt(maxValue) + minValue, rand.nextInt(maxValue) + minValue,rand.nextInt(maxValue) + minValue);
    }

    public int generateGenome(int minValue, int maxValue) {
        return rand.nextInt(maxValue) + minValue;
    }

    public ArrayList<Equation> generatePopulation(int size, int minValue, int maxValue) {
        ArrayList<Equation> list = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            list.add(generateOne(minValue, maxValue));
        }
        return list;
    }
}
