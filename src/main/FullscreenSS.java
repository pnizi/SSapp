package main;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FullscreenSS 
{
	public void fullscreenScreenshot()
	{
		//check if folder exists if not it creates
		if(CheckFolder.check())
		{
			try
			{
				BufferedImage image=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				ImageIO.write(image,"png",new File(System.getProperty("user.home"+ "Desktop\\Screenshots\\ss1.png")));
				System.out.println("Screenshoted");
			} 
			catch (HeadlessException | AWTException | IOException e)
			{
				e.printStackTrace();
				System.out.println("Error: Cannot capture fullscreen SS");
			}
		}
	}
}
