package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    List<Item> inventoryList;

    public Inventory(){
        this.inventoryList = new ArrayList<>();
    }

    public void addItem(String name, String serial, double value){
        if(!duplicateSerialExists(serial)){
            inventoryList.add(new Item(name, serial, value));
        }
    }

    public void deleteItem(Item item){
        inventoryList.remove(item);
    }

    public List<Item> searchByName(String name){
        List<Item> list = new ArrayList<>();
        for (Item item : inventoryList) {
            if (item.getName().contains(name)) {
                list.add(item);
            }
        }
        return list;
    }

    public List<Item> searchBySerial(String serial){
        List<Item> list = new ArrayList<>();
        for (Item item : inventoryList) {
            if (item.getSerialNumber().contains(serial)) {
                list.add(item);
            }
        }
        return list;
    }

    public boolean duplicateSerialExists(String serial){
        List<Item> list = new ArrayList<>();
        for (Item item : inventoryList) {
            if (item.getSerialNumber().equals(serial)) {
                list.add(item);
            }
        }
        return list.size() >= 1;
    }

    public void saveTSV(File file) throws IOException {
        FileWriter writer = new FileWriter(file);

        writer.write("name\tserial\tvalue\n");
        for (Item item : inventoryList) {
            writer.write(item.getName() + "\t");
            writer.write(item.getSerialNumber() + "\t");
            writer.write(item.getValue() + "\t");
            writer.write("\n");
        }

        writer.close();
    }

    public void loadTSV(File file) throws IOException {
        Scanner reader = new Scanner(file);
        Inventory new_inventory = new Inventory();

        if(reader.nextLine().equals("name\tserial\tvalue")){
            while(reader.hasNextLine()){
                String[] input = reader.nextLine().split("\t");
                double formatted_price = Double.parseDouble(input[2].substring(1));
                new_inventory.addItem(input[0], input[1], formatted_price);
            }
            this.inventoryList = new_inventory.inventoryList;
        }
        reader.close();
    }

    public void saveHTML(File file) throws IOException {
        FileWriter writer = new FileWriter(file);

        writer.write("<table style=\"width:100%\">\n");
        writer.write("<tr><th>Name</th><th>Serial Number</th><th>Value</th></tr>\n");
        for (Item item : inventoryList) {
            writer.write("<tr>");
            writer.write("<td>"+ item.getName() +"</td>");
            writer.write("<td>"+ item.getSerialNumber() +"</td>");
            writer.write("<td>"+ item.getValue() +"</td>");
            writer.write("</tr>\n");
        }
        writer.write("</table>");

        writer.close();
    }
    
    public void loadHTML(File file) throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        Inventory new_inventory = new Inventory();

        if(reader.nextLine().equals("<table style=\"width:100%\">")){
            reader.nextLine();
            while(reader.hasNextLine()){
                String[] input = reader.nextLine().split("</td>");
                if(input.length == 1){
                    break;
                }

                String formatted_name = input[0].substring(8);
                String formatted_serial = input[1].substring(4);
                double formatted_value = Double.parseDouble(input[2].substring(5));
                new_inventory.addItem(formatted_name, formatted_serial, formatted_value);
            }
            this.inventoryList = new_inventory.inventoryList;
        }
        reader.close();
    }

    public void saveJSON(File file){

    }

    public void loadJSON(File file){

    }
}
