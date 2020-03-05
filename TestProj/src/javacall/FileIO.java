package javacall;

import java.io.FileReader;

public class FileIO 
{
	public static void main(String[] args) {
		try {
			BasicOperations();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



private static void BasicOperations() throws Exception

{
	FileReader Fr = new FileReader("Sample.csv");
	int index =0 ;
	while((index  = Fr.read())!= -1)
	{
		System.out.println((char)index);
	}
	Fr.close();
}
}