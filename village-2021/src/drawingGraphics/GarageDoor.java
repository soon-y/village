package drawingGraphics;

import java.awt.Color;

public class GarageDoor {
	
	private int width, height;
	private float garBrightness;

	public GarageDoor(int width, int height, float garBrightness) {
		this.width = width;
		this.height = height;
		this.garBrightness = garBrightness;
	}
	
	public void draw(int left, int bottom){
		
		int x = left+width/10;
		int y = bottom-height;
		float Hue = (float)(Math.random());
		Color doorColor = Color.getHSBColor(Hue, 0.55f, garBrightness- 0.15f);
		Color barColor = Color.getHSBColor(Hue, 0.55f, garBrightness-0.3f);
		
		Drawing.pen().setColor(doorColor);
		Drawing.pen().fillRect(x, y, width, height);
		
		Drawing.pen().setColor(barColor);
		Drawing.pen().fillRect(x, y+(height/4*1), width, height/12);
		Drawing.pen().fillRect(x, y+(height/4*2), width, height/12);
		Drawing.pen().fillRect(x, y+(height/4*3), width, height/12);
	}
}