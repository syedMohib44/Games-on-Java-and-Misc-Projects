import java.awt.*;
import java.util.Random;


public class Drop {

    private Random rng = new Random();
    private Random tips = new Random();
    private int velocity, length, x, y;
    private char[][] text;

    public Drop(int x) {
        this.x = x;
        length = getRandomInteger(5, 30);
        text = createContent(length);
        velocity = getRandomInteger(1, 5);
        this.y = (-1) * length * Config.FONT_SIZE;
    }

    protected char[][] createContent(int length) {
        char[][] result = new char[length][1];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = getRandomCharacter();
        }
        return result;
    }

    public void draw(Graphics2D g2) {
        int fontSize = g2.getFont().getSize();
        for (int i = 0; i < length; i++) {
            if (getRandomInteger(0, length) == i)
            {
                text[i][0] = getRandomCharacter();
            }
            if (i == length - 1 && getRandomTips(0, 2) == 2)
            {            	
                g2.setColor(new Color(180,255, 180));            	
            }
            else
            {
                g2.setColor(new Color(0, 255, 70));
            }
            g2.drawChars(text[i], 0, 1, x, y + (i * fontSize));
        }
        y += velocity;
    }

    public char getRandomCharacter() {
        return (char) (rng.nextInt(26) + 'a');
    }
    
    public int getRandomTips(int min, int max) {
    	int random = tips.nextInt((max - min) +1) + min;
    	return random;
    }

    public int getRandomInteger(int min, int max) {
        int randomNum = rng.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public boolean isOffScreen() {
        return (y > Config.SCREEN_WIDTH);
    }
}
