package main;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLEncoder;
import javax.imageio.ImageIO;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


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
	        getURL();
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
	public String getURL()
	{
		String imgStr=getImgurResponse();
		String imgUrl="";
		String regex="http:\\/\\/i.imgur.com\\/........png";
		
		Pattern p=Pattern.compile(regex);
		
		Matcher m=p.matcher(imgStr);
		while(m.find())
			imgUrl=m.group();
		System.out.println(imgUrl);
		
		return imgUrl;	
	}
}
