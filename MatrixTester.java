
import java.util.ArrayList; 
import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;

public class MatrixTester
{

	static ArrayList<Matrix> matrixList = new ArrayList<Matrix>(); 


	public static void main(String[] args)
	{
	
		//try 	
		try
		{

			//create a file object 
			File file = new File("MatrixTestTxt.txt");
			
			//create a scanner 
			Scanner scan = new Scanner(file); 

			//read first line to find the number of cases
			int numberOfMatricies = scan.nextInt(); 

			//call the read method to add a matrix instance to the array list.  
			for (int i = 0 ; i < numberOfMatricies ; i++ ) 
			{
			
				testCaseBuilder(scan); 

			}//end for loop 

			//call test method for getRowVector 
			if(getRowVectorTestCycle(scan) == true)
			{

				System.out.println("****************");
				System.out.println("Get row vector test PASSED"); 

			}//end if 

			//call test method for getColumnVector
			if (getColumnVectorTestCycle(scan)) 
			{
			
				System.out.println("***************");
				System.out.println("Get column vector test PASSED"); 

			}//end if 


			//call test method for setRowVector
			if ( setRowVectorTestCycle(scan) ) 
			{
			
				System.out.println("***************"); 
				System.out.println("Set row vector test PASSED "); 

			}//end if 

			//call test method for setColumnVector 
			if ( setColumnVectorTestCycle(scan) ) 
			{
			
				System.out.println("****************");
				System.out.println("Set column vector test PASSED");  

			}//end if 

			//call test method for compareMatricies 
			if ( compareMatrixTest(scan) ) 
			{
				
				System.out.println("****************");
				System.out.println("Compare Matrix test PASSED"); 				

			}//end if 

			//call test method for print
			printTest();


		}
		//catch 
		catch(FileNotFoundException e)
		{

			System.out.println("File not found."); 

		}

	}//class 


	public static void debug(int caseNumber, String test)
	{

		System.out.println("Test number " + caseNumber + " from " + test + " FAILED. ");   

	}//end debug 


	public static boolean getRowVectorTestCycle(Scanner scan)
	{

		//get the number of cases
		int numberOfCases = scan.nextInt(); 

		//for loop to read in cases
		for (int i = 0 ; i < numberOfCases ; i++ ) 
		{
		
			//if false 
			if(getRowVectorTest(scan,matrixList.get(i)) == false)
			{

				//debug 
				debug(i+1,"getRowVectorTest"); 

				//return false
				return false; 

			}//end if 


		}//end for 


		//return true 
		return true; 

	}//end getRowVectorTestCycle


	public static boolean getRowVectorTest(Scanner scan,Matrix matrix)
	{

		//iterate over the individual matrix row
		for (int i = 0 ; i < matrix.rowDimension ; i++ ) 
		{
		
			//build a vector reading from the input 
			ArrayList<VectorEntry> entryList = new ArrayList<VectorEntry>(); 
			int size = scan.nextInt(); 
			//for loop to build vector
			for (int j = 0 ; j < size ; j++ ) 
			{
			
				int numerator = scan.nextInt(); 
				int denominator = scan.nextInt(); 

				entryList.add( new VectorEntry(numerator,denominator) ); 

			}//end for  
			if(matrix.getRowVector(i+1).compareVector(new Vector(entryList)) == false)
			{

				return false; 

			}//end if 
		}//end for 

		return true; 

	}//end getRowVectorTest


	public static boolean getColumnVectorTestCycle(Scanner scan)
	{

		//get the number of test cases 
		int numberOfCases = scan.nextInt(); 

		//for loop to loop over the matrix list 
		for (int i = 0 ; i < numberOfCases ;i++ ) 
		{
		
			//if getColumnVector test is false 
			if(getColumnVectorTest(scan,matrixList.get(i)) == false) 
			{
			
				debug(i+1,"getColumnVectorTest");

				//return false
				return false; 

			}//end if 

		}//end for 


		return true; 

	}//end getColumnVectorTestCycle


	public static boolean getColumnVectorTest(Scanner scan, Matrix matrix)
	{

		//for loop to iterate over the individual matrix columns 
		for (int i = 0 ; i < matrix.columnDimension ; i++ ) 
		{
		
			//build a vector reading from from the input
			ArrayList<VectorEntry> entryList = new ArrayList<VectorEntry>(); 
			int size = scan.nextInt(); 

			//for loop to build vector 
			for (int j = 0 ; j < size ; j++) 
			{
			
				int numerator = scan.nextInt(); 
				int denominator = scan.nextInt(); 
				entryList.add( new VectorEntry(numerator,denominator) ); 

			}//end for loop 

			//if statement to check if vector matches the column 
			if(matrix.getColumnVector(i+1).compareVector( new Vector(entryList) ) == false )
			{
			
				debug(i+1,"getColumnVectorTest"); 
				return false; 

			}//end if 			


		}//end for loop 
		
		return true; 

	}//end getColumnVectorTest


