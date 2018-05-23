import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

//Player class inherits JPanel
public class Player extends JPanel {
	private int PlayerX, PlayerY;
	private Image playerimg;
	private ImageIcon player;	
	private int playerscore = 0;
	public int setplayerscore;
	
	
	//This is Encapsulation 
	public void setPlayerX(int X)
	{
		PlayerX = X;
	}
	
	public void setPlayerY(int Y)
	{
		PlayerY = Y;
	}
	
	public int getPlayerX()
	{
		return PlayerX;
	}
	
	public int getPlayerY()
	{
		return PlayerY;
	}
	
	public Player()
	{		
		player = new ImageIcon("player.png");
		playerimg = player.getImage();
	}

	public void desgin(Graphics g)
	{
		//player
		g.drawImage(playerimg, PlayerX, PlayerY, this);		
		/*g.setColor(Color.blue);
		g.fillOval(PlayerX, PlayerY, 40, 40);*/		
		
		//playerscore
		g.setFont(new Font("Arial", Font.BOLD, 28));
		playerscore = setplayerscore;
		g.drawString("Player: " + playerscore, 700, 610);
	}
	public void restrictArea()
	{
		if(PlayerX < 610)		
		{
			PlayerX = 610;
		}
		
		if(PlayerX > 850)
		{			
			PlayerX = 850;
		}
		
		if(PlayerY < 390)
		{
			PlayerY = 390;
		}
		
		if(PlayerY > 560)
		{
			PlayerY = 560;
		}
	}	
	public void move(MouseEvent e)
	{
		PlayerX = e.getX();
		PlayerY = e.getY();
		e.consume();
	}
}
