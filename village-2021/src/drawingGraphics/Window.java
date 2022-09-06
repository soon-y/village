package drawingGraphics;

import java.awt.Color;

public class Window{

	private int width, height;
	private float barHue;
	private int randomNum = RandomNumber.between(0, 16);
	private float barBrightness;
	private float lightHue; 
	private float lightSat; 
	private float lightBrightness; 
	private int onOff = RandomNumber.between(0, 1);

	public Window(int width, int height, float facadeHue, float facadeBrightness, float windowHue, float windowSat, float windowBrightness) {
		this.width = width;
		this.height = height;
		this.barHue = facadeHue;
		this.barBrightness = facadeBrightness;
		lightHue = windowHue;
		lightSat = windowSat;
		lightBrightness = windowBrightness;
	}

	public float setLightHue() {
		if (lightHue!=0) {
			return lightHue;
		} 
		return barHue;
	}

	public float setLightBrightness() {
		if (lightBrightness ==0) {
			return onOff;
		} 
		return lightBrightness;
	}

	public void draw(int left, int top){

		int x = left-width/2;
		int y = top;

		Color windowLight = Color.getHSBColor(setLightHue(), lightSat, setLightBrightness());
		Color windowBarColor = Color.getHSBColor(barHue, 0.12f, barBrightness);

		Drawing.pen().setColor(windowLight); 
		Drawing.pen().fillRect(x, y-height, width, height+randomNum);	

		Drawing.pen().setColor(windowBarColor); 
		Drawing.pen().fillRect(x, y-height/2-height/10, width, height/6);				
	}
}