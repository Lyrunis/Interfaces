package com.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class ShortLister {
    
    // Method to filter and print short words from a file
    public static void processFileWithFilter(File file, Filter filter) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            int shortWordCount = 0;
            System.out.println("Short words in the file \"" + file.getName() + "\":");
            
            // Loop through the file and apply the filter
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (filter.accept(word)) {
                    System.out.println(word);
                    shortWordCount++;
                }
            }
            
            // Output the number of short words
            System.out.println("\nTotal number of short words (<5 characters): " + shortWordCount);
        }
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected. Exiting.");
            return;
        }

        File file = chooser.getSelectedFile();
        ShortWordFilter filter = new ShortWordFilter();
        
        try {
            // Process the selected file using the filter
            processFileWithFilter(file, filter);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }
}
