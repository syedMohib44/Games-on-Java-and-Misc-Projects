import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class enemies extends JPanel {
	private Image enemyimg;
	private ImageIcon enemyimgicn;
	protected int enemiesPosX, enemiesPosY;
	protected int enemiesVelX, enemiesVelY;
	String path = "enemies/";
	public int totalframe = 0, deathCount = 0;
	public boolean enemyIsDead = false;
	MusicPlayer mp;
	
	public enemies(int enemiesPosX, int enemiesPosY)
	{
		this.enemiesPosX = enemiesPosX;
		this.enemiesPosY = enemiesPosY;
		mp = new MusicPlayer("audio1.wav");

	}
	
	public void setDeath(boolean enemyIsDead) {
		this.enemyIsDead = enemyIsDead;
	}
	
	public void setenemiesPosX(int enemiesPosX) {
		this.enemiesPosX = enemiesPosX;
	}
	
    public void setenemiesPosY() {
    	this.enemiesPosY = enemiesPosY;
	}
	
	public int getenemiesPosX()	{
		return enemiesPosX;
	}
	
	public boolean getDeath() {
		return enemyIsDead;
	}
	
	public int getenemiesPosY() {
		return enemiesPosY;
	}
	
	public void setenemiesVelX(int enemiesVelX) {
		this.enemiesVelX = enemiesVelX;
	}
	
	public void setenemiesVelY(int enemiesVelY) {
		this.enemiesVelY = enemiesVelY;		
	}
	
    public int getenemiesVelX() {
		return enemiesVelX;
	}
	
	public int getenemiesVelY() {
		return enemiesVelY;
	}
	
	public Rectangle enemyBounds() {
		return new Rectangle(getenemiesPosX(), getenemiesPosY(), 50, 40);
	}
	
	public void rendrer(Graphics g) {
	     //g.drawRect(getenemiesPosX(), getenemiesPosY(), 50, 40);
	     enemyimgicn = new ImageIcon(path + totalframe + ".png");
	 	 enemyimg = enemyimgicn.getImage();
		if(enemyIsDead == true)
		  g.drawImage(enemyimg, getenemiesPosX(), getenemiesPosY(), this);
			
		if(enemyIsDead == false)
		  g.drawImage(enemyimg, getenemiesPosX(), getenemiesPosY(), this);
	}
	
	public void enemyAnim()
	{
		enemiesPosX -= getenemiesVelX();

		setenemiesVelX(2);
		if(totalframe >= 9)
		{
			totalframe = 0;
		}
		totalframe++;
	}
	
	
	public void deathAnim() {
		
		if(getDeath() == true) {
			setenemiesVelX(0);
			path = "enemies/blood";
		    enemiesPosY = 790;
		    totalframe = 0;
			deathCount++;
		}
		if(deathCount == 1) {
			mp.run(1);
		}
		else if (deathCount >= 50) {
			//score++;
			enemiesPosX = 850;
			setDeath(false);
		}
		if(getDeath() == false) {
			reset();
		}
	}
	
	public void reset() {
		enemiesPosX = 880;
	    enemiesPosY = 775;
		setenemiesVelX(2);
		deathCount = 0;
		path = "enemies/";
	}
}
