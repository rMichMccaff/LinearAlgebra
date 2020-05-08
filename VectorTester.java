import java.util.ArrayList; 

public class VectorTester
{



	static VectorEntry entry1 = new VectorEntry(5,1);
	static VectorEntry entry2 = new VectorEntry(6,2);
	static VectorEntry entry3 = new VectorEntry(8,7);
	static VectorEntry entry4 = new VectorEntry(6,7);
	static VectorEntry entry5 = new VectorEntry(0,9);
	static VectorEntry entry6 = new VectorEntry(1,12);
	static VectorEntry entry7 = new VectorEntry(25,5);
	static VectorEntry entry8 = new VectorEntry(5,45);
	static VectorEntry entry9 = new VectorEntry(6,8);
	static VectorEntry entry10 = new VectorEntry(9,13);
	static VectorEntry entry11 = new VectorEntry(-3,4);
	static VectorEntry entry12 = new VectorEntry(-80,100);

	static Vector vector1; 
	static Vector vector2; 
	static Vector vector3; 
	static Vector vector4;
	static Vector vector5;

	static ArrayList<VectorEntry> vectorList1; 
	static ArrayList<VectorEntry> vectorList2; 
	static ArrayList<VectorEntry> vectorList3; 
	static ArrayList<VectorEntry> vectorList4; 
	static ArrayList<VectorEntry> vectorList5; 



	public static void main(String[] args) {
		
		initializeVectorCases();
		getVectorTest(); 
		getEntryAtTest();
		compareTest();
		vectorConstructorTest();
		setEntryAtTest(); 


	}//end main 



	public static void initializeVectorCases()
	{

		//make lists 
		vectorList1 = new ArrayList<VectorEntry>();
		vectorList2 = new ArrayList<VectorEntry>();
		vectorList3 = new ArrayList<VectorEntry>();
		vectorList4 = new ArrayList<VectorEntry>();
		vectorList5 = new ArrayList<VectorEntry>();


		//make a zero vector
		for(int i = 0 ; i < 3 ; i++)
		{

			vectorList1.add(entry5); 

		}//end for loop 

		//make a rational less than one greater than zero  vector 
		vectorList2.add(entry4);
		vectorList2.add(entry6);
		vectorList2.add(entry8);


		//make a rational less than one with negatives and positives 
		vectorList3.add(entry12);
		vectorList3.add(entry11);
		vectorList3.add(entry4);



		//make a rational vector less than one with all negatives 
		vectorList4.add(entry11);
		vectorList4.add(entry12);
		vectorList4.add(entry11);


		//make an larger than one array
		vectorList5.add(entry2);
		vectorList5.add(entry5);
		vectorList5.add(entry7);


		//build vector objects
		vector1 = new Vector(vectorList1);
		vector2 = new Vector(vectorList2);
		vector3 = new Vector(vectorList3);
		vector4 = new Vector(vectorList4);
		vector5 = new Vector(vectorList5);   

	}//end initializeVectorCases



	public static void vectorConstructorTest()
	{



		//construct a zero vector 
		boolean constructorBoolean1 = false; 
		if(vector1.compareVector( new Vector(vector1) ) == true )
		{

			constructorBoolean1 = true; 

		}


		//construct a non-zero vector 
		boolean constructorBoolean2 = false; 
		if(vector2.compareVector( new Vector(vector2) ) == true )
		{

			constructorBoolean2 = true; 	

		}

		//construct a non-zero vector 
		boolean constructorBoolean3 = false; 
		if(vector3.compareVector(new Vector(vector3) ) == true )
		{

			constructorBoolean3 = true; 

		}


		if(constructorBoolean1 == true)
		{

			System.out.println("Test PASSED for constructorTest Vector 1");

		}
		if(constructorBoolean2 == true)
		{

			System.out.println("Test PASSED for constructorTest Vector 2"); 

		}
		if(constructorBoolean3 == true)
		{

			System.out.println("Test PASSED for constructorTest Vector 3");

		}

	}//end vectorConstructorTest



	public static void getVectorTest()
	{


		boolean vector1Boolean = false;
		for(int i = 0 ; i < vector1.getVector().getVectorList().size() ; i++ ) 
		{
			
			if(entry5.compareVectorEntry(vector1.getVector().getVectorList().get(i)) == true  )
			{

				vector1Boolean = true; 

			}


		}//end for loop 
		if(vector1Boolean == true)
		{

			System.out.println("Test PASSED for getVectorTest Vector1."); 

		}
		else
		{

			System.out.println("Test FAILED for getVectorTest Vector1");

		}
		


		boolean vector2Boolean = false; 
		if(vector2.getVector().getVectorList().get(0).compareVectorEntry(entry4) == true && 
			vector2.getVector().getVectorList().get(1).compareVectorEntry(entry6) == true &&
			 vector2.getVector().getVectorList().get(2).compareVectorEntry(entry8)  == true)
		{

			vector2Boolean = true;

		}
		if(vector2Boolean == true) 
		{
			System.out.println("Test PASSED for getVectorTest Vector2");	
		}
		else
		{

			System.out.println("Test FAILED for getVectorTest Vector2"); 

		}


		boolean vector3Boolean = false; 
		if(vector3.getVector().getVectorList().get(0).compareVectorEntry(entry12) == true &&
			vector3.getVector().getVectorList().get(1).compareVectorEntry(entry11) == true &&
			 vector3.getVector().getVectorList().get(2).compareVectorEntry(entry4) == true)
		{

			vector3Boolean = true;



		}
		if(vector3Boolean == true)
		{

			System.out.println("Test PASSED for getVectorTest Vector3"); 

		}
		else
		{

			System.out.println("Test FAILED for getVectorTest Vector3");

		}


		boolean vector4Boolean = false; 
		if(vector4.getVector().getVectorList().get(0).compareVectorEntry(entry11) == true &&
			vector4.getVector().getVectorList().get(1).compareVectorEntry(entry12) == true &&
			 vector4.getVector().getVectorList().get(2).compareVectorEntry(entry11) == true)
		{

			vector4Boolean = true; 

		}
		if(vector4Boolean == true)
		{

			System.out.println("Test PASSED for getVectorTest Vector4");

		}
		else
		{

			System.out.println("Test FAILED for getVectorTest Vector4");

		}


		boolean vector5Boolean = true; 
		if(vector5.getVector().getVectorList().get(0).compareVectorEntry(entry2) == true &&
			vector5.getVector().getVectorList().get(1).compareVectorEntry(entry5) == true &&
			 vector5.getVector().getVectorList().get(2).compareVectorEntry(entry7) == true)
		{

			vector5Boolean = true; 

		}
		if(vector5Boolean == true)
		{

			System.out.println("Test PASSED for getVecotorTest Vector5");

		}
		else
		{

			System.out.println("Test FAILED for getVectorTest Vector5");

		}

	}//end getVectorTest



