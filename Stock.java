// stock.java

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class Stock {
    
    int searchMedicine(String medicineName,String power){

        File f = new File("StockData.csv");
        
        try {
            Scanner scan = new Scanner(f);
            boolean flag = false;
            int count = 0;

            while(scan.hasNextLine()){
                String medicine = scan.nextLine();
                String mdata[] = medicine.split(",");

                if(medicineName.toLowerCase().equals(mdata[1])){
                    flag = true;

                    if(power.equals(mdata[2])){
                        System.out.println("\n!! - Medicine Data - !!");
                        System.out.println("\nManufacturer     -   " + mdata[0]);
                        System.out.println("Name             -   " + mdata[1]);
                        System.out.println("Mg               -   " + mdata[2]);
                        System.out.println("Quantity         -   " + mdata[3]);
                        System.out.println("Price Per Tablet -   " + mdata[4]);
                    }
                    else if(power.equals("0")){
                      

                        System.out.println("\n!! - Medicine Data - !!");
                        System.out.println("\nManufacturer     -   " + mdata[0]);
                        System.out.println("Name             -   " + mdata[1]);
                        System.out.println("Mg               -   " + mdata[2]);
                        System.out.println("Quantity         -   " + mdata[3]);
                        System.out.println("Price Per Tablet -   " + mdata[4]);
                    }
                }
            }
            if(flag){
                return 0;
            }
            else{
                return 1;
            }
        } catch (FileNotFoundException e) {
            return -1;
        }
    }

    void showallmed(){
        File f = new File("StockData.csv");

        try {
            Scanner scan = new Scanner(f);
            int count = 1;

            if(scan.hasNextLine()){

                while(scan.hasNextLine()){

                String medicine = scan.nextLine();
                String mdata[] = medicine.split(",");

                System.out.println("\n## -- Medicine " + count + " -- ##");

                System.out.println("\nManufacturer       -   " + mdata[0]);
                System.out.println("Name               -   " + mdata[1]);
                System.out.println("Mg                 -   " + mdata[2]);
                System.out.println("Quantity           -   " + mdata[3]);
                System.out.println("Price Per Tablet   -   " + mdata[4]);

                count++;
        
                }
            }
            else{
                System.out.println("\nFile Is Empty , No Medicine Data Found - ");
            }

        } catch (FileNotFoundException e) {
            System.out.println("\nFILE NOT FOUND - ");
        }
    }
    int updateQuantityFromBill(String medName,String power,String purchaseQuantity){
        
        File f = new File("StockData.csv");

        try {
            
            Scanner scan = new Scanner(f);

            ArrayList<String> stockData = new ArrayList<>();
            
            while(scan.hasNextLine()){
                
                String meddata = scan.nextLine();
                String meddataarr[] = meddata.split(",");

                if(medName.equals(meddataarr[1]) && power.equals(meddataarr[2])){

                    try {
                        
                        int remainingQuantity = Integer.parseInt(meddataarr[3]) - Integer.parseInt(purchaseQuantity);
                        String remaining = remainingQuantity + "";

                        String updatedMedData = meddataarr[0] + "," + meddataarr[1] + "," + meddataarr[2] + "," + remainingQuantity + "," + meddataarr[4];

                        stockData.add(updatedMedData);
                    } catch (NumberFormatException e) {
                        return -2;
                    }
                }
                else{

                    stockData.add(meddata);
                }
            }

            try {

                FileWriter fw = new FileWriter("StockData.csv");
                fw.write("");
            
                for (String medData : stockData) {
                        fw.append(medData + "\n");
                }

                fw.close();

                return 1;

            } catch (IOException e) {
                return -2;
            }
           

        } catch(FileNotFoundException e) {
            return -1;
        }
    }
}
