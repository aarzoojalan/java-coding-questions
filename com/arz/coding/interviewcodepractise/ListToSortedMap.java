package com.arz.coding.interviewcodepractise;

import java.util.*;
import java.util.stream.Collectors;

public class ListToSortedMap {
    public static  void main(String[] args) {
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes( "note1", 11));
        noteLst.add(new Notes( "note2", 22));
        noteLst.add(new Notes( "note3", 33));
        noteLst.add(new Notes( "note4", 44));
        noteLst.add(new Notes( "note5", 55));
        noteLst.add(new Notes( "note4", 66));

        Map<String,Integer> map = noteLst.stream().sorted(Comparator.comparing(Notes::getTagId)
                        .reversed()).collect(Collectors.toMap(Notes::getTagName,Notes::getTagId,(n,m) -> n));
        System.out.println(map);
    }
}
class Notes {

    String note;
    int tagId;

    public Notes( String note, int tagId) {
        this.note = note;
        this.tagId = tagId;
    }


    public String getTagName() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
