//I declare that my work contains no examples of misconduct, such as
//plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1898902
//7/8/2022
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        Passenger[][]  fuelList = new Passenger[6][7]; //7
        Queue[] waitingQueue = new Queue[6];

        for(int passengerNumber = 1;passengerNumber<fuelList.length;passengerNumber++){
            for(int detail = 1;detail<fuelList[passengerNumber].length;detail++){
                fuelList[passengerNumber][detail] = new Passenger();

            }
        }

        Main main = new Main();
        FuelQueue.array(fuelList,waitingQueue);
        main.mainMenu(fuelList,waitingQueue);


    }

    public static void mainMenu(Passenger[][] fuelList,Queue[] waitingQueue) throws IOException {
        while(true) {

            System.out.println("!!!! Welcome to Fuel Station !!!!");
            System.out.println("--------------------------------------------------------");
            System.out.println("""
                100 or VFQ:- View all Fuel Queues.
                101 or VEQ:- View all Empty Queues.
                102 or ACQ:- Add customer to a Queue.
                103 or RCQ:- Remove a customer from a Queue. (From a specific location)
                104 or PCQ:- Remove a served customer.
                105 or VCS:- View Customers Sorted in alphabetical order (Do not use library sort routine)
                106 or SPD:- Store Program Data into file.
                107 or LPD:- Load Program Data from file.
                108 or STK:- View Remaining Fuel Stock.
                109 or AFS:- Add Fuel Stock.
                110 or IFQ:- Income Fuel Queue.
                999 or EXT:- Exit the Program.
                """);
            System.out.println("-------------------------------------------------------");
            System.out.println();
            System.out.print("Enter a number from the list: ");
            String choice = input.next();
            String choice1 = choice.toUpperCase();
            switch (choice1) {
                case "100", "VFQ":
                    FuelQueue.viewAllQueue(fuelList);
                    break;
                case "101", "VEQ":
                    FuelQueue.viewEmptyQueue(fuelList);
                    break;
                case "102", "ACQ":
                    FuelQueue.addCustomerQueue(fuelList,waitingQueue);
                    break;
                case "103", "RCQ":
                    FuelQueue.removeCustomerQueue(fuelList);
                    break;
                case "104", "PCQ":
                    FuelQueue.removeServedCustomer(fuelList,waitingQueue);
                    break;
                case "105", "VCS":
                    FuelQueue.viewCustomersSorted(fuelList);
                    break;
                case "106", "SPD":
                    FuelQueue.storeProgramFile(fuelList);
                    break;
                case "107", "LPD":
                    FuelQueue.loadProgramData();
                    break;
                case "108", "STK":
                    FuelQueue.viewRemainingFuel(FuelQueue.liters);
                    break;
                case "109", "AFS":
                    FuelQueue.addFuelStock();
                    break;
                case "110", "IFQ":
                    FuelQueue.incomeFuelQueue(fuelList);
                    break;
                case "999", "EXT":
                    FuelQueue.exitTheProgram();
                    break;
                default:
                    System.out.println("Please Choose your choice from above list !!!");
                    break;
            }
        }

    }
}
