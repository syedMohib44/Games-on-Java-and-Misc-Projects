import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class menuGui extends JFrame implements ActionListener{
	
	JLabel board1, board2, board3, backgrund;
	JButton select1,select2,select3,backbutton;
	public menuGui()
	{	
		setBounds(0,0,1024,800);
		setLayout(null);	
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Air-Hockey 2.0");
		
		backgrund = new JLabel(new ImageIcon("back.jpg"));
		add(backgrund);
		backgrund.setSize(1024,800);
		
		board1 = new JLabel(new ImageIcon("map1.png"));
		board1.setLayout(null);
		backgrund.add(board1);
		board1.setBounds(80,150,250,350);		
		select1= new JButton("Select");
		select1.setFont(new Font("Verdana", Font.BOLD, 15));
		select1.setBounds(155,525,100,25);
		select1.setBackground(Color.ORANGE);
		select1.setForeground(new Color(139,0,139));
		backgrund.add(select1);
		
		board2 = new JLabel(new ImageIcon("map2.png"));
		board2.setLayout(null);
		backgrund.add(board2);
		board2.setBounds(380,150,250,350);
		select2= new JButton("Select");
		select2.setFont(new Font("Verdana", Font.BOLD, 15));
		select2.setBounds(455,525,100,25);
		select2.setBackground(Color.ORANGE);
		select2.setForeground(new Color(139,0,139));
		backgrund.add(select2);
		
		board3 = new JLabel(new ImageIcon("map3.png"));
		board3.setLayout(null);
		backgrund.add(board3);
		board3.setBounds(680,150,250,350);
		select3= new JButton("Select");
		select3.setFont(new Font("Verdana", Font.BOLD, 15));
		select3.setBounds(755,525,100,25);
		select3.setBackground(Color.ORANGE);
		select3.setForeground(new Color(139,0,139));
		backgrund.add(select3);
		
		backbutton = new JButton("Back");
		backbutton.setFont(new Font("Verdana", Font.BOLD, 15));
		backbutton.setBackground(Color.ORANGE);
		backbutton.setForeground(new Color(139,0,139));
		backbutton.setBounds(40,40,100,25);
		backgrund.add(backbutton);
		
		select1.addActionListener(this);
		select2.addActionListener(this);
		select3.addActionListener(this);
		backbutton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == select1)
		{
			this.setVisible(false);
			game gm = new game();			
			gm.tgame("Map1");
		}
		if(e.getSource() == select2)
		{
			this.setVisible(false);
			game gm = new game();			
			gm.tgame("Map2");
		}
		if(e.getSource() == select3)
		{
			this.setVisible(false);
			game gm = new game();			
			gm.tgame("Map3");
		}
		
		if(e.getSource() == backbutton)
		{
			this.setVisible(false);
			new menu();
		}
	}

}
