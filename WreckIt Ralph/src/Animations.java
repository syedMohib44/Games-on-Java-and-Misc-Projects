public class Animations {
	
	private int jumpingCount = 0, deathCount = 0, rightcount = 0, leftcount = 0, fallingCount = 0;
	movements m;
	
	public Animations(movements m) {
		this.m = m;
	}
	
	public void animations() {
		
		if(m.getPlayerDeath() == true) {
			deathCount++;
		}
		if(deathCount >= 2)
		{
			deathCount = 2;
		}

		if(m.jumping == true)
		{
			jumpingCount++;
		}
		
		if(jumpingCount >= 2)
		{
			jumpingCount = 0;
		}
	
		if(m.right == true)
		{			
			rightcount++;
		}		
		if(rightcount >= 2)
		{
			rightcount = 0;				
		}
		
		if(m.left == true)
		{			
			leftcount++;
		}		
		if(leftcount >= 2)
		{
			leftcount = 0;				
		}
		
		if(m.falling == true)
		{
			fallingCount++;
		}
		if(fallingCount >= 2) {
			fallingCount = 0;
		}
	}
	
	public int getLeftCount() {
		return leftcount;
	}
	
	public int getRightCount() {
		return rightcount;
	}
	
	public int getJumpingCount() {
		return jumpingCount;
	}
	
	public int getDeathCount() {
		return deathCount;
	}
	
	public int getFallingCount() {
		return fallingCount;
	}
}
