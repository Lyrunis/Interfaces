package com.interfaces;

import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {

    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle rect = (Rectangle) x;
            return calculatePerimeter(rect) > 10; // Only accept rectangles with perimeter > 10
        }
        return false;
    }

    // calculate the perimeter of a rectangle
    private int calculatePerimeter(Rectangle rect) {
        return 2 * (rect.width + rect.height);
    }
}