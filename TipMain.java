import java.util.Scanner;

public class TipMain {

	// class variables
	private double billCost;
	private double tipPercent;
	private double tipAmount;
	Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		TipMain billCalc = new TipMain();
		System.out.printf("%.2f", billCalc.costOfBill());

	}

	// gets the cost of the user's bill
	public double costOfBill() {

		System.out.print("How Much Was Your Bill? $");
		if (!scnr.hasNextInt() && !scnr.hasNextDouble()) {
			System.out.println();
			System.out.println("Invalid input, please enter a number.");
			scnr.next();
			costOfBill();
		}
		billCost = scnr.nextDouble();
		tipPercent = experienceCalculator();
		tipAmount = billCost * tipPercent;
		
		return tipAmount;
	}

	public double experienceCalculator() {
		// variables
		double tipTemp = 0;
		int rating = 0;
		boolean testLoop = true;
		boolean trueOrFalse = false;
		String tempQuestion;

		// gets user experience in restaurant in 1-5 rating
		
		while (testLoop) {

			System.out.print("How was your experience? Please enter a number 1-5, where 1 is terrible and 5 is awesome. ");
			if (!scnr.hasNextInt()) {
				scnr.next();
				System.out.println("Invalid input.");
				
			} else {
				rating = scnr.nextInt();
				if (rating >= 1 && rating <= 5) {
					testLoop = false;
				} else {
				System.out.println("Invalid input");
				}
			}
		}

		// calculates tip based on user experience
		switch (rating) {
		case 1:
			tipTemp = 0.12;
			break;
		case 2:
			tipTemp = 0.15;
			break;
		case 3:
			tipTemp = 0.18;
			break;
		case 4:
			tipTemp = 0.21;
			break;
		case 5:
			tipTemp = 0.24;
			break;
		}

		//asks the user if the bill was significantly less because of a discount
		testLoop = true;
		while (testLoop) {
			System.out.print("Was there a major deal? Yes or No. ");
			tempQuestion = scnr.next();
			if (tempQuestion.toLowerCase().compareTo("yes") == 0 || tempQuestion.toLowerCase().compareTo("no") == 0) {
				testLoop = false;
				if (tempQuestion.toLowerCase().compareTo("yes") == 0) {
					trueOrFalse = true;
				} else {
					trueOrFalse = false;
				}
			}
		}

		// adds 75% of the meal back on to the bill to calculate a tip if there was a major discount
		int numMeals = 0;
		testLoop = true;
		boolean findDiscount = false;
		boolean innerLoop = true;
		double originalPrices = 0;
		double discountedPrices = 0;

		while (testLoop) {
			if (trueOrFalse == true) {
				System.out.print("How many meals were discounted? ");

				if (scnr.hasNextInt()) {
					numMeals = scnr.nextInt();
					testLoop = false;
					findDiscount = true;
				} else {
					System.out.println("Please enter a number");
					scnr.next();
				}

				if (findDiscount) {
					for (int i = 1; i <= numMeals; i++) {
						innerLoop = true;
						while (innerLoop) {
							System.out.print("How much was meal " + i + " originally? $");
							if (scnr.hasNextInt() || scnr.hasNextDouble()) {
								originalPrices += scnr.nextDouble();
								innerLoop = false;
							} else {
								scnr.next();
							}
						}
					}

					for (int i = 1; i <= numMeals; i++) {
						innerLoop = true;
						while (innerLoop) {
							System.out.print("How much was meal " + i + " after the discount? $");
							if (scnr.hasNextInt() || scnr.hasNextDouble()) {
								discountedPrices += scnr.nextDouble();
								innerLoop = false;
							} else {
								scnr.next();
							}
						}
					}

					billCost += (originalPrices - discountedPrices) * 0.75;

				}

			} else {
				testLoop = false;
			}
			
			
		}
		
		testLoop = true;
		// gets user experience in restaurant in 1-5 rating
				while (testLoop) {

					System.out.print("How was attentive was your waiter/waitress? Please enter a number 1-5, where 1 is not helpful and 5 is always there when needed. ");
					if (!scnr.hasNextInt()) {
						scnr.next();
						System.out.println("Invalid input.");
						
					} else {
						rating = scnr.nextInt();
						if (rating >= 1 && rating <= 5) {
							testLoop = false;
						} else {
						System.out.println("Invalid input");
						}
					}
				}
					
				// calculates tip based on user experience
				switch (rating) {
				case 1:
					tipTemp = ((tipTemp += 0.12) / 2);
					break;
				case 2:
					tipTemp = ((tipTemp += 0.15) / 2);
					break;
				case 3:
					tipTemp = ((tipTemp += 0.18) / 2);
					break;
				case 4:
					tipTemp = ((tipTemp += 0.21) / 2);
					break;
				case 5:
					tipTemp = ((tipTemp += 0.24) / 2);
					break;
				}
				
		return tipTemp;
	}

}
