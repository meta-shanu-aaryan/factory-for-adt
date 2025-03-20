package FactoryADT.Shape;

import java.util.List;

import FactoryADT.Shape.Shape.shapeType;

public class ShapeFactory {
    /**
     * @param type      shapeType enum, which shape you want, e.g. CIRCLE, SQUARE
     * @param origin    Point of origin
     * @param parameter other parameters depending on Shape type
     * @return Object as per type
     */
    public static Shape createShape(shapeType type, Point origin, List<Integer> parameter) {

        switch (type) {
            case CIRCLE:
                return new Circle(origin, parameter);
            case SQUARE:
                return new Square(origin, parameter);
            case RECTANGLE:
                return new Rectangle(origin, parameter);
            case TRIANGLE:
                return new Triangle(origin, parameter);
            case POLYGON:
                return new Polygon(origin, parameter);
            default:
                throw new IllegalArgumentException("Choose the shape correctly");
        }
    }

}
