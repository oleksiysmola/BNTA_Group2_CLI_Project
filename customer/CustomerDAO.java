package com.bntaairport.customer;

import java.io.*;
import java.util.Scanner;

public class CustomerDAO {
//    public void toTextFile(Customer[] customers){
//        // Generate file of given path
//        File file = new File("customer.txt");
//        try {
//            // Check if file exists
//            if (!file.exists()){
//                file.createNewFile();
//            }
//            // Set up file and print writer
//            FileWriter fileWriter = new FileWriter(file);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            // Loop over array
//            for (int i = 0; i < customers.length; i++) {
//                // Print lines
//
//                printWriter.println(customers[i].toString());
//            }
//            // Finish writing
//            printWriter.flush();
//            printWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public void toCSVFile(Customer[] customers){
        // Generate file of given path
        File file = new File("customer.csv");
        try {
            // Check if file exists
            if (!file.exists()){
                file.createNewFile();
            }
            // Set up file and print writer
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            // Initialise line to be printed
            String line = "";
            // Loop over array
            for (int i = 0; i < customers.length; i++) {
                line = "";
                line += customers[i].getId() + ",";
                line += customers[i].getName() + ",";
                line += customers[i].getEmail() + ",";
                line += customers[i].getNumber() + ",";
                line += customers[i].getPassportNumber() + ",";
                // Print lines
                printWriter.println(line.substring(0, line.length() - 1));
            }
            // Finish writing
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public Customer[] readCSV(){
//        // Initialise file to be read
//        File file = new File("customer.csv");
//        try {
//            // Initialise scanner
//            Scanner scanner = new Scanner(file);
//            // Loop through doc while there is another line
//            while (scanner.hasNext()){
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Error customer data not found");
//        }
//    }
}
