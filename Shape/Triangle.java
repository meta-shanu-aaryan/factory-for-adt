package FactoryADT.Shape;

import java.util.List;

public class Triangle implements Shape {

    Point origin;
    Point p2;
    Point p3;
    Object type;
    long timestamp;

    /**
     * @param origin Point 1 of triangle
     * @param p2     Point 2 of triangle
     * @param p3     Point 3 of triangle
     */
    public Triangle(Point origin, Point p2, Point p3) {
        this.type = Shape.shapeType.TRIANGLE;
        this.origin = origin;
        this.p2 = p2;
        this.p3 = p3;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * @param origin    Point 1 of triangle and origin point
     * @param parameter array with other coordinates such as its other coordinate
     *                  points
     */
    public Triangle(Point origin, List<Integer> parameter) {
        this.origin = origin;
        this.p2 = new Point(parameter.get(0), parameter.get(1));
        this.p3 = new Point(parameter.get(2), parameter.get(3));
    }

    @Override
    public double getArea() {
        try {
            double area = Math.abs((origin.getX() * (p2.getY() - p3.getY())) + (p2.getX() * (p3.getY() - origin.getY()))
                    + (p3.getX() * (origin.getY() - p2.getY()))) / 2;
            return area;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public double getPerimeter() {
        try {
            return Point.getDistance(origin, p2) + Point.getDistance(origin, p3) + Point.getDistance(p2, p3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public Point getOrigin() {
        try {
            return this.origin;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Point(-1, -1);
        }
    }

    @Override
    public boolean isEnclosed(Point p) {
        try {
            Triangle t1 = new Triangle(p, this.origin, this.p2);
            Triangle t2 = new Triangle(p, this.p2, this.p3);
            Triangle t3 = new Triangle(p, this.p3, this.origin);
            double totalArea = t1.getArea() + t2.getArea() + t3.getArea();

            return (totalArea == this.getArea());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public shapeType getShapeType() {
        return shapeType.TRIANGLE;
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }

}
