package com.example.admin.xo;

import android.database.Cursor;

import java.util.ArrayList;

public class ModelTxt {
    int id;
    String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ModelTxt(int id, String text) {

        this.id = id;
        this.text = text;
    }
    public static ArrayList<ModelTxt> cursorToArray (Cursor input){
        ArrayList<ModelTxt> output = new ArrayList<>();
        while(input.moveToNext()){
            output.add(new ModelTxt(input.getInt(0),input.getString(1)));
        }
        return output;
    }
}
