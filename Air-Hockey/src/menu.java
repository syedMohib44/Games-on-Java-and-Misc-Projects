import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class menu extends JFrame implements ActionListener{	
	
	private JButton play, about, exit;
	private JLabel background,logo;
	menuGui gu;
	
	public menu() {
		
		setBounds(0,0,1024,800);
		setLayout(null);	
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Air-Hockey 2.0");
	
		play = new JButton("Play");
		play.setFont(new Font("Verdana", Font.BOLD, 15));
		play.setBounds(870, 550, 100, 25);
		play.setBackground(Color.ORANGE);
		play.setForeground(new Color(139,0,139));
		
		about = new JButton("About");
		about.setFont(new Font("Verdana", Font.BOLD, 15));
		about.setBounds(870,600,100,25);
		about.setBackground(Color.ORANGE);
		about.setForeground(new Color(139,0,139));
		
		exit = new JButton("Exit");
		exit.setFont(new Font("Verdana", Font.BOLD, 15));
		exit.setBounds(870,650,100,25);
		exit.setBackground(Color.ORANGE);	
		exit.setForeground(new Color(139,0,139));
		
		logo = new JLabel(new ImageIcon("DevelopersVoidLogo.png"));
		logo.setSize(130,130);
		logo.setLocation(0, 10);
		
		background = new JLabel(new ImageIcon("home0.jpg")); //from Background from here
		background.setLayout(null);
		add(background); 
		background.setSize(1024,800); //till here
		
		background.add(play);
		background.add(about);
		background.add(exit);
		background.add(logo);
		
		play.addActionListener(this);
		about.addActionListener(this);
		exit.addActionListener(this);		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == play)
		{
			this.setVisible(false);
			gu = new menuGui();
		}
		if(e.getSource() == about)
		{
			this.setVisible(false);
			About abt = new About();
		}
		if(e.getSource() == exit)
		{
			this.dispose();
		}		
	}
}
