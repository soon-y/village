package drawingGraphics;

import java.awt.Color;

public class Chimney {

	private int width, height;

	public Chimney(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void draw(int left, int bottom, float roofColor, float brightness) {

		int x = left;
		int y = bottom-height;

		Color chimColor = Color.getHSBColor(roofColor, 0.82f, brightness - .1f);
		Color chimColor2 = Color.getHSBColor(roofColor, 0.5f, brightness);
		
		Drawing.pen().setColor(chimColor);
		Drawing.pen().fillRect(x, y, width, height);
		
		Drawing.pen().setColor(chimColor2);
		Drawing.pen().fillRect(x-width/8, y, width+ width/4, height/6);
	}
}