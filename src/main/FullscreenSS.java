package main;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class FullscreenSS implements ISS
{	
	private final String ssDir="\\Desktop\\Screenshots\\";
	private CheckFolder cf=new CheckFolder();
	private String imgaddress = "";
	
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
				//save to destination
				imgaddress = getFilePath();
				ImageIO.write(image,"png",new File(imgaddress));
				Upload upload=new Upload();
				upload.uploadToImgur(imgaddress); 
				upload.openURL(); //test upload n open link
				upload.UrlToClipboard(); //test upload n clipboard link
			} 
			catch (HeadlessException | AWTException | IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//generate unique name and formats directory
	public String generateImgName()
	{
		StringBuilder strBuild=new StringBuilder();
		String imgName=GenerateString.generateRandomString();
		//create dir string with filename
		strBuild.append(ssDir);
		strBuild.append(imgName);
		strBuild.append(".png");
		
		return strBuild.toString();
	}
	//Sets file name as timestamp 
	public String generateImgNameAsTimestamp()
	{
		DateFormat dateFormat= new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
		Date date=new Date();
		StringBuilder strBuild=new StringBuilder();
		//create dir string with filename
		strBuild.append(ssDir);
		strBuild.append(dateFormat.format(date));
		strBuild.append(".png");
		System.out.println(strBuild);
		
		return strBuild.toString();	
	}
	public String getFilePath()
	{
		return System.getProperty("user.home")+generateImgNameAsTimestamp();
	}
}
