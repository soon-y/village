package drawingGraphics;

import java.awt.Color;

public class Garage {

	private GarageRoof garoof;
	private GarageDoor gadoor;
	private int width, height;
	private float facadeHue;
	private float brightness;

	public Garage(int width, int height, float roofColor, float facadeColor, float facadeBrightness) {

		garoof = new GarageRoof(width+width/10, height/4, roofColor);
		gadoor = new GarageDoor(width*8/10, height *8/10, facadeBrightness);

		this.width = width;
		this.height = height;
		this.facadeHue = facadeColor;
		this.brightness = facadeBrightness;
	}

	public int getWidth(){
		return garoof.getWidth();
	}
	
	public void draw(int left, int bottom) {

		int x = left;
		int y = bottom-height;

		Color garColor = Color.getHSBColor(facadeHue, 0.12f, brightness-0.1f);
		Drawing.pen().setColor(garColor);
		Drawing.pen().fillRect(x, y, width, height);

		garoof.draw(x,y,brightness);
		gadoor.draw(x,bottom);
	}
}