package FactoryADT.Shape;

import java.util.List;

public class Rectangle implements Shape {

    double length;
    double breadth;
    Point origin;
    Object type;
    long timestamp;

    // constructor
    /**
     * @param origin    Origin point
     * @param parameter other parameters such as length and breadth as arrayList
     */
    public Rectangle(Point origin, List<Integer> parameter) {
        this.type = Shape.shapeType.RECTANGLE;
        this.origin = origin;
        this.length = parameter.get(0);
        this.breadth = parameter.get(1);
        this.timestamp = System.currentTimeMillis();
    }

    // Overridden methods
    @Override
    public double getArea() {
        try {
            return length * breadth;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public double getPerimeter() {
        try {
            return 2 * (length + breadth);
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
            double pointX = p.getX();
            double pointY = p.getY();

            double xMax = this.origin.getX() + this.length;
            double yMax = this.origin.getY() + this.breadth;

            if (pointX >= this.origin.getX() && pointY >= this.origin.getY() && pointX <= xMax && pointY <= yMax) {
                return true;
            }

            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }

    @Override
    public shapeType getShapeType() {
        return shapeType.RECTANGLE;
    }

}
