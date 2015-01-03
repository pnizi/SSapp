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

public class FullscreenSS implements ISS
{	
	private String ssDir="\\Desktop\\Screenshots\\";
	private CheckFolder cf=new CheckFolder();
	
	//Fullscreen SS
	public void screenshot()
	{
		//check if folder exists if not it creates
		if(cf.check())
		{
			try
			{
				//take SS
				BufferedImage image=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				//Write
				ImageIO.write(image,"png",new File(System.getProperty("user.home")+generateImgName()));
			} 
			catch (HeadlessException | AWTException | IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Screenshotted");	
		}
	}
	public void hotkey()
	{
		//
		
	}
	//generate unique name and formats directory
	public String generateImgName()
	{
		StringBuilder strBuild=new StringBuilder();
		String imgName=GenerateString.generateRandomString();
		
		strBuild.append(ssDir);
		strBuild.append(imgName);
		strBuild.append(".png");
		
		System.out.println(strBuild.toString());
		return strBuild.toString();
	}
}
