package main;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class TrayManager {
	
	private static Screenshot scrnsht=new Screenshot();
	public static TrayIcon trayIcon;

	/*
	public void AddTrayIcon() {
    try {
	Image icon2 = ImageIO.read(getClass().getResource("/images/ehlen.png"));
    trayicon = new TrayIcon(icon2);
	SystemTray.getSystemTray().add(trayicon);
	} 
    catch (Exception e1) {
    e1.printStackTrace();
	}
    }
	*/
	
	 public static void createAndShowGUI() throws IOException, URISyntaxException
	 {
	        //Check the SystemTray support
	        if (!SystemTray.isSupported()) {
	            System.out.println("SystemTray is not supported");
	            return;
	        }
	        final PopupMenu popup = new PopupMenu();
	       
	        //get root directory
	        //  URL u = getClass().getProtectionDomain().getCodeSource().getLocation();
	       // File f = new File(u.toURI());
	        
	        trayIcon =
	                new TrayIcon(createImage("/images/ehlen.png", "E"));
	        final SystemTray tray = SystemTray.getSystemTray();
	         
	        // Create a popup menu components
	        MenuItem aboutItem = new MenuItem("About");
	        Menu displayMenu = new Menu("Screenshot");
	        MenuItem fullscreen = new MenuItem("Capture Fullscreen");
	        MenuItem window = new MenuItem("Capture Current Window");
	        MenuItem area = new MenuItem("Capture Area");
	        MenuItem exitItem = new MenuItem("Exit");
	         
	        //Add components to popup menu
	        popup.add(aboutItem);
	        
	        popup.addSeparator();
	        
	        popup.add(displayMenu);
	        displayMenu.add(fullscreen);
	        displayMenu.add(window);
	        displayMenu.add(area);
	        
	        popup.addSeparator();
	        
	        popup.add(exitItem);
	         
	       trayIcon.setPopupMenu(popup);
	        
	        try 
	        {
	            tray.add(trayIcon);
	        } 
	        catch (AWTException e) 
	        {
	            System.out.println("TrayIcon could not be added.");
	            return;
	        }
	        trayIcon.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                JOptionPane.showMessageDialog(null,
	                        "This dialog box is run from System Tray");
	            }
	        });
	     
	        aboutItem.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	                JOptionPane.showMessageDialog(null,
	                        "Created by x0i\nContributors: Lazer\n\n\nHotkeys:\nF9: Capture Fullscreen\nF10: Capture Current Window\nF11: Capture Area");
	            }
	        });
	         
	        ActionListener listener = new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	                MenuItem item = (MenuItem)e.getSource();
	                //TrayIcon.MessageType type = null;
	                System.out.println(item.getLabel());
	                if ("Capture Fullscreen".equals(item.getLabel()))
	                {
	                    scrnsht.fullscreenSS();
	                     
	                } 
	                else if ("Capture Current Window".equals(item.getLabel())) 
	                {
	                    scrnsht.windowSS();
	                     
	                } 
	                else if ("Capture Area".equals(item.getLabel())) 
	                {
	                    //type = TrayIcon.MessageType.INFO;
	                    trayIcon.displayMessage("x0i's Screenshotter",
	                            "Not available", TrayIcon.MessageType.INFO);
	                }
	            }
	        };
	         
	        fullscreen.addActionListener(listener);
	        window.addActionListener(listener);
	        area.addActionListener(listener);
	         
	        exitItem.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	            {
	                tray.remove(trayIcon);
	                System.exit(0);
	            }
	        });
	    }
	
	 protected static Image createImage(String path, String description) 
	 {
	        URL imageURL = TrayManager.class.getResource(path);
	         
	        if (imageURL == null) 
	        {
	            System.err.println("Resource not found: " + path);
	            return null;
	        } 
	        else 
	        {
	            return (new ImageIcon(imageURL, description)).getImage();
	        }
	  }
}





