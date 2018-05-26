import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Logger;
import java.util.logging.Level;


public class tree extends Applet {
	

	public void init()
	{
		setSize(1200,600);
		setBackground(Color.black);
	}
	public void paint(Graphics g)
	{
		try {
			treeimg(g,100,0,600,550);
		} catch (InterruptedException e) {
			Logger.getLogger(tree.class.getName()).log(Level.SEVERE, null,e);
		}
	}
	
	public void treeimg(Graphics g, int len, int angle,int x , int y) throws InterruptedException
	{
		int xsize = (int)(Math.cos(Math.toRadians(angle + 90))*len);
		int ysize = (int)(Math.sin(Math.toRadians(angle - 90))*len);
		setForeground(Color.green);
		g.drawLine(x, y, x+xsize, y+ysize);
		Thread.sleep(0);
		if(len >= 1)
		{
			treeimg(g, len-10, angle+30, x+xsize, y+ysize);
			treeimg(g, len-10, angle-30, x+xsize, y+ysize);			
		}			
	}
}
