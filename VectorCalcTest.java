/*

The purpose of this class is to read in from a text file to construct test 
cases for the vector calculator.  There will need to be six methods tested 
in total.  

There will be a read in pattern for the test case from the text file.

first line : Number of Test Vectors 
second line : Length of test 
Test cases
* to indicate ending of test cases 

first line : number to test Vectors 
second line : length of test vectors 
Test Cases
* to indicate ending of test cases 

number of addition answers 
number of cases 
length of solution 
solutions
length of solution
solutions 


number of subtraction answers 
number of cases 
length of solutions 
soutions 
length of solution 
solutions 


*/


import java.util.ArrayList;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class VectorCalcTest
{


	static ArrayList<Vector> testVectors2D = new ArrayList<Vector>();
	static ArrayList<Vector> testVectors3D = new ArrayList<Vector>();   
	static ArrayList<Vector> solutionVectors2D = new ArrayList<Vector>(); 
	static ArrayList<Vector> solutionVectors3D = new ArrayList<Vector>(); 
	static ArrayList<VectorEntry> scalars = new ArrayList<VectorEntry>(); 
	static ArrayList<VectorEntry> dotProducts2D = new ArrayList<VectorEntry>(); 
	static ArrayList<VectorEntry> dotProducts3D = new ArrayList<VectorEntry>(); 


	public static void main(String[] args) 
	{
	
		//try block 
		try
		{

			//create a file object 
			File file = new File("VectorTestInput.txt");

			//create a scanner 
			Scanner scan = new Scanner(file);

			testLoaderCases(scan,2);

			testLoaderCases(scan,3);


			//load addition solutions 2D and 3D
			testLoaderSolutions(scan,2);
			testLoaderSolutions(scan,3);
			additionTestCycle();
			
			solutionVectors2D = new ArrayList<Vector>();
			solutionVectors3D = new ArrayList<Vector>();
			testLoaderSolutions(scan,2);
			testLoaderSolutions(scan,3);  
			subtractionTestCycle(); 

			//scalar test cases 
			solutionVectors2D = new ArrayList<Vector>(); 
			solutionVectors3D = new ArrayList<Vector>(); 
			scalarLoader(scan);
			testLoaderSolutions(scan,2);
			testLoaderSolutions(scan,3);
			System.out.println(); 
/*
			System.out.println("2D Test Cases"); 
			for (int i = 0 ;i < testVectors2D.size() ; i++ ) 
			{
			
				System.out.println(testVectors2D.get(i).print()); 

			}//end for 
			System.out.println("3D Test Cases"); 
			for (int i = 0 ; i < testVectors3D.size() ; i++ ) 
			{
			
				System.out.println(testVectors3D.get(i).print()); 

			}//end for 
*/
			scalarTestCycle();

			//dot product
			dotProductLoader(scan,2);
			dotProductLoader(scan,3);
			dotProductTestCycle(); 

		}//end try
		//catch block for file not found 
		catch(FileNotFoundException e)
		{

			System.out.println("The read in file was not found");

		}//end throw



	}//end main 



	public static void testLoaderSolutions(Scanner scan, int dimension)
	{

		if(dimension == 2) 
		{
		 	int cases = scan.nextInt(); 
		 	int length = scan.nextInt(); 

			for (int i = 0 ; i < cases ; i++ ) 
			{
			
				ArrayList<VectorEntry> entryList = new ArrayList<VectorEntry>(); 

				for (int j = 0 ; j < length ; j++ ) 
				{
				
					int numerator = scan.nextInt(); 
					int denominator = scan.nextInt(); 

					entryList.add( new VectorEntry(numerator,denominator) ); 

				}//end for 

				solutionVectors2D.add( new Vector(entryList) ); 

			}//end for 

		}//end if  
		else if(dimension == 3)
		{

			int cases = scan.nextInt(); 
			int length = scan.nextInt(); 

			for (int i = 0 ; i < cases ; i++ ) 
			{
			
				ArrayList<VectorEntry> entryList = new ArrayList<VectorEntry>(); 

				for (int j = 0 ; j < length ; j++ ) 
				{
					int numerator = scan.nextInt(); 
					int denominator = scan.nextInt(); 

					entryList.add( new VectorEntry(numerator,denominator) ); 

				}//end for 

				solutionVectors3D.add(new Vector(entryList) );

			}//end for 

		}//end else 

	}//end testLoader


	public static void scalarLoader(Scanner scan)
	{

		int numberOfScalars = scan.nextInt();
		for (int i = 0 ; i < numberOfScalars ; i++ ) 
		{
		 	
			int numerator = scan.nextInt(); 
			int denominator = scan.nextInt(); 

			scalars.add(new VectorEntry(numerator,denominator) ); 

		}//end for  

	}//end scalarLoader 


	public static void dotProductLoader(Scanner scan, int dimension)
	{

		if (dimension == 2) 
		{
		
			int testCases = scan.nextInt(); 
			for (int i = 0 ; i < testCases ; i++ ) 
			{
				int numerator = scan.nextInt();
				int denominator = scan.nextInt(); 

				dotProducts2D.add( new VectorEntry(numerator,denominator) ); 

			}//end for loop 


		}
		else
		{

			int testCases = scan.nextInt(); 
			for (int i = 0 ; i < testCases ; i++ ) 
			{
				int numerator = scan.nextInt();
				int denominator = scan.nextInt(); 

				dotProducts3D.add( new VectorEntry(numerator,denominator) ); 

			}//end for loop 			

		}


	}//end dotProductLoader

	public static void testLoaderCases(Scanner scan,int dimension)
	{

		//if dimension is 2 
		if(dimension == 2) 
		{
			int cases = scan.nextInt(); 
			int length = scan.nextInt(); 

			//add vectors to the 2D testVectors 
			for (int i = 0 ; i < cases ; i++ ) 
			{
				ArrayList<VectorEntry> entryList = new ArrayList<VectorEntry>(); 

				for (int j = 0 ; j < length ; j++) 
				{
					
					int numerator = scan.nextInt(); 
					int denominator = scan.nextInt(); 

					entryList.add(new VectorEntry(numerator,denominator));

				}//end for 

				testVectors2D.add( new Vector(entryList) ); 

			}//end for 


		}
		//else dimension is 3 
		else if(dimension == 3) 
		{
			int cases = scan.nextInt(); 
			int length = scan.nextInt(); 

			for (int i = 0 ; i < cases  ; i++ ) 
			{
			
				ArrayList<VectorEntry> entryList = new ArrayList<VectorEntry>(); 

				for (int j = 0 ; j < length ; j++ ) 
				{
				
					int numerator = scan.nextInt(); 
					int denominator = scan.nextInt(); 
					entryList.add(new VectorEntry(numerator,denominator)); 

				}//end for 

				testVectors3D.add( new Vector(entryList) ); 
			}//end for 

		}//end else 

	}//end testLoaderCases



	public static void debugPrint(int solutionLoc, int operationOne, 
									int operationTwo, int testNumber,
									int dimension					
									)
	{

		System.out.println("Test number " + testNumber + "FAILED");
		if(dimension == 2)
		{

			System.out.println("Performed operation on " + testVectors2D.get(operationOne).print() + 
								" and " + testVectors2D.get(operationTwo).print() ); 

			System.out.println( "Solution was meant to be " + solutionVectors2D.get(solutionLoc).print() ); 

		}
		else if(dimension == 3)
		{


			System.out.println("Performed operation on " + testVectors3D.get(operationOne).print() + 
								" and " + testVectors3D.get(operationTwo).print() ); 
			
			System.out.println( "Solution was meant to be " + solutionVectors3D.get(solutionLoc).print() + 
								" on test number " + testNumber);			

		}

	
	}//end debugPrint



	public static void additionTestCycle()
	{
		
		System.out.println("***************"); 
		System.out.println("ADDITION TEST");
		boolean resultBool = true; 
		//2D tests
		System.out.println("2D Tests"); 
		for (int i = 0 ; i < testVectors2D.size() ; i++ ) 
		{
		
							
			if(i + 1 == testVectors2D.size() )
			{

				break; 

			}//end if 
			else
			{

				resultBool = additionTest(2,i,i,i+1,i+1);
				if(resultBool == false)
				{

					break; 

				}//end if 

			}//end else 

			
		}//end for 
		System.out.println("3D Tests"); 
		//3D tests 
		for (int i = 0 ; i < testVectors3D.size() ; i++ ) 
		{
			
			if(i + 1 == testVectors3D.size() )
			{

				break; 

			}//end if 
			else
			{
				resultBool = additionTest(3,i,i,i+1,i+1);
				if(resultBool == false)
				{

					break; 

				}//end if  
					
			}//end else


		}//end for 


	}//end additionTestCycle



	public static boolean additionTest(int dimension, int solutionLoc,
										 int additionLocOne, int additionLocTwo,int testNumber)
	{


		//run the test case
		if(dimension == 2)
		{

			if (solutionVectors2D.get(solutionLoc).compareVector( 
				VectorCalculator.addition( testVectors2D.get(additionLocOne) ,
											 testVectors2D.get(additionLocTwo) )  )
											== false) 
			{
			
					debugPrint(solutionLoc,additionLocOne,additionLocTwo,testNumber,dimension); 
					return false; 

			}//end if 
			else
			{

				System.out.println("Test number " + testNumber + " PASSED "); 

			}//end else

		}//end if  
		else if(dimension == 3)
		{

			if (solutionVectors3D.get(solutionLoc).compareVector( 
				VectorCalculator.addition( testVectors3D.get(additionLocOne) ,
											 testVectors3D.get(additionLocTwo) )  )
											== false) 
			{
			
					debugPrint(solutionLoc,additionLocOne,additionLocTwo,testNumber,dimension); 
					return false; 

			}//end if 
			else
			{

				System.out.println("Test number " + testNumber + " PASSED "); 

			}//end else
		}//end else 
		

		return true; 
	

	}//end additionTest 



	public static void subtractionTestCycle()
	{

		System.out.println("***************"); 
		System.out.println("SUBTRACTION TEST");
		boolean resultBool = true; 
		//2D tests
		System.out.println("2D Tests"); 
		for (int i = 0 ; i < testVectors2D.size() ; i++ ) 
		{
		
							
			if(i + 1 == testVectors2D.size() )
			{

				break; 

			}//end if 
			else
			{

				resultBool = subtractionTest(2,i,i,i+1,i+1);
				if(resultBool == false)
				{

					break; 

				}//end if 

			}//end else 

			
		}//end for 
		System.out.println("3D Tests"); 
		//3D tests 
		for (int i = 0 ; i < testVectors3D.size() ; i++ ) 
		{
			
			if(i + 1 == testVectors3D.size() )
			{

				break; 

			}//end if 
			else
			{
				resultBool = subtractionTest(3,i,i,i+1,i+1);
				if(resultBool == false)
				{

					break; 

				}//end if  
					
			}//end else


		}//end for 		

	}//end subtractionTestCycle



	public static boolean subtractionTest(int dimension, int solutionLoc,
										 int additionLocOne, int additionLocTwo,int testNumber)
	{


		//run the test case
		if(dimension == 2)
		{

			if (solutionVectors2D.get(solutionLoc).compareVector( 
				VectorCalculator.subtraction( testVectors2D.get(additionLocOne) ,
											 testVectors2D.get(additionLocTwo) )  )
											== false) 
			{
			
					debugPrint(solutionLoc,additionLocOne,additionLocTwo,testNumber,dimension); 
					return false; 

			}//end if 
			else
			{

				System.out.println("Test number " + testNumber + " PASSED "); 

			}//end else

		}//end if  
		else if(dimension == 3)
		{

			if (solutionVectors3D.get(solutionLoc).compareVector( 
				VectorCalculator.subtraction( testVectors3D.get(additionLocOne) ,
											 testVectors3D.get(additionLocTwo) )  )
											== false) 
			{
			
					debugPrint(solutionLoc,additionLocOne,additionLocTwo,testNumber,dimension); 
					return false; 

			}//end if 
			else
			{

				System.out.println("Test number " + testNumber + " PASSED "); 

			}//end else
		}//end else 
		

		return true; 

	}//end subtractionTest



	public static void scalarTestCycle()
	{

		System.out.println("****************");
		System.out.println("SCALAR MULTIPLICATION"); 
		
		//2d vectors 
		for (int i = 0 ; i < solutionVectors2D.size() ; i++ ) 
		{
		
			if(solutionVectors2D.get(i).compareVector( 
													VectorCalculator.scalarMultiplication(
														scalars.get(i),testVectors2D.get(i)) 
													)
			  == false) 
			{
			
				debugPrint(i,i,i,i+1,2);

			}//end if 
			else
			{

				System.out.println("Test number " + (i+1) +" PASSED ");

			}//end else 

		}//end for loop 
		
		//3d vectors 
		for (int i = 0 ; i < solutionVectors3D.size() ; i++ ) 
		{
			
			if(solutionVectors3D.get(i).compareVector( 
													VectorCalculator.scalarMultiplication(
														scalars.get(i),testVectors3D.get(i)) 
													)
			  == false) 
			{
			
				debugPrint(i,i,i,i+1,2);

			}//end if 
			else
			{

				System.out.println("Test number " + (i+1) +" PASSED ");

			}//end else 

		}//end for loop 

	}//end scalarTestCycle



	public static void dotProductTestCycle()
	{

		System.out.println("******************");
		System.out.println("DOT PRODUCT TEST");  
		System.out.println("2D Test");
		for (int i = 0 ; i < testVectors2D.size() ; i++ ) 
		{
		
			if(i+1 == testVectors2D.size())
			{

				break; 

			}//end if 

			if(dotProducts2D.get(i).compareVectorEntry(
				VectorCalculator.dotProduct(testVectors2D.get(i),testVectors2D.get(i+1)) ) == false)
			{

				System.out.println("Test number " + (i+1) + " FAILED " ); 
				break; 

			}//end if 
			else
			{

				System.out.println("Test number " + (i+1) + " PASSED"); 	

			}//end else

		}//end for 
		System.out.println("3D Test");
		for (int i = 0 ; i < testVectors3D.size() ; i++) 
		{
		
			if(i+1 == testVectors3D.size())
			{

				break; 

			}//end if 

			if(dotProducts3D.get(i).compareVectorEntry(
								VectorCalculator.dotProduct(testVectors3D.get(i),testVectors3D.get(i+1) )) == false)
			{

				System.out.println("Test number " + (i+1) + " FAILED " ); 
				System.out.println("Searched for " +
									 VectorCalculator.dotProduct(testVectors3D.get(i),testVectors3D.get(i)).getNumerator()
									 + "/" + VectorCalculator.dotProduct(testVectors3D.get(i),testVectors3D.get(i)).getDenominator() +
									  "  found " + dotProducts3D.get(i).getNumerator() + "/" + dotProducts3D.get(i).getDenominator()
									); 
				break; 

			}//end if 
			else
			{

				System.out.println("Test number " + (i+1) + " PASSED"); 	

			}//end else

		}//end for 

	}//end dotProductTest



	public static boolean crossProductTest()
	{

		return true; 

	}//end crossProductTest 



	public static boolean angleBetweenTest()
	{

		return true; 

	}//end angleBetweenTest


}//end class 