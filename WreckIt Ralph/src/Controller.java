import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.spi.AudioFileReader;

public class Controller {
	
	LinkedList<enemies> e = new LinkedList<enemies>();
	enemies tempEnemy;
	private int score = 0;
	private movements player;
	private boolean isdead;
	
	public Controller(movements player) {
		this.player = player;
		addEnemy(new enemies(775, 780));
		addEnemy(new enemies(900, 780));
		addEnemy(new enemies(1050, 780));
		addEnemy(new enemies(1200, 780));
		addEnemy(new enemies(1350, 780));
	}
	
	public boolean dead = false;
	public void render(Graphics g) {
		for(int i = 0; i < e.size(); i++) {
			tempEnemy = e.get(i);
			tempEnemy.rendrer(g);
		}
	}
	
	/*public Rectangle enemyBounds() {
		for(int i = 0; i < e.size(); i++) {
			tempEnemy = e.get(i);
			return new Rectangle(tempEnemy.getenemiesPosX() * i, tempEnemy.getenemiesPosY(), 50, 40);
		}
	}*/
	
	public int getScore() {
		return score;
	}
	
	public void update() {
		for(int i = 0; i < e.size(); i++) {
			tempEnemy = e.get(i);
			tempEnemy.enemyAnim();	
			
			/* {
				enemydeaths();
			}*/
		}
	}	
	public void enemydeaths() {
		for(int i = 0; i < e.size(); i++) {
			tempEnemy = e.get(i);
			if(player.getBoundsBottom().intersects(tempEnemy.enemyBounds())) {
				System.out.println("Enemy is dead");
				//player.setPlayerDeath(false);
				tempEnemy.setDeath(true);
				//dead = tempEnemy.getDeath();
				}
				
			else if((player.getBoundsRight().intersects(tempEnemy.enemyBounds()) || player.getBoundsLeft().intersects(tempEnemy.enemyBounds()))){
					player.setPlayerDeath(true);
					System.out.println("Player is dead");
				}
				
				if(tempEnemy.getDeath() == true) {
					score = tempEnemy.getScore();
					player.setPlayerDeath(false);
					tempEnemy.deathAnim();
					}
				if(tempEnemy.getenemiesPosX() < -20) {
					tempEnemy.setenemiesPosX(1050);
					System.out.println(tempEnemy.getenemiesPosX());
				}
				} 
		}
	public void addEnemy(enemies enemy) {
			e.add(enemy);
	}
	
	public void saveScore() {
		FileWriter writeFile = null;
		BufferedWriter writer = null;
		
		try {
			writeFile = new FileWriter("score.txt");
			writer = new BufferedWriter(writeFile);
			writer.newLine();
			writer.write(Integer.toString(score));
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
