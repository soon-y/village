package drawingGraphics;

import java.awt.Color;

public class LampBody {

	private int width, height;
	
	public LampBody(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void draw(int left, int top) {

		int x = left-width/2;
		int y = top;
		
		Color lampBody = Color.getHSBColor(0.72f, 0.2f, 0.3f);
		Color lampBodyDeco = Color.getHSBColor(0.72f, 0.22f, 0.35f);

		Drawing.pen().setColor(lampBody);
		Drawing.pen().fillRect(x, y, width, height);
		
		Drawing.pen().setColor(lampBodyDeco);
		Drawing.pen().fillRect(x-width/4, y+height/3, width+width/2, height/20);
		
		Drawing.pen().setColor(lampBodyDeco);
		Drawing.pen().fillRect(x-width/4, y+height/3+height/10, width+width/2, height/20);
		
		Drawing.pen().setColor(lampBodyDeco);
		Drawing.pen().fillRect(x-width/4, y+height/3*2, width+width/2, height/20);
		
		Drawing.pen().setColor(lampBodyDeco);
		Drawing.pen().fillRect(x-width/4, y+height/3*2+height/10, width+width/2, height/20);
		
		Drawing.pen().setColor(lampBodyDeco);
		Drawing.pen().fillRect(x-width/2, y+height, width+width, height/6); //bottom
	}
}