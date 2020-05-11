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


	static ArrayList<Vector> testVectors = new ArrayList<Vector>();  
	static ArrayList<Vector> solutionVectors = new ArrayList<Vector>(); 


	public static void main(String[] args) 
	{
	
		//try block 
		try
		{

			//create a file object 
			File file = new File("VectorTestInput.txt");

			//create a scanner 
			Scanner scan = new Scanner(file);

			//read in test vectors for 2d cases
			int numberOfCases = scan.nextInt(); 
			int length = scan.nextInt(); 
			for (int i = 0 ; i < numberOfCases ; i++) 
			{	
				
				//create a arraylist of vectorentries 
				ArrayList<VectorEntry> vectorEntryList = new ArrayList<VectorEntry>(); 

				for (int j = 0 ; j < 2*length ; j++) 
				{
					

					//create vector entries and add them to the list
					int numerator = scan.nextInt(); 
					int denominator = scan.nextInt(); 
					vectorEntryList.add(new VectorEntry(numerator,denominator)); 

				}//end for loop 

				//create a vector and add it to the vector list
				testVectors.add( new Vector(vectorEntryList) );

			}//end for loop   


			//read in testvectors for 3d cases
			numberOfCases = scan.nextInt(); 
			length = scan.nextInt();
			for (int i = 0 ; i < numberOfCases ; i++) 
			{
				
				//create arraylist of vector entries 
				ArrayList<VectorEntry> vectorEntryList = new ArrayList<VectorEntry>();


				for (int j = 0; j < 2*length; j++) 
				{
				
					int numerator = scan.nextInt(); 
					int denominator = scan.nextInt(); 
					vectorEntryList.add( new VectorEntry(numerator,denominator) ); 

				}//end for

				testVectors.add( new Vector(vectorEntryList) );

			}//end for

			//read in solutions addition
			numberOfCases = scan.nextInt();
			length = scan.nextInt(); 
			for (int i = 0 ; i < numberOfCases ; i++ ) 
			{


				//create arraylist of vector entries
				ArrayList<VectorEntry> vectorEntryList = new ArrayList<VectorEntry>(); 
				for (int j = 0 ; j < length*2 ; j++ ) 
				{
					
					int numerator = scan.nextInt(); 
					int denominator = scan.nextInt(); 
					vectorEntryList.add(new VectorEntry(numerator,denominator)); 

				}//end for 
				
				solutionVectors.add( new Vector(vectorEntryList) );

			}//end for 

			//read in solutions subtraction
			numberOfCases = scan.nextInt(); 
			length = scan.nextInt(); 
			for (int i = 0 ; i < numberOfCases ; i++ ) 
			{
				

				ArrayList<VectorEntry> vectorEntryList = new ArrayList<VectorEntry>(); 
				for (int j = 0 ; j < length*2 ; j++ ) 
				{
					
					int numerator = scan.nextInt(); 
					int denominator = scan.nextInt(); 
					vectorEntryList.add( new VectorEntry(numerator,denominator)	); 

				}//end for loop 

				solutionVectors.add( new Vector(vectorEntryList) ); 

			}//end for loop 


			//read in solutions 

			//call addition test 

			//call subtraction test 

			//call multiplication test

			//call dot product test


		}//end try
		//catch block for file not found 
		catch(FileNotFoundException e)
		{

			System.out.println("The read in file was not found");

		}//end throw



	}//end main 

}//end class 