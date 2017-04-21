
public class BogOff
{

	/**
	 * Daniel Ingram
	 */
	public static void main(String[] args)
	{
		//Import the TaxChart class
		TaxChart taxes = new TaxChart();
		//Values to be input into the class
		int[] values = {50, 100, 125, 150, 200, 250, 300, 340, 400, 475};
		
		//Draws the Axes and Bars.
		taxes.drawAxis();
		taxes.drawBars(values);

	}

}
