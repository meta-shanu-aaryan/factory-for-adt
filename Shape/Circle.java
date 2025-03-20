package FactoryADT.Shape;

import java.util.List;

public class Circle implements Shape {

    public double radius;
    Point origin;
    Object type;
    long timestamp;

    /**
     * @param origin origin point of the circle that is its center
     * @param parameter
     */
    public Circle(Point origin, List<Integer> parameter) {
        this.origin = origin;
        this.radius = parameter.get(0);
        this.type = Shape.shapeType.CIRCLE;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public double getArea() {
        try {
            return Math.round((Math.PI * radius * radius) * 100) / 100;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public double getPerimeter() {
        try {
            double perimeter = 2 * Math.PI * radius;
            return Math.round((perimeter * 100)) / 100;
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
            return (this.radius >= Point.getDistance(p, this.origin));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public shapeType getShapeType() {
        return Shape.shapeType.CIRCLE;
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }

}
