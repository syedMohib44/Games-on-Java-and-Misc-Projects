import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class movements {
	
	protected int playerPosX, playerPosY;
	protected int playerWidth = 50, playerHeigth = 60;
	protected boolean iscollied = false, playerIsDead = false;
	protected boolean jumping = false, falling = false, left = false, right = false, grab = false, grableft = false;
	protected double gravity = 0, maxY = 4, velX = 1, velY = 2;
	MusicPlayer mp;
	Collisions c;
	public movements(Collisions c)
	{
		this.c = c;
	}
	
	public void setPlayerDeath(boolean playerIsDead) {
		this.playerIsDead = playerIsDead;
	}
	
	public boolean getPlayerDeath() {
		return playerIsDead;
	}
	
	public void setplayerPosX(int playerPosX)	{
		this.playerPosX = playerPosX;
	}
	
	public void setplayerPosY(int playerPosY)	{
		this.playerPosY = playerPosY;
	}
	
	public int getplayerPosX()	{
		return playerPosX;
	}
	
	public int getplayerPosY() {
		return playerPosY;
	}
	
	public void fall()
	{		
		this.playerPosY += gravity;			
	}
	
	public void jump()
	{
		playerPosY -= velY;	
	}	
	
	public Rectangle getBoundsRight() {
		return new Rectangle(playerPosX + ((playerWidth /2) + (playerWidth / 2) - 6),  playerPosY + (playerHeigth / 2), (playerWidth - (playerWidth / 2)) / 2, playerHeigth - ((playerHeigth/2)));
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle(playerPosX + (((playerWidth / 4)/2)), playerPosY + (playerHeigth / 2), (playerWidth / 2) / 2, playerHeigth - ((playerHeigth/2)));
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle(playerPosX + 20, playerPosY +(playerHeigth / 2 + 20), playerWidth/2,(playerPosY / 2)/((playerHeigth / 2)));
	}
	public Rectangle getBoundsTop() {
		return new Rectangle(playerPosX + 20, playerPosY + 5, playerWidth / 2, (playerPosY / 2)/((playerHeigth / 2)));
	}
	
	public void playerMov(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{			
			grab = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			left = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{			
			right = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP && jumping == false)			
		{			
			jumping = true;		
				if(e.getKeyCode() == KeyEvent.VK_UP && c.StairsCollision(playerPosX, playerPosY, velX, velY))
				{
					jumping = false;
					playerPosY -= velY;
				}
				/*if(c.StairsCollision(playerPosX, playerPosY, velX, velY))
				{
					jumping = false;
					falling = false;
					playerPosY -= velY;
				}
				else if(!c.StairsCollision(playerPosX, playerPosY, velX, velY) && falling == true)
				{
					//velY = 0;
					jumping = true;
					falling = false;						
				}*/
		}
	}
	
	public void upKey(KeyEvent e)
	{		
		if(e.getKeyCode() == KeyEvent.VK_UP)			
		{			
				//falling = true;				
				//jumping = false;				
				
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)			
		{			
				left = false;			
				
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)			
		{			
				right = false;					
		}	
	}
}
