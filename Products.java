package prodPack;

import java.util.ArrayList;

public class Products {
    // Instance Variables
    private int number;
    private String name;
    private double price = 0.00;
    private static int counter = 1;
    private static double total = 0;

    //  Objects of class Products
    public static Products hotDog = new Products(1,"Hotdog",2.99);
    public static Products taco = new Products(2,"Taco",2.75);
    public static Products burrito = new Products(3,"Burrito",5.75);
    public static Products pizza = new Products(4,"Pizza",1.99);
    public static Products soup = new Products(5,"Soup",7.55);
    public static Products Nachos = new Products(6,"Nachos",3.65);
    public static Products iceCream = new Products(7,"Ice Cream",.99);
    public static Products water = new Products(8,"Water",1.25);
    public static Products fries = new Products(9,"Fries",15.33);
    public static Products toy = new Products(10,"Toy",20.66);

    //  Constructor for Products that accepts and initiates number, name, price.
    public Products(int number, String name, double price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters functions
    public static int getCounter(){return counter;}
    public static void incrementCounter(){counter++;}
    public static double getTotal(){return total;}
    public static void addToTotal(double temp){total += temp ;}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    // Array stuff
    // declares an ArrayList of integers
    private static ArrayList<Integer> arrayNumbers = new ArrayList<>();

    public static int getArrayVal(int i){return arrayNumbers.get(i);}   // Returns specified value
    public static void addToArray(int i){                               // adds value to array
        arrayNumbers.add(i);}

    // cycles through array by its size and printing each value
    public static void printArrayCycle() {
        for(int i = 0; i < arrayNumbers.size(); i++)
        {
            switch (arrayNumbers.get(i)){
                case 1:
                    printItemsArray(hotDog,i);
                    continue;
                case 2:
                    printItemsArray(taco,i);
                    continue;
                case 3:
                    printItemsArray(burrito,i);
                    continue;
                case 4:
                    printItemsArray(pizza,i);
                    continue;
                case 5:
                    printItemsArray(soup,i);
                    continue;
                case 6:
                    printItemsArray(Nachos,i);
                    continue;
                case 7:
                    printItemsArray(iceCream,i);
                    continue;
                case 8:
                    printItemsArray(water,i);
                    continue;
                case 9:
                    printItemsArray(fries,i);
                    continue;
                case 10:
                    printItemsArray(toy,i);
                    continue;
            }
        }

    }

    //  prints requested individual value
    public static void printItemsArray(Products prod, int i) {
        System.out.println("Item " + (i+1) + ": " +
                prod.getName() + "\t $" + prod.getPrice());
    }

}
