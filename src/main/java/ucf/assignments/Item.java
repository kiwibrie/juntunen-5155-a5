package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {
    String name;
    String serialnumber;
    double value;

    public Item(String name, String serialnumber, double value){
        setName(name);
        setSerialNumber(serialnumber);
        setValue(value);
    }

    public void setName(String name){
        if(validName(name)){
            this.name = name;
        }
    }

    public String getName(){
        return name;
    }

    public void setSerialNumber(String serialnumber){
        if(validSerialNumber(serialnumber)){
            this.serialnumber = serialnumber;
        }
    }

    public String getSerialNumber(){
        return serialnumber;
    }

    public void setValue(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }

    private boolean validName(String input){
        char[] string = input.toCharArray();
        return (string.length > 1) && (string.length < 257);
    }

    private boolean validSerialNumber(String input){
        if(input.length() == 10){
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher matchSpecial = special.matcher(input);
            return !matchSpecial.find();
        }
        return false;
    }
}
