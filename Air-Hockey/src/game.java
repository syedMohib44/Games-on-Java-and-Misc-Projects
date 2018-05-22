import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class game{	
	public void tgame(String s)
	{			
		JFrame jf = new JFrame();
		movements m = new movements(s);
		jf.setBounds(0,0,1024,800);		
		jf.setLayout(null);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.add(m);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);			
	}
}

//https://www.youtube.com/watch?v=_SqnzvJuKiA
//https://www.youtube.com/watch?v=oXmUp4ZTW2Q&t=336s