package FactoryADT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import FactoryADT.Shape.Point;
import FactoryADT.Shape.Shape;

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

    public Screen(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
        shapeList = new ArrayList<>();
    }

    public boolean addShape(Shape shape) {
        try {
            return shapeList.add(shape);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteShape(Shape shape) {
        try {
            return shapeList.remove(shape);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

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
                case TIMESTAMP:
                    Collections.sort(sorteList, new shapeTimestampComparator());
                default:
                    break;
            }

            return sorteList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

}
