import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Customer{

	private String nme,mno,medName,pow,medPrice,qnty;
	
	int addData(String name,String mobileNumber,String medicineName,String power,String quantity,String tprice){

		nme = name;
		mno = mobileNumber;
		medName = medicineName;
		pow = power;
		qnty = quantity;
		medPrice = tprice;

		try{	
			String cdatetime = "" + LocalDateTime.now();

			String finalString = nme + "," + mno + "," + medName + "," + pow + "," + qnty + "," + medPrice + "," + cdatetime + "\n";

			FileWriter fw = new FileWriter("CustomerData.csv",true);
			
			fw.write(finalString);
			fw.close();
			return 1;
		}
		catch(Exception e){
			return 0;
		}
	}

	void printData() {
		File f = new File("CustomerData.csv");

		try {
			Scanner scf = new Scanner(f);

			if (!scf.hasNextLine()) {
				System.out.println("\nCustomer Data File Is Empty");
			} else {
				System.out.println("\nCustomer Data");
				System.out.println("\n" + String.format("Customer Name          | Customer Number  | Medicine Name      | Power     | Quantity    | Total Price   | Time \n"));

				while (scf.hasNextLine()) {
					String customerData = scf.nextLine();
					String data[] = customerData.split(",");
					System.out.println(String.format("%-22s | %-16s | %-18s | %-9s | %-11s | %-13s | %-10s", data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("\nFile Not Found");
		}
	}

	void clearData(){
		try {

			FileWriter fw = new FileWriter("CustomerData.csv");

			fw.write("");
			fw.close();

			System.out.println("\nAll Customers Data Cleared Successfully");			
			
		} catch (IOException e) {
			
			System.out.println("\nIOException Occured");
		}
	}

	void searchData(String searchValue,String byName){

		File f = new File("CustomerData.csv");

		try {

			Scanner scn = new Scanner(f);

			if(!scn.hasNextLine()){

				System.out.println("\nFile Is Empty - ");
			}

			else if( byName.equals("name")){

				System.out.println("\n" + String.format("Customer Name          | Customer Number  | Medicine Name      | Power     | Quantity    | Total Price   | Time \n"));

				boolean flag = false;

				while(scn.hasNextLine()){
					String data = scn.nextLine();
					String cstmrData[] = data.split(",");

					if( cstmrData[0].toLowerCase().contains(searchValue.toLowerCase())){

						flag = true;

						System.out.println(String.format("%-22s | %-16s | %-18s | %-9s | %-11s | %-13s | %-10s", cstmrData[0], cstmrData[1], cstmrData[2], cstmrData[3], cstmrData[4], cstmrData[5], cstmrData[6]));
					}
				}
				
				if(!flag){

					System.out.println("\nNo Data Found - ");
				}
			}

			else if( byName.equals("mobile_number")){

				System.out.println("\n" + String.format("Customer Name          | Customer Number  | Medicine Name      | Power     | Quantity    | Total Price   | Time \n"));

				boolean flag = false;
				while(scn.hasNextLine()){
					String data = scn.nextLine();
					String cstmrData[] = data.split(",");

					if( cstmrData[1].equals(searchValue)){

						flag = true;

						System.out.println(String.format("%-22s | %-16s | %-18s | %-9s | %-11s | %-13s | %-10s", cstmrData[0], cstmrData[1], cstmrData[2], cstmrData[3], cstmrData[4], cstmrData[5], cstmrData[6]));
					}
				}
				
				if(!flag){

					System.out.println("\nNo Data Found - ");
				}				

			}

			else if( byName.equals("medicine_name")){

				System.out.println("\n" + String.format("Customer Name          | Customer Number  | Medicine Name      | Power     | Quantity    | Total Price   | Time \n"));

				boolean flag = false;
				while(scn.hasNextLine()){
					String data = scn.nextLine();
					String cstmrData[] = data.split(",");

					if( cstmrData[2].toLowerCase().contains(searchValue.toLowerCase())){

						flag = true;

						System.out.println(String.format("%-22s | %-16s | %-18s | %-9s | %-11s | %-13s | %-10s", cstmrData[0], cstmrData[1], cstmrData[2], cstmrData[3], cstmrData[4], cstmrData[5], cstmrData[6]));
					}
				}
				
				if(!flag){

					System.out.println("\nNo Data Found - ");
				}				

			}
	
		} catch (FileNotFoundException e) {

			System.out.println("\nFile Not Found Exception Occured - ");
		}
	}
}