//I declare that my work contains no examples of misconduct, such as
//plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//7/8/2022
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FuelQueue {
    public static Scanner input = new Scanner(System.in);

    public static int liters = 6600;
    public static int FuelWarning = 500;
    public static int index = 0;
    public static int total=0;




    public static void array(Passenger[][] fuelArr,Queue waitingQueue[]) {    // initialise the waiting queue
        for (int passengerNumber = 1; passengerNumber < fuelArr.length; passengerNumber++) {
            for (int customerNum = 1; customerNum < fuelArr[passengerNumber].length; customerNum++) {
                fuelArr[passengerNumber][customerNum].setFName("Empty");
                fuelArr[passengerNumber][customerNum].setLName("Empty");
                fuelArr[passengerNumber][customerNum].setVehicle_No("Empty");
                fuelArr[passengerNumber][customerNum].setNoOfLiters(0);
            }
        }
        for (int i = 0;i<6;i++){
            waitingQueue[i] = new Queue("Empty","Empty","Empty",0);
        }
    }


    public static void viewAllQueue(Passenger[][] fuelList) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>View All Queues<<<<<<<<<<<<<<<<<<<<<<<<");
        for (int fuelNumber = 1; fuelNumber < fuelList.length; fuelNumber++) {
            System.out.println("---------Fuel Pump   " + fuelNumber + "-----------");
            for (int passengerNumber = 1; passengerNumber < fuelList[fuelNumber].length; passengerNumber++) {
                if (fuelList[fuelNumber][passengerNumber].getFName().equals("Empty")) {
                    System.out.println("Customer " + passengerNumber + " is Empty");

                } else {
                    System.out.println("Customer " + passengerNumber + " view Queues ");
                    System.out.println(" First Name    :- " + fuelList[fuelNumber][passengerNumber].getFName());
                    System.out.println(" Last Name     :- " + fuelList[fuelNumber][passengerNumber].getLName());
                    System.out.println(" Vehicle Number:- " + fuelList[fuelNumber][passengerNumber].getVehicle_No());
                    System.out.println(" Fuel Liter    :- " + fuelList[fuelNumber][passengerNumber].getNoOfLiters());

                }
            }
            System.out.println();

        }
    }

    public static void viewEmptyQueue(Passenger[][] fuelList) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>View Empty Queues<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        for (int fuelNumber = 1;fuelNumber<fuelList.length;fuelNumber++){
            System.out.println(">>>>>>>>>Fuel Queue " + fuelNumber + ">>>>>>>");
            for (int passengerNumber = 1;passengerNumber<fuelList[fuelNumber].length;passengerNumber++){
                if (fuelList[fuelNumber][passengerNumber].getFName().equals("Empty")){
                    System.out.println(passengerNumber + " Customer is Empty ");
                }
            }
            System.out.println();
        }

    }



    public static void addCustomerQueue(Passenger[][] fuelList,Queue waitingQueue[]){
        try {
            int fuelNumber = 0;
            int passengerNumber;


            while(true){
                if (pumpSearch(fuelList)){
                    if(index<6){
                        System.out.println("All pumps are full now stay the waiting list");
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Enter your First Name: ");
                        waitingQueue[index].setFName(sc.next());

                        System.out.println("Enter your Last Name: ");
                        waitingQueue[index].setLName(sc.next());

                        System.out.println("Enter your Vehicle Number: ");
                        waitingQueue[index].setVehicle_No(sc.next());

                        System.out.println("How much fuel liter do you want: ");
                        waitingQueue[index].setNoOfLiters(sc.nextInt());
                        System.out.println("--------------------------------");
                        index+=1;
                    }
                    else{
                        System.out.println("\n Waiting list is full now \n");
                    }
                    Main.mainMenu(fuelList,waitingQueue);
                }


                System.out.println("---------------------------------------------------------------------");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Add Customer to a Queue<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println();
                System.out.println("Enter a pump number 1/2/3/4/5 or enter 6 go to the main menu:");
                fuelNumber = input.nextInt();


                if(fuelNumber==6){
                    Main.mainMenu(fuelList,waitingQueue);
                } else{
                    if (fuelNumber>=fuelList.length){
                        System.err.println("not in range");
                        addCustomerQueue(fuelList,waitingQueue);
                        break;
                    }
                    for (;fuelNumber<fuelList.length;fuelNumber++){
                        for (passengerNumber=1;passengerNumber<fuelList[fuelNumber].length;passengerNumber++){
                            if(fuelList[fuelNumber][passengerNumber].getFName().equals("Empty")){
                                if(fuelList[fuelNumber][passengerNumber].getFName().equals("Empty")){


                                    System.out.println("Enter your First name: ");
                                    if(input.hasNext()){
                                        String FirstName = input.next().toUpperCase();
                                        fuelList[fuelNumber][passengerNumber].setFName(FirstName);
                                    }
                                    else{
                                        System.out.println("Please enter valid name as your first name");
                                    }

                                    System.out.println("Enter your Last name: ");
                                    if(input.hasNext()){
                                        String LastName = input.next().toUpperCase();
                                        fuelList[fuelNumber][passengerNumber].setLName(LastName);
                                    }
                                    else{
                                        System.out.println("Please enter valid name as your first name");
                                    }

                                    System.out.println("Enter your vehicle number: ");
                                    if(input.hasNext()){
                                        String vehicle_No = input.next().toUpperCase();
                                        fuelList[fuelNumber][passengerNumber].setVehicle_No(vehicle_No);
                                    }
                                    else{
                                        System.out.println("Please enter valid vehicle number");
                                    }

                                    System.out.println("How much fuel liters do you want: ");
                                    if(input.hasNextInt()){
                                        int no_Of_Liters = input.nextInt();
                                        fuelList[fuelNumber][passengerNumber].setNoOfLiters(no_Of_Liters);
                                    }
                                    else{
                                        System.out.println("Please enter valid number");
                                        fuelList[fuelNumber][passengerNumber].setFName("Empty");
                                        fuelList[fuelNumber][passengerNumber].setLName("Empty");
                                        fuelList[fuelNumber][passengerNumber].setVehicle_No("Empty");
                                        fuelList[fuelNumber][passengerNumber].setNoOfLiters(0);
                                        Main.mainMenu(fuelList,waitingQueue);
                                    }

                                    System.out.println("Pump" + fuelNumber + "----" + passengerNumber + "st Customer ");
                                    System.out.println("First Name    :-" + fuelList[fuelNumber][passengerNumber].getFName());
                                    System.out.println("Last Name     :-" + fuelList[fuelNumber][passengerNumber].getLName());
                                    System.out.println("Vehicle Number:-" + fuelList[fuelNumber][passengerNumber].getVehicle_No());
                                    System.out.println("No of Liters  :-" + fuelList[fuelNumber][passengerNumber].getNoOfLiters());
                                    addCustomerQueue(fuelList,waitingQueue);
                                }
                                else {
                                    System.out.println();
                                    System.out.println("Pump number " + fuelNumber + " Customer " + passengerNumber + "is already in " + fuelList[fuelNumber][passengerNumber].getFName());
                                    System.out.println();
                                }
                                addCustomerQueue(fuelList,waitingQueue);
                            }

                        }
                        System.err.println("\nPump Number " + fuelNumber + " Customer capacity(6) exceeded Please choose a pump number");
                        break;
                    }
                }

            }

        }
        catch (Exception e){
            System.err.println("Invalid input\n");
            input.nextLine();

        }
    }

    public static boolean pumpSearch(Passenger[][] fuelList){    // check the main to add the customer data to waiting queue array
        int pumps = 0;
        for (int fuelNumber = 1;fuelNumber<fuelList.length;fuelNumber++){
            for (int passengerNumber = 1;passengerNumber<fuelList[fuelNumber].length;passengerNumber++){
                if (!fuelList[fuelNumber][passengerNumber].getFName().equals("Empty")){
                    pumps+=1;
                }
            }
        }
        if (pumps==30){  //30
            return true;
        }
        return false;
    }

    public static void removeCustomerQueue(Passenger[][] fuelList){
        System.out.println("--------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Remove a Customer from Queue<<<<<<<<<<<<<<<<<<");
        System.out.println("Enter Customer name to remove :");
        String removeName = input.next().toUpperCase();
        boolean customerIn = false;
        for(int fuelNumber = 1;fuelNumber<fuelList.length;fuelNumber++){
            for (int passengerNumber=1;passengerNumber<fuelList[fuelNumber].length;passengerNumber++){
                if(fuelList[fuelNumber][passengerNumber].getFName().equals(removeName)){
                    fuelList[fuelNumber][passengerNumber].setFName("Empty");
                    fuelList[fuelNumber][passengerNumber].setLName("Empty");
                    fuelList[fuelNumber][passengerNumber].setVehicle_No("Empty");
                    fuelList[fuelNumber][passengerNumber].setNoOfLiters(0);

                    System.out.println("Fuel Queue " + fuelNumber + " Removed Customer Name " + "----> " + removeName);
                    customerIn=true;
                }
            }
        }
        if(!customerIn){
            System.out.println(removeName + " No customer here ");
        }

    }
    public static int removeServedCustomer(Passenger[][] fuelList,Queue waitingQueue[]) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>Remove a Served Customer from Queue<<<<<<<<<<<<<<<<");



        for(int fuelNumber=1;fuelNumber<fuelList.length;fuelNumber++) {
            for (int passengerNumber = 1; passengerNumber < fuelList[fuelNumber].length; passengerNumber++) {
                if (!fuelList[fuelNumber][passengerNumber].getFName().equals("Empty")) {

                    liters = liters - fuelList[fuelNumber][passengerNumber].getNoOfLiters();
                    total = total + fuelList[fuelNumber][passengerNumber].getNoOfLiters()*430;

                    fuelList[fuelNumber][passengerNumber].setFName("Empty");
                    fuelList[fuelNumber][passengerNumber].setLName("Empty");
                    fuelList[fuelNumber][passengerNumber].setVehicle_No("Empty");
                    fuelList[fuelNumber][passengerNumber].setNoOfLiters(0);


                    System.out.println(" Fuel Queue " + fuelNumber + " Customer " + passengerNumber + "--> " + "served ");

                    break;
                }
            }

        }

        return liters;

    }

    public static void viewCustomersSorted(Passenger[][] fuelList){
        System.out.println("--------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>View Customer Sorted<<<<<<<<<<<<<<<<<<<<<<<<<");
        String sort[] = new String[30];
        int set = 0;
        for(int fuelNumber=1;fuelNumber<fuelList.length;fuelNumber++ ){
            for (int passengerNumber=1;passengerNumber<fuelList[fuelNumber].length;passengerNumber++){
                sort[set++]=fuelList[fuelNumber][passengerNumber].getFName();
            }
        }


        String sortTemp;
        for (int j = 0;j<sort.length;j++){
            for (int i = j+1;i<sort.length-1;i++){
                if (sort[i].compareTo(sort[j]) < 0){
                    sortTemp = sort[j];
                    sort[j] = sort[i];
                    sort[i] = sortTemp;
                }
            }
            if (!sort[j].equals("Empty")){
                System.out.println(sort[j]);
            }
        }

    }
    public static void storeProgramFile(Passenger[][] fuelList) throws IOException {
        System.out.println("---------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Store Program File<<<<<<<<<<<<<<<<<<<<<<<<<,<<");
        try(FileWriter file = new FileWriter("File.txt")){
            for (int fuelNumber = 1; fuelNumber < fuelList.length;fuelNumber++){
                for (int passengerNumber = 1;passengerNumber<fuelList[fuelNumber].length;passengerNumber++){
                    file.write("Pump number              :-- " + fuelNumber + "  Customer:- " + passengerNumber +  "\n");
                    file.write("Customer First Name      :-  "  + fuelList[fuelNumber][passengerNumber].getFName() + "\n");
                    file.write("Customer Last Name       :-  " + fuelList[fuelNumber][passengerNumber].getLName() + "\n");
                    file.write("Customer's Vehicle Number:-  "   + fuelList[fuelNumber][passengerNumber].getVehicle_No() + "\n");
                    file.write("Customer's No of Liters  :-  "   + fuelList[fuelNumber][passengerNumber].getNoOfLiters() + "\n");
                }
            }
            file.close();
            System.out.println();
            System.out.println("Customer Data Stored Successfully into the file.....");
            System.out.println();
        }
    }
    public static void loadProgramData() throws FileNotFoundException {
        System.out.println("--------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Load Program Data<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        try {
            Scanner loadFile = new Scanner(new File("File.txt"));
            while (loadFile.hasNext()) {
                System.out.println(loadFile.nextLine());

            }
            System.out.println("Successfully Loaded from the file.......");
            loadFile.close();
        }
        catch (Exception e){
            System.err.println("There is no file or data here");
            input.nextLine();
        }
    }
    public static void viewRemainingFuel(int liters) throws IOException {
        System.out.println("--------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>View Remaining Fuel<<<<<<<<<<<<<<<<<<<<<<<<<<");
        if(liters<=FuelWarning){
            System.out.println("You don't have enough fuel to serve!!!!!!!");
        }
        else{
            System.out.println("You have enough fuel to serve: " + liters);
        }

        FileWriter remain = new FileWriter("remainFuel.txt");
        remain.write("You have " + liters + " now.");
        remain.close();

    }

    public static void addFuelStock(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Add Fuel Stock<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        if(liters==FuelWarning){
            System.out.println(liters + 6100 + " liters added ");

        }
        else {
            int used  = 6600 - liters;
            liters = used + liters;
            System.out.println("Fuel Stock " + liters + " Available now ");

        }




    }
    public static void incomeFuelQueue(Passenger[][] fuelList){
        System.out.println("--------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Income of a Queue Stock<<<<<<<<<<<<<<<<<<<<<<");


        System.out.println("All Served pump Queues Income is Rs: " + total);

    }


    public static void exitTheProgram(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Exit The Program<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("Successfully Exited from the program ......");
        System.exit(0);


    }



}
