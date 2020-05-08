import java.lang.Math; 

public class VectorEntryCalculator
{


	public static VectorEntry addition(VectorEntry entry1, VectorEntry entry2)
	{

		int newNumerator1 = entry1.getNumerator() * entry2.getDenominator();
		int newNumerator2 = entry2.getNumerator() * entry1.getDenominator();

		int resultNumerator = newNumerator1 + newNumerator2;		
		int newDenominator  = Math.abs( entry1.getDenominator() * entry2.getDenominator() );


		return new VectorEntry(resultNumerator,newDenominator);

	}//end addition 	


	public static VectorEntry subtraction(VectorEntry entry1, VectorEntry entry2)
	{

		VectorEntry negative = new VectorEntry(-1,1); 
		entry2 = multiplication(entry2,negative);

		return addition(entry1, entry2);

	}//end subtraction 


	public static VectorEntry multiplication(VectorEntry entry1, VectorEntry entry2)
	{



		return new VectorEntry(entry1.getNumerator() * entry2.getNumerator() , entry1.getDenominator() * entry2.getDenominator() );

	}//end multiplication method


	public static VectorEntry division(VectorEntry entry1, VectorEntry entry2)
	{

		return new VectorEntry(entry1.getNumerator() * entry2.getDenominator(), entry1.getDenominator() * entry2.getNumerator());

	}//end division 


	public static VectorEntry exponentiation(VectorEntry entry1 ,int degree)
	{


		VectorEntry localEntry = new VectorEntry( entry1.getNumerator() , entry1.getDenominator() );

		for (int i = 0 ; i < degree - 1 ; i++ ) 
		{
			
			localEntry = multiplication(localEntry,entry1);

		}//end for loop 

		return localEntry; 

	}//end eponentiation method 
	

}//end class 