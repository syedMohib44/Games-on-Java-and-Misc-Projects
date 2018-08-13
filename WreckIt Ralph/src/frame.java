import javax.swing.JFrame;

public class frame {
	
	static int WIDTH = 955, HEIGHT = 865;
	
	public static void main(String args[])
	{
		JFrame fr = new JFrame();
		gamescreen gs = new gamescreen();
		fr.setBounds(0,0,WIDTH,HEIGHT);
		fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		fr.add(gs);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
}
