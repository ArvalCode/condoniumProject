//MAIN

package condoProject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class CondoRunner {

	public static void main(String[] args) {

		Square[][] sqrMap = new Square[][] { new Square[13], new Square[13], new Square[13], new Square[3],
				new Square[3], new Square[3], new Square[3], new Square[13], new Square[13], new Square[13], };

		for (int i = 1; i > 0 && i < sqrMap.length - 1; i++) { // Does Column 1 (0)
			sqrMap[i][0] = new Square(new Location(i, 0), 30, "Ocean", "Not Available", 0);

		}
		sqrMap[0][0] = new Square(new Location(0, 0), .50, "Ocean", "Not Available", 0);
		sqrMap[9][0] = new Square(new Location(9, 0), .50, "Ocean", "Not Available", 0);

		for (int i = 1; i < sqrMap[0].length - 1; i++) { // Does Row 1 and 10 (0 and 9)
			sqrMap[0][i] = new Square(new Location(0, i), .30, "Ocean", "Not Available", 0);
			sqrMap[9][i] = new Square(new Location(9, i), .30, "Ocean", "Not Available", 0);

		}
		sqrMap[0][12] = new Square(new Location(0, 12), .40, "Ocean", "Not Available", 0);
		sqrMap[9][12] = new Square(new Location(9, 12), .30, "Ocean", "Not Available", 0);

		for (int i = 1; i < sqrMap[1].length - 1; i++) { // Rows 2 and 9 (1 and 8)
			sqrMap[1][i] = new Square(new Location(1, i), 0, "None", "Not Available", 0);
			sqrMap[8][i] = new Square(new Location(8, i), 0, "None", "Not Available", 0);
		}
		sqrMap[1][12] = new Square(new Location(1, 12), .25, "None", "Not Available", 0);
		sqrMap[8][12] = new Square(new Location(8, 12), .25, "None", "Not Available", 0);

		for (int i = 2; i < 8; i++) { // Column Inclusive [2][1] to [7][1]
			sqrMap[i][1] = new Square(new Location(i, 1), 0, "None", "Not Available", 0);
		}

// Column Inclusive from [3][2] to [6][2]
		sqrMap[7][2] = new Square(new Location(7, 2), 0, "None", "Not Available", 0);
		sqrMap[2][2] = new Square(new Location(2, 2), 0, "None", "Not Available", 0);

		for (int i = 3; i < 7; i++) {
			sqrMap[i][2] = new Square(new Location(i, 2), .20, "Pool", "Not Available", 0);
		}

// Rows inclusive from[2&&7][3] to [2&&7][12]
		sqrMap[2][3] = new Square(new Location(2, 3), .10, "Pool", "Not Available", 0);
		sqrMap[7][3] = new Square(new Location(7, 3), .10, "Pool", "Not Available", 0);
		for (int i = 4; i < 10; i++) {
			sqrMap[2][i] = new Square(new Location(2, i), .20, "Pool", "Not Available", 0);
			sqrMap[7][i] = new Square(new Location(7, i), .20, "Pool", "Not Available", 0);

		}
		sqrMap[2][10] = new Square(new Location(2, 10), .25, "Pool", "Not Available", 0);
		sqrMap[2][11] = new Square(new Location(2, 11), .25, "Pool", "Not Available", 0);
		sqrMap[2][12] = new Square(new Location(2, 12), .30, "Pool", "Not Available", 0);

		sqrMap[7][10] = new Square(new Location(7, 10), .25, "Pool", "Not Available", 0);
		sqrMap[7][11] = new Square(new Location(7, 11), .25, "Pool", "Not Available", 0);
		sqrMap[7][12] = new Square(new Location(7, 12), .40, "Pool", "Not Available", 0);

		ArrayList<Condo> devConList = new ArrayList<>();

// One bungalow unit
		ArrayList<Square> bunga = new ArrayList<>();
		bunga.add(sqrMap[0][0]);
		bunga.add(sqrMap[0][1]);
		Bungalow bungalow1 = new Bungalow(bunga);
//bungalow.setStatus("Final Construction");
		devConList.add(bungalow1);

// One retreat unit
		ArrayList<Square> retr = new ArrayList<>();
		retr.add(sqrMap[0][11]);
		retr.add(sqrMap[0][12]);
		retr.add(sqrMap[1][11]);
		retr.add(sqrMap[1][12]);
		retr.add(sqrMap[2][11]);
		retr.add(sqrMap[2][12]);

		Retreat retreat1 = new Retreat(retr);
		devConList.add(retreat1);

// One custom unit
		ArrayList<Square> cust = new ArrayList<>();
		cust.add(sqrMap[7][12]);
		cust.add(sqrMap[8][12]);
		cust.add(sqrMap[9][12]);

		Custom custom1 = new Custom(cust);
		custom1.addAdditions("Bedroom with Suite");
		custom1.addAdditions("Bedroom");
		custom1.addAdditions("Kitchen Upgrade");
		custom1.addAdditions("Folding Doors with View");

		devConList.add(custom1);

//Rest of the Condos

		ArrayList<Square> unit1 = new ArrayList<>();
		unit1.add(sqrMap[7][10]);
		unit1.add(sqrMap[7][11]);
		unit1.add(sqrMap[8][10]);
		unit1.add(sqrMap[8][11]);
		unit1.add(sqrMap[9][10]);
		unit1.add(sqrMap[9][11]);
		Retreat u1 = new Retreat(unit1);
		devConList.add(u1);

		ArrayList<Square> unit2 = new ArrayList<>();
		unit2.add(sqrMap[7][8]);
		unit2.add(sqrMap[7][9]);
		Bungalow u2 = new Bungalow(unit2);
		devConList.add(u2);

		ArrayList<Square> unit3 = new ArrayList<>();
		unit3.add(sqrMap[8][8]);
		unit3.add(sqrMap[9][8]);
		Bungalow u3 = new Bungalow(unit3);
		devConList.add(u3);

		ArrayList<Square> unit4 = new ArrayList<>();
		unit4.add(sqrMap[8][9]);
		unit4.add(sqrMap[9][9]);
		Bungalow u4 = new Bungalow(unit4);
		devConList.add(u4);

		ArrayList<Square> unit5 = new ArrayList<>();
		unit5.add(sqrMap[7][6]);
		unit5.add(sqrMap[7][7]);
		unit5.add(sqrMap[8][6]);
		unit5.add(sqrMap[8][7]);
		unit5.add(sqrMap[9][6]);
		unit5.add(sqrMap[9][7]);
		Retreat u5 = new Retreat(unit5);
		devConList.add(u5);

		ArrayList<Square> unit6 = new ArrayList<>();
		unit6.add(sqrMap[7][4]);
		unit6.add(sqrMap[7][5]);
		unit6.add(sqrMap[8][4]);
		unit6.add(sqrMap[8][5]);
		unit6.add(sqrMap[9][4]);
		unit6.add(sqrMap[9][5]);
		Retreat u6 = new Retreat(unit6);
		devConList.add(u6);

		ArrayList<Square> unit7 = new ArrayList<>();
		unit7.add(sqrMap[7][3]);
		unit7.add(sqrMap[8][3]);
		unit7.add(sqrMap[9][3]);
		Custom u7 = new Custom(unit7);
		u7.addAdditions("Bedroom");
		u7.addAdditions("Bedroom");
		u7.addAdditions("Kitchen Upgrade");
		u7.addAdditions("Folding Doors with View");
		devConList.add(u7);

		ArrayList<Square> unit8 = new ArrayList<>();
		unit8.add(sqrMap[7][0]);
		unit8.add(sqrMap[7][1]);
		unit8.add(sqrMap[7][2]);
		unit8.add(sqrMap[8][0]);
		unit8.add(sqrMap[8][1]);
		unit8.add(sqrMap[8][2]);
		unit8.add(sqrMap[9][0]);
		unit8.add(sqrMap[9][1]);
		unit8.add(sqrMap[9][2]);
		Custom u8 = new Custom(unit8);
		u8.addAdditions("Bedroom");
		u8.addAdditions("Bedroom");
		u8.addAdditions("Bedroom");
		u8.addAdditions("Bedroom");
		u8.addAdditions("Bedroom");
		u8.addAdditions("Kitchen Upgrade");
		u8.addAdditions("Folding Doors with View");
		devConList.add(u8);

		ArrayList<Square> unit9 = new ArrayList<>();
		unit9.add(sqrMap[5][0]);
		unit9.add(sqrMap[5][1]);
		unit9.add(sqrMap[5][2]);
		unit9.add(sqrMap[6][0]);
		unit9.add(sqrMap[6][1]);
		unit9.add(sqrMap[6][2]);
		Retreat u9 = new Retreat(unit9);
		devConList.add(u9);

		ArrayList<Square> unit10 = new ArrayList<>();
		unit10.add(sqrMap[3][0]);
		unit10.add(sqrMap[3][1]);
		unit10.add(sqrMap[3][2]);
		unit10.add(sqrMap[4][0]);
		unit10.add(sqrMap[4][1]);
		unit10.add(sqrMap[4][2]);
		Retreat u10 = new Retreat(unit10);
		devConList.add(u10);

		ArrayList<Square> unit11 = new ArrayList<>();
		unit11.add(sqrMap[1][0]);
		unit11.add(sqrMap[1][1]);
		Bungalow u11 = new Bungalow(unit11);
		devConList.add(u11);

		ArrayList<Square> unit12 = new ArrayList<>();
		unit12.add(sqrMap[2][0]);
		unit12.add(sqrMap[2][1]);
		Bungalow u12 = new Bungalow(unit12);
		devConList.add(u12);

		ArrayList<Square> unit13 = new ArrayList<>();
		unit13.add(sqrMap[0][2]);
		unit13.add(sqrMap[1][2]);
		Bungalow u13 = new Bungalow(unit13);
		devConList.add(u13);

		ArrayList<Square> unit14 = new ArrayList<>();
		unit14.add(sqrMap[0][3]);
		unit14.add(sqrMap[1][3]);
		Bungalow u14 = new Bungalow(unit14);
		devConList.add(u14);

		ArrayList<Square> unit15 = new ArrayList<>();
		unit15.add(sqrMap[2][2]);
		unit15.add(sqrMap[2][3]);
		Bungalow u15 = new Bungalow(unit15);
		devConList.add(u15);

		ArrayList<Square> unit16 = new ArrayList<>();
		unit16.add(sqrMap[0][4]);
		unit16.add(sqrMap[0][5]);
		unit16.add(sqrMap[1][4]);
		unit16.add(sqrMap[1][5]);
		unit16.add(sqrMap[2][4]);
		unit16.add(sqrMap[2][5]);
		Retreat u16 = new Retreat(unit16);
		devConList.add(u16);

		ArrayList<Square> unit17 = new ArrayList<>();
		unit17.add(sqrMap[0][6]);
		unit17.add(sqrMap[0][7]);
		unit17.add(sqrMap[1][6]);
		unit17.add(sqrMap[1][7]);
		unit17.add(sqrMap[2][6]);
		unit17.add(sqrMap[2][7]);
		Retreat u17 = new Retreat(unit17);
		devConList.add(u17);

		ArrayList<Square> unit18 = new ArrayList<>();
		unit18.add(sqrMap[0][8]);
		unit18.add(sqrMap[0][9]);
		unit18.add(sqrMap[0][10]);
		unit18.add(sqrMap[1][8]);
		unit18.add(sqrMap[1][9]);
		unit18.add(sqrMap[1][10]);
		unit18.add(sqrMap[2][8]);
		unit18.add(sqrMap[2][9]);
		unit18.add(sqrMap[2][10]);
		Custom u18 = new Custom(unit18);
		u18.addAdditions("Bedroom");
		u18.addAdditions("Bedroom");
		u18.addAdditions("Bedroom");
		u18.addAdditions("Bedroom");
		u18.addAdditions("Bedroom");
		u18.addAdditions("Kitchen Upgrade");
		u18.addAdditions("Folding Doors with View");
		devConList.add(u18);

		Development dev = new Development(devConList, sqrMap);
		dev.printBlueprint(); // MAKE SURE TO FIX ADDING UNIQUE ID TO THE VIEWER
		dev.generateCondoInfoTable();

		dev.requestCondo("Bungalow");

		dev.reserveCondo(bungalow1);
		dev.buyCondo(bungalow1);

		dev.reserveCondo(custom1);
		dev.buyCondo(custom1);

		dev.reserveCondo(retreat1);
		dev.buyCondo(retreat1);
		dev.backoutDealCondo(retreat1);

		dev.reserveCondo(u1);
		
		dev.reserveCondo(u2);
		dev.buyCondo(u2);

		dev.reserveCondo(u3);
		dev.buyCondo(u3);

		dev.reserveCondo(u4);
		
		dev.reserveCondo(u5);
		dev.buyCondo(u5);

		dev.reserveCondo(u6);
		dev.buyCondo(u6);

		dev.reserveCondo(u7);
		dev.buyCondo(u7);

		dev.reserveCondo(u8);

		dev.reserveCondo(u9);
		dev.buyCondo(u9);

		dev.reserveCondo(u10);
		
		dev.reserveCondo(u11);
		dev.buyCondo(u11);

		dev.reserveCondo(u12);
		dev.buyCondo(u12);

		dev.reserveCondo(u13);
		
		dev.reserveCondo(u14);
		dev.buyCondo(u14);

		dev.reserveCondo(u15);
		dev.buyCondo(u15);

		dev.reserveCondo(u16);

		dev.reserveCondo(u17);
		dev.buyCondo(u17);

		dev.reserveCondo(u18);
		
		dev.generateCondoInfoTable();

		dev.generateProfitStatement();
		dev.printBlueprint();

	}

}
