// staff.java

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Staff {

        File f = new File("StaffData.csv");
        
    void staffdataall(){
        
        System.out.println("\n!!- Staff Data -!!");

        try {
            Scanner scan = new Scanner(f);
            int count = 1;

            while(scan.hasNextLine()){
                
                String stfdata = scan.nextLine();
                String[] stf = stfdata.split(",");

                System.out.println("\n##  Staff Member - " + count + "  ##");
                System.out.println("\nStaff Id = " + stf[0]);
                System.out.println("Name = " + stf[1] + " " + stf[2]);
                System.out.println("Age = " + stf[3]);
                System.out.println("Mobile Number = " + stf[4]);
                System.out.println("Address = " + stf[5]);
                System.out.println("Joining Date = " + stf[6]);
                System.out.println("Salary = " + stf[7]);

                count ++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nFILE NOT FOUND - ");
        }
    }

    void staffdataspecific(String fname) {

        try {
            Integer num = Integer.parseInt(fname);
            Scanner scan = new Scanner(f);
            boolean flag = false;

            while(scan.hasNextLine()) {
                    
                String stfdata = scan.nextLine();
                String[] stf = stfdata.split(",");
                    
                if(fname.equals(stf[0])) {
                    System.out.println("\n!!- Staff Data -!!");
    
                    System.out.println("\nStaff ID = " + stf[0]);
                    System.out.println("Name = " + stf[1] + " " + stf[2]);
                    System.out.println("Age = " + stf[3]);
                    System.out.println("Mobile Number = " + stf[4]);
                    System.out.println("Address = " + stf[5]);
                    System.out.println("Joining Date = " + stf[6]);                        System.out.println("Salary = " + stf[7]);
                    flag = true;
                    break;
                }
            }
    
            if(flag == false) {
                System.out.println("\nSorry Staff Member Not Found 'or' Check Spelling And Try Again -");
            }
        }    
        catch (NumberFormatException e) {

            try {
                Scanner scan = new Scanner(f);
    
                boolean flag = false;
    
                while(scan.hasNextLine()) {
                    
                    String stfdata = scan.nextLine();
                    String[] stf = stfdata.split(",");
                    
                    if(fname.equals(stf[1])) {
                        System.out.println("\n!!- Staff Data -!!");
    
                        System.out.println("\nEmployee ID = " + stf[0]);
                        System.out.println("\nName = " + stf[1] + " " + stf[2]);
                        System.out.println("Age = " + stf[3]);
                        System.out.println("Mobile Number = " + stf[4]);
                        System.out.println("Address = " + stf[5]);
                        System.out.println("Joining Date = " + stf[6]);
                        System.out.println("Salary = " + stf[7]);
                        flag = true;
                        break;
                    }
                }
    
                if(flag == false) {
                    System.out.println("\nSorry Staff Member Not Found 'or' Check Spelling And Try Again -");
                }
            }
            catch (FileNotFoundException a) {
                System.out.println("\nFILE NOT FOUND - ");
            }
        }
        catch(FileNotFoundException fnotfound){
            System.out.println("FILE NOT FOUND , ERROR (:");
        }
    }
    int updatestaffdata(String s1,String s2,int choice){

        try {

            Scanner scan = new Scanner(f);
            boolean flag = false;
            String final_s = "";
            
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                
                if(choice == 1){
                    String data[] = line.split(",");
                    if(data[0].equals(s1)){
                        flag = true; 
                        data[1] = s2;
                        line = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7];
                    } 
                }
                else if(choice == 2){
                    String data[] = line.split(",");
                    if(data[0].equals(s1)){
                        flag = true; 
                        data[2] = s2;
                        line = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7];
                    } 
                }
                else if(choice == 3){
                    String data[] = line.split(",");
                    if(data[0].equals(s1)){
                        flag = true; 
                        data[3] = s2;
                        line = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7];
                    } 
                }
                else if(choice == 4){
                    String data[] = line.split(",");
                    if(data[0].equals(s1)){
                        flag = true; 
                        data[4] = s2;
                        line = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7];
                    } 
                }
                else if(choice == 5){
                    String data[] = line.split(",");
                    if(data[0].equals(s1)){
                        flag = true; 
                        data[5] = s2;
                        line = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7];
                    } 
                }
                else if(choice == 7){
                    String data[] = line.split(",");
                    if(data[0].equals(s1)){
                        flag = true; 
                        data[7] = s2;
                        line = data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7];
                    } 
                }
                final_s = final_s + line + "\n";
            }

            FileWriter fw = new FileWriter("StaffData.csv");

            fw.write(final_s);
            fw.close();
            
            if(flag){
                return 0;
            }
            else{
                return 1;
            }
        }
        catch(FileNotFoundException e){
            System.out.println("\nFile Not Found ...."); 
            return -1;
        } 
        catch(IOException d){
            System.out.println("\nIOException ....");
            return -1;
        }   
    }
    int removestaffmember(String staffid){

        try {
            Scanner scan = new Scanner(f);

            String final_String = "";
            boolean flag = false;

            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String data[] = line.split(",");

                if(data[0].equals(staffid)){
                    flag = true;
                    continue;
                }
                final_String += line + "\n";
            }
            
            FileWriter fw = new FileWriter("StaffData.csv");

            fw.write(final_String);
            fw.close();

            if(flag){
                return 0;
            }
            else{
                return 1;
            }

        } catch (FileNotFoundException e) {
            return -1;

        } catch(IOException io){
            return -1;
        }
    }  

    int addStaffMember(String employeeid,String firstName,String lastName,String age,String mobilenUMBER,String address,String salary){
        try {
            FileWriter fw = new FileWriter(f, true);
            LocalDateTime now = LocalDateTime.now(); 
            
            String finalString = employeeid + "," + firstName + "," + lastName + "," + age + "," + mobilenUMBER + "," + address + "," + now + "," + salary;
            fw.append(finalString);
            fw.close();
            return 1;
        } catch (IOException e) {
            return 0;
        }

    }

    void changeUsername(String oldUsername, String newUsername, String password) {
        File f = new File("StaffLoginId.csv");
    
        try {
            Scanner scan = new Scanner(f);
            ArrayList<String> useridPassword = new ArrayList<>();
            boolean found = false;
            int rval = 0;
    
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String userpass[] = data.split(",");
    
                // If username matched
                if (userpass[0].equals(oldUsername)) {
    
                    // If password matched
                    if (userpass[1].equals(password)) {
                        data = newUsername + "," + password;
                        found = true;
                        rval = 1;
                    } else {
                        System.out.println("\nPassword Is Incorrect");
                    }
                }
    
                useridPassword.add(data);
            }
    
            if (!found) {
                System.out.println("\nUsername Not Found"); // Username not found
            }
    
            scan.close();
    
            if (rval == 1) {
                try {
                    FileWriter fw = new FileWriter("StaffLoginId.csv");
                    for (String data : useridPassword) {
                        fw.write(data + "\n");
                    }
                    fw.close();

                    System.out.println("\nUsername Changed Successfully");
                } catch (IOException e) {
                    System.out.println("\nIOException Occured");
                }
            }
    
        } catch (FileNotFoundException e) {
            System.out.println("\nFileNotFoundException Occured");// File Not Found
        }
    }

    void changePassword(String userid, String oldPassword, String newPassword) {
        File f = new File("StaffLoginId.csv");
    
        try {
            Scanner scf = new Scanner(f);
    
            if (!scf.hasNextLine()) {
                System.out.println("\nNo Data Found - ");
            } else {
                boolean flag = false;
                ArrayList<String> staffLoginData = new ArrayList<>();
    
                while (scf.hasNextLine()) {
                    String idpass = scf.nextLine();
                    String useridpass[] = idpass.split(",");
    
                    if (useridpass[0].equals(userid)) {
                        flag = true;
    
                        if (useridpass[1].equals(oldPassword)) {  // Corrected this line
                            String newData = useridpass[0] + "," + newPassword + "\n";
                            staffLoginData.add(newData);
                        } else {
                            System.out.println("\nOld Password Is Wrong - ");
                            return;  // Added a return statement
                        }
                    } else {
                        staffLoginData.add(idpass + "\n");
                    }
                }
    
                if (!flag) {
                    System.out.println("\nUser Not Found - ");
                } else {
                    try {
                        FileWriter fw = new FileWriter("StaffLoginId.csv");
                        fw.write("");  // Clearing the file content
                        fw.close();
    
                        FileWriter fw2 = new FileWriter("StaffLoginId.csv", true);
    
                        for (String data : staffLoginData) {
                            fw2.write(data);  // Writing data without newline here
                        }
                        fw2.close();
    
                        System.out.println("\nPassword Changed Successfully - ");
                    } catch (IOException e) {
                        System.out.println("\nIOException Occurred - ");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nFile Not Found Exception Occurred - ");
        }
    }
    

}