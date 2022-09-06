package drawingGraphics;

import java.awt.Color;

public class GarageRoof {
	
	private int width, height; 
	private float roofHue;

	public GarageRoof(int width, int height, float roofColor) {
		this.width = width;
		this.height = height;
		this.roofHue = roofColor;
	}
	
	public int getWidth(){
		return width;
	}
		
	public void draw(int left, int bottom, float brightness){
		
		int x = left;
		int y = bottom-height;
		
		Color roofColor = Color.getHSBColor(roofHue, 0.82f, brightness-0.2f);
		
		Drawing.pen().setColor(roofColor); 
		Drawing.pen().fillRect(x, y, width, height);
	}	
}