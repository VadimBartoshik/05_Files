package com.epam.task2;

import java.io.File;
import java.util.*;

public class TopMaxSizeFiles extends DiskAnalyzer {

    private ArrayList<File> topMaxSizeFilesList = new ArrayList<>();
    private Map<File, Long> fileSizeMap = new HashMap<>();

    public TopMaxSizeFiles(File path) {
        retrieveCatalogs(path);
        findFileSize();
        printSizeMap();
        findTopMaxSizeFiles();
        printListFilesName(topMaxSizeFilesList);
    }


    public void findFileSize() {
        for (File file : getFileList()) {
            long size = file.length();
            fileSizeMap.put(file, size);
        }
    }

    public void findTopMaxSizeFiles() {
        for (int i = 0; i < 5; i++) {
            File maxFileSize = Collections.max(fileSizeMap.entrySet(), (entry1, entry2) ->
                    (int) (entry1.getValue() - entry2.getValue())).getKey();
            fileSizeMap.remove(maxFileSize);
            topMaxSizeFilesList.add(maxFileSize);
        }
    }

    public void printListFilesName(List<File> fileList) {
        System.out.println("Top 5 largest file sizes :");
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath() + " - " + file.length() + " byte");
        }
    }

    public void printSizeMap() {
        fileSizeMap.forEach((key, value) -> {
            System.out.println("FileName : " + key + ", length = " + value + " byte");
        });
    }
}
