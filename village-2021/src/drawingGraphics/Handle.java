package drawingGraphics;

import java.awt.Color;

public class Handle{
	
	private int width, height, doorHeight;
	
	public Handle(int doorheight, int width, int height) {
		
		this.width = width;
		this.height = height;
		this.doorHeight = doorheight;
	}
	
	public void draw(int left, int bottom){
		int x = left+doorHeight/10;
		int y = bottom+(doorHeight/2)+width;
		Drawing.pen().setColor(Color.decode("#E5E7F7"));
		Drawing.pen().fillOval(x, y, width, height);
	}
}