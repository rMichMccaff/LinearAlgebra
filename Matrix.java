import java.util.ArrayList;

public class Matrix
{

	//GLOBAL VARIABLES
	ArrayList<Vector> rowVectors;
	ArrayList<Vector> columnVectors;
	int rowDimension;
	int columnDimension;


	//CONSTRUCTORS 
	public Matrix(ArrayList<Vector> vectors, boolean type)
	{

		//if boolean true 
		if( type == true)
		{

			//set rowVectors 
			this.rowVectors = vectors; 
			columnBuilder(vectors);
			this.columnDimension = columnVectors.size();
			this.rowDimension = vectors.size();

			//use column builder

		}//end if 
		else
		{

			this.columnVectors = vectors; 
			rowBuilder(vectors);
			this.columnDimension = vectors.size();
			this.rowDimension = rowVectors.size(); 
		}//end else 
 
		
	}//end constructor 


	public Matrix(Matrix newMatrix)
	{

		//get newMatrix row vectors
		this.rowVectors = newMatrix.getRowVectors();

		//get newMatrix column vectors 
		this.columnVectors = newMatrix.getColumnVectors(); 

		//set Dimension 
		this.rowDimension = rowVectors.size();
		this.columnDimension = columnVectors.size(); 


	}//end constructor 


	//METHODS


	//getRowVector
	public Vector getRowVector(int location)
	{

		return rowVectors.get(location - 1);

	}//end getRowVector 
	

	//setRowVector
	public void setRowVector(int location, Vector newRowVector)
	{

		rowVectors.set(location -1 , newRowVector);

	}//end setRowVector


	//getColumnVector
	public Vector getColumnVector(int location)
	{

		return columnVectors.get(location - 1);


	}//end getColumnVector


	public void swapRows(int i , int j)
	{

		Vector refVector = this.rowVectors.get(i);

		this.rowVectors.set( i ,this.rowVectors.get(j) );

		this.rowVectors.set( j ,refVector );

		columnBuilder(this.rowVectors);   

	}//end swapRows


	//setColumnVector 
	public void setColumnVector(int location, Vector newColumnVector)
	{

		columnVectors.set(location - 1 , newColumnVector);

	}//end setColumnVector


	//getColumnVectors
	public ArrayList<Vector> getColumnVectors()
	{

		ArrayList<Vector> returnVectorList = new ArrayList<Vector>();
		for (int i = 0 ; i < columnVectors.size() ; i++ ) {
				
				returnVectorList.add(columnVectors.get(i));

		}//end for loop 

		return returnVectorList;

	}//end getColumnVectors	

	//getRowVectors
	public ArrayList<Vector> getRowVectors()
	{

		ArrayList<Vector> returnVectorList = new ArrayList<Vector>();

		for (int i = 0 ; i < rowVectors.size() ; i++ ) 
		{
			
			returnVectorList.add(rowVectors.get(i));

		}//end for loop

		return returnVectorList;

	}//end getRowVectors

	
	//setRowVectors
	public void setRowVectors(ArrayList<Vector> newRowVectors)
	{

		ArrayList<Vector> newList = new ArrayList<Vector>();

		for (int i = 0 ; i < newRowVectors.size() ; i++ ) 
		{
			
			newList.add(rowVectors.get(i));

		}//end for loop 

		rowVectors = newList; 

	}//end setRowVectors


	//columnBuilder
	private void columnBuilder(ArrayList<Vector> vectors)
	{


		for (int i = 0 ; i < vectors.size() ; i++ ) 
		{
		 
		 	ArrayList<VectorEntry> localCol = new ArrayList<VectorEntry>(); 

			for (int j = 0 ; j < vectors.get(j).getVectorList().size() ; j++ ) 
			{
				
				localCol.add(vectors.get(j).getVectorList().get(i));

			}//end for loop 
			
			Vector newColumnVector = new Vector(localCol);

			columnVectors.add(newColumnVector);
		}//end for loop  
		

	}//end columnBuilder 


	//rowBuilder 
	private void rowBuilder(ArrayList<Vector> vectors)
	{

		for (int i = 0 ; i < vectors.size() ; i++ ) 
		{
		
			ArrayList<VectorEntry> localRow = new ArrayList<VectorEntry>();

			for (int j = 0 ; j < vectors.get(j).getVectorList().size() ; j++ ) 
			{	
				
				localRow.add( vectors.get(j).getVectorList().get(i) );

			}//end for loop 

			Vector newRowVector = new Vector(localRow);

			rowVectors.add(newRowVector);

		}//end for loop 

	}//end rowBuilder


	public boolean compareMatricies(Matrix comparingMatrix)
	{

		boolean comparingVariable = true; 

		for (int i = 0 ; i < comparingMatrix.getRowVectors().size() ; i++ ) {
			
			if(rowVectors.get(i).compareVector(comparingMatrix.getRowVectors().get(i)) == false  ) 
			{

				return false;

			}//end if statement 

		}//end for loop 

		for (int i = 0 ; i < comparingMatrix.getRowVectors().size() ; i++ ) {
			
			if(columnVectors.get(i).compareVector(comparingMatrix.getColumnVectors().get(i)))
			{

				return false;

			}

		}//end for loop 

		return true;

	}//end compareMatricies


}//end class 