	public static boolean setRowVectorTestCycle(Scanner scan)
	{

		//scan for number of cases
		int numberOfCases = scan.nextInt(); 

		//for loop to change vectors 
		for (int i = 0 ; i < numberOfCases ; i++) 
		{
			
			//scan for location 
			int location = scan.nextInt(); 

			//scan for vector size
			int size = scan.nextInt(); 

			//start arraylist for vectoro entries
			ArrayList<VectorEntry> entryList = new ArrayList<VectorEntry>(); 

			//for loop to build vector
			for (int j = 0 ; j < size ; j++) 
			{
			
				int numerator = scan.nextInt(); 
				int denominator = scan.nextInt(); 

				entryList.add( new VectorEntry(numerator,denominator) ); 

			}//end for loop 

			Vector testVector = new Vector(entryList); 

			//set at ith matrix in matrix list 
			matrixList.get(i).setRowVector(location,testVector);

			//if the row matrix is different than test vector 
			if (matrixList.get(i).getRowVector(location).compareVector(testVector) == false) 
			{
			
				//return false
				debug(i+1,"setRowVector"); 
				return false; 

			}//end if 


		}


		return true; 

	}//end setRowVectorTestCycle


	public static boolean setColumnVectorTestCycle(Scanner scan)
	{

		//scan for the number of tests
		int numberOfCases = scan.nextInt(); 

		//for loop to iterate over the matrix list 
		for (int i = 0 ; i < numberOfCases ; i++) 
		{
		
			//scan for size of vector 
			int size = scan.nextInt(); 

			//scan for location 
			int location = scan.nextInt(); 

			//arraylist for creating the new vector 
			ArrayList<VectorEntry> entryList = new ArrayList<VectorEntry>(); 

			//for loop to create vector 
			for (int j = 0 ; j < size ; j++ ) 
			{
			
				int numerator = scan.nextInt(); 
				int denominator = scan.nextInt(); 

				entryList.add( new VectorEntry( numerator , denominator ) ); 

			}//end for loop 

			//create test vector
			Vector testVector = new Vector(entryList);

			//set the vector at a new location 
			matrixList.get(i).setColumnVector(location,testVector);
	
			//if the  matix is different from the test vector
			if (matrixList.get(i).getColumnVector(location).compareVector(testVector) == false) 
			{	
				
				debug(i+1,"setColumnVectorTest"); 
				return false; 

			}//end if 


		}//end for loop 

		return true; 

	}//end setColumnVectorTestCycle


	public static boolean compareMatrixTest(Scanner scan)
	{

		//loop over the matricies and compare likes 
		for (int i = 0 ; i < matrixList.size() ; i++) 
		{
		
			if (matrixList.get(i).compareMatricies(matrixList.get(i)) == false ) 
			{
			
				return false;

			}//end if 

		}//end for 

		//loop over the matricies and compre differents
		for (int i = 0 ; i < matrixList.size() ; i++) 
		{
			if(i+1 == matrixList.size())
			{	

				break; 

			}//elsend if  


			if (matrixList.get(i).compareMatricies(matrixList.get(i+1)) == true) 
			{
			
				return false;  

			}//end if 

		}//end for loop

		return true; 
	}//end compareMatrixTest


	public static void printTest()
	{

		//print matricies 
		for (int i = 0 ; i < matrixList.size() ; i++ ) 
		{	
			System.out.println("*******************"); 
			System.out.println( matrixList.get(i).print() ); 
			System.out.println("*******************"); 

		}//end for loop 

	}//end printTest


	public static void testCaseBuilder(Scanner scan)
	{

		int rowDimension = scan.nextInt(); 
		int columnDimension = scan.nextInt(); 


		//create an arraylist of vectors
		ArrayList<Vector> vectorList = new ArrayList<Vector>(); 

		//for loop to create rows 
		for (int i = 0 ; i < rowDimension ; i++ ) 
		{
		
			//create arraylist of entries
			ArrayList<VectorEntry> entryList = new ArrayList<VectorEntry>(); 

			//for loop to create entries 
			for (int j = 0 ; j < columnDimension ; j++) 
			{
			
				//create a vector entry and add it to the list 
				int numerator = scan.nextInt(); 
				int denominator = scan.nextInt(); 

				entryList.add( new VectorEntry(numerator,denominator) );

			}//end for loop 

			//create a vector and add it to the vector list 
			vectorList.add( new Vector(entryList) ); 

		}//end for loop 

		Matrix newMatrix = new Matrix(vectorList,true); 

		//create a matrix object and add it to the matrix list 
		matrixList.add( newMatrix ); 

	
	}//end testGetRowVector 
	

	public static Vector testVector(Scanner scan)
	{

		ArrayList<VectorEntry> entryList = new ArrayList<VectorEntry>(); 
		int vectorDimension = scan.nextInt(); 
		for (int i = 0 ; i < vectorDimension ; i++) 
		{
		
			int numerator = scan.nextInt(); 
			int denominator = scan.nextInt(); 
			entryList.add( new VectorEntry(numerator , denominator ) ); 

		}//end for loop 

		return new Vector(entryList);

	
	}//end testVector




}//end class 