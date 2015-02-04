package main;

public class Run
{
	
	public static void main(String [] args) throws Exception
	{
		 Listener key = new Listener();  
	     key.Listener();
	     TrayManager TrayStuff  = new TrayManager();
	     TrayStuff.createAndShowGUI();
	     
	     while (Listener.KeyListener) 
	     {  
	         try 
	         {  
	             Thread.sleep(10000);  
	         } 
	         catch (Exception ex) 
	         {  
	             break;  
	         }  
	     }    
	}
}
