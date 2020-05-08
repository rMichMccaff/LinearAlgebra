import java.util.ArrayList;


public class VectorCalcTest
{

	static VectorEntry entry1 = new VectorEntry(6,2);
	static VectorEntry entry2 = new VectorEntry(4,2);
	static VectorEntry entry3 = new VectorEntry(20,4);
	static VectorEntry entry4 = new VectorEntry(1000,100);
	static VectorEntry entry5 = new VectorEntry(100,100);
	static VectorEntry entry6 = new VectorEntry( 40 , 5 );
	static VectorEntry entry7 = new VectorEntry(20, -10);
	static VectorEntry entry8 = new VectorEntry(50,5);
	static VectorEntry entry9 = new VectorEntry(9,9);
	static VectorEntry entry10 = new VectorEntry(0,4);


	static Vector vector1; 
	static Vector vector2; 
	static Vector vector3; 

	public static void main(String[] args) {
			
		initializeVectors(); 
		additionTest();
		subtractionTest();
		scalarMultiplicationTest(); 

	}//end main 


	public static void initializeVectors()
	{

		ArrayList<VectorEntry> vectorList1 = new ArrayList<VectorEntry>();
		ArrayList<VectorEntry> vectorList2 = new ArrayList<VectorEntry>();
		ArrayList<VectorEntry> vectorList3 = new ArrayList<VectorEntry>();


		vectorList1.add(entry1);
		vectorList1.add(entry2);
		vectorList1.add(entry3);

		vectorList2.add(entry10);
		vectorList2.add(entry10);
		vectorList2.add(entry10);


		vectorList3.add(entry4);
		vectorList3.add(entry5);
		vectorList3.add(entry6);

		vector1 = new Vector(vectorList1);
		vector2 = new Vector(vectorList2);
		vector3 = new Vector(vectorList3);


	}//end initializeVectors


	public static void additionTest()
	{

		
		if(VectorCalculator.addition(vector1 , vector2).compareVector(vector1) == true )
		{

			System.out.println("Test PASSED for addition vector1 and vector2");

		}
		if(VectorCalculator.addition(vector3,vector2).compareVector(vector3) == true )
		{

			System.out.println("Test PASSED for addition vector2 and vector3"); 

		}
		if(VectorCalculator.addition(vector1,vector3).compareVector(vector2) == false)
		{

			System.out.println("Test PASSED for false addition"); 

		}

		VectorEntry solutionEntry1  = new VectorEntry(13,1);
		VectorEntry solutionEntry2  = new VectorEntry(3,1);
		VectorEntry solutionEntry3  = new VectorEntry(13,1);

		ArrayList<VectorEntry> solutionList = new ArrayList<VectorEntry>(); 

		solutionList.add(solutionEntry1);
		solutionList.add(solutionEntry2);
		solutionList.add(solutionEntry3);


		Vector solutionVector = new Vector(solutionList); 

		if(VectorCalculator.addition(vector1,vector3).compareVector(solutionVector) == true)
		{

			System.out.println("Test PASSED for addition vector1 and vector3");

		}

	}//end additionTest


	public static void subtractionTest()
	{

		if(VectorCalculator.subtraction(vector1,vector2).compareVector(vector1) == true) 
		{
		
			System.out.println("Test PASSED subtraction vector1 and vector2.");
		
		}
		

		VectorEntry solutionEntry1 = new VectorEntry(-7,1);
		VectorEntry solutionEntry2 = new VectorEntry(1,1);
		VectorEntry solutionEntry3 = new VectorEntry(-3,1);


		ArrayList<VectorEntry> solutionList = new ArrayList<VectorEntry>(); 

		solutionList.add(solutionEntry1);
		solutionList.add(solutionEntry2);
		solutionList.add(solutionEntry3);

		Vector solutionVector = new Vector(solutionList);

		if(VectorCalculator.subtraction(vector1,vector3).compareVector(solutionVector) == true )
		{

			System.out.println("Test PASSED subtraction vector1 and vector3.");

		}
		VectorEntry solutionEntry11 = new VectorEntry(-6,2);
		VectorEntry solutionEntry12 = new VectorEntry(-4,2);
		VectorEntry solutionEntry13 = new VectorEntry(-20,4);
		ArrayList<VectorEntry> solutionList2 = new ArrayList<VectorEntry>();
		solutionList2.add(solutionEntry11);
		solutionList2.add(solutionEntry12);
		solutionList2.add(solutionEntry13);
		Vector solutionVector2 = new Vector(solutionList2);

		if( VectorCalculator.subtraction( vector2 , vector1 ).compareVector( solutionVector2) == true )
		{

			System.out.println("Test PASSED for vector2 and vector1 subtraction");

		}



	}//end subtractionTest 


	public static void scalarMultiplicationTest()
	{

		VectorEntry scalar1 = new VectorEntry(0,7);
		VectorEntry scalar2 = new VectorEntry(5,1);
		VectorEntry scalar3 = new VectorEntry(1,5);

		//multiply by scalar1
		if(VectorCalculator.scalarMultiplication(scalar1,vector1).compareVector(vector2) == true)
		{

			System.out.println("Test PASSED for multiplication of scalar1 and vector1"); 

		}

		if(VectorCalculator.scalarMultiplication( scalar1 , vector3 ).compareVector(vector2) == true )
		{

			System.out.println("Test PASSED for multiplication of scalar1 and vector3");
		}
		if(VectorCalculator.scalarMultiplication(scalar1,vector2).compareVector(vector2) == true)
		{

			System.out.println("Test PASSED for multiplication of scalar1 and vector2");

		}

		VectorEntry solutionEntry1 = new VectorEntry(15 , 1);
		VectorEntry solutionEntry2 = new VectorEntry(10 , 1);
		VectorEntry solutionEntry3 = new VectorEntry( 25 , 1 );

		ArrayList<VectorEntry> solutionList = new ArrayList<VectorEntry>();

		solutionList.add(solutionEntry1);
		solutionList.add(solutionEntry2);
		solutionList.add(solutionEntry3);

		Vector solutionVector = new Vector(solutionList);

		//multiply by scalar2 
		if(VectorCalculator.scalarMultiplication(scalar2,vector1).compareVector(solutionVector) == true)
		{

			System.out.println("Test PASSED for multiplication for scalar2 and vector1"); 

		}		


		//multiply by scalar3

	}//end scalarMultiplicationTest


	public static void dotProductTest()
	{



	}//end dotProductTest


	public static void crossProductTest()
	{



	}//end crossProductTest


	public static void angleBetweenTest()
	{



	}//end angleBetweenTest  

}//end class 