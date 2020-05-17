package com.epam.task2;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MaxCountS extends DiskAnalyzer {

    private Map<File, Long> fileCountS = new HashMap<>();

    public MaxCountS(File path) throws NoSuchElementException{
        retrieveCatalogs(path);
        File fileWithMaxS = findCountS();
        printCountSMap();
        System.out.println("File with max count 's' in name : " + fileWithMaxS);
    }

    public void printCountSMap() {
        fileCountS.forEach((key, value) -> {
            System.out.println("FileName : " + key + ", count 's' = " + value);
        });
    }

    public File findCountS() throws NoSuchElementException {
        for (File file : getFileList()) {
            long countS = file.getName().codePoints().filter(ch -> ch == 's').count();
            fileCountS.put(file, countS);
        }
        return Collections.max(fileCountS.entrySet(), (entry1, entry2) ->
                (int) (entry1.getValue() - entry2.getValue())).getKey();
    }
}
