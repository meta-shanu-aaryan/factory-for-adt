package FactoryADT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import FactoryADT.Shape.Point;
import FactoryADT.Shape.Shape;
import FactoryADT.Shape.ShapeFactory;

public class Main {

    public int intScanner() {
        int n;
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                n = sc.nextInt();
                if (n >= 0) {
                    break;
                } else {
                    System.out.println("enter positive integer only");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Enter integer value only");
                continue;
            }
        }
        // sc.close();
        return n;
    }

    public double doubleScanner() {
        Scanner sc = new Scanner(System.in);
        double n;
        while (true) {
            try {
                n = sc.nextDouble();
                if (n >= 0) {
                    break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Enter integer value only");
            }
        }

        // sc.close();
        return n;
    }

    public static void main(String[] args) {
        try {
            Main m = new Main();
            Screen screen = new Screen(100, 100);

            while (true) {

                System.out.println("Welcome to Shape Factory...");
                System.out.println("1.\tAdd shape to screen");
                // System.out.println("2.\tDelete Specific shape from screen");
                System.out.println("2.\tDelete shape type from screen");
                System.out.println("3.\tSort shape in screen");
                System.out.println("4.\tPrint shapes in screen");
                System.out.println("5.\tCheck if a point lies inside all shapes in screen");
                System.out.println("6.\tExit...");
                int choice = m.intScanner();

                switch (choice) {
                    case 1:
                        System.out.println("Choose Shape");
                        System.out.println("1.\tCIRCLE");
                        System.out.println("2.\tSQUARE");
                        System.out.println("3.\tRECTANGLE");
                        System.out.println("4.\tTRIANGLE");
                        System.out.println("5.\tPOLYGON");
                        int shapeChoice = m.intScanner();
                        try {
                            switch (shapeChoice) {
                                case 1:
                                    System.out.println("Enter origin axis and radius");
                                    int originX = m.intScanner();
                                    int originY = m.intScanner();
                                    int radius = m.intScanner();
                                    screen.addShape(ShapeFactory.createShape(Shape.shapeType.CIRCLE,
                                            new Point(originX, originY), Arrays.asList(radius)));
                                    break;

                                case 2:
                                    System.out.println("Enter origin axis and side");
                                    originX = m.intScanner();
                                    originY = m.intScanner();
                                    int side = m.intScanner();
                                    screen.addShape(ShapeFactory.createShape(Shape.shapeType.SQUARE,
                                            new Point(originX, originY), Arrays.asList(side)));
                                    break;
                                case 3:
                                    System.out.println("Enter origin axis, length and breadth");
                                    originX = m.intScanner();
                                    originY = m.intScanner();
                                    int Length = m.intScanner();
                                    int breadth = m.intScanner();
                                    screen.addShape(ShapeFactory.createShape(Shape.shapeType.RECTANGLE,
                                            new Point(originX, originY), Arrays.asList(Length, breadth)));
                                    break;
                                case 4:
                                    System.out.println("Enter axis of 3 points");
                                    originX = m.intScanner();
                                    originY = m.intScanner();
                                    int p2X = m.intScanner();
                                    int p2Y = m.intScanner();
                                    int p3X = m.intScanner();
                                    int p3Y = m.intScanner();
                                    screen.addShape(ShapeFactory.createShape(Shape.shapeType.TRIANGLE,
                                            new Point(originX, originY), Arrays.asList(p2X, p2Y, p3X, p3Y)));
                                    break;

                                case 5:
                                    System.out.println("Enter number of sides");
                                    int sideNum = m.intScanner();
                                    System.out.println("Enter axis of all the points");
                                    originX = m.intScanner();
                                    originY = m.intScanner();
                                    ArrayList<Integer> parameters = new ArrayList<>();
                                    for (int i = 0; i < 2 * (sideNum - 1); i++) {
                                        parameters.add(m.intScanner());
                                    }
                                    screen.addShape(ShapeFactory.createShape(Shape.shapeType.POLYGON,
                                            new Point(originX, originY), parameters));
                                    break;
                                default:
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("Shape added to screen");
                        break;
                    case 2:
                        System.out.println("Choose Shape");
                        System.out.println("1.\tCIRCLE");
                        System.out.println("2.\tSQUARE");
                        System.out.println("3.\tRECTANGLE");
                        System.out.println("4.\tTRIANGLE");
                        System.out.println("5.\tPOLYGON");
                        int deleteChoice = m.intScanner();
                        switch (deleteChoice) {
                            case 1:
                                if (screen.deleteAllShape(Shape.shapeType.CIRCLE)) {
                                    System.out.println("Deleted");
                                }
                                break;
                            case 2:
                                if (screen.deleteAllShape(Shape.shapeType.SQUARE)) {
                                    System.out.println("Deleted");
                                }
                                break;
                            case 3:
                                if (screen.deleteAllShape(Shape.shapeType.RECTANGLE)) {
                                    System.out.println("Deleted");
                                }
                                break;
                            case 4:
                                if (screen.deleteAllShape(Shape.shapeType.TRIANGLE)) {
                                    System.out.println("Deleted");
                                }
                                break;
                            case 5:
                                if (screen.deleteAllShape(Shape.shapeType.POLYGON)) {
                                    System.out.println("Deleted");
                                }
                                break;
                            default:
                                System.out.println("Wrong choice entered");
                                break;
                        }

                        break;
                    case 3:
                        System.out.println("Choose How you want to sort");
                        System.out.println("1.\tAREA");
                        System.out.println("2.\tPERIMETER");
                        System.out.println("3.\tORIGIN DISTANCE");
                        System.out.println("4.\tTIMESTAMP");

                        int sortChoice = m.intScanner();
                        switch (sortChoice) {
                            case 1:
                                for (Shape shape : screen.sortedList(Screen.compareBy.AREA)) {
                                    System.out.println(shape.getArea());
                                }
                                break;
                            case 2:
                                for (Shape shape : screen.sortedList(Screen.compareBy.PERIMETER)) {
                                    System.out.println(shape.getPerimeter());
                                }
                                break;
                            case 3:
                                for (Shape shape : screen.sortedList(Screen.compareBy.DISTANCE)) {
                                    System.out.println(shape.getOrigin());
                                }
                                break;
                            case 4:
                                for (Shape shape : screen.sortedList(Screen.compareBy.TIMESTAMP)) {
                                    System.out.println(shape.getTimeStamp());
                                }
                                break;

                            default:
                                break;
                        }
                        break;
                    case 4:
                        for (Shape shape : screen.shapeList) {
                            System.out.println(shape.getShapeType());
                        }
                        break;
                    case 5:
                        int axisX = m.intScanner();
                        int axisY = m.intScanner();
                        if (screen.isPointInsideAll(new Point(axisX, axisY))) {
                            System.out.println("Point is inside all shapes");
                        } else {
                            System.out.println("NOPE it is not inside all");
                        }
                        break;
                    case 6:
                        break;
                    default:
                        break;
                }
                if (choice == 6) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }
}
