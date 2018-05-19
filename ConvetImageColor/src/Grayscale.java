import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Grayscale{
	// You can also convert PNG to JPG file, I have read JPG file and writ PNG file  
	public static void main(String[] args) {	
	File orignalImgae = new File("D:\\Image.jpg");
	BufferedImage img = null;
	try
	{
		img = ImageIO.read(orignalImgae);
		System.out.println("Reading Compeleted!");
		BufferedImage grayscale = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		for(int i = 0; i < img.getWidth(); i++)
		{
			for (int j = 0; j < img.getHeight(); j++)
			{
				Color c = new Color(img.getRGB(i, j));
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();
				int a = c.getAlpha();
				
				int gr = (r+g+b)/3;
				
				//Changed Places to cange color effects
				//Color gcolor = new Color(g,r,b,a);
				
				//Divided all three RGB components by 3 to get grayscale 
				//Color gcolor = new Color(gr,gr,gr,a);

				//Orignal Image
				Color gcolor = new Color(r,g,b,a);
				grayscale.setRGB(i, j, gcolor.getRGB());
			}
		}
		ImageIO.write(grayscale, "png", new File("D:\\rds.png"));
		System.out.println("Writting Compeleted!");
	}
	catch(Exception e)
	{
		e.printStackTrace();	
	}
  }
}
