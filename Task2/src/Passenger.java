//I declare that my work contains no examples of misconduct, such as
//plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//7/8/2022
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
