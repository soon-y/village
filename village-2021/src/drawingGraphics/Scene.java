package drawingGraphics;

import java.awt.Point;
import java.util.ArrayList;

import drawingGraphics.graphicState.State;
import drawingGraphics.graphicState.SceneState;

public class Scene{

	private ArrayList <LocatedRectangle> objects = new ArrayList<LocatedRectangle>();

	private static State graphicState;
	
	private float brightness;
	private float windowHue ;
	private float windowSat;
	private float transparency;
	private float windowBrightness;
	private Background bg = new Background();

	public Scene() {
		graphicState = SceneState.getInstance(this);
	}
	
	public void setVillage() {
		graphicState = graphicState.drawVillage();
	}

	public void setCloud() {
		graphicState = graphicState.drawCloud();
	}
	
	public void setHouses() {
		graphicState = graphicState.drawHouses();
	}
	
	public void setStreetLight() {
		graphicState = graphicState.drawStreetLight();
	}
	
	public void setLamps() {
		graphicState = graphicState.drawLamps();
	}
	
	public void setBrokenLamps() {
		graphicState = graphicState.drawBrokenLamps();
	}
	
	public void draw(float brightness, float windowHue, float windowSat, float transparency, float windowBrightness) {

		this.brightness = brightness;
		this.windowHue = windowHue;
		this.windowSat = windowSat;
		this.transparency = transparency;
		this.windowBrightness= windowBrightness;
		bg.draw(brightness);
		
		for(LocatedRectangle ob: objects) {
			ob.draw();
		}
	
	}

	private void addAnObject(LocatedRectangle newObjects) {
		boolean intersects = false;
		for (LocatedRectangle aObject : objects) {
			intersects = intersects || aObject.intersects(newObjects);
		}
		if ( !intersects ) {
			objects.add(newObjects);
		}
	}

	public void addSomeCloud() { 

		int diameter = RandomNumber.between(90, 140);
		int num = RandomNumber.between(1, 50);

		Point address = new Point(0, 100); 

		Cloud nextCloud = new Cloud(address, diameter, brightness);
		addAnObject(nextCloud);

		nextCloud = new Cloud(new Point(1140,250), 100, brightness);
		addAnObject(nextCloud);

		nextCloud = new Cloud(new Point(130+num,300-num), diameter, brightness);
		addAnObject(nextCloud);

		nextCloud = new Cloud(new Point(240+num,150+num), diameter ,brightness);
		addAnObject(nextCloud);

		nextCloud = new Cloud(new Point(340+num,150+num), diameter ,brightness);
		addAnObject(nextCloud);

		nextCloud = new Cloud(new Point(500+num,280-num), diameter ,brightness);
		addAnObject(nextCloud);

		nextCloud = new Cloud(new Point(600+num,120+num), diameter ,brightness);
		addAnObject(nextCloud);

		nextCloud = new Cloud(new Point(820+num,220-num), diameter ,brightness);
		addAnObject(nextCloud);

		nextCloud = new Cloud(new Point(1020+num,50+num), diameter ,brightness);
		addAnObject(nextCloud);

		nextCloud = new Cloud(new Point(1300+num,100+num), diameter ,brightness);
		addAnObject(nextCloud);

		nextCloud = new Cloud(new Point(1520+num,320-num), diameter ,brightness);
		addAnObject(nextCloud);

	}

	public void addSomeLight() { 

		int size = RandomNumber.between(30, 34);
		int num = RandomNumber.between(0, 50);

		StreetLight nextLamp = new StreetLight(new Point(70-num,780), size, transparency);
		addAnObject(nextLamp);

		nextLamp = new StreetLight(new Point(400+num,580+num), size, transparency);
		addAnObject(nextLamp);

		nextLamp = new StreetLight(new Point(300-num,680+num), size, transparency);
		addAnObject(nextLamp);

		nextLamp = new StreetLight(new Point(770+num,530+num), size,transparency);
		addAnObject(nextLamp);

		nextLamp = new StreetLight(new Point(1180-num,580+num), size, transparency);
		addAnObject(nextLamp);

		nextLamp = new StreetLight(new Point(1100+num,800+num), size, transparency);
		addAnObject(nextLamp);

	}

	public void addBrokenLamp() {
		int size = RandomNumber.between(30, 34);
		int num = RandomNumber.between(0, 50);

		BrokenLight nextBrokenLamp = new BrokenLight(new Point(350+num,540+num), size, transparency);
		addAnObject(nextBrokenLamp);

		nextBrokenLamp = new BrokenLight(new Point(550+num,700+num), size, transparency);
		addAnObject(nextBrokenLamp);

		nextBrokenLamp = new BrokenLight(new Point(1100+num,560+num), size, transparency);
		addAnObject(nextBrokenLamp);

		nextBrokenLamp = new BrokenLight(new Point(1000+num,780-num), size, transparency);
		addAnObject(nextBrokenLamp);

		nextBrokenLamp = new BrokenLight(new Point(1450-num,740-num), size, transparency);
		addAnObject(nextBrokenLamp);
	}

	public void addSomeHouses() { 
		Point address = new Point(530, 500);
		int houseSize = RandomNumber.between(45, 55);
		int num = RandomNumber.between(0, 20);	

		House nextHouse = new House(address, houseSize, brightness, windowHue, windowSat, windowBrightness);
		addAnObject(nextHouse);

		nextHouse = new House(new Point(10+num,550-num), houseSize, brightness, windowHue, windowSat, windowBrightness);
		addAnObject(nextHouse);

		nextHouse = new House(new Point(360+num,726+num), houseSize,brightness, windowHue, windowSat, windowBrightness);
		addAnObject(nextHouse);

		nextHouse = new House(new Point(680+num,760+num), houseSize ,brightness, windowHue, windowSat, windowBrightness);
		addAnObject(nextHouse);

		nextHouse = new House(new Point(940+num,600+num), houseSize ,brightness, windowHue, windowSat, windowBrightness);
		addAnObject(nextHouse);

		nextHouse = new House(new Point(1230+num,720+num), houseSize ,brightness, windowHue, windowSat, windowBrightness);
		addAnObject(nextHouse);

		nextHouse = new House(new Point(1300+num, 500-num), houseSize ,brightness, windowHue, windowSat, windowBrightness);
		addAnObject(nextHouse);
	}

	public void clear() {
		objects.clear();
		
	}

}
