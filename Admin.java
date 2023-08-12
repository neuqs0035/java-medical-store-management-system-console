import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    void changeUsername(String oldUsername, String newUsername, String password) {
        File f = new File("AdminLoginId.csv");
    
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
                    FileWriter fw = new FileWriter("AdminLoginId.csv");
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

        File f = new File("AdminLoginId.csv");
    
        try {
            Scanner scf = new Scanner(f);
    
            if (!scf.hasNextLine()) {
                System.out.println("\nNo Data Found - ");
            } else {
                boolean flag = false;
                ArrayList<String> adminLoginData = new ArrayList<>();
    
                while (scf.hasNextLine()) {
                    String idpass = scf.nextLine();
                    String useridpass[] = idpass.split(",");
    
                    if (useridpass[0].equals(userid)) {
                        flag = true;
    
                        if (useridpass[1].equals(oldPassword)) {  // Corrected this line
                            String newData = useridpass[0] + "," + newPassword + "\n";
                            adminLoginData.add(newData);
                        } else {
                            System.out.println("\nOld Password Is Wrong - ");
                            return;  // Added a return statement
                        }
                    } else {
                        adminLoginData.add(idpass + "\n");
                    }
                }
    
                if (!flag) {
                    System.out.println("\nUser Not Found - ");
                } else {
                    try {
                        FileWriter fw = new FileWriter("AdminLoginId.csv");
                        fw.write("");  // Clearing the file content
                        fw.close();
    
                        FileWriter fw2 = new FileWriter("AdminLoginId.csv", true);
    
                        for (String data : adminLoginData) {
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