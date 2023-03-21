package com.example.gui;

public class Passenger {
    private  String FName;
    private  String LName;
    private String Vehicle_No;
    private int NoOfLiters;





    public Passenger(){   // Constructor class

        FName = "";
        LName = "";
        Vehicle_No = "";
        NoOfLiters = 0;

    }

    public  String getFName() {
        return FName;
    }

    public  void setFName(String FName) {
        this.FName = FName;
    }

    public  String getLName() {
        return LName;
    }

    public  void setLName(String LName) {
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
