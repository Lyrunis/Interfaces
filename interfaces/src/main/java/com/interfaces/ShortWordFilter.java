package com.interfaces;

public class ShortWordFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        // Check if the object is a string and if its length is less than 5
        if (x instanceof String) {
            String str = (String) x;
            return str.trim().length() < 5; // Trimming for extra spaces
        }
        return false; // Reject non-string objects
    }
}
