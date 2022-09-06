package drawingGraphics;

import java.awt.Point;

public class StreetLight implements LocatedRectangle{
	
	private LampHead lampHead;
	private LampBody lampBody;
	private int lampSize;
	private Point position;
	
	public StreetLight(Point position, int lampsize, float transparency) {
		lampHead = new LampHead(lampsize, lampsize, transparency);
		lampBody = new LampBody(lampsize/3,lampsize*3);	
		this.lampSize = lampsize;
		this.position = position;
		
	}
	
	public int getLampSize() {
		return lampSize;
	}
	
	public LampHead getLampHead() {
		return lampHead;
	}
	
	public void draw() {
		int x = address().x;
		int y = address().y;
		lampBody.draw(x,y);
		drawHead(x, y);
	}
	
	public void drawHead(int x, int y) {
		lampHead.draw(x,y);
	}

	@Override
	public Point address() {
		return position;
	}

	@Override
	public int width() {
		return lampHead.getLampHeadWidth();
	}

	@Override
	public int height() {
		return lampSize*3 + lampHead.getLampHeadHiehgt();	
	}	
}