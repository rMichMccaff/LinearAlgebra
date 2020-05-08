

/*
The purpose of the class is to solve a system of equations  using gaussian elimination


Matrix sort()
Matrix rowForm()
Matrix reducedRowForm()


*/

import java.util.ArrayList; 
public class Gaussian
{

	public static Matrix sort(Matrix first)
	{

		//iterate over the matrix starting at row one 
		for (int i = 1; i <= first.rowDimension ; i++ ) 
		{
			
			int firstNonZero = 1; 

			//iterate through the row until the first non-zero entry is found 
			for (int j = 1 ; j < first.getRowVector(i).size() ; j++ ) 
			{
					
				if(first.getRowVector(i).getEntryAt(j).getNumerator() == 0 )
				{

					firstNonZero++; 

				}
				else
				{

					break; 

				}

			}//end for loop

			//iterate through the matrix starting at row 2 
			for (int j = 2 ; j <= first.rowDimension ; j++ ) 
			{
				int counterTwo = 1; 
				//iterate until first nonzero is found 
				for (int k = 1; k <= first.getRowVector(j).size() ; k++) 
				{
				
					if(first.getRowVector(j).getEntryAt(k).getNumerator() == 0)
					{

						counterTwo++; 

					}//end if 
					else
					{

						break; 

					}//end else 


				}//end for loop  

				if (firstNonZero > counterTwo) 
				{
				
					first.swapRows(i,j);

				}//end if
				else if(firstNonZero < counterTwo)
				{

					continue; 

				}//end else i 
				else
				{

					continue; 

				}//end else 


			}//end for loop 


		}//end for 



		return first; 

	}//end sort() 



	public static Matrix rowForm(Matrix first)
	{

		//sort first
		first = sort(first);

		//starting at the beginning iterate through the matrix starting at the front
		for (int i = 1 ; i <= first.rowDimension ; i++ ) 
		{
		
			int firstNonZero = 1; 
			//start a loop to find first non-zero of top 
			for (int j = 1 ; j <= first.getRowVector(i).size() ; j++ ) 
			{
			
				if(first.getRowVector(i).getEntryAt(j).getNumerator() == 0)
				{

					firstNonZero++; 

				}//end if
				else if(firstNonZero == first.rowDimension && 
						first.getRowVector(i).getEntryAt(firstNonZero).getNumerator() == 0)
				{

					return first; 

				}//end else if 
				else
				{	
					break; 

				}//end else 

			}//end for loop

			//starting at the next row iterate downward 
			for (int j = 2; j <= first.rowDimension ; j++ ) 
			{
			
				int secondNonZero = 1; 
				//start a loop to find the first non-zero 
				for (int k = 1 ; k <= first.getRowVector(j).size() ; k++) 
				{
				
					if(first.getRowVector(j).getEntryAt(k).getNumerator() == 0)
					{

						secondNonZero++; 

					}//end if 
					else
					{

						break; 

					}//end else 

				}//end for loop 

				//if there is a match 
				if(firstNonZero == secondNonZero)
				{

					/*

					  create a correct scaled operating vector 
					  perforrm the operation 

					*/
					VectorEntry scalar = new VectorEntry(
					 					first.getRowVector(i).getEntryAt(firstNonZero).getDenominator(),
					 					first.getRowVector(i).getEntryAt(firstNonZero).getNumerator()
					 					); 

					 //scale the vector 
					Vector operatingVector = VectorCalculator.scalarMultiplication(scalar, first.getRowVector(j) );

					operatingVector = VectorCalculator.scalarMultiplication(
					 					first.getRowVector(j).getEntryAt(secondNonZero),
					 					operatingVector
					 					);


					Vector otherVector = first.getRowVector(j);

					if(first.getRowVector(j).getEntryAt(secondNonZero).getNumerator() > 0)
					{

					 	otherVector = VectorCalculator.subtraction(otherVector,operatingVector); 

					} 
					else if(first.getRowVector(j).getEntryAt(secondNonZero).getNumerator() < 0)
					{

					 	otherVector = VectorCalculator.addition(otherVector,operatingVector); 

					}//end else if
									
					first.setRowVector(j,otherVector);

					//sort 
					sort(first);

				}//end if 

				//else 
				else
				{

					continue; 

				}//end 

			}//end for loop 


		}//end for loop 

		return first; 

	}//end rowForm()



	public static Matrix reducedRowForm(Matrix first )
	{

		return first; 

	}//end reducedRowForm()  



}//end class 