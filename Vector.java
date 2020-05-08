import java.util.ArrayList;

public class Vector
{


	//GLOBAL VARIALBES 
	ArrayList<VectorEntry> vectorList;
	


	//CONSTRUCTOR
	public Vector(ArrayList<VectorEntry> vectorList)
	{

		ArrayList<VectorEntry> newVectorList = new ArrayList<VectorEntry>();

		for (int i = 0 ; i < vectorList.size() ; i++ ) 
		{
		
			newVectorList.add(vectorList.get(i));

		}//end for loop 

		this.vectorList = newVectorList;



	}//end constructor 


	public Vector(Vector newVector)
	{

		ArrayList<VectorEntry> newList = new ArrayList<VectorEntry>();
		for (int i = 0 ; i < newVector.getVectorList().size() ; i++) {
			
			newList.add(newVector.getVectorList().get(i));

		}//end for loop 

		this.vectorList = newList; 

	}//end constructor 
	
	//setVector
	public void setVector(Vector newVector)
	{	

		ArrayList<VectorEntry> newEntryList = new  ArrayList<VectorEntry>();

		for (int i = 0 ; i < newVector.getVectorList().size() ; i++) {
			
			newEntryList.add(newVector.getVectorList().get(i));

		}//end for loop 

		this.vectorList = newEntryList;



	}//end setVector 


	public int size()
	{

		return vectorList.size();

	}//end size method 


	//getVector
	public Vector getVector()
	{

		return new Vector(this.vectorList);

	}//end getVector


	public void setVectorList(ArrayList<VectorEntry> newVectorList)
	{

		ArrayList<VectorEntry> newEntryList = new ArrayList<VectorEntry>();

		for (int i = 0 ; i < newVectorList.size() ; i++ ) {
			
			newEntryList.add(newVectorList.get(i));

		}//end for loop 

		this.vectorList = newVectorList;


	}//end setVectorList 

	//getVectorList
	public ArrayList<VectorEntry> getVectorList()
	{

		ArrayList<VectorEntry> returnList = new ArrayList<VectorEntry>();

		for (int i = 0 ; i < vectorList.size() ; i++ ) {
			
			returnList.add(vectorList.get(i));

		}//end for loop 

		return returnList;

	}//end getVectorList


	//setEntryAt
	public void setEntryAt(int location,VectorEntry newEntry)
	{

		vectorList.add(location - 1 , newEntry );

	}//end setEntryAt


	//getEntryAt
	public VectorEntry getEntryAt(int location)
	{

		return vectorList.get(location - 1);

	}//end getEntryAt

	//compareVector 
	public boolean compareVector(Vector comparingVector)
	{

		boolean comparingVariable = true;

		for (int i = 1; i <= comparingVector.getVectorList().size() ; i++ ) {
			
			if (vectorList.get(i - 1).compareVectorEntry(comparingVector.getEntryAt(i)) == false ) {
				
				comparingVariable = false;

			}//end if statment 

		}//end for loop 

		return comparingVariable;

	}//end compareVector


}//end class 