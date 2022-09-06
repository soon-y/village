package drawingGraphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Background {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = screenSize.height;
	
	public void draw(float brigtness) {
		Color Sky = Color.getHSBColor(0.73f, 0.44f, brigtness-.1f);  
		Color ground = Color.getHSBColor(0.71f, 0.56f, brigtness-.3f);
		Color moonLight1 = new Color(1f, 1f, 1f,.08f);
		Color moonLight2 = new Color(01f, 1f, 1f,.12f);
		Color moonNsun = Color.getHSBColor(0.136f, 0.83f, 0.9f); 

		Drawing.pen().setColor(Sky);
		Drawing.pen().fillRect(0, 0, 100000, 100000);
	
		Drawing.pen().setColor(moonLight1);
		Drawing.pen().fillArc(1165, 105, 170, 170, 0, 360);
		
		Drawing.pen().setColor(moonLight2); 
		Drawing.pen().fillArc(1185, 125, 130, 130, 0, 360);
	
		Drawing.pen().setColor(ground);
		Drawing.pen().fillRect(0, screenHeight/2, 1000000, 1000000);
		Drawing.pen().setColor(moonNsun);
		Drawing.pen().fillArc(1200, 140, 100, 100, 0, 360);

	}

}
