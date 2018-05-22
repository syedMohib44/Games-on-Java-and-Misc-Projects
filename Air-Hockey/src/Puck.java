import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Puck extends JPanel{
	

	public Image dbimage, puckimg, playerimg, enemyimg;
	public ImageIcon board1, puck, player, enemy;
	public int puckPosX, puckPosY, puckXdir, puckYdir;
	public int enemyscore = 0, playerscore = 0;
	
	public Puck(int puckX, int puckY, int puckXdirect, int puckYdirect)
	{
		puckPosX = puckX;
		puckPosY = puckY;
		puckXdir = puckXdirect;
		puckYdir = puckYdirect;
		puck = new ImageIcon("puck.png");
		puckimg = puck.getImage();		
	}
	
	public void desgine(Graphics g)
	{
		//Puck
		g.drawImage(puckimg, puckPosX, puckPosY, this);
		/*g.setColor(Color.red);
		g.fillOval(puckPosX, puckPosY, 30, 30);*/		
	}
	
	/*I have to both x and y positions and add them in x and y direction which is -1 and -2.
	After that I have put a condition that if puck position is lesser than 610 or equal to it
	then it's direction will become opposite means now x direction is now +1 and not -1 
	beacuse -ve-ve = +ve, it's like -(-puckXdir), and same goes for y.
	Try to debug you will understand it ;)*/
	public void puckMovement()
	{
		puckPosX += puckXdir;
		puckPosY += puckYdir;
		
		if(puckPosX <= 610)
		{
			puckXdir = -puckXdir;
		}
		
		if(puckPosX >= 865)
		{
			puckXdir = -puckXdir;
		}
		
		if(puckPosY > 150)
		{
			puckYdir = -puckYdir;
		}
		
		if(puckPosY < 590)
		{
			puckYdir = -puckYdir;
		}
	}

}
