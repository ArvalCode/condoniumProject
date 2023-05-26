//CLASSES

package condoProject;

import java.util.ArrayList;

class Location {
	private int x, y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

class Square {
	Location loc;
	private double viewPremium;
	private String viewType;
	private String status;
	private int uniqueID;

	public Square(Location l, double d, String vT, String stat, int uID) {
		loc = l;
		viewPremium = d;
		viewType = vT;
		status = stat;
		uniqueID = uID;
	}

	public Location getLocation() {
		return loc;
	}

	public double getPremium() {
		return viewPremium;
	}

	public String getType() {
		return viewType;
	}

	public String getStatus() {
		return status;
	}

	public int getID() {
		return uniqueID;
	}

	public void setStatus(String s) {
		status = s;
	}

	public void setID(int i) {
		uniqueID = i;
	}

}

class Condo {
	ArrayList<Square> squareList = new ArrayList<>();
	private int amountOfSquares;
	private int square = 625; // Area in square foot
	private float customerCost = 0, profit = customerCost - amountOfSquares * 100000;
	Location loc; // Has coordinates of most northwest square
	protected float rate = 0;

	public double getPremium() {
		double totalPrem = 0;
		for (int i = 0; i < squareList.size(); i++) {
			totalPrem += rate * squareList.get(i).getPremium();
		}
		return totalPrem;
	}

	public float getRate() {
// TODO Auto-generated method stub
		return rate;
	}

	public Condo(ArrayList<Square> r) {
		amountOfSquares = r.size();
		squareList = r;
		loc = r.get(0).getLocation();

		int uniID = squareList.get(0).getLocation().getY() + (100 * squareList.get(0).getLocation().getX()) + 100; // Put
// premium
// percentages
// in
// here
		for (int i = 0; i < squareList.size(); i++) {
			squareList.get(i).setID(uniID);
		}

	}

	public void setStatus(String s) {
		for (int i = 0; i < squareList.size(); i++) {
			squareList.get(i).setStatus(s);
		}
	}

	public int getID() {
		return squareList.get(0).getID();
	}

	public String getStatus() {
		return squareList.get(0).getStatus();
	}

	public int getAmountOfSquares() {

		return amountOfSquares;
	}

	public float getCustomerCost() { // In works
		double premTotal = 0;
// TODO Auto-generated method stub
		customerCost = rate * amountOfSquares;
		for (int i = 0; i < squareList.size(); i++) {
			premTotal += squareList.get(i).getPremium() * rate;
		}

		return (float) (customerCost + premTotal);
	}

	public float getProfit() {
		return customerCost - (100000 * amountOfSquares);
	}
}

class Bungalow extends Condo {

	public Bungalow(ArrayList<Square> r) {
		super(r);
		rate = 275000;
	}

	public float bungalowCost() {
		return rate * super.getAmountOfSquares();
	}

}

class Retreat extends Condo {

	public Retreat(ArrayList<Square> r) {
		super(r);
		rate = 225000;
	}

	public float retreatCost() {
		return rate * super.getAmountOfSquares();
	}

}

class Custom extends Condo { // Build the custom feature prices into the program
	private float customAddedTotal = 0;
	private float additionalBedroomWSuite = 75000, additionalBedroom = 50000, additionalBathroom = 25000,
			standardKitchen = 50000, foldableDoorsWView = 25000, floorUpgrade = 50000;

	public Custom(ArrayList<Square> r) {
		super(r);
		rate = 250000;

	}

	public void addAdditions(String t) {
		int bedroomCount = 0;
		if (t == "Bedroom with Suite" && (bedroomCount <= super.getAmountOfSquares())) {
			bedroomCount++; // Counts amount of beds to make sure that it does not exceed the square
			customAddedTotal += additionalBedroomWSuite;

		} else if (t == "Bedroom" && (bedroomCount <= super.getAmountOfSquares())) {
			bedroomCount++; // Counts amount of beds to make sure that it does not exceed the square
			customAddedTotal += additionalBedroom;
		} else if (t.equals("Bathroom")) {
			customAddedTotal += additionalBathroom;

		} else if (t.equals("Kitchen Upgrade")) {
			customAddedTotal += standardKitchen;
		} else if (t.equals("Folding Doors with View")) {
			customAddedTotal += foldableDoorsWView;
		} else if (t.equals("Floor Upgrade")) {
			customAddedTotal += floorUpgrade;
		}
	}

	public float getCustomTotal() {
		return customAddedTotal;
	}

}

class Development {
	ArrayList<Condo> condoList;
	private Square[][] squareRagged;
	private int sizeSquareRagged;
	private float cost, overallCost, profit, overallProfit, condoFinalConstructionProfit, closedCondosProfit;

	public Development(ArrayList<Condo> cL, Square[][] sR) {
		condoList = cL;
		squareRagged = sR;

		for (int i = 0; i < squareRagged.length; i++) {
			sizeSquareRagged += squareRagged[i].length;
		}
		for (int j = 0; j < cL.size(); j++) {
			cL.get(j).setStatus("Available");
		}

	}

