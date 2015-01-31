package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class FTPUpload
{
	private static final int BUFFER_SIZE = 4096;
	static String ftpUrl="ftp://%s:%s@%s/%s;type i";
	final static String host="";
	final static String  user="";
	final static String pass="";
	static String filePath="";
	static String uploadPath="";
	Screenshot fs=new Screenshot();
	
	public void uploadToFTP(String path)
	{
		filePath=fs.getFilePath();
		
		ftpUrl=String.format(ftpUrl,user,pass,host,uploadPath);
		System.out.println("UP"+ftpUrl);
		
		try
		{
			URL url=new URL(ftpUrl);
			URLConnection conn=url.openConnection();
			OutputStream outputStream=conn.getOutputStream();
			FileInputStream inputStream=new FileInputStream(filePath);
			
			byte [] buffer=new byte[BUFFER_SIZE];
			int bytesRead=-1;
			while((bytesRead=inputStream.read(buffer))!=1)
				outputStream.write(buffer, 0, bytesRead);
			
			inputStream.close();
			outputStream.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
}
