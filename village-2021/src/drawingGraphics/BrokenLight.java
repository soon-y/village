package drawingGraphics;

import java.awt.Point;

public class BrokenLight extends StreetLight {
	
	public BrokenLight(Point position, int lampSize, float transparency) {
		super(position, lampSize, transparency);
	}

	@Override
	public void drawHead(int x, int y) {
		getLampHead().draw(x,y, getLampSize()/2);
	}
}