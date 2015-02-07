package main;
import java.io.File;

public class CheckFolder
{
	//Check for default folder if exists proceed else make it
	public boolean check()
	{
		File theDir=new File(System.getProperty("user.home"), "\\Desktop\\Screenshots");
		boolean complete=false;
		if(!theDir.exists())
		{
			theDir.mkdir();
			complete=true;
		}
		else
			complete=true;
		return complete;
	}
}
