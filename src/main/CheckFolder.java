package main;
import java.io.File;

public class CheckFolder
{
	//Check for default folder if exists proceed else make it
	public static boolean check()
	{
		boolean complete=false;
		File theDir=new File(System.getProperty("user.home"), "Desktop\\Screenshots");
		if(!theDir.exists())
		{
			theDir.mkdir();
			complete=true;
		}
		return complete;
	}
}
