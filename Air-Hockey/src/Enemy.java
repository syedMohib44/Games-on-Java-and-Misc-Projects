import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Enemy extends JPanel{
	
	private int enemyPosX = 650,enemyPosY = 220, enemyXdir = -1, enemyYdir = -2;
	private Image enemyimg;
	private ImageIcon enemy;	
	private boolean enemymov = false;   
	private int enemyscore = 0;
	public int setenemyscore;
	
	public Enemy()
	{
		enemy = new ImageIcon("enemy.png");
		enemyimg = enemy.getImage();
	}
	
	public void setEnemyX(int X)
	{
		enemyPosX = X;
	}
	
	public void setEnemyY(int Y)
	{
		enemyPosY = Y;
	}
	
	public void setEnemydirX(int X)
	{
		enemyXdir = X;
	}
	
	public void setEnemydirY(int Y)
	{
		enemyYdir = Y;
	}
	
	public int getEnemyX()
	{
		return enemyPosX;
	}
	
	public int getEnemyY()
	{
		return enemyPosY;
	}
	
	public int getEnemydirY()
	{
		return enemyYdir;
	}
	
	public int getEnemydirX()
	{
		return enemyXdir;
	}
	
	public void desgine (Graphics g)
	{
		//enemy
		g.drawImage(enemyimg, enemyPosX, enemyPosY, this);
		/*g.setColor(Color.green);
		g.fillOval(enemyPosX, enemyPosY, 40, 40);*/
		
		//enemyscore
		g.setFont(new Font("Arial", Font.BOLD, 28));
		enemyscore = setenemyscore;
		g.drawString("Score " + enemyscore, 700, 190);
	}
	
	/*This works same as Puck. There are two ways to move your enemy see which seems easy to you 
	and try to implement that first and after that try to understand second one*/
	
	public void enemyMovement()
	{
		//One way
		/*if(enemymov)
		{
			enemyPosX += 3;
		}
		else 
		{
			enemyPosX -= 3;
		}
		
		if(enemyPosX < 610)
		{
			enemymov = true;
		}
		
		if(enemyPosX > 867)
		{
			enemymov = false;
		}*/	
		
		//Other way		
		enemyPosX += enemyXdir;
		enemyPosY += enemyYdir;
		
		if(enemyPosX < 610 )		
			enemyXdir = -enemyXdir;
		
		if(enemyPosX > 867 )		
			enemyXdir = -enemyXdir;	
		
		if(enemyPosY < 150 )		
			enemyYdir = -enemyYdir;
		
		if(enemyPosY > 300 )		
			enemyYdir = -enemyYdir;	
	}	

}
