package drawingGraphics;

import java.awt.Color;

public class Door {

	private Handle handle;
	private int width, height;

	public Door(int width, int height) {
		
		this.width = width;
		this.height = height;	
		
		handle = new Handle(width,  width/5, height/7);
	}

	public void draw(int left, int bottom){

		int x = left-(width/2);
		int y = bottom-height;
		float Hue = (float)(Math.random());
		Color doorColor = Color.getHSBColor(Hue, 0.80f, 0.4f);
		
		Drawing.pen().setColor(doorColor);
		Drawing.pen().fillRect(x, y, width, height);
		
		handle.draw(x,y);
	}	
}