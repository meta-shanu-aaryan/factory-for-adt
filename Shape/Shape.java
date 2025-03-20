package FactoryADT.Shape;

public interface Shape {

    static enum shapeType {
        CIRCLE,
        SQUARE,
        RECTANGLE,
        TRIANGLE,
        POLYGON
    }

    /**
     * @return area of the shape
     */
    double getArea();

    /**
     * @return perimeter of shape
     */
    double getPerimeter();

    /**
     * @return Origin of the shape
     */
    Point getOrigin();

    /**
     * @param p point to check if this exist in the shape
     * @return true if exist inside else false
     */
    boolean isEnclosed(Point p);

    /**
     * @return the type of shape e.g. square, rectangle
     */
    Shape.shapeType getShapeType();

    /**
     * @return timestamp of the shape on which it was added to screen
     */
    long getTimeStamp();

}
