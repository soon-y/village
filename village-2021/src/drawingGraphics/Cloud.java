package drawingGraphics;

import java.awt.Point;

public class Cloud implements LocatedRectangle{
	private SemiCloud semiCloudLeft; //composite
	private SemiCloud semiCloudMid; //composite
	private SemiCloud semiCloudRight; //composite
	private int diameter;
	private Point position;
	private float brightness;
	int shape = RandomNumber.between(0, 2);

	public Cloud(Point position, int diameter, float brightness) {
		semiCloudLeft = new SemiCloud(diameter*3/5,0,180);
		semiCloudMid = new SemiCloud(diameter,0,180);
		semiCloudRight = new SemiCloud(diameter*3/5,0,180);
		this.diameter=diameter;
		this.position=position;
		this.brightness = brightness;
	}

	public void draw(){
		int x = address().x+diameter/2;
		int y = address().y;
		if(shape == 0) {
			semiCloudLeft.draw(x-diameter/2,y, brightness);
			semiCloudRight.draw(x+(diameter/2),y, brightness);
		}else if(shape == 1) {
			semiCloudRight.draw(x+(diameter/2),y, brightness);
		}else if(shape == 2) {
			semiCloudLeft.draw(x-diameter/2,y, brightness);
		}
		semiCloudMid.draw(x,y, brightness);
	}
	
	@Override
	public Point address() {
		return position;
	}

	@Override
	public int width() {
		return diameter+diameter/5*6;
	}

	@Override
	public int height() {
		return diameter/2;
	}
	
}