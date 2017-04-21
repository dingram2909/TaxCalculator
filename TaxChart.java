import java.awt.Canvas;


public class TaxChart
{

	/**
	 * Daniel Ingram
	 */
	public static void main(String[] args)
	{
		int[] barValues = {25, 50, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 500, 550};
		drawAxis();
		drawBars(barValues);
	}
	
	public static void drawAxis()
	{
		//This method draws the axis for the chart.
		int xah = 1;
		int xaw = 200;
		int yah = 200;
		int yaw = 1;
	
		//Initialises the Bar objects.
		Bar xAxis = new Bar();
		Bar yAxis = new Bar();
		
		xAxis.changeSize(xaw, xah);
		yAxis.changeSize(yaw, yah);
		xAxis.changeColour(Colour.BLACK);
		yAxis.changeColour(Colour.BLACK);
		
		xAxis.moveVertical(200);
		xAxis.makeVisible();
		yAxis.makeVisible();
	}

	public static void drawBars(int[] barValues)
	{
		//Imports the TaxCalculator class
		TaxCalculator taxes = new TaxCalculator();
		
		//Declares the variables
		int barWidth = 3;
		double tempTaxHeight;
		double tempGrossHeight;
		int taxHeight;
		int grossHeight;
		System.out.println("Income | G.Income | Tax Paid");
		System.out.println("----------------------------");
		
		//For loop runs for the length of the array.
		for(int x = 0; x < barValues.length; x++)
		{
			//Takes the values from the netEarnings method and the taxPayable method
			tempGrossHeight = taxes.netEarnings(barValues[x]);
			tempTaxHeight = taxes.taxPayable(barValues[x]);
			
			//Formats the output for a table.
			System.out.printf("£%5d | £%7.2f | £%7.2f %n", barValues[x], tempGrossHeight, tempTaxHeight);
			
			//Adjusts the height of the bars so that they will fit on the canvas.
			taxHeight = (int)(tempTaxHeight/4);
			grossHeight = (int)(tempGrossHeight/4);
			
			//Creates two bars for the chart.
			Bar gross = new Bar();
			Bar tax = new Bar();
			
			//Resizes and flips the gross income bar.
			gross.changeSize(barWidth, grossHeight);
			gross.changeColour(Colour.YELLOW);
			gross.moveHorizontal((x+1)*10);
			gross.moveVertical((Canvas.HEIGHT - grossHeight) + 198);
			gross.makeVisible();
			
			//Resizes and flips the tax paid bar.
			tax.changeSize(barWidth, taxHeight);
			tax.changeColour(Colour.RED);
			tax.moveHorizontal((x+1)*10);
			tax.moveVertical(((Canvas.HEIGHT - grossHeight) + 198) - taxHeight);
			tax.makeVisible();
			
		}
	}
}
