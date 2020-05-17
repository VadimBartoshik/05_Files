package com.epam.task2;

import java.io.File;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AverageFileSize extends DiskAnalyzer {

    private List<Long> fileSizeList = new ArrayList<>();

    public AverageFileSize(File path) throws NoSuchElementException {
        retrieveCatalogs(path);
        findFileSize();
        printAverageSize(countAverageFileSize());
    }

    public double countAverageFileSize() {
        OptionalDouble average = fileSizeList.stream().mapToLong(e -> e).average();
        if (average.isPresent()) {
            return average.getAsDouble();
        } else return 0;
    }

    public void findFileSize() throws NoSuchElementException {
        if (getFileList().size() == 0) {
            throw new NoSuchElementException();
        } else {
            for (File file : getFileList()) {
                fileSizeList.add(file.length());
            }
        }
    }

    public void printAverageSize(double average) {

        System.out.println("Average file size = " + String.format("%.0f", average) + " byte");
    }
}
