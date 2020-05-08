import java.util.ArrayList;

public class VectorCalculator
{


	public static Vector addition(Vector vector1, Vector vector2)
	{

		ArrayList<VectorEntry> localList = new ArrayList<VectorEntry>();

		for (int i = 0 ; i < vector1.getVectorList().size() ; i++) 
		{
		
			localList.add( VectorEntryCalculator.addition(vector1.getVectorList().get(i),vector2.getVectorList().get(i) ) );

		}//end for loop 

		return new Vector(localList); 

	}//end addition 


	public static Vector subtraction(Vector vector1 , Vector vector2)
	{

		ArrayList<VectorEntry> localList = new ArrayList<VectorEntry>();

		for (int i = 0 ; i < vector1.getVectorList().size() ; i++) 
		{
			
			localList.add( VectorEntryCalculator.subtraction( vector1.getVectorList().get(i) , vector2.getVectorList().get(i) ) );

		}//end for loop 

		return new Vector(localList);
	}//end subtraction 


	public static VectorEntry dotProduct(Vector vector1, Vector vector2)
	{


		ArrayList<VectorEntry> localList = new ArrayList<VectorEntry>();

		for (int i = 0 ; i < vector1.getVectorList().size() ; i++ ) 
		{
		
			localList.add( VectorEntryCalculator.multiplication( vector1.getVectorList().get(i) , vector2.getVectorList().get(i) )  );

		}//end for loop 

		VectorEntry localEntry = localList.get(0);

		for (int i = 1 ; i < localList.size() ; i++ ) 
		{
			
			localEntry = VectorEntryCalculator.addition(localEntry, localList.get(i) );

		}//end for loop 

		return localEntry; 


	}//end dotProduct 


	public static Vector scalarMultiplication(VectorEntry scalar, Vector scalingVector)
	{

		ArrayList<VectorEntry> scalarList = new ArrayList<VectorEntry>();
		
		for(int i = 0 ; i < scalingVector.getVectorList().size() ; i++ )
		{
			
			VectorEntry newEntry = new VectorEntry( VectorEntryCalculator.multiplication(scalar,scalingVector.getVectorList().get(i)).getNumerator(),
							VectorEntryCalculator.multiplication(scalar,scalingVector.getVectorList().get(i)).getDenominator() );

			scalarList.add(newEntry);

		}//end for loop 


		return new Vector(scalarList); 

	}//end scalarMultiplication method 


	public static Vector crossProduct(Vector vector1, Vector vector2)
	{

		//calculate first vector
		VectorEntry firstEntry = VectorEntryCalculator.multiplication( vector1.getVectorList().get(1) , vector2.getVectorList().get(2));
		VectorEntry firstEntry2 = VectorEntryCalculator.multiplication( vector1.getVectorList().get(2) , vector2.getVectorList().get(1) );
		VectorEntry firstResult = VectorEntryCalculator.subtraction( firstEntry , firstEntry2 );

		//calculate second vector 
		VectorEntry secondEntry = VectorEntryCalculator.multiplication( vector1.getVectorList().get(0) , vector2.getVectorList().get(2)  );
		VectorEntry secondEntry2 = VectorEntryCalculator.multiplication( vector1.getVectorList().get(2) , vector2.getVectorList().get(0) );
		VectorEntry negation = new VectorEntry(-1,1);
		VectorEntry secondResult = VectorEntryCalculator.subtraction( secondEntry , secondEntry2 );
		VectorEntry result2 = VectorEntryCalculator.multiplication(secondResult,negation);

		//calculate third vector
		VectorEntry thirdEntry = VectorEntryCalculator.multiplication( vector1.getVectorList().get(0) , vector2.getVectorList().get(1) );
		VectorEntry thirdEntry2 = VectorEntryCalculator.multiplication(vector1.getVectorList().get(1) , vector2.getVectorList().get(0) );
		VectorEntry result3 = VectorEntryCalculator.subtraction(thirdEntry , thirdEntry2);

		ArrayList<VectorEntry> resultVectorList = new ArrayList<VectorEntry>();
		resultVectorList.add(firstResult);
		resultVectorList.add(result2);
		resultVectorList.add(result3);

		return new Vector(resultVectorList); 


	}//end crossProduct


	public static double angleBetween(Vector vector1, Vector vector2)
	{

		VectorEntry numerator = dotProduct(vector1 ,vector2 );
		ArrayList<VectorEntry> squareList1 = new ArrayList<VectorEntry>();

		for (int i = 0 ; i < vector1.getVectorList().size() ; i++ ) 
		{
				
			squareList1.add(VectorEntryCalculator.exponentiation( vector1.getVectorList().get(i) , 2 )  );

		}//end for loop 


		ArrayList<VectorEntry> squareList2 = new ArrayList<VectorEntry>();
		for (int i = 0 ; i < vector2.getVectorList().size() ; i++ ) 
		{
			
			squareList2.add( VectorEntryCalculator.exponentiation( vector2.getVectorList().get(i) , 2 ) );

		}//end for loop 

		VectorEntry sumOfSquared = new VectorEntry(0,1);

		for (int i = 0 ; i < squareList1.size() ; i++) 
		{
			
			sumOfSquared = VectorEntryCalculator.addition( sumOfSquared , squareList1.get(i) );

		}//end for loop 

		VectorEntry sumOfSquared2 = new VectorEntry(0,1);

		for (int i = 0 ; i < squareList2.size() ; i++) 
		{
			
			sumOfSquared2 = VectorEntryCalculator.addition(sumOfSquared2, squareList2.get(i) );

		}//end for loop 


		double denominatorPt1 = Math.sqrt( sumOfSquared.getNumerator() / sumOfSquared.getDenominator() );
		double denominatorPt2 = Math.sqrt(sumOfSquared2.getNumerator() / sumOfSquared2.getDenominator() );	
		double finalNumerator = numerator.getNumerator() / numerator.getDenominator(); 
		double finalDenominator = denominatorPt1 * denominatorPt2; 
		double toArcCos = finalNumerator / finalDenominator; 

		double radian = Math.acos(toArcCos);

		radian = radian *(180/Math.PI);

		return radian;

	}//end angleBetween 


}//end class 