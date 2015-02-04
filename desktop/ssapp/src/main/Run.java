package main;

public class Run
{
	public static TrayManager TrayMGR = new TrayManager();
	public static void main(String [] args) throws Exception
	{
	     TrayMGR.createAndShowGUI();
		 Listener key = new Listener();  
		 Listener.KeyListener = true;
	     key.Listener();
	     
	     Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	    	    public void run() {
	    	     key.cleanup();
	    	     
	    	    }
	    	}));
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
