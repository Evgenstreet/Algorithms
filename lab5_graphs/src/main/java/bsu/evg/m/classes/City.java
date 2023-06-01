package bsu.evg.m.classes;

public class City {
        private double x;
        private double y;
    public City(double x, double y) {
        this.x = x;
        this.y = y;
    }

        public double distance(City city2) {
        return Math.sqrt(Math.pow(this.x - city2.x,2)+Math.pow(this.y - city2.y,2));
    }

        @Override
        public String toString() {
        return "City: {" + "x=" + x + ", y=" + y + '}';
    }
}
