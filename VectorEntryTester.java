public class VectorEntryTester
{


	//TestObjects 
	static VectorEntry entry1 = new VectorEntry(1,2);
	static VectorEntry entry2 = new VectorEntry(-1,-2);
	static VectorEntry entry3 = new VectorEntry(1,-2); 
	static VectorEntry entry4 = new VectorEntry(50 , 100);
	static VectorEntry entry5 = new VectorEntry(-50 ,-100 );
	static VectorEntry entry6 = new VectorEntry(50 , -100 );
	static VectorEntry entry7 = new VectorEntry(0,100); 


	public static void main(String[] args) {
		
		testConstructors();
		testCompare();

	}//end main 


	public static void testConstructors()
	{

	
		//check that negative values come back in the right order 

			
			//case 1 negative denominator positive	 numerator 
			if(entry1.getNumerator() == 1 && entry1.getDenominator() == 2 )
			{

				System.out.println("Test passed on Entry 1");

			}//end if 
			else
			{

				System.out.println("Test failed of ENTRY 1 looked for 1 and 2 and found "+ entry1.getNumerator() + " " + entry1.getDenominator() ); 

			}//end else 

			
			//case 2 negative denominator negative numerator 
			if(entry2.getNumerator() == 1 && entry2.getDenominator() == 2 )
			{

				System.out.println("Test passed on entry 2");

			}//end if 
			else
			{

				System.out.println("Test failed on ENTRY 2 looked for 1 and 2 and found " + entry2.getNumerator() + " and "+ entry2.getDenominator() );

			}//end else 


			//case 3 positive denominator negative numerator
			if(entry3.getNumerator() == -1 && entry3.getDenominator() == 2)
			{

				System.out.println("Test passed on Entry 3");

			}//end if 
			else
			{

				System.out.println(" Test failed on ENTRY 3 looked for -1 and 2 and found " + entry3.getNumerator() + " " + entry3.getDenominator() );

			}//end else 

		//select out for division by zero 

		//check for lowest terms cases 

			//case 1 already in lowest terms 
			if (entry4.getNumerator() == 1 && entry4.getDenominator() == 2 ) 
			{
			
				System.out.println("Test passed on ENTRY 4");

			}//end if 
			else
			{

				System.out.println("Test failed on ENTRY 4 looked for 1 and 2 and found "+ entry4.getNumerator() +" "+ entry4.getDenominator() );

			}//end else

				
			//case 2 not in lowest terms both terms positive 
			if (entry5.getNumerator() == 1 && entry5.getDenominator() == 2 ) 
			{
			
				System.out.println("Test passed on ENTRY 5");

			}//end if 
			else
			{

				System.out.println("Test failed on ENTRY 5 looked for 1 and 2 and found  "+ entry5.getNumerator() + " " + entry5.getDenominator() );

			}//end else 

			//case 3 already lowest terms opposite signed terms 
			if(entry6.getNumerator() == -1 && entry6.getDenominator() == 2 )
			{

				System.out.println("Test passed on ENTRY 6");

			}//end if 
			else
			{

				System.out.println("Test failed on ENTRY 6 looked for -1 and 2 and found  "+ entry6.getNumerator() + " " +entry6.getDenominator() );

			}//end else 


	}//end testConsturctors




	public static void testCompare()
	{

		//test for similarity for all sign differences 
		if( entry1.compareVectorEntry(entry2) == true )
		{

			System.out.println("Test passed for comparing ENTRY 1  and ENTRY 2");

		}//end if 
		if(entry1.compareVectorEntry(entry7) == false)
		{

			System.out.println("Test passed for comparing entry1 and entry7");

		}

		//test for difference for all sign diffenrences

	}//end testCompare 


}//end class 