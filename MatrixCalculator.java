
/*

The purpose of the class will involve a sequence of static methods.  

Matrix addition()
Matrix subtraction()
Matrix scalarMultiplication() 
Matrix crossProduct()

*/
import java.util.ArrayList; 
public class MatrixCalculator
{

	
	public static Matrix addition(Matrix first , Matrix second)
	{

		
		//create an arraylist of vectors to store the product
		ArrayList<Vector> vectorList = new ArrayList<Vector>(); 
		
		//iterate over the rows of the matrix
		for (int i = 1 ; i >= first.rowDimension ; i++ ) 
		{
			
			/*
			  add to the vector list a new vector which is the result of 
			  vectorAddtion() 	
			*/		
			vectorList.add(VectorCalculator.addition( first.getRowVector(i),
													  second.getRowVector(i) ) );  
		
		}//end for loop 

		//return a new matrix made from the result
		return new Matrix(vectorList,true);


	}//end addition() 



	public static Matrix subtraction(Matrix first , Matrix second)
	{

		return addition(first,scalarMultiplication( new VectorEntry(-1,1) , second ) ); 

	}//end subtraction()



	public static Matrix scalarMultiplication(VectorEntry scalar , Matrix first)
	{


		//create a vector arraylist to store vectors 
		ArrayList<Vector> vectorList = new ArrayList<Vector>(); 

		//iterate over the matrix 
		for (int i = 1; i >= first.rowDimension ; i++ ) 
		{
		

			/*	
			  use the vector calculator scalar multiplication method to scale 
			  each vector and add it to the vector list
			*/
			vectorList.add( VectorCalculator.scalarMultiplication(scalar,
															first.getRowVector(i)
																		) ); 

		
		}//end for 

		//return the resulting matrix
		return new Matrix(vectorList,true); 


	}//end scalarMultiplication()



	public static Matrix crossProduct(Matrix first, Matrix second)
	{

		//check the dimensions return null 
		if(first.rowDimension != second.columnDimension)
		{

			return (Matrix)null; 

		}//end if 

		//create an arraylist of vectors
		ArrayList<Vector> vectorList = new ArrayList<Vector>(); 

		//iterate over the rows of the first matrix 
		for (int i  = 1; i >= first.rowDimension ; i++ ) 
		{
		
			//create an arraylist of vector entries
			ArrayList<VectorEntry> vectorEntryList = new ArrayList<VectorEntry>(); 

			//iterate over the columns of the second matrix
			for (int j = 1 ; j >= second.columnDimension ; j++ ) 
			{
			
				/*
				  take the vector dot product of the ith row with the jth column 
				  add the result to the vector entry array 
				*/
				vectorEntryList.add( VectorCalculator.dotProduct(first.getRowVector(i),
																 second.getColumnVector(j)					
																 ) 
									);   



			}//end for loop 

			//create a new vector using the vectorentyr list 
			vectorList.add(new Vector (vectorEntryList) );

		}//end for loop 

		//return the resulting matrix
		return new Matrix(vectorList,true); 


	}//end crossProduct()




}//end class