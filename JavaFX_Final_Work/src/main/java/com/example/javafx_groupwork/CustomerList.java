package com.example.javafx_groupwork;

import java.util.ArrayList;

public class CustomerList {
    ArrayList<GoodsList> customerlist = new ArrayList<GoodsList>();
    public void addToRecordsList(GoodsList rl){
        customerlist.add(rl);
    }
}
