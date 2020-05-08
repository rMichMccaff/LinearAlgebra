import java.lang.Math; 

public class VectorEntry
{

	//GLOBAL VARIABLES 
	private int numerator; 
	private int denominator; 

	
	//CONSTRUCTORS
	public VectorEntry(int numerator, int denominator)
	{


		if(denominator == 0)
		{

			throw new IllegalArgumentException("Denominator contains a zero"); 

		}
		
		if(denominator < 0  && numerator < 0)
		{

			denominator = Math.abs(denominator);
			numerator = Math.abs(numerator);

		}//end if statement 

		if(denominator < 0 && numerator > 0)
		{

			numerator = -1 * numerator;
			denominator = -1 * denominator;

		}//end if statment 
		
		int[] lowestTermsAr = lowestTerms( Math.abs(numerator), Math.abs(denominator) );	

		if(numerator < 0 )
		{

			lowestTermsAr[0] = -1 * lowestTermsAr[0];

		}//end if 
	

		this.numerator = lowestTermsAr[0];
		this.denominator = lowestTermsAr[1];

	}//end VectorEntry constructor 


	public VectorEntry(VectorEntry newEntry)
	{

		
		if(newEntry.getDenominator() < 0 && newEntry.getNumerator() < 0 )
		{

			newEntry.setDenominator(-1 * newEntry.getDenominator());
			newEntry.setNumerator( -1 * newEntry.getNumerator() );

		}
		if(newEntry.getDenominator() < 0 && newEntry.getNumerator() > 0)
		{

			newEntry.setNumerator( Math.abs(newEntry.getNumerator() ) );
			newEntry.setDenominator( Math.abs(newEntry.getDenominator() ) );
		
		}//end if 


		int[] lowestTermsAr = lowestTerms( Math.abs( newEntry.getNumerator() ), Math.abs( newEntry.getDenominator() ) );


		if(newEntry.getNumerator() < 0)
		{

			lowestTermsAr[0] = -1 * lowestTermsAr[0];

		}//end if statement

		this.numerator = lowestTermsAr[0];
		this.denominator = lowestTermsAr[1];

	
	}//end constructor 

	
	//getNumerator
	public int getNumerator()
	{

		return this.numerator;

	}//end getNumerator


	//getDenominator
	public int getDenominator()
	{

		return this.denominator; 

	}//end getDenominator


	//setNumerator
	private void setNumerator(int newNumerator)
	{

		this.numerator = newNumerator;

	}//end setNumerator 


	//setDenominator
	private void setDenominator(int newDenominator)
	{

		this.denominator = newDenominator;

	}//end setDenominator


	
	//lowestTerms
	private int[] lowestTerms(int currentNumerator, int currentDenominator)
	{

		int lower = 0 ;
		int higher = 0;
		int remainder = 1; 

		if(currentNumerator == 0)
		{

			int[] returnArray = new int[2];

			returnArray[0] = 0; 

			returnArray[1] = currentDenominator;

			return returnArray;
		}

		//if currentNumerator > currentDenominator
		if (currentNumerator > currentDenominator) 
		{
			
			//hand off varaibles 
			lower = currentDenominator;
			higher = currentNumerator;
			
			//for loop  
			for ( ;remainder != 0 ; ) {
								
				remainder = higher % lower;

				higher = lower; 


				if(remainder == 0)
				{


					break;

				}

				lower = remainder;


			}//end for loop 

		}//end if statment 

		//else currentNumerator < currentDenominator
		if(currentDenominator > currentNumerator)
		{
			//hand off variables 
			lower = currentNumerator;
			higher = currentDenominator;
					 


			for (;remainder != 0  ; ) {

					
				remainder = higher % lower; 
				higher = lower;
				if(remainder == 0)
				{

					break;

				}
				lower = remainder; 
				


			}//end for loop 

		}//end else if 
		//else


		if(currentNumerator == currentDenominator)
		{


			int[] returnArray = new int[2];

			returnArray[0] = 1; 
			returnArray[1] = 1; 


			return returnArray; 
		}//end else


		currentNumerator = currentNumerator/lower; 
		
		currentDenominator = currentDenominator/lower;

		int[] localArray = new int[2];
		
		localArray[0] = currentNumerator; 
		localArray[1] = currentDenominator; 


		return localArray; 

	}//end lowestTerms

	//compareVectorEntry
	public boolean compareVectorEntry(VectorEntry comparingEntry)
	{


		boolean comparingVariable = true;

		if(this.numerator == 0 && comparingEntry.getNumerator() == 0)
		{

			return true; 

		}//end if 
 
		if (comparingEntry.getNumerator() != this.numerator) {
			
			comparingVariable = false;

		}//end if 

		if (comparingEntry.getDenominator() != this.denominator) {
			
			comparingVariable = false;

		}//end if 

		return comparingVariable;

	}//end compare method 


}//end class  