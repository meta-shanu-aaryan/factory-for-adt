package FactoryADT.Shape;

import java.util.List;

public class Square implements Shape {
    double side;
    Point origin;
    Object type;
    long timestamp;

    public Square(Point origin, List<Integer> parameter) {
        this.type = Shape.shapeType.SQUARE;
        this.origin = origin;
        this.side = parameter.get(0);
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public double getArea() {
        try {
            return 4 * side;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public double getPerimeter() {
        try {
            double perimeter = Math.round((side * side) * 100) / 100;
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

            double pointX = p.getX();
            double pointY = p.getY();

            double xMax = this.origin.getX() + this.side;
            double yMax = this.origin.getY() + this.side;

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
    public shapeType getShapeType() {
        return shapeType.SQUARE;
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }

}
