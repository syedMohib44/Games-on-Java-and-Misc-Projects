import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class gamescreen extends JPanel implements KeyListener, ActionListener{
	  
	Image playerimg, dbimage, backimg, blurimg;
	ImageIcon player,back, _enemies, blur;
	Graphics dbg;
	Timer tr, animator, enemy;
	private int temp = 650, musicTimer = 0, duration = 600, menuCount = 0;
	private String help = "Press Left Arrow key to move Left \n \nPress Right Arrow key to move Right \n \nPress Up Arrow key to Jump \n \nJump on Bugs to kill them  \n \nJump on stairs to avoid Bugs."; 
	movements m;
	Collisions coll;
	menu Menu;
	Controller c;
	Animations anim;
	MusicPlayer mp;
	
	public Rectangle backButton	= new Rectangle((frame.WIDTH/8)-100, (frame.HEIGHT/20), 150, 50);

	
	public static enum STATE {
		MENU,
		GAME,
		HELP,
		QUIT,
		BACK,
		GAMEOVER;
	};
	public static STATE state = STATE.MENU;

	public gamescreen()
	{
		coll = new Collisions();
		m = new movements(coll);
		c = new Controller(m);
		Menu = new menu(m);
		anim = new Animations(m);
		mp = new MusicPlayer("audio.wav");		
		 
		 this.addMouseListener(new mouseInputs());
   		 setSize(frame.WIDTH,frame.HEIGHT);		
		
		
		back = new ImageIcon("background.jpg");
		backimg = back.getImage();	

		blur = new ImageIcon("blur.png");
		blurimg = blur.getImage();
		
		render("playerRight0.png");
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		m.setplayerPosX(20);
		m.setplayerPosY(775);
				
		tr = new Timer(10,this);
		tr.start();
		
		animator = new Timer(300,this);
		animator.start();
				
		enemy = new Timer(100, this);
		
	}
	
	public void render(String path)
	{
		player = new ImageIcon(path);
		playerimg = player.getImage();
	}
	
	//Below code works same as the code above.
	/*public Image getplayerImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(path));
	}*/
	
	public void paint(Graphics g)
	{
		dbimage = createImage(getWidth(),getHeight());
		dbg = dbimage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbimage, 0, 0, this);
		
		
		/*Below Code is for calculating Bounds.*/
		
		// Left Rectangle component
		/*g.setColor(Color.white);
		g.drawRect(m.playerPosX + (((m.playerWidth / 4)/2)), m.playerPosY + (m.playerHeigth / 3), (m.playerWidth / 2) / 2, m.playerHeigth - ((m.playerHeigth/2)));
		
		//Right Rectangle component
		g.setColor(Color.red);
		g.drawRect(m.playerPosX + ((m.playerWidth /2) + (m.playerWidth / 2) - 6),  m.playerPosY + (m.playerHeigth / 3), (m.playerWidth - (m.playerWidth / 2)) / 2, m.playerHeigth - ((m.playerHeigth/2)));
		
		// Up Rectangle component
		g.setColor(Color.cyan);
		g.drawRect(m.playerPosX + 20,m.playerPosY + 5, m.playerWidth / 2, (m.playerPosY / 2)/((m.playerHeigth / 2)));
		
		// Down Rectangle component
		g.setColor(Color.orange);
		g.drawRect(m.playerPosX + 20, m.playerPosY +(m.playerHeigth / 2 + 20), m.playerWidth/2,(m.playerPosY / 2)/((m.playerHeigth / 2)));*/
		//b.render(g);
		
		if(state == STATE.GAME) {
			c.render(g);
		    //coll.desgine(g);
		}
	}
	
	public void fallingAnim()
	{
		player = new ImageIcon("falling" + anim.getFallingCount() + ".png");
		playerimg = player.getImage();
	}
	
	public void jumpingAnim()
	{
		player = new ImageIcon("jump" + anim.getJumpingCount() + ".png");
		playerimg = player.getImage();	
	}
	
	public void runningRight()
	{
		player = new ImageIcon("playerRight" + anim.getRightCount() + ".png");
		playerimg = player.getImage();		
	}
	
	public void runningLeft()
	{		
		player = new ImageIcon("playerLeft" + anim.getLeftCount() + ".png");
		playerimg = player.getImage();		
	}
	
	public void drawString(Graphics g, String text, int x, int y) {
		for(String line : text.split("\n")) {
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
		}
	}
	
	public void paintComponent(Graphics g)
	{		
		if(state == STATE.GAME) {
			g.drawImage(backimg, 0, 0, this);
		if(!m.getPlayerDeath() && m.right && coll.Verticalintersection(m.playerPosX, m.playerPosY, m.velX, m.velY, 50, 60))
			runningRight(); 
		
		 
		 if(!m.getPlayerDeath() && m.left && coll.Verticalintersection(m.playerPosX, m.playerPosY, m.velX, m.velY, 50, 60))
			 runningLeft();	
		
		if(coll.StairsCollision(m.playerPosX, m.playerPosY, m.velX, m.velY))
		{
				render("Rstairs.png");
			
			if(m.playerPosX > 580 && coll.StairsCollision(m.playerPosX, m.playerPosY, m.velX, m.velY))
			{
				render("stairs.png");
				System.out.println(m.playerPosX);
			}
		}
		if(m.getPlayerDeath())
		{
			render("death" + anim.getDeathCount() + ".png");
			tr.stop();
			m.setplayerPosY(790);
		}
		
		if(!m.getPlayerDeath() && m.jumping)
		   jumpingAnim();
		
		if(m.falling)
			fallingAnim();

		Font fnt = new Font("Arial", Font.BOLD, 20);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("SCORE: " + c.getScore(), (frame.WIDTH/2) - 50, 50);
		c.render(g);
      	g.drawImage(playerimg, m.getplayerPosX(), m.getplayerPosY(),this);
		}
		else if(state == STATE.MENU){
			jumpingAnim();
			m.jumping = true;
			g.drawImage(blurimg, 0, 0, this);
			g.drawImage(playerimg, m.playerPosX + 20, m.playerPosY,this);
			
			Menu.render(g);
		}
		else if(state == STATE.HELP) {
			g.drawImage(blurimg, 0, 0, this);
			Font fnt = new Font("Arial", Font.BOLD, 30);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("INSTRUCTIONS:", frame.WIDTH/6, frame.HEIGHT/3);
			drawString(g, help, frame.WIDTH/6, frame.HEIGHT/3);
			
			g.drawString("BACK", backButton.x + 20, backButton.y + 40);
			//g.drawRect(backButton.x, backButton.y, backButton.width, backButton.height);
		}
		if(state == STATE.BACK) {
			state = STATE.MENU;
		}
		
		if(state == STATE.GAMEOVER) {
			g.drawImage(blurimg, 0, 0, this);
			Font fnt0 = new Font("Arial", Font.BOLD, 50);
			g.setFont(fnt0);
			g.setColor(Color.white);
			g.drawString("GAME OVER", (frame.WIDTH/2) - 200, frame.HEIGHT/2);
		}
	}

	public void reset() {
		m.setplayerPosX(20);
		m.setplayerPosY(775);
		jumpingAnim();
	}
	
	public void actionPerformed(ActionEvent e) {
		//mp.music();
		mp.run(musicTimer);
				
		if(m.getPlayerDeath() == true) {
			menuCount++;
		}
		
		if(menuCount == 50) {
			state = STATE.GAMEOVER;
		}
		
		if(menuCount == 100) {
			//menuCount = 50;
			m.setPlayerDeath(false);
			reset();
			state = STATE.MENU;
		}
		
		if(state == STATE.MENU) {
			menuCount = 0;
		}
		
		if(musicTimer == duration)
			musicTimer = 0;
		musicTimer++;
		
		if(state == STATE.GAME) {
			enemy.start();
			}
		
		if(state == STATE.QUIT) {
			System.exit(1);
			}
		
		if(e.getSource() == enemy)
		{						
			c.update();
			c.enemydeaths();
			repaint();
		}
		
		if(e.getSource() == animator)
		{
			anim.animations();		
			repaint();
		}
		
		if(e.getSource() == tr)
		{	
     	if(m.left == true)
	    {
	    	m.playerPosX -= m.velX;	
	    }
	
       	if(m.right == true)
	   {
		   m.playerPosX += m.velX;
	   }	
		
		if(m.playerPosY <= temp && coll.StairsCollision(m.playerPosX, m.playerPosY, m.velX, m.velY) == false)
		{
			m.falling = true;
			m.jumping = false;
		}
		
		if(coll.StairsCollision(m.playerPosX, m.playerPosY, m.velX, m.velY))
		{
			m.jumping = false;
		}
		
		if(m.jumping == true)
		{		
			m.jump();	
		}		
			
		if(m.falling == true)		
		{
			m.fall();		
		}	
		
		if(coll.Verticalintersection(m.playerPosX, m.playerPosY, m.velX, m.velY, 50, 60)/* && m.jumping == true*/)
		{
		    m.gravity = 0;		
			temp = m.playerPosY;
			temp -= 90;
			m.jumping = false;
			m.falling = false;
			render("playerRight0.png");
		}
		if(!coll.Verticalintersection(m.playerPosX, m.playerPosY, m.velX, m.velY, 50, 60) && m.playerPosY <= temp && !coll.StairsCollision(m.playerPosX, m.playerPosY, m.velX, m.velY))
		{
			m.gravity = 3;			
			/*m.jumping = false;
			m.falling = true;*/
		}
		if(m.playerPosX <= 5) {
			m.playerPosX = 5;
		}
		if(m.playerPosX >= 890) {
			m.playerPosX = 890;
		}	
		repaint();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		
		if(state == STATE.GAME) {
			m.playerMov(e);
			Menu.HighScroe();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		m.upKey(e);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
