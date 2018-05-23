import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class highScore extends JFrame implements ActionListener{
	
	private JLabel scorelabel, backgrund, HighScore;
	private JButton backbutton;

	public highScore()
	{
		setBounds(0,0,1024,800);
		setLayout(null);	
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Air-Hockey 2.0");
		setVisible(true);
		
		backgrund = new JLabel(new ImageIcon("back.jpg"));
		add(backgrund);
		backgrund.setSize(1024,800);
		
		backbutton = new JButton("Back");
		backbutton.setFont(new Font("Verdana", Font.BOLD, 15));
		backbutton.setBounds(40, 40, 100, 25);
		backbutton.setBackground(Color.ORANGE);
		backbutton.setForeground(new Color(139,0,139));
		add(backbutton);
		

		scorelabel = new JLabel("HIGH SCORE");
		scorelabel.setBounds(350,150,650,300);
		scorelabel.setForeground(Color.ORANGE);
		scorelabel.setFont(new Font("Verdana", Font.BOLD, 40));
		backgrund.add(scorelabel);
		
		getHighScore();
		HighScore = new JLabel(Integer.toString(highScore));
		HighScore.setBounds(470,220,650,300);
		HighScore.setForeground(Color.ORANGE);
		HighScore.setFont(new Font("Verdana", Font.BOLD, 40));
		backgrund.add(HighScore);		
		
		backbutton.addActionListener(this);
	}

	int highScore = 0;
	public void getHighScore()
	{
		FileReader readfile = null;
		BufferedReader reader = null;
		try {
			readfile = new FileReader("Score.txt");
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backbutton)
		{
			this.setVisible(false);
			new menu();
		}
		
	}

}
