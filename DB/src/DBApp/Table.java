package DBApp;

//import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.ObjectOutputStream;

public class Table {
	
	int numPages;
	String name;
	String [] colNames;
	String [] colTypes;
	Page last;
	boolean open;
		
	//First Step: Constructing a table - You should initialize the variables given above -
	public Table(String name, String [] colNames,String [] colTypes) throws IOException
	{
	
	}
		
	//Function1: A function that creates a "Tables" folder in which the pages of a table will be created 
	//and adds a page into that folder
	public void addPage(Page p) throws IOException
	{
	
	}
	
	//Function2: A function that inserts a record of strings into the last page of the table if it is not full,
	//otherwise, it should add a new page into the folder and insert the record into it
	public int insert (String []record) throws ClassNotFoundException, IOException
	{        
		return 1;
	}
		
	//Testing Your Code
	public static void main(String []args) throws IOException, ClassNotFoundException {
		
		String tName="Student";
		String [] tColNames={"ID","Name","GPA","Age","Year"};
		String [] tColTypes={"int","String","double","int","int"};			
		Table t = new Table(tName,tColNames,tColTypes);
			
		for(int i=0;i<300;i++)
		{
			String []st={""+i,"Name"+i,"0."+i,"20","3"};
			t.insert(st);
		}
		for(int i=0;i<300;i++)
		{
			String []st={""+(i+300),"Name"+(i+300),"0."+(i+300),"21","4"};
			t.insert(st);
		}
			
		for(int i=0;i<300;i++)
		{
			String []st={""+(i+600),"Name"+(i+600),"0."+(i+600),"21","3"};
			t.insert(st);
		}
			
		System.out.println(t);
		
	}
}