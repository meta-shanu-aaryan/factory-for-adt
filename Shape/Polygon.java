package FactoryADT.Shape;

import java.util.ArrayList;
import java.util.List;

public class Polygon implements Shape {

    Point origin;
    List<Point> otherPoints;
    public Shape.shapeType type;
    long timestamp;

    public Polygon(Point origin, List<Integer> parameter) {
        this.timestamp = System.currentTimeMillis();
        this.type = Shape.shapeType.POLYGON;
        this.origin = origin;
        otherPoints = new ArrayList<>();
        for (int i = 0; i < parameter.size(); i++, i++) {
            otherPoints.add(new Point(parameter.get(i), parameter.get(i + 1)));
        }
    }

    @Override
    public double getArea() {
        try {
            double area = (origin.getX() + otherPoints.get(0).getX()) * (origin.getY() - otherPoints.get(0).getY());
            for (int index = 0; index < otherPoints.size() - 1; index++) {
                area += (otherPoints.get(index).getX() + otherPoints.get(index + 1).getX())
                        * (otherPoints.get(index).getY() - otherPoints.get(index + 1).getY());
            }
            area += (otherPoints.get(otherPoints.size() - 1).getX() + origin.getX())
                    * (otherPoints.get(otherPoints.size() - 1).getY() - origin.getY());
            return Math.abs(area / 2.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public double getPerimeter() {
        try {
            double perimeter = Point.getDistance(origin, otherPoints.get(0));
            int n = otherPoints.size();
            for (int i = 0; i < otherPoints.size() - 1; i++) {
                perimeter += Point.getDistance(otherPoints.get(i), otherPoints.get(i + 1));
            }

            perimeter += Point.getDistance(otherPoints.get(n - 1), origin);

            return perimeter;

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
            int n = otherPoints.size();
            Triangle t = new Triangle(p, origin, otherPoints.get(0));
            double totalTriangleArea = t.getArea();

            for (int i = 0; i < n - 1; i++) {
                // Triangle t1 = new Triangle(p, otherPoints.get(i), otherPoints.get(i+1));
                totalTriangleArea += new Triangle(p, otherPoints.get(i), otherPoints.get(i + 1)).getArea();
            }

            totalTriangleArea += new Triangle(p, otherPoints.get(n - 1), origin).getArea();

            return (totalTriangleArea == this.getArea());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public shapeType getShapeType() {
        return Shape.shapeType.POLYGON;
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }

}
