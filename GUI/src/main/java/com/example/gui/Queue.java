//I declare that my work contains no examples of misconduct, such as
//plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//7/8/2022
package com.example.gui;

public class Queue {
    String FName;
    String LName;
    String Vehicle_No;
    int NoOfLiters;

    public Queue(String FName,String LName,String Vehicle_No,int NoOfLiters){
        this.FName=FName;
        this.LName=LName;
        this.Vehicle_No=Vehicle_No;
        this.NoOfLiters=NoOfLiters;

    }
    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getVehicle_No() {
        return Vehicle_No;
    }

    public void setVehicle_No(String vehicle_No) {
        this.Vehicle_No = vehicle_No;
    }

    public int getNoOfLiters() {
        return NoOfLiters;
    }

    public void setNoOfLiters(int noOfLiters) {
        this.NoOfLiters = noOfLiters;
    }
}
