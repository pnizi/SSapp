package main;
import java.util.Random;

public class GenerateString
{
	 private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	 private static final int RANDOM_STRING_LENGTH=7;
	 
	public static String generateRandomString()
	{
		StringBuffer randStr=new StringBuffer();
		for(int i=0;i<=RANDOM_STRING_LENGTH;i++)
		{
			int number=getRandomNumber();
			char ch=CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
		
	}
	public static int getRandomNumber()
	{
		int randomInt=0;
		Random randomGen=new Random();
		randomInt=randomGen.nextInt(CHAR_LIST.length());
		if(randomInt-1==-1)
			return randomInt;
		else
			return randomInt-1;
	}
}
