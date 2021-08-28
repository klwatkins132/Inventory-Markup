/**
*Name: Kelsy Watkins
In this assignment you will write a program that uses a loop to read a Data.txt file from your hard drive and create an inventory report based on the data in the file. 
The program will write back to the hard drive creating a file called Inventory.txt. The program’s purpose is to add the designated markup cost to products.
The program then outputs the product names, original raw-costs, and product costs after markup (calculated using the formula itemCost(x) * 1.3).
**/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Write a program that opens a data file called 'Data.txt' located in the root folder of your project
        try {
            File myFile = new File("./Data.txt");

            //The program will read-in the product name and next read-in the cost of the item.
            //Using a loop, the program will only stop reading the file when there are no more product names in the sequence.
            Scanner firstScanner = new Scanner(myFile);
            while (firstScanner.hasNextLine()) {
                String product = firstScanner.nextLine();
                String costString = "";

                Scanner secondScanner = new Scanner(firstScanner.nextLine());
                while (secondScanner.hasNext()) {
                    costString = secondScanner.next();
                }
                secondScanner.close();

                //The program will take each cost and mark it up 30% using the formula (itemCost * 1.3) where itemCost is your own declared variable for product cost.
                double cost = Double.parseDouble(costString);
                double finalCost = cost * 1.3;

                String productToFile = String.format("Product Name: %s", product);
                String costStringToFile = String.format("Product Cost: $%s", costString);
                String finalCostToFile = String.format("Product Current Price: $%.2f", finalCost);

                //The program will then write to a file called 'Inventory.txt' located in the root folder of your project.
                //There will be a space between products in the Inventory.txt and all ten products must be listed. See image examples below for format.
                try{
                    FileWriter myWriter = new FileWriter("./Inventory.txt", true);
                    myWriter.write(productToFile + "\n");
                    myWriter.write(costStringToFile + "\n");  
                    myWriter.write(finalCostToFile + "\n\n");

                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                
                //Your program will print to the screen (console window) a line with the product name, a line with the cost, a line with the markup cost, and lastly with message
                //'*******Successfully Retrieved*************'.
                System.out.println(productToFile);
                System.out.println(costStringToFile);
                System.out.println(finalCostToFile + "\n");
            }
            System.out.println("*******Successfully Retrieved*************");
            firstScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
