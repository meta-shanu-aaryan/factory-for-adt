package FactoryADT.Shape;

public class Point {
    double x;
    double y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public static double getDistance(Point a, Point b) {

        double distance = Math.sqrt((Math.pow(Math.abs(b.x - a.x), 2)) + Math.pow(Math.abs(b.y - a.y), 2));

        return distance;
    }
}