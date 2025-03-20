package FactoryADT.Shape;

public class Point {
    double x;
    double y;

    //constructor
    /**
     * @param x x axis point
     * @param y y axis point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    //getters
    /**
     * @return x axis point
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return y axis point
     */
    public double getY() {
        return this.y;
    }


    //methods
    /**
     * @param a Point a
     * @param b Point b
     * @return distance between a and b point
     */
    public static double getDistance(Point a, Point b) {

        double distance = Math.sqrt((Math.pow(Math.abs(b.x - a.x), 2)) + Math.pow(Math.abs(b.y - a.y), 2));

        return distance;
    }
}