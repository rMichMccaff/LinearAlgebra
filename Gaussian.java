

/*
The purpose of the class is to solve a system of equations  using gaussian elimination


Matrix sort()
Matrix rowForm()
Matrix reducedRowForm()


*/

import java.util.ArrayList; 
public class Gaussian
{

	public static Matrix solution(Matrix first)
	{

		return reducedRowForm(rowForm(first)); 

	}//end solution 

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
		for (int i = 1 ; i < first.rowDimension ; i++ ) 
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
			for (int j = i + 1; j <= first.rowDimension ; j++ ) 
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

		//sort the matrix 
		first = sort(first);

		//iterate over the matrix starting from the bottom 
		for (int i = first.rowDimension ; i > 1 ; i-- ) 
		{
		

			int firstNonZero = 1; 
			//iterate through the starting row to find the first non zero 
			for (int j = 1 ; j <= first.columnDimension ; j++ ) 
			{
			
				if(first.getRowVector(i).getEntryAt(j).getNumerator() == 0)
				{

					firstNonZero++; 

				}//end if 
				else
				{

					continue; 

				}//end else

			}//end for loop 

			//if the row is all zeros go to the next iteration of the loop 
			if(firstNonZero == first.rowDimension &&
			   first.getRowVector(i).getEntryAt(firstNonZero).getNumerator() == 0) 
			{
			
				continue; 

			}//end if 
			//else 
			else
			{

				//iterate starting from one up to perform operations
				for (int j = i - 1 ; j <= 1 ; j-- ) 
				{
					
					int secondNonZero = 1; 

					for (int k = 1 ; k <= first.columnDimension ; k++ ) 
					{
					
						if(first.getRowVector(j).getEntryAt(k).getNumerator() == 0 ) 
						{
						
							secondNonZero++; 

						}//end if 
						else
						{

							continue; 

						}//end else 

					}//end for loop 

					//if the location of the second loop vector is zero 
					if (secondNonZero == first.columnDimension && 
						first.getRowVector(j).getEntryAt(secondNonZero).getNumerator() == 0) 
					{
					
						//skip to the next 
						continue; 

					}//end if 
					//else 
					else
					{

						//find a scaled vector to alter the second loop vector 
						Vector scaledVector = first.getRowVector(i);
						VectorEntry scalar = new VectorEntry(
											scaledVector.getEntryAt(firstNonZero).getDenominator() ,
											scaledVector.getEntryAt(firstNonZero).getNumerator()
											);
						scaledVector = VectorCalculator.scalarMultiplication(scalar,scaledVector);
						VectorEntry operatingScalar = new VectorEntry(first.getRowVector(j).getEntryAt(secondNonZero).getNumerator(),
														first.getRowVector(j).getEntryAt(secondNonZero).getDenominator()																						
						  								);
						scaledVector = VectorCalculator.scalarMultiplication(operatingScalar,scaledVector);

						//perform the operation 
						if(first.getRowVector(j).getEntryAt(secondNonZero).getNumerator() > 0)
						{

							//use subtraction 
							Vector newVector = first.getRowVector(j); 
							newVector = VectorCalculator.subtraction(newVector,scaledVector);
							first.setRowVector(j,newVector);
						
						}//end if 
						else
						{

							Vector newVector = first.getRowVector(j); 
							newVector = VectorCalculator.addition(newVector,scaledVector);
							first.setRowVector(j,newVector);	

						}//end else
						
						//sort	
						first = sort(first);

					}//end else 

			

				}//end for loop 
 

			}//end else 

			

		}//end for loop 


		//return the result
		return first; 

	}//end reducedRowForm()  



}//end class 