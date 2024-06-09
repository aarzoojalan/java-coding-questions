package com.arz.coding.interviewcodepractise;

import java.io.*;;
import java.util.Map;

public class HashMapDeserialized {
    public static void main(String[] args)  throws  IOException,RuntimeException{
        Map<Integer,String> newMap = null;
        try{
            FileInputStream fileInputStream = new FileInputStream
                    ("D:/Self-Study/GitRepository/java-coding-questions/serializedHahMap.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            newMap = (Map) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        for(Map.Entry<Integer,String> map : newMap.entrySet()){
           System.out.println(map.getKey() + " "+ map.getValue());
        }
    }
}
