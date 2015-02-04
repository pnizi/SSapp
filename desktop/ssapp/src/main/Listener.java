package main;

import java.awt.event.KeyEvent;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;



public class Listener implements HotkeyListener
{
	static Boolean KeyListener = true;
	
	public void Listener()
	{
		JIntellitype.getInstance().registerHotKey(0, 0, KeyEvent.VK_F9); 
		JIntellitype.getInstance().registerHotKey(1, 0, KeyEvent.VK_F10); 
		JIntellitype.getInstance().registerHotKey(2, 0, KeyEvent.VK_F11); 
		JIntellitype.getInstance().addHotKeyListener(this);
		
	}

	public void cleanup()
	{
		JIntellitype.getInstance().unregisterHotKey(0);
		JIntellitype.getInstance().unregisterHotKey(1);
		JIntellitype.getInstance().unregisterHotKey(2);
		JIntellitype.getInstance().cleanUp();
		//System.exit(0);
	}
	
	public void onHotKey(int key)
	{
		if(key == 0)
		{
			Screenshot TakeScreenShot = new Screenshot();
			TakeScreenShot.fullscreenSS();
			System.out.println("Full Screenshot taken");
		    
		}
		if(key == 1)
		{
			Screenshot TakeScreenShot = new Screenshot();
			TakeScreenShot.windowSS();
			System.out.println("Current Window screenshot taken");
		}
		if(key == 2)
		{
			//Screenshot TakeScreenShot = new Screenshot();
			//TakeScreenShot.fullscreenSS();
			System.out.println("f11 pressed");
		}
		
	}
	
}
