package com.epam.task2;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scannerPath = new Scanner(System.in);
        Scanner scannerChoice= new Scanner(System.in);
        int choiceNumber = 0;
        String path;

        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();
        try {
            while (choiceNumber != 5) {
                System.out.println("enter path:");
                path = scannerPath.nextLine();
                File file = new File(path);
                printChoice();
                choiceNumber = scannerChoice.nextInt();
                diskAnalyzer.choiceFunction(file, choiceNumber);

            }
            scannerPath.close();
            scannerChoice.close();


        } catch (NoSuchElementException ex) {
            System.out.println("There are no files in this directory");
        }


    }

    private static void printChoice() {
        System.out.println("Choose function :");
        System.out.println("1 - Search for the file name with the maximum number of letters ‘s’ in the name");
        System.out.println("2 - Search for the top 5 largest files");
        System.out.println("3 - Search average file size in the specified directory or any subdirectories");
        System.out.println("4 - Show number of files and folders, broken by the first letters of the alphabet");
        System.out.println("5 - Exit");
    }
}
