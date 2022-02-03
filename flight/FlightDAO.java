//package com.bntaairport.flight;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//public class FlightDAO {
//    public void toTextFile(Flight[] flights) {
//        File file = new File("flights.txt"); //'file' object created and path included
//
//        try {
//            if (!file.exists()) { //if this file doesn't already exist, create it using .createNewFile()
//                file.createNewFile();
//            }
//
//            FileWriter fileWriter = new FileWriter(file);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            for (int i = 0; i < flights.length; i++) {
//                printWriter.println(flights[i].toString());
//            }
//
//            printWriter.flush();
//            printWriter.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void toCsvFile(Flight[] flights) {
//
//        File file = new File("flights.csv"); //file path needs to be updated!!
//
//        try {
//            if (!file.exists()) { //if this file doesn't already exist, create it using .createNewFile()
//                file.createNewFile();
//            }
//
//            FileWriter fileWriter = new FileWriter(file);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            String line = "";
//            for (int i = 0; i < flights.length; i++) {
//                line += flights[i].getFlightNumber() + ", ";
//                line += flights[i].getAirline() + ", ";
//                line += flights[i].getDepartureTime() + ", ";
//                line += flights[i].getDestination() + ", ";
//                line += flights[i].getMaxCapacity() + ", ";
//                line += flights[i].getCustomersOnFlight() + ", ";
//
//                printWriter.println(line.substring(0, line.length() - 1));
//
//                printWriter.flush();
//                printWriter.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
