import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;

public class menu {
	
	public Rectangle playButton	= new Rectangle((frame.WIDTH/2)-100, frame.HEIGHT/3, 150, 50);
	public Rectangle helpButton	= new Rectangle((frame.WIDTH/2)-100, (frame.HEIGHT/3) + 100, 150, 50);
	public Rectangle quitButton	= new Rectangle((frame.WIDTH/2)-100, (frame.HEIGHT/3) + 200, 150, 50);
	public Rectangle backButton	= new Rectangle((frame.WIDTH/8)-100, (frame.HEIGHT/20), 150, 50);
	private movements player;
	private int highScore = 0;
	public menu(movements player) {
		this.player = player;
		HighScroe();
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		Font fnt = new Font("Arial", Font.BOLD, 50);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("WRECKIT RALPH", (frame.WIDTH / 2)/2, frame.HEIGHT / 6);
		
		Font fnt1 = new Font("Arial", Font.BOLD, 40);
		g.setFont(fnt1);
		g.drawString("PLAY", playButton.x + 20, playButton.y + 40);
		//g2d.draw(playButton);

		g.drawString("HELP", helpButton.x + 20, helpButton.y + 40);
		//g2d.draw(helpButton);

		g.drawString("QUIT", quitButton.x + 20, quitButton.y + 40);
		//g2d.draw(quitButton);
		
		Font fnt2 = new Font("Arial", Font.BOLD, 20);
		g.setColor(Color.WHITE);
		g.setFont(fnt2);
		g.drawString("HighScore: " + highScore, player.getplayerPosX() / 2, player.getplayerPosY());
		
		
	/*	if(gamescreen.state == gamescreen.STATE.HELP) {
			Font fnt3 = new Font("Arial", Font.BOLD, 50);
			g.setColor(Color.WHITE);
			g.setFont(fnt3);
		    g.drawString("BACK", backButton.x + 20, backButton.y + 40);
		    g2d.draw(backButton);
		}*/
	}
	public void HighScroe() {
		FileReader readfile = null;
		BufferedReader reader = null;
		try {
			readfile = new FileReader("score.txt");
			reader = new BufferedReader(readfile);
			   String line = reader.readLine();
		        while (line != null)                 // read the score file line by line
		        {
		            try {
		                int score = Integer.parseInt(line.trim());   // parse each line as an int
		                if (score > highScore)                       // and keep track of the largest
		                { 
		                    highScore = score; 
		                }
		            } catch (NumberFormatException e1) {
		                // ignore invalid scores
		                //System.err.println("ignoring invalid score: " + line);
		            }
		            line = reader.readLine();
		        }
		        reader.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
