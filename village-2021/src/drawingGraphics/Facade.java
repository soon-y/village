package drawingGraphics;

import java.awt.Color;

public class Facade {

	private Window winleft;
	private Window winright; 
	private ArcWindow arcwin; 
	private Door door; 
	private Garage gar;
	private int width, height;
	private float facadeHue = (float)(Math.random());
	private float brightness;
	
	
	public Facade(int width, int height, float roofColor, float brightness, float windowHue, float windowSat, float windowBrightness) {
		this.width = width;
		this.height = height;
		this.brightness = brightness+.1f;
		winleft = new Window(width/10*4, height/5, getFacadeHue(), brightness+.1f, windowHue, windowSat, windowBrightness);
		winright = new Window(width/10*4, height/5, getFacadeHue(), brightness+.1f, windowHue, windowSat, windowBrightness);
		door = new Door(width/10*6, width);
		arcwin = new ArcWindow(width/10*12,width,0,180, getFacadeHue(), brightness+.1f, windowHue, windowSat, windowBrightness);
		gar = new Garage(width*2, width/10*14, roofColor, getFacadeHue(),brightness+.1f);
	}	

	public int getWidth(){
		return width*2 + gar.getWidth();
	}
	
	float getFacadeHue() {
		return facadeHue;
	};
	
	public void draw(int x1, int y1) {
		
		int[] x = { x1, x1+width, x1+width, x1-width, x1-width };	
		int[] y = { y1, y1+width, y1+height, y1+height, y1+width };
		int n = 5;		
		
		Color facadeColor = Color.getHSBColor(facadeHue, 0.12f, brightness);
		
		Drawing.pen().setColor(facadeColor);
		Drawing.pen().fillPolygon(x, y, n);
		
		door.draw(x1, y1+height);
		winleft.draw(x1-width+(width/3), y1+height-(width/2));
		winright.draw(x1+width-(width/3), y1+height-(width/2));
		arcwin.draw(x1,y1+width);
		gar.draw(x1+width,y1+height);
	}
}