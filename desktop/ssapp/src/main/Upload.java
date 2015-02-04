package main;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import javax.imageio.ImageIO;

import java.net.URISyntaxException;



public class Upload
{
	private final static String CLIENT_ID ="afc1aa3fddc92fa";
	private final static String IMGUR_POST_URI= "https://api.imgur.com/3/upload";
	static BufferedImage imgToUpload = null;
	private static String imgurResponse="";
	
	public void uploadToImgur(String path)
	{
		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
		try 
		{

			URL uploadurl = new URL(IMGUR_POST_URI);
			imgToUpload = ImageIO.read(new File(path)); 
			
			System.out.println("Writing the image");
			ImageIO.write(imgToUpload, "png", outputstream); 
			
			//Encode
	        String requestparams = URLEncoder.encode("image", "UTF-8") + 
	        		"=" +  URLEncoder.encode(com.sun.org.apache.xml.internal.security.utils.Base64.encode(outputstream.toByteArray()), "UTF-8") + 
	        		"&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(CLIENT_ID, "UTF-8");
			
	        		
	        //upload
	        java.net.URLConnection uploadconnection = uploadurl.openConnection();
	        uploadconnection.setDoOutput(true);
	        uploadconnection.setDoInput(true);
	        uploadconnection.setUseCaches(true);
	        uploadconnection.setRequestProperty("Authorization", "Client-ID " + CLIENT_ID);
	        uploadconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

	        OutputStreamWriter sendData = new OutputStreamWriter(uploadconnection.getOutputStream());

	        sendData.write(requestparams);
	        sendData.flush();
            sendData.close();
	        System.out.println("Request made awaiting results");
 
	        BufferedReader reader = new BufferedReader(new InputStreamReader(uploadconnection.getInputStream()));
	        for(String data; (data = reader.readLine()) != null;) 
	        {
	        	 System.out.println(data);
	        	 setImgurResponse(data);
	        }
	        reader.close();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
	public void setImgurResponse(String x)
	{
		imgurResponse=x;
	}
	public String getImgurResponse()
	{
		return imgurResponse;
	}
	private String getURL()
	{
		String imgStr=getImgurResponse();
		//get url from string
		String imgUrl=imgStr.substring(imgStr.indexOf("link\":\"") + 7, imgStr.indexOf("\"}")).replaceAll("\\\\", "");;
		
		return imgUrl;	
	}
	public void openURL()
	{
		String url=getURL();
		
		if(Desktop.isDesktopSupported())
		{
			Desktop desktop=Desktop.getDesktop();
			try
			{
				//windows
				desktop.browse(new URI(url));
			}
			catch(IOException | URISyntaxException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			Runtime runtime=Runtime.getRuntime();
			try
			{
				//ubuntu
				runtime.exec("xdg-open "+url);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	public void UrlToClipboard()
	{
		StringSelection imgLink=new StringSelection(getURL());
		Clipboard clpbrd=Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(imgLink, null);
	}
}
