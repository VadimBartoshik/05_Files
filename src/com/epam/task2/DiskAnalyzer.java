package com.epam.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DiskAnalyzer {

    private ArrayList<File> fileList = new ArrayList<>();
    private ArrayList<File> folderList = new ArrayList<>();

    public void choiceFunction(File path, int functionNumber) throws NoSuchElementException {
        switch (functionNumber) {
            case 1:
                new MaxCountS(path);
                break;
            case 2:
                new TopMaxSizeFiles(path);
                break;
            case 3:
                new AverageFileSize(path);
                break;
            case 4:
                new SortingAlphabetically(path);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Function not selected");
                break;
        }
    }

    public void retrieveCatalogs(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        retrieveCatalogs(file);
                        folderList.add(file);
                    } else {
                        fileList.add(file);
                    }
                }
            }
        }
    }

    public void printListFiles(List<File> fileList) {
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public ArrayList<File> getFolderList() {
        return folderList;
    }

    public ArrayList<File> getFileList() {
        return fileList;
    }
}
