package com.example.javafx_groupwork;

import java.util.ArrayList;


public class GoodsList {
    static String Name;
    static double Price;
    static String Index;
    ArrayList<Goods> gList = new ArrayList<>();

    public static void AddGoods(ArrayList<Goods> gList){
        Goods g = new Goods();

        g.setName(Name);
        g.setIndex(Index);
        g.setPrice(Price);
        gList.add(g);
    }


    public static void Display(ArrayList<Goods> gList){
        if (gList.size() == 0) {
            System.out.println("请先填入信息");
            return;
        }
        System.out.println("名称\t\t编号\t\t价格");
        for (int i = 0; i < gList.size(); i++) {
            Goods g = gList.get(i);
            System.out.println(g.getName()+ "\t" +g.getIndex()+ "\t\t" +g.getPrice());
        }
    }



}