	public static void getEntryAtTest()
	{

		boolean searchBoolean1 = false; 
		//get a vector at the beginning 
		if(vector1.getEntryAt(1).compareVectorEntry(entry5) == true  )
		{

			searchBoolean1 = true; 

		}
		//get a middle vector 	
		
		boolean searchBoolean2 = false; 
		if(vector3.getEntryAt(2).compareVectorEntry(entry11) == true)
		{

			searchBoolean2 = true; 

		}

		
		//get an end vector 
		boolean searchBoolean3 = false;
		if(vector4.getEntryAt(3).compareVectorEntry(entry11) == true)
		{

			searchBoolean3 = true; 

		}


		if(searchBoolean1 == true)
		{

			System.out.println("Test PASSED for vector1 at beginnning.");

		}
		else
		{

			System.out.println("Test FAILED for vector1 at beginnning"); 

		}
		if(searchBoolean2 == true)
		{
			
			System.out.println("Test PASSED for vector2 sample at middle."); 	

		}
		else
		{

			System.out.println("Test FAILED for vector2 at middle");

		}
		if(searchBoolean3 ==true)
		{

			System.out.println("Test PASSED for vector3 sample at end.");

		}
		else
		{

			System.out.println("Test FAILED for vector3 at end");
		
		}


	}//end getEntryAtTest



	public static void setEntryAtTest()
	{

		//set a vector at the beginnning 
		vector1.setEntryAt(1,new VectorEntry( 1 , 8 ) );
		boolean setEntryAt1 = false; 
		if(vector1.getEntryAt(1).compareVectorEntry( new VectorEntry(1,8) ) == true )
		{

			setEntryAt1 = true; 

		} 
		
		//set a vector at the middle  
		vector1.setEntryAt(2,new VectorEntry( 8 , 1 ) );
		boolean setEntryAt2 = false; 
		if(vector1.getEntryAt(2).compareVectorEntry( new VectorEntry(8,1) ) == true)
		{

			setEntryAt2 = true; 

		}

		//set a vector in the end 
		boolean setEntryAt3 = false; 
		vector1.setEntryAt(3, new VectorEntry(1,9) );
		if(vector1.getEntryAt(3).compareVectorEntry(new VectorEntry(1,9) ) == true)
		{

			setEntryAt3 = true; 

		}

		if(setEntryAt1 == true)
		{

			System.out.println("Test PASSED setEntryAt for position 1"); 

		}
		if(setEntryAt2 == true)
		{

			System.out.println("Test PASSED  setEntryAt for position 2"); 

		}
		if(setEntryAt3 == true)
		{

			System.out.println("Test PASSED setEntryAt for position 3");

		}

	}//end setEntryAtTest



	public static void compareTest()
	{


		//compare zero vectors 
		boolean compareBoolean1 = false;
		if(vector1.compareVector(vector1) == true)
		{

			compareBoolean1 = true; 

		}

		//compare another without zero vectors 
		boolean compareBoolean2 = false; 
		if(vector1.compareVector(vector2) == false)
		{

			compareBoolean2 = true; 

		}
		
		//compare two non zero vectors that match 
		boolean compareBoolean3 = false; 
		if(vector2.compareVector(vector2) == true )
		{

			compareBoolean3 = true; 

		}

		//compare two non zero vectors that don't match
		boolean compareBoolean4 = false; 
		if(vector2.compareVector(vector4) == false )
		{

			compareBoolean4 = true; 

		}


		if(compareBoolean1 == true)
		{

			System.out.println("Test PASSED for zero vectors"); 

		}
		else{}
		if(compareBoolean2 == true)
		{

			System.out.println("Test PASSED for one zero and one non-zero vectors which don't match."); 

		}
		else{}	
		if(compareBoolean3 == true)
		{

			System.out.println("Test PASSED for non-zero vectors which match"); 

		}
		else{}
		if(compareBoolean4 == true)
		{

			System.out.println("Test PASSED for non-zero vectors which don't match"); 

		}
		else{}
	

	}//end compareTest


}//end class 