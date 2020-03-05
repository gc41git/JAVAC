package prog;

import java.util.Scanner;

public class Vowels 
{
	static String sentence=null;
	static int c=0,v=0;
	static Scanner scn = new Scanner(System.in);
	
	public static String removeSpace(String sentence)
	{
		 sentence=sentence.replaceAll("\\s", " ");
		 return sentence;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter String");
		sentence = scn.nextLine();
		
		sentence=removeSpace(sentence);
		char s = 0;
		
		for(int i=0;i<sentence.length();i++)
		{
			s = sentence.charAt(i);
			
			if(s=='a'||s=='e'||s=='i'||s=='o'||s=='u')
			{
				v++;
			}
			else
			{
				c++;
			}
		}
		System.out.println("THE VOWELS COUNT IS = "+v);
		System.out.println("THE CONSONANT COUNT IS = "+c);
	}
}
