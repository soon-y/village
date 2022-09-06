package drawingGraphics;

import java.awt.Color;

public class ArcWindow {

	private int width, height, startangle, arcangle;
	private float barHue;
	private float barBrightness;
	private int randomNum = RandomNumber.between(0, 50);
	private float lightHue;
	private float lightSat;
	private float lightBrightness;
	private int onOff = RandomNumber.between(0, 1);


	public ArcWindow(int height, int width, int startangle, int arcangle, float facadeHue, float brightness, float windowHue, float windowSat, float windowBrightness) {
		this.width = width;
		this.height = height+randomNum;
		this.startangle = startangle;
		this.arcangle = arcangle;
		this.barHue = facadeHue;
		this.barBrightness = brightness;
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
	
	public void draw(int left, int bottom){
		
		int x = left-width/2;
		int y = bottom-height/4;
		
		Color lightOnOff = Color.getHSBColor(setLightHue(), lightSat, setLightBrightness());
		Color windowBarColor = Color.getHSBColor(barHue, 0.12f, barBrightness);
		
		Drawing.pen().setColor(lightOnOff); 
		Drawing.pen().fillArc(x, y, width, height, startangle, arcangle);
		
		Drawing.pen().setColor(windowBarColor);
		Drawing.pen().fillRect(x+width/2-width/20, y, width/10, height/2+randomNum/5);
	}
	
}
