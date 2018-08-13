import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Collisions {
	
	public int floorX = 5, floorY = 823, floorWidth = 955, floorHeigth = 10;
	public int LwallX = 5, LwallY = 10, LwallWidth = 5, LwallHeight = 800;
	public int RwallX = 940, RwallY = 10, RwallWidth = 5,RwallHeight = 800;
	
	public void desgine(Graphics g)
	{
		//floor
		g.setColor(Color.white);
		g.drawRect(floorX, floorY, floorWidth, floorHeigth);
		
		//roof
		g.setColor(Color.white);		
		g.drawRect(290, 80, 370, 10);
		
		//first line
		g.setColor(Color.white);		
		g.drawRect(307, 415, 335, 10);
		
		//second
		g.setColor(Color.white);		
		g.drawRect(307,630, 335, 10);
		
		//left
		g.setColor(Color.white);		
		g.drawRect(5,10, 5, 800);
		
		//right
		g.setColor(Color.white);		
		g.drawRect(940,10, 5, 800);	
		
		//left stairs
		g.setColor(Color.white);		
		g.drawRect(290, 100, 15, 600);
		
		//right stairs
		g.setColor(Color.white);		
		g.drawRect(645, 100, 15, 600);
		
	}
	public boolean Verticalintersection(int playerPosX, int playerPosY, double velX, double velY, int playerWidth, int playerHeigth)
	{
		if(new Rectangle(playerPosX + 20, playerPosY +(playerHeigth / 2 + 25), playerWidth/2,(playerPosY / 2)/((playerHeigth / 2))).intersects(new Rectangle(floorX, floorY, floorWidth, floorHeigth)))
		{
			velY = 0;
			return true;
		}		
		if(new Rectangle(playerPosX + 5, playerPosY + 5,50,60).intersects(new Rectangle(307,630, 335, 10)))
		{
			return true;
		}
		
		if(new Rectangle(playerPosX + 5, playerPosY + 5,50,60).intersects(new Rectangle(307, 415, 335, 10)))
		{
			return true;
		}
		
		if(new Rectangle(playerPosX + 5, playerPosY + 5,50,60).intersects(new Rectangle(290, 80, 370, 10)))
		{
			return true;
		}	
		
		return false;
	}
	

	public boolean StairsCollision(int playerPosX, int playerPosY, double velX, double velY)
	{
		if(new Rectangle(playerPosX + 5, playerPosY + 5,50,60).intersects(new Rectangle(290, 100, 15, 600)))
		{
			return true;
		}
		if(new Rectangle(playerPosX + 5, playerPosY + 5,50,60).intersects(new Rectangle(645, 100, 15, 600)))
		{
			return true;
		}
		return false;
	}
	public boolean enemyCollsion(int playerPosX, int playerPosY, int enemyPosX, int enemyPosY, int len)
	{
		for(int i = 1; i < len; i++)
		{
		if(new Rectangle(playerPosX + 5, playerPosY + 5,50,60).intersects(new Rectangle(new Rectangle(enemyPosX * i, enemyPosY, 50, 40))))
		{
			return true;
		}
		}	
		return false;
	}
	
	/*public Rectangle getBoundsLeft(int playerPosX, int playerPosY, int playerWidth, int playerHeigth) {
		return new Rectangle(playerPosX + (((playerWidth / 4)/2)), playerPosY + 5, (playerWidth / 2) / 2, playerHeigth);
	}
	
	public Rectangle getBoundsRight(int playerPosX, int playerPosY, int playerWidth, int playerHeigth) {
		return new Rectangle(playerPosX + ((playerWidth /2) + (playerWidth / 2) - 6), playerPosY + 5, (playerWidth - (playerWidth / 2)) / 2, playerHeigth);
	}
	
	public Rectangle getBoundsBottom(int playerPosX, int playerPosY, int playerWidth, int playerHeigth) {
		return new Rectangle(playerPosX + 5, playerPosY + playerHeigth - 7, playerWidth,(playerPosY / 2)/((playerHeigth / 2)));
	}
	public Rectangle getBoundsTop(int playerPosX, int playerPosY, int playerWidth, int playerHeigth) {
		return new Rectangle(playerPosX + 5, playerPosY + 5, playerWidth, (playerPosY / 2)/((playerHeigth / 2)));
	}*/
}
