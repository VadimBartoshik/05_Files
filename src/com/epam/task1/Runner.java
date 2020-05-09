package com.epam.task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {

        String fileName = "people.out";

        ArrayList<People> peopleListSerialization = new ArrayList<>();
        ArrayList<People> peopleListDeserialization = new ArrayList<>();

        peopleListSerialization.add(new People("Bartoshik", "Vadim", 18));
        peopleListSerialization.add(new People("Ivanov", "Ivan", 19));
        peopleListSerialization.add(new People("Lataeva", "Marina", 21));

        try {
            People.serializationPeopleList(peopleListSerialization, fileName);
            People.deserializationPeopleList(peopleListDeserialization, fileName);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
