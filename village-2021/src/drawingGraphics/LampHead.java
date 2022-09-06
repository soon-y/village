package drawingGraphics;

import java.awt.Color;

public class LampHead{

	private int width, height;
	private float transparency = 1f;

	public LampHead(int width, int height, float transparency) {
		this.width = width;
		this.height = height;
		this.transparency = transparency;
	}

	public void draw(int left, int bottom) {

		int x = left;
		int y = bottom-height;

		int[] x1 = {x-width/2, x+width/2, x+width/3, x-width/3 };	
		int[] y1 = {y, y, y+height, y+height};
		int n = 4;

		Color light = new Color(1, 0.85f, 0.17f, transparency);
		Drawing.pen().setColor(light);
		Drawing.pen().fillPolygon(x1, y1, n);

		drawContour(x, y);
	}

	public void draw(int left, int bottom, int lightball) {

		int x = left;
		int y = bottom-height;
		int diameter = lightball;
		Color lightBall = new Color(1, 0.85f, 0.17f,.4f);
		Color lightGlass = new Color(0.82f,0.74f,0.96f,.3f );

		int[] x1 = {x-width/2, x+width/2, x+width/3, x-width/3 };	
		int[] y1 = {y, y, y+height, y+height};
		int n = 4;

		Drawing.pen().setColor(lightGlass);
		Drawing.pen().fillPolygon(x1, y1, n);		

		Drawing.pen().setColor(lightBall);
		Drawing.pen().fillArc(x-width/4, bottom-height/2 , diameter, diameter, 0, 360);

		drawContour(x, y);
	}

	private void drawContour(int x, int y) {

		Color lampHead = Color.getHSBColor(0.72f, 0.22f, 0.24f);
		Color lampOval = Color.getHSBColor(0.72f, 0.2f, 0.3f);

		Drawing.pen().setColor(lampOval); 
		Drawing.pen().fillArc(x-width/2, y-height*2/5, width, height, 0, 180);

		Drawing.pen().setColor(lampHead); //middle line
		Drawing.pen().fillRect(x, y, width/10, height);

		Drawing.pen().setColor(lampHead); // top bar
		Drawing.pen().fillRect(x-width/2-width/8, y, width+width/4, height/4);

		Drawing.pen().setColor(lampHead); // bottom bar
		Drawing.pen().fillRect(x-width/2, y+height, width, height/4);
	}

	public int getLampHeadHiehgt() {
		return height*2;
	}

	public int getLampHeadWidth() {
		return width+width/4;
	}
}

