package testing;

import de.ksquared.system.mouse.GlobalMouseListener;
import de.ksquared.system.mouse.MouseAdapter;
import de.ksquared.system.mouse.MouseEvent;

public class MouseHookTest {
    public static void main(String[] args) 
    {
        new GlobalMouseListener().addMouseListener(new MouseAdapter() 
        {
        	/*
            @Override public void mousePressed(MouseEvent event)  
            { 
            	System.out.println(event); 
            }
            */
            @Override public void mouseReleased(MouseEvent event)  
            { 
            	
            	System.out.println(event); 
            }
        /*    @Override public void mouseMoved(MouseEvent event) 
            {
                System.out.println(event);
                if((event.getButtons()&MouseEvent.BUTTON_LEFT)!=MouseEvent.BUTTON_NO
                && (event.getButtons()&MouseEvent.BUTTON_RIGHT)!=MouseEvent.BUTTON_NO)
                    System.out.println("Both mouse buttons are currenlty pressed!");
            }
            */
        });
        while(true)
            try { Thread.sleep(100); }
            catch(InterruptedException e) { e.printStackTrace(); }
    }
}