	public void printBlueprint() { // Part B.1
		int i;
		for (i = 0; i < squareRagged.length; i++) {
			if (i != 0 && (squareRagged[i].length <= squareRagged[i - 1].length)) {
				System.out.print("--------".repeat(Math.abs(squareRagged[i].length - squareRagged[i - 1].length)));
			}
			System.out.println("--------".repeat(squareRagged[i].length) + "|");
			System.out.print("|");

			for (int j = 0; j < squareRagged[i].length; j++) {

				if (squareRagged[i][j].getStatus().equals("Available")) {
					System.out.print(" A-" + squareRagged[i][j].getID() + " |");
				} else if (squareRagged[i][j].getStatus().equals("Final Construction")) {
					System.out.print(" C-" + squareRagged[i][j].getID() + " |");
				} else if (squareRagged[i][j].getStatus().equals("Sold")) {
					System.out.print(" S-" + squareRagged[i][j].getID() + " |");
				} else if (squareRagged[i][j].getStatus().equals("Not Available")) {
					System.out.print("NA |");
				}
			}
			System.out.println();

		}
		System.out.println("--------".repeat(squareRagged[i - 1].length) + "|");
	}

	public void generateCondoInfoTable() {
// Customer Cost && Profit
		System.out.println("\nCondo Information:");
		System.out.println(String.format("%1$10s %2$25s %3$15s %4$15s %5$20s %6$20s", "CondoID:", "CondoStatus:",
				"CustomerCost:", "OwnerProfit:", "CostToReserve:", "CostToClose:"));
		for (int i = 0; i < condoList.size(); i++) {
			overallCost += cost;
			overallProfit += profit;
			cost = 0;
			profit = 0;
			cost = condoList.get(i).getCustomerCost();
			profit = condoList.get(i).getCustomerCost() - condoList.get(i).getProfit();

			System.out.println(String.format("%1$10s %2$25s %3$15.2f %4$15.2f %5$20.2f %6$20.2f",
					condoList.get(i).getID(), condoList.get(i).getStatus(), cost, profit, cost * .3, cost * .7));
		}
		System.out.println();

	}

	public void generateProfitStatement() {
		float finalConstructionProfit = 0, finalConstructionInvestment = 0, FCFinal = 0;
		float closedProfit = 0, closedInvestment = 0, CFinal = 0;

		System.out.println("Profit Statement:");
		for (int j = 0; j < condoList.size(); j++) {
			if (condoList.get(j).getStatus().equals("Final Construction")) {
				finalConstructionInvestment += condoList.get(j).getAmountOfSquares() * 100000;
				finalConstructionProfit += condoList.get(j).getProfit();
				FCFinal = finalConstructionProfit - finalConstructionInvestment;
			} else if (condoList.get(j).getStatus().equals("Sold")) {
				closedInvestment += condoList.get(j).getAmountOfSquares() * 100000;
				closedProfit += condoList.get(j).getProfit();
				CFinal = closedProfit - closedInvestment;
			}
		}

		System.out.println("The overall cash flow of the project is  " + (overallProfit - overallCost)
				+ "\n, with the overall cash flow of the Condos in Final Construction being " + FCFinal
				+ "\n, and the overall cash flow of the Condos that are Closed being " + CFinal);
	}

	public void reserveCondo(Condo l) { // Find logic to request certain location in condo
		if (l.getStatus().equals("Available")) {
			l.setStatus("Final Construction");
			System.out.println(
					"You reserved the condo, costing you 30 percent of the cost: $" + l.getCustomerCost() * .3);
			overallProfit += (l.getCustomerCost() * .3);
		} else {
			System.out.println("The condo you were meant to buy is not available.");
		}
	}

	public void backoutDealCondo(Condo l) {
		if (l.getStatus().equals("Final Construction")) {
			l.setStatus("Available");
			overallProfit -= (l.getCustomerCost() * .3) * .1;
			System.out.println("You've successfully backed out of the deal with 10% of the money you've paid: $"
					+ (l.getCustomerCost() * .3) * .1);
		} else {
			System.out.println("You cannot back out of this deal. Condo: " + l.getID());
		}
	}

	public void buyCondo(Condo l) {
		if (l.getStatus().equals("Final Construction")) {
			l.setStatus("Sold");
			overallProfit += (l.getCustomerCost() * .7);
			System.out.println("Successfully bought condo! Owner profit has made $" + l.getProfit()
					+ ", with customer cost being $" + l.getCustomerCost());
		} else {
			System.out.println("You cannot buy condo: " + l.getID());
		}
	}

	public void requestCondo(String s) {
		float moneyStartOfFC = 0, closingCost;
		int uID = 0;
		String stat;

		System.out.println("\nRequested Condo Info:");
		System.out.println(String.format("%1$25s %2$25s %3$25S %4$25S %5$25S", "CondoID:", "Condo Type:",
				"Condo Status:", "Final Construction Pay:", "Money Need for Closing:"));
		for (int i = 0; i < condoList.size(); i++) {

			if (condoList.get(i).getClass().getSimpleName().equals(s)
					&& condoList.get(i).getStatus().equals("Available")) {
				moneyStartOfFC = (float) (condoList.get(i).getCustomerCost() * .3);
				stat = condoList.get(i).getStatus();
				uID = condoList.get(i).getID();

				System.out.println(String.format("%1$25d %2$25s %3$25s %4$25.2f %5$25.2f", uID,
						condoList.get(i).getClass().getSimpleName(), stat, moneyStartOfFC,
						condoList.get(i).getCustomerCost() - (moneyStartOfFC)));
			}

		}
		System.out.println();
	}
}
