import java.util.Scanner;

public class TaxCalculator
{

	/**
	 * Daniel Ingram
	 */
	public static void main(String[] args)
	{
		//Declaration of Scanner class, income variable and boolean.
		Scanner input = new Scanner(System.in);
		double income;
		boolean end = true;
		
		//Do loop to ensure that the program runs at least once.
		do
		{
			//System prints a prompt for the user then collects the input.
			System.out.println("How much money has this child earnt? (GBP, no letters please!)");
			income = input.nextDouble();
		
			//Tests that the input is positive
			if(income < 0)
			{
				System.out.println("You have entered a negative amount, please try again.\n");
			}
			else
			{
				//Runs Tax Payable method
				System.out.println("This child is paying £" + taxPayable(income) + " in tax.");
				//Runs Net Earnings method
				System.out.println("Therefore, this child will receive £" + netEarnings(income));
				//Tells boolean to exit
				end = false;
			}
		}while(end);		
	}

	public static double taxPayable(double income)
	{
		//Declares the taxBreak and taxRate arrays. These can be changed at any point.
		int[] taxBreak = { 400, 300, 200, 150, 100, 0};
		double[] taxRate = { 1.2, 0.6, 0.4, 0.2, 0.1, 0};
		double tax = 0;
		double temp;

		
		//This for loop applies the tax based on the input.
		for (int x = 0; x < 6; x++)
		{
			temp = (income - taxBreak[x]);
			if (temp > 0)
			{
				temp = temp * taxRate[x];
				tax = tax + temp;
				income = taxBreak[x];
			}
		}
		tax = Math.round(tax);
		return tax;

	}

	public static double netEarnings(double income)
	{
		//Calculates the income taken home by deducting the tax from the net income
		income = income - taxPayable(income);
		return income;
	}

}
