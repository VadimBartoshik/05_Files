package com.epam.task1;

import java.io.*;
import java.util.ArrayList;

public class People implements Serializable {
    private String surName;
    private String name;
    private transient int age;

    public People() {

    }

    public People(String surName, String name, int age) {
        this.surName = surName;
        this.name = name;
        this.age = age;

    }

    public static void serializationPeopleList(ArrayList<People> peopleListSerialization,
                                               String fileName) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(peopleListSerialization);
        oos.flush();
        oos.close();
    }

    public static void deserializationPeopleList(ArrayList<People> peopleListDeserialization,
                                                 String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        peopleListDeserialization=((ArrayList<People>)ois.readObject());
        printPeopleList(peopleListDeserialization);
    }

    public static void printPeopleList(ArrayList<People> peopleList){
        for(People p : peopleList)
            System.out.printf("surName: %s \t name: %s \n", p.getSurName(), p.getName());
    }

    public void work() {
        System.out.println("are working");
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
