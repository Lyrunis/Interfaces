package com.interfaces;

import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectangleLister {

    public static void main(String[] args) {
        // array list size 10
        ArrayList<Rectangle> rectangles = createRectangleList();

        // filter
        BigRectangleFilter filter = new BigRectangleFilter();

        // rect display after filter
        System.out.println("Rectangles with perimeter greater than 10:");
        filterAndDisplayRectangles(rectangles, filter);
    }

    // list of rectangles
    private static ArrayList<Rectangle> createRectangleList() {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(5, 5, 4, 3)); // Perim. = 14
        rectangles.add(new Rectangle(1, 1, 6, 1)); // Perim. = 14
        rectangles.add(new Rectangle(3, 3, 2, 2)); // Perim. = 8
        rectangles.add(new Rectangle(7, 7, 5, 6)); // Perim. = 22
        rectangles.add(new Rectangle(6, 6, 3, 1)); // Perim. = 8
        rectangles.add(new Rectangle(2, 2, 1, 5)); // Perim. = 12
        rectangles.add(new Rectangle(9, 9, 2, 4)); // Perim. = 12
        rectangles.add(new Rectangle(4, 4, 7, 3)); // Perim. = 20
        rectangles.add(new Rectangle(8, 8, 3, 2)); // Perim. = 10
        rectangles.add(new Rectangle(10, 10, 4, 5)); // Perim. = 18
        return rectangles;
    }

    // Filter and display the rectangles that match condition
    private static void filterAndDisplayRectangles(ArrayList<Rectangle> rectangles, Filter filter) {
        for (Rectangle rectangle : rectangles) {
            if (filter.accept(rectangle)) {
                System.out.println(rectangle + " Perimeter: " + (2 * (rectangle.width + rectangle.height)));
            }
        }
    }
}