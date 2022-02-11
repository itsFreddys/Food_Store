import prodPack.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public interface Menu {

    public static void printMenu(){
        Scanner sc = new Scanner(System.in);        // preparing scanner for user input
        int choice = 1;
        double total = 0;           // will be our total purchase cost

        //  Presenting the user with the store items
        System.out.println("Select from the following items:");
        System.out.println("1) Hotdog\t$2.99 \t| 6) Nachos   $3.65\n" +
                "2) Taco \t$2.75 \t| 7) IceCream $0.99\n" +
                "3) Burrito\t$5.75 \t| 8) Water    $1.25\n" +
                "4) Pizza\t$1.99 \t| 9) Fries    $15.33\n"+
                "5) Soup \t$7.55 \t| 10) Toy     $20.66");

        //  This do while will loop until user inputs 0.
        do{
            System.out.print("\nEnter number of the product that you want, enter 0 when finished: ");
            choice = sc.nextInt();              // Collects user input and stores into choice variable
            if(choice >= 1 && choice <= 10){    // if choice is within range it will be collected
                collectItem(choice);
                Products.incrementCounter();
            } else if (choice != 0){                                     // else if, not in range and not equal to 0,
                System.out.println("Incorrect selection, Try again.");   // we display to user that their input was incorrect
            } else{                                     // if 0 is entered, we dismiss with a thanks
                System.out.println("\nThanks for stopping by.");
            }

        }while (choice != 0);

        if (Products.getTotal() != 0){              // if total cost is not 0, then we continue to get Receipt
            Receipt();
        }                                           // else, this step is skipped and program ends

    }

    // Prints for each product added by user
    public static void printProduct(Products prod) {
        System.out.println("Item " + Products.getCounter()+ ": added [" +
                prod.getNumber() + ") " + prod.getName() + "\t $" + prod.getPrice()+ "]");
        double temp = prod.getPrice();
        Products.addToTotal(temp);                      // pass in the value of the product so the total can be calculated
        Products.addToArray(prod.getNumber());          // user int input is recorded into an arrayList for later use.
        System.out.println("Total Purchase: $" + Products.getTotal());      // Display the customer's total cost after every selection

    }

    // Collects user choice and passes it into a switch statement to be printed
    public static void collectItem(int choice) {
        switch (choice){
            case 1:
                printProduct(Products.hotDog);      // print that it added the item
                break;
            case 2:
                printProduct(Products.taco);
                break;
            case 3:
                printProduct(Products.burrito);
                break;
            case 4:
                printProduct(Products.pizza);
                break;
            case 5:
                printProduct(Products.soup);
                break;
            case 6:
                printProduct(Products.Nachos);
                break;
            case 7:
                printProduct(Products.iceCream);
                break;
            case 8:
                printProduct(Products.water);
                break;
            case 9:
                printProduct(Products.fries);
                break;
            case 10:
                printProduct(Products.toy);
                break;
        }
    }

    // Displays today's date and lets user create a delivery date
    public static void pickDeliveryDate(){
        byte month, day;
        Scanner dateIn = new Scanner(System.in);

        String date = new SimpleDateFormat("MM/dd/YYYY").       // to obtain today's date
                format(Calendar.getInstance().getTime());


        System.out.println("\nPick a date after today's date: "+date);     // user picks month
        System.out.print("Enter Month digit: ");
        month = dateIn.nextByte();

        System.out.print("Enter day digit: ");                              // picks day
        day = dateIn.nextByte();

        // Displays delivery date
        System.out.println("Delivery date has been set to: " + month + "/" + day + "/2022");

    }

    // Prints user Receipt
    public static void Receipt(){
        System.out.println("___________Receipt___________\nItems purchased:");
        Products.printArrayCycle();                  // displays each item purchased
        System.out.println("Total purchase cost: $"+ Products.getTotal());  // shows total
        pickDeliveryDate();                         // calls method for delivery date
    }



}
