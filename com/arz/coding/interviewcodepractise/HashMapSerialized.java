package com.arz.coding.interviewcodepractise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
public class HashMapSerialized implements Serializable {
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        Map<Integer,String> myMap = Map.of(1,"Aarzoo",2,"Jalan");

        try{
            FileOutputStream fileOutputStream = new FileOutputStream
                    ("D:/Self-Study/GitRepository/java-coding-questions/serializedHahMap.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(myMap);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
