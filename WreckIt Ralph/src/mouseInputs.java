import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseInputs implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		public Rectangle helpButton	= new Rectangle((frame.WIDTH/2)-100, (frame.HEIGHT/3) + 100, 150, 50);

		int mx = e.getX();
		int my = e.getY();
		
		if((mx >= (frame.WIDTH/2) - 100) && mx <= (frame.WIDTH/2) + 50){
			if(my >= frame.HEIGHT/3 && my <= frame.HEIGHT/3 + 50) {
				//Pressed playButton
				if(gamescreen.state == gamescreen.STATE.MENU) {
				gamescreen.state = gamescreen.STATE.GAME;
				}
			}	
		}
		
		if(mx >= ((frame.WIDTH/2) - 100) && mx <= (frame.WIDTH/2) + 50) {
			if(my >= frame.HEIGHT/3 + 100 && my <= frame.HEIGHT/3 + 150) {
				if(gamescreen.state == gamescreen.STATE.MENU) {
				gamescreen.state = gamescreen.STATE.HELP;
				}
			}
		}
		
		if(mx >= ((frame.WIDTH/2) - 100) && mx <= (frame.WIDTH/2) + 50) {
			if(my >= frame.HEIGHT/3 + 200 && my <= frame.HEIGHT/3 + 250) {
				if(gamescreen.state == gamescreen.STATE.MENU) {
					gamescreen.state = gamescreen.STATE.QUIT;
				}
			}
		}
		
//		public Rectangle backButton	= new Rectangle((frame.WIDTH/8)-100, (frame.HEIGHT/20), 150, 50);
	
		if(mx >= (frame.WIDTH/8) - 100 && mx <= (frame.WIDTH/20) + 200) {
			if(my >= frame.HEIGHT/20 && my <= frame.HEIGHT/20 + 150) {
				if(gamescreen.state == gamescreen.STATE.HELP) {
				gamescreen.state = gamescreen.STATE.BACK;
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
