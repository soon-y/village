package drawingGraphics;

import java.awt.Point;

public class House implements LocatedRectangle{
	
	private Point position;
	private Facade facade;
	private Roof roof;
	private int height;
	private int width;
	
	public House(Point position, int width, float brightness, float windowHue, float windowSat, float windowBrightness) { 
		this.position = position;
		this.height = width*3;
		this.width = width;
		roof = new Roof(width, height, brightness);
		facade = new Facade(width, height, roof.getRoofHue(), brightness, windowHue, windowSat, windowBrightness);
	}

	public void draw() {
		int x = address().x;
		int y = address().y;
		
		roof.draw(x, y+height-height*2/3);
		facade.draw(x,y);
	}
	
	@Override
	public Point address() {
		return position;
	}
	
	@Override
	public int width() {
		return facade.getWidth()+(height-width*2)/2;
	}
	
	@Override
	public int height() {
		return height + roof.getHeight();
	}
}