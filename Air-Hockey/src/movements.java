import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class movements extends JPanel implements ActionListener, MouseMotionListener {
	
	private Timer gametimer, timer;
	private Image dbimage,backimg;
	private ImageIcon board1,backr;
	private int delay = 8;
	private int enemyscore = 0, playerscore = 0;
	private int time = 100, count = 0;
	private String inst = "INSTRUCTIONS:\nTime will start on hitting the puck.\nOnce the puck is hit time will run\ndown until one makes a goal.\nOn goal score will be added\non screen. Best Of Luck!";

	
	Player p;
	Enemy emy;
	Puck puc;
	public movements(String s)
	{
		p = new Player();
		emy = new Enemy();
		setSize(1024,800);
		setLayout(null);
		timer = new Timer(100,this);
		timer.start();			
		
		gametimer = new Timer(delay,this);
		gametimer.start();
			
		addMouseMotionListener(this);
		
		if(s == "Map1")
		{
		board1 = new ImageIcon("board.png");
		}
		if(s == "Map2")
		{
		board1 = new ImageIcon("board2.png");
		}
		if(s == "Map3")
		{
		board1 = new ImageIcon("board3.png");
		}
		dbimage = board1.getImage();	
		backr = new ImageIcon("gameplayBack.jpg");
		backimg = backr.getImage();
		
		puc = new Puck(742,372,-1,-2);
		p.setPlayerX(700);
		p.setPlayerY(450);
		emy.setEnemyX(650);
		emy.setEnemyY(220);
		emy.setEnemydirX(-1);
		emy.setEnemydirY(-2);
	}
	
	//This will break line on \n.
	 private void drawString(Graphics g, String text, int x, int y) {
         for (String line : text.split("\n"))
             g.drawString(line, x, y += g.getFontMetrics().getHeight());
     }

	public void paint(Graphics g)
	{	
		super.paintComponent(g);
		
		g.drawImage(backimg, 0, 0, this);
		
		//Board		
		g.drawImage(dbimage, 600, 150, this);
		
		//Puck
		puc.desgine(g);
		
		//Enemy
		emy.desgine(g);		
		
		//Player
		p.desgin(g);			
		
		//timesUp
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.setColor(new Color(249,196,2));
		g.drawString("Time " + time, 500, 100);
		
		//Instructions
		g.setFont(new Font("Verdana", Font.BOLD, 20));
		g.setColor(new Color(249,196,2));
		drawString(g, inst, 50, 300);
		//g.drawString(inst + time, 50, 400);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(count >= 1)
		{	
		if(e.getSource() == timer)
		{
			time--;
			if(time == 0)
			{
			saveScore();
			timesUp();
		    }
		}
		//time++;
		if(e.getSource() == gametimer)
		{
		puc.puckMovement();
		emy.enemyMovement();
		}
		}
		p.restrictArea();
		intersections();
		repaint();		
	}
	
	public int getPlayerScore()
	{
		if(playerscore >= 0)
		{
			return playerscore;
		}
		else
			return 0;
	}
	
	public int getEnemyScore()
	{
		if(enemyscore >= 0)
		{
			return enemyscore;
		}
		else
			return 0;
	}
	
	public void timesUp()
	{
		timer.stop();
		gametimer.stop();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	public void intersections()
	{
		Rectangle enemyBound = new Rectangle(emy.getEnemyX(), emy.getEnemyY(), 55, 55);
		Rectangle puckBound = new Rectangle(puc.puckPosX, puc.puckPosY, 35, 35);
		Rectangle playerBound = new Rectangle(p.getPlayerX(), p.getPlayerY(), 55, 55);
		Rectangle enemyGoal = new Rectangle(700, 100, 120, 60);
		Rectangle playerGoal = new Rectangle(700, 610, 120, 60);

		if(puckBound.intersects(enemyBound) || puckBound.intersects(playerBound))
		{
			puc.puckYdir = -puc.puckYdir;
			count++;
		}
		if(puckBound.intersects(playerGoal))
		{
			enemyscore++;
			emy.setenemyscore = getEnemyScore();
			reset();
		}
		
		if(puckBound.intersects(enemyGoal))
		{
			playerscore++;
			p.setplayerscore = getPlayerScore();
			reset();
		}
	}	
	
	public void saveScore()
	{
		FileWriter writefile = null;
		BufferedWriter writter = null;
		try {
			writefile = new FileWriter("Score.txt",true);
			writter = new BufferedWriter(writefile);
			writter.newLine();
			writter.write(Integer.toString( playerscore));
			writter.close();
		}
		catch(Exception e){
			e.printStackTrace();			
		}
	}
	public void reset()
	{
		puc.puckPosX = 742;
		puc.puckPosY = 372;		
		count = 0;
	}

	@Override
	public void mouseMoved(MouseEvent e) {		
		p.move(e);	
	}
}
//https://www.youtube.com/watch?v=CZ6i8RM6Uxg&t=299s
