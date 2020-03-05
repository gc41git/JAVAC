package javacall;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Docker implements Serializable
{
	private int id;
	private String name;
	private double bill;


public Docker(int id,String name,double bill)
{
	this.id=id;
	this.name=name;
	this.bill=bill;
}
public int getId()
	{
		return id;
	}
public String getName()
	{
		return name;
	}
public double getBill()
	{
		return bill;
	}
@Override
public String toString()
	{
		return String.format("ID = %d\nName = %s\nBill = %f",id,name,bill);
		
	}
}

public class Serialized {
	public static void serializationPart()
	{
		try {
			Docker dk = new Docker(123, "Radeon", 121234);
			FileOutputStream fs= new FileOutputStream("Test.gc");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(dk);
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deserializationPart()
	{
		try {
			FileInputStream fs = new FileInputStream("Test.gc");
			ObjectInputStream is = new ObjectInputStream(fs);
			Docker dk = (Docker)is.readObject();
			if(dk!=null)
			{
				System.out.println(dk);
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//serializationPart();
		deserializationPart();
	}
}
