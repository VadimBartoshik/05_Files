package com.epam.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingAlphabetically extends DiskAnalyzer {

    private List<Character> firstLetterFileList = new ArrayList<>();
    private List<Character> firstLetterFolderList = new ArrayList<>();

    public SortingAlphabetically(File path) throws NoSuchElementException  {
        retrieveCatalogs(path);
        findFirstLetter(getFileList(), firstLetterFileList);
        findFirstLetter(getFolderList(), firstLetterFolderList);
        System.out.println("Files list:");
        countFirstLetter(firstLetterFileList);
        System.out.println("Folders list:");
        countFirstLetter(firstLetterFolderList);
    }

    public void findFirstLetter(List<File> list, List<Character> firstLetterList) {
        char firstLetter;
        for (File file : list) {
            firstLetter = file.getName().charAt(0);
            firstLetterList.add(firstLetter);
        }
    }

    public void countFirstLetter(List<Character> firstLetterList) throws NoSuchElementException {
        if (firstLetterFileList.size() == 0 && firstLetterFolderList.size() == 0) {
            throw new NoSuchElementException();
        }
        else {
            Map<Character, Long> result =
                    firstLetterList.stream().collect(
                            Collectors.groupingBy(
                                    Function.identity(), Collectors.counting()
                            )
                    );

            System.out.println(result);
        }
    }


    public void printFirstLetter(List<Character> firstLetterList) {
        for (Character character : firstLetterList) {
            System.out.println(character);
        }
    }

}
