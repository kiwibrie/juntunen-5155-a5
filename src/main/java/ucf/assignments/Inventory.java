package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> inventoryList;

    public Inventory(){
        this.inventoryList = new ArrayList<>();
    }

    public void addItem(String name, String serial, double value){
        inventoryList.add(new Item(name, serial, value));
    }

    //todo getItem? getItemByName
    //getItemBySerial
    //getItemByIndex

    public void deleteItem(Item item){
        inventoryList.remove(item);
    }

    public List<Item> searchByName(String name){
        List<Item> list = new ArrayList<>();
        for (Item item : inventoryList) {
            if (item.getName().equals(name)) {
                list.add(item);
            }
        }
        return list;
    }

    public List<Item> searchBySerial(String serial){
        List<Item> list = new ArrayList<>();
        for (Item item : inventoryList) {
            if (item.getSerialNumber().equals(serial)) {
                list.add(item);
            }
        }
        return list;
    }

    public void saveTSV(){
        //todo saveTSV
    }

    public void loadTSV(){
        //todo loadTSV
    }

    public void saveHTML(){
        //todo saveHTML
    }
    
    public void loadHTML(){
        //todo loadHTML
    }

    //todo json
}
