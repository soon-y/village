package drawingGraphics;

import java.awt.Color;

public class Roof{
	
	private Chimney chim; 
	private int width, height;
	private float roofHue = (float)(Math.random());
	private float brightness;
	
	public Roof(int width, int height, float brightness){

		this.width = width;
		this.height = height;
		chim = new Chimney(width/3, height/2);
		this.brightness = brightness;
	}
	
	public int getHeight() {
		return height/2;
	}
	
	public float getRoofHue() {
		return roofHue;
	}
	
	public void draw(int x1, int y1){
		int [] x = { x1,  x1-height/2, x1, x1+height/2 };
		int [] y = { y1, y1, y1-height/2, y1};
		int n =4;
		
		chim.draw(x1+width/2, y1, roofHue, brightness);
		
		Color roofColor = Color.getHSBColor(roofHue, 0.6f, brightness);
		Drawing.pen().setColor(roofColor);
		Drawing.pen().fillPolygon(x, y, n);
	}
}	