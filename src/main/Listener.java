package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener
{
	
	public Listener()
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_F9)
		{
			System.out.println("f9 pressed");
		}
		if(e.getKeyCode() == KeyEvent.VK_F10)
		{
			System.out.println("f10 pressed");
		}
		if(e.getKeyCode() == KeyEvent.VK_F11)
		{
			System.out.println("f11 pressed");
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_F9)
		{
			System.out.println("f9 released");
		}	
		if(e.getKeyCode() == KeyEvent.VK_F10)
		{
			System.out.println("f10 released");
		}
		if(e.getKeyCode() == KeyEvent.VK_F11)
		{
			System.out.println("f11 released");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_F9)
		{
			System.out.println("f9 released");
		}	
		if(e.getKeyCode() == KeyEvent.VK_F10)
		{
			System.out.println("f10 released");
		}
		if(e.getKeyCode() == KeyEvent.VK_F11)
		{
			System.out.println("f11 released");
		}
	}
}
