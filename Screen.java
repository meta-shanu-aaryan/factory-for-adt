package FactoryADT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import FactoryADT.Shape.Point;
import FactoryADT.Shape.Shape;

//Classes overriding compare of Comparator for modified sorting
class shapeAreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return (int) (o1.getArea() - o2.getArea());
    }

}

class shapePerimeterComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return (int) (o1.getPerimeter() - o2.getPerimeter());
    }

}

class shapeDistanceComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return (int) (Point.getDistance(new Point(0, 0), o1.getOrigin())
                - Point.getDistance(new Point(0, 0), o2.getOrigin()));
    }

}

class shapeTimestampComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return (int) (o1.getTimeStamp() - o2.getTimeStamp());
    }

}

public class Screen {

    enum compareBy {
        AREA,
        PERIMETER,
        TIMESTAMP,
        DISTANCE
    }

    List<Shape> shapeList;
    int xMax;
    int yMax;

    /**
     * @param xMax Max X axis of screen
     * @param yMax Max Y axis of screen
     */
    public Screen(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
        shapeList = new ArrayList<>();
    }

    /**
     * @param shape Object to add in list
     * @return true if object added to screen else false
     */
    public boolean addShape(Shape shape) {
        try {
            return shapeList.add(shape);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @param shape Object to delete in list
     * @return true if object deleted from screen else false
     */
    public boolean deleteShape(Shape shape) {
        try {
            return shapeList.remove(shape);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @param shape ShapeType the shape to be deleted
     * @return true if deleted successfully, else false
     */
    public boolean deleteAllShape(Shape.shapeType shape) {
        try {

            for (int i = 0; i < shapeList.size(); i++) {
                if (shapeList.get(i).getShapeType() == shape)
                    shapeList.remove(i);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @param c in which parameter sorting is to be performed
     * @return sorted list according to parameter
     */
    List<Shape> sortedList(compareBy c) {
        try {
            List<Shape> sorteList = new ArrayList<>(shapeList);
            switch (c) {
                case AREA:
                    Collections.sort(sorteList, new shapeAreaComparator());
                    break;
                case PERIMETER:
                    Collections.sort(sorteList, new shapePerimeterComparator());
                    break;
                case DISTANCE:
                    Collections.sort(sorteList, new shapeDistanceComparator());
                    break;
                case TIMESTAMP:
                    Collections.sort(sorteList, new shapeTimestampComparator());
                    break;
                default:
                    break;
            }

            return sorteList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * @param p The point to check is enclosed by all shapes
     * @return true if it is inside all shapes else false
     */
    public boolean isPointInsideAll(Point p) {
        try {

            for (Shape shape : shapeList) {
                if (!shape.isEnclosed(p)) {
                    return false;
                }
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
