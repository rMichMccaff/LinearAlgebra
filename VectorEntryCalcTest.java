public class VectorEntryCalcTest
{

	//test cases 
	static VectorEntry entry1 = new VectorEntry(1,2);
	static VectorEntry entry2 = new VectorEntry(1,2);
	static VectorEntry entry3 = new VectorEntry(1,4);
	static VectorEntry entry4 = new VectorEntry(50,100);
	static VectorEntry entry5 = new VectorEntry(75,100);
	static VectorEntry entry6 = new VectorEntry( -50 , 100 );
	static VectorEntry entry7 = new VectorEntry(50, -100);
	static VectorEntry entry8 = new VectorEntry(2,4);
	static VectorEntry entry9 = new VectorEntry(-3,4);
	static VectorEntry entry10 = new VectorEntry(0,4);



	public static void main(String[] args) {
		System.out.println("**** VECTOR ENTRY CALCULATOR TESTS****");
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
	 	System.out.println();
	 	System.out.println();
	 	System.out.println("************ADDITION TEST*************");
		additionTest();
	
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println();
		System.out.println();
		System.out.println("************SUBTRACTION TEST*************");
		subtractionTest();
	
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println();
		System.out.println();
		System.out.println("**********MULTIPLICATION TEST**********");
		multiplicationTest();
	
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println(); 
		System.out.println();
		System.out.println("*************DIVISION TEST*************");
		divisionTest(); 
	
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println();
		System.out.println();
		System.out.println("**********EXPONENTIATION TEST*********");
		exponentiationTest(); 
	
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 
		System.out.println("**************************************"); 


	}//end main 


	//additionTest 
	public static void additionTest()
	{



		System.out.println("**************************************"); 

		//test case entry1 and entry2
		if( (VectorEntryCalculator.addition(entry1 , entry2).getNumerator() == 1) && (VectorEntryCalculator.addition(entry1 ,entry2 ).getDenominator() == 1) )
		{

			System.out.println("Test for entry1 and entry2 addition passed."); 

		}//end if 
		else
		{

			System.out.println("Test for entry1 and entry2 addition failed looked for 1/1 and found "  
								+ VectorEntryCalculator.addition(entry1 , entry2).getNumerator() + " " 
								+ VectorEntryCalculator.addition(entry1 ,entry2 ).getDenominator() ); 

		}//end else 
	
		


		//test case entry1 and entry3
		if((VectorEntryCalculator.addition(entry1,entry3).getNumerator()) == 3  &&  (VectorEntryCalculator.addition(entry1, entry3).getDenominator()) == 4 )
		{

			System.out.println("Test for entry1 and entry3 addition passed"); 

		}//end if 
		else
		{

			System.out.println("Test for entry1 and entry2 addition failed looked for 3/4 and found "  
								+ VectorEntryCalculator.addition(entry1 , entry3).getNumerator() + " " 
								+ VectorEntryCalculator.addition(entry1 ,entry3 ).getDenominator() ); 

		}//end else 		


	


		//test case entry4 and entry5 
		if(VectorEntryCalculator.addition(entry4,entry5).getNumerator() == 5 && VectorEntryCalculator.addition(entry4,entry5).getDenominator() == 4 )
		{

			System.out.println("Test for entry4 and entry5 addition passed."); 

		}//end if 
		else
		{

			System.out.println("Test for entry1 and entry2 addition failed looked for 3/4 and found "  
								+ VectorEntryCalculator.addition(entry4 , entry5).getNumerator() + " " 
								+ VectorEntryCalculator.addition(entry4 ,entry5 ).getDenominator() ); 

		}//end else 		
			
		//test case entry5 and entry6
		if(VectorEntryCalculator.addition(entry5,entry6).getNumerator() == 1 && VectorEntryCalculator.addition(entry5,entry6).getDenominator() == 4 )
		{

			System.out.println("Test for entry5 and entry6 addition passed.");

		}//end if 
		else
		{

			System.out.println("Test for entry1 and entry2 addition failed looked for 3/4 and found "  
								+ VectorEntryCalculator.addition(entry5 , entry6).getNumerator() + " " 
								+ VectorEntryCalculator.addition(entry5 ,entry6 ).getDenominator() ); 

		}//end else 
		
		//test case entry7 and entry8
		if(VectorEntryCalculator.addition(entry7,entry8).getNumerator() == 0 && VectorEntryCalculator.addition(entry7,entry8).getDenominator() == 4)
		{

			System.out.println("Test for Entry7 and Entry8 addition passed");

		}//end if 
		else
		{

			System.out.println("Test for entry7 and entry8 addition failed looked for 3/4 and found "  
								+ VectorEntryCalculator.addition(entry7 , entry8).getNumerator() + " " 
								+ VectorEntryCalculator.addition(entry7 ,entry8 ).getDenominator() ); 

		}//end else 		
		
		//test case entry9 and entry8
		if(VectorEntryCalculator.addition(entry9,entry8).getNumerator() == -1 && VectorEntryCalculator.addition(entry9,entry8).getDenominator() == 4)
		{

			System.out.println("Test for entry9 and entry8 addition passed. ");

		}//end if 
		else
		{

			System.out.println("Test for entry9 and entry8 addition failed looked for -1/4 and found "  
								+ VectorEntryCalculator.addition(entry9 , entry8).getNumerator() + " " 
								+ VectorEntryCalculator.addition(entry9 ,entry8 ).getDenominator() );

		}//end else 


	}//end additionTest 


	//subtractionTest 
	public static void subtractionTest()
	{
		//entry 1 and entry2
		if(VectorEntryCalculator.subtraction(entry1,entry2).getNumerator() == 0 && VectorEntryCalculator.subtraction(entry1,entry2).getDenominator() == 4)
		{
				
			System.out.println("Test passed for Subtraction entry1 and entry2");

		}
		else
		{


		}
	
		//entry1 and entry3
		if(VectorEntryCalculator.subtraction(entry1,entry3).getNumerator() == 1 && VectorEntryCalculator.subtraction(entry1,entry3).getDenominator() == 4)
		{
	
			System.out.println("Test passed for Subtraction entry1 and entry3.");

		}
		else
		{

		}
			
		//entry4 and entry5 
		if(VectorEntryCalculator.subtraction(entry4,entry5).getNumerator() == -1 && VectorEntryCalculator.subtraction(entry4,entry5).getDenominator() == 4)
		{
			
			System.out.println("Test passed for Subtraction entry4 and entry5");

		}
		else
		{


		}
	
		//entry5 and entry6
		if(VectorEntryCalculator.subtraction(entry5,entry6).getNumerator() == 5 && VectorEntryCalculator.subtraction(entry5,entry6).getDenominator() == 4)
		{

			System.out.println("Test passed for Subtraction entry5 and entry6");

		}
		else
		{



		}
			
		//entry7 and entry8 
		if(VectorEntryCalculator.subtraction(entry7,entry8).getNumerator() == -1 && VectorEntryCalculator.subtraction(entry7,entry8).getDenominator() == 1)
		{

			System.out.println("Test passed for Subtraction entry7 and entry8");

		}
		else
		{


			
		}		
		
		//entry8 and entry9 
		if(VectorEntryCalculator.subtraction(entry8,entry9).getNumerator() == 5 && VectorEntryCalculator.subtraction(entry8,entry9).getDenominator() == 4)
		{

			System.out.println("Test passed for Subtraction entry8 and entry9"); 

		}
		else
		{


			
		}

		
	}//end subtractionTest 


	//multiplicationTest 
	public static void multiplicationTest()
	{


		if(VectorEntryCalculator.multiplication(entry10, entry1).getNumerator() == 0 && VectorEntryCalculator.multiplication(entry10, entry1).getDenominator() == 8 )
		{

			System.out.println("Test passed for Multiplication entry10 and entry1."); 

		}
		else
		{



		}
		
		if(VectorEntryCalculator.multiplication(entry1, entry2).getNumerator() == 1 && VectorEntryCalculator.multiplication(entry1, entry2).getDenominator() == 4 )
		{

			System.out.println("Test poassed for Multiplication entry1 and entry2.");

		}
		else
		{}		
		
		if(VectorEntryCalculator.multiplication(entry1, entry3).getNumerator() == 1 && VectorEntryCalculator.multiplication(entry1, entry3).getDenominator() == 8)
		{
			System.out.println("Test passed for Multiplication entry1 and entry3");

		}
		else
		{}		
		
		if(VectorEntryCalculator.multiplication(entry4, entry5).getNumerator() == 3 && VectorEntryCalculator.multiplication(entry4, entry5).getDenominator() == 8)
		{

			System.out.println("Test passed for Multiplication entry4 and entry5"); 

		}
		else
		{}		
	
		if(VectorEntryCalculator.multiplication(entry5, entry6).getNumerator() == -3 && VectorEntryCalculator.multiplication(entry5, entry6).getDenominator() == 8)
		{

			System.out.println("Test passed for Multiplication entry5 and entry6"); 

		}
		else
		{}		
		
		if(VectorEntryCalculator.multiplication(entry7, entry8).getNumerator() == -1 && VectorEntryCalculator.multiplication(entry7, entry8).getDenominator() == 4)
		{

			System.out.println("Test passed for Multiplication entry7 and entry8"); 

		}
		else
		{}		
			
		if(VectorEntryCalculator.multiplication(entry8, entry9).getNumerator() == -3 && VectorEntryCalculator.multiplication(entry8, entry9).getDenominator() == 8)
		{

			System.out.println("Test passed for Multiplication entry8 and entry9");

		}
		else
		{


		}

	}//end multiplicationTest


	//divisionTest 
	public static void divisionTest()
	{

	

		if(VectorEntryCalculator.division(entry1,entry2).getNumerator() == 1  &&  VectorEntryCalculator.division(entry1,entry2).getDenominator() == 1)
		{

			System.out.println("Passed Division Test for entry1 and entry2");

		}
		else
		{

			System.out.println("Failed Division Test for entry1 and entry2 looked for 1 and 2 and found " +VectorEntryCalculator.division(entry1,entry2).getNumerator() + " " +VectorEntryCalculator.division(entry1,entry2).getDenominator() );

		}
		if(VectorEntryCalculator.division(entry1,entry3).getNumerator() == 2  &&  VectorEntryCalculator.division(entry1,entry3).getDenominator() == 1)
		{
			System.out.println("Passed Division Test for entry1 and entry3."); 
		}
		else
		{

			System.out.println("Failed Division Test for entry1 and entry3 looked for 2 and 1 and found " +VectorEntryCalculator.division(entry1,entry3).getNumerator() + " " +VectorEntryCalculator.division(entry1,entry3).getDenominator() );


		}
		if(VectorEntryCalculator.division(entry3,entry4).getNumerator() == 1  &&  VectorEntryCalculator.division(entry3,entry4).getDenominator() == 2)
		{

			System.out.println("Passed Division Test for entry3 and entry4 "); 

		}
		else
		{

			System.out.println("Failed Division Test for entry3 and entry4 looked for 2 and 1 and found " +VectorEntryCalculator.division(entry3,entry4).getNumerator() + " " +VectorEntryCalculator.division(entry3,entry4).getDenominator() );


		}
		if(VectorEntryCalculator.division(entry5,entry6).getNumerator() == -3  &&  VectorEntryCalculator.division(entry5,entry6).getDenominator() == 2)
		{

			System.out.println("Passed Division Test for entry5 and entry6");

		}
		else
		{

			System.out.println("Failed Division Test for entry5 and entry6 looked for -3 and 2 and found " +VectorEntryCalculator.division(entry5,entry6).getNumerator() + " " +VectorEntryCalculator.division(entry5,entry6).getDenominator() );


		}
		if(VectorEntryCalculator.division(entry10,entry9).getNumerator() == 0  &&  VectorEntryCalculator.division(entry10,entry9).getDenominator() == 12)
		{

			System.out.println("Passed Division Test for entry10 and entry9");

		}
		else
		{

			System.out.println("Failed Division Test for entry5 and entry6 looked for -3 and 2 and found " +VectorEntryCalculator.division(entry10,entry9).getNumerator() + " " +VectorEntryCalculator.division(entry10,entry9).getDenominator() );


		}
		if(VectorEntryCalculator.division(entry7,entry9).getNumerator() == 2  &&  VectorEntryCalculator.division(entry7,entry9).getDenominator() == 3)
		{

			System.out.println("Passed Division Test for entry7 and entry9");


		}	
		else
		{
			System.out.println("Failed Division Test for entry7 and entry9 looked for 2 and 3 and found " +VectorEntryCalculator.division(entry7,entry9).getNumerator() + " " +VectorEntryCalculator.division(entry7,entry9).getDenominator() );

		}

	


	}//end divisionTest
	

	//exponentiationTest
	public static void exponentiationTest()
	{

		if(VectorEntryCalculator.exponentiation(entry1,2).getNumerator() ==  1 && VectorEntryCalculator.exponentiation(entry1,2).getDenominator() == 4 )
		{

			System.out.println("Passed Exponentiation Test for entry1");

		}
		else
		{

			System.out.println("Failed Exponentiation test for entry1 looked for 1/4 and found " + VectorEntryCalculator.exponentiation(entry1,2).getNumerator() + " " + VectorEntryCalculator.exponentiation(entry1,2).getDenominator() );
			


		}

		if(VectorEntryCalculator.exponentiation(entry6,2).getNumerator() ==  1 && VectorEntryCalculator.exponentiation(entry6,2).getDenominator() == 4 )
		{

			System.out.println("Passed Exponentiation Test for entry6");

		}
		else
		{

			System.out.println("Failed Exponentiation test for entry6 looked for 1/4 and found "+VectorEntryCalculator.exponentiation(entry6,2).getNumerator()+""+VectorEntryCalculator.exponentiation(entry6,2).getDenominator());

		}
		if(VectorEntryCalculator.exponentiation(entry6,3).getNumerator() ==  - 1 && VectorEntryCalculator.exponentiation(entry6,3).getDenominator() == 8 )
		{

			System.out.println("Passed Exponentiation Test for entry6 degree three.");

		}
		else
		{

			System.out.println("Failed Exponentiation test for entry6 looked for -1/8 and found "+VectorEntryCalculator.exponentiation(entry6,3).getNumerator()+" "+VectorEntryCalculator.exponentiation(entry6,3).getDenominator());
			

		}		
		if(VectorEntryCalculator.exponentiation(entry7,3).getNumerator() ==  - 1 && VectorEntryCalculator.exponentiation(entry7,3).getDenominator() == 8)
		{

			System.out.println("Passed Exponentiation Test for entry7 ");

		}
		else
		{

			System.out.println("Failed Exponentiation test for entry6 looked for -1/8 and found "+VectorEntryCalculator.exponentiation(entry7,3).getNumerator()+" "+VectorEntryCalculator.exponentiation(entry7,3).getDenominator());

		}		
		if(VectorEntryCalculator.exponentiation(entry9,3).getNumerator() ==  - 27 && VectorEntryCalculator.exponentiation(entry9,3).getDenominator() == 64)
		{

			System.out.println("Passed Exponentiation Test for Entry9");

		}
		else
		{

			System.out.println("Failed Exponentiation test for entry6 looked for -27/48 and found "+VectorEntryCalculator.exponentiation(entry9,3).getNumerator()+" "+VectorEntryCalculator.exponentiation(entry9,3).getDenominator());


		}		
		if(VectorEntryCalculator.exponentiation(entry10,3).getNumerator() ==  0 && VectorEntryCalculator.exponentiation(entry10,3).getDenominator() == 64)
		{

			System.out.println("Passed Exponentiation Test for Entry10"); 

		}
		else
		{

			System.out.println("Failed Exponentiation test for entry6 looked for 0/48 and found "+VectorEntryCalculator.exponentiation(entry10,3).getNumerator()+" "+VectorEntryCalculator.exponentiation(entry10,3).getDenominator());


		}		

	}//end exponentiationTest



}//end class 