import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class About extends JFrame implements ActionListener{
	
	private JLabel me, backgrund;
	private String about = "<html>This Game is made for a<br>Blog(Developers-Void)<br>This game is made for<br>Educational purpose.<br> For more projects and info visit:<br> http://developersvoid.wordpress.com</html>";
	private JButton backbutton;
	public About()
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
		
		me = new JLabel(about);
		me.setBounds(260,200,650,300);
		me.setForeground(Color.ORANGE);
		me.setFont(new Font("Verdana", Font.BOLD, 30));
		backgrund.add(me);
		
		backbutton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backbutton)
		{
			this.setVisible(false);
			
			//This is composition
			new menu();
		}
	}	
}
