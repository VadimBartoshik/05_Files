package com.epam.task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;


public class Runner {


    public static void main(String[] args) throws IOException {
        File source = new File("C:\\data\\uncle\\mama\\vadik.txt");
        File dest = new File("C:\\data\\uncle\\papa\\j\\1.txt");

        long averageTime = 0;
        // засекаем время до выполнения копирования
        for (int i = 0; i < 1000; i++) {
            averageTime = +copyFileUsingStream(source, dest);
        }
        System.out.println("Average File Copy Time Using Streams = " + (averageTime/1000));
        averageTime = 0;

        for (int i = 0; i < 1000; i++) {
            averageTime = +copyFileUsingChannel(source, dest);
        }
        System.out.println("Average File Copy Time Using java.nio.FileChannel = " + (averageTime/1000));
        averageTime = 0;
        // копируем файл с помощью Apache Commons io
        File source1 = new File("C:\\data\\uncle\\mama\\vadik.txt");
        File dest1 = new File("C:\\data\\uncle\\papa\\j\\2.txt");
            averageTime = + copyFileUsingJava7Files(source1, dest1);

        System.out.println("Average File Copy Time Using Files Java 7 = "+(averageTime));
    }


    private static long copyFileUsingStream(File source, File dest) throws IOException {
        long start = System.nanoTime();
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
            return System.nanoTime() - start;
        }
    }

    private static long copyFileUsingChannel(File source, File dest) throws IOException {
        long start = System.nanoTime();
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            sourceChannel.close();
            destChannel.close();
            return System.nanoTime() - start;
        }
    }

    private static long copyFileUsingJava7Files(File source, File dest) throws IOException {
        long start = System.nanoTime();
        Files.copy(source.toPath(), dest.toPath());
        return System.nanoTime() - start;
    }


}
