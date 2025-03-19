package FactoryADT.Shape;

public interface Shape {

    static enum shapeType {
        CIRCLE,
        SQUARE,
        RECTANGLE,
        TRIANGLE,
        POLYGON
    }

    double getArea();

    double getPerimeter();

    Point getOrigin();

    boolean isEnclosed(Point p);

    Shape.shapeType getShapeType();

    long getTimeStamp();

}
