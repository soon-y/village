/**
 * Provides a panel which can be used for drawing.
 * 
 * @author Soonyoung Park
 * 
 */

package drawingGraphics;

import java.awt.Graphics;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class DrawingArea extends JPanel implements SetBrightness, SetHueSaturation, SetTransparency{
	private float brightness = 0.4f;
	private float lightHue = 0.13f;
	private float lightSat = 0.85f;
	private float lightBrightness= RandomNumber.between(0, 1);
	private float transparency = 1;

	private Scene scene = null;
	
	public Scene getScene(){ 
		return scene; 
	}
	
	@Override
	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		Drawing.set(pen);
		if (scene != null) {
		scene.draw(getColorBrightness(), getLightHue(), getLightSaturation(), getTransparency(), getLightBrightness());
		}else {
			scene = new Scene();
		}
	}
	
	@Override
	public float getColorBrightness() {
		return brightness;
	}

	@Override
	public void setColorBrightness(float brightness) {
		this.brightness = brightness;
		
	}

	@Override
	public float getLightHue() {
		return lightHue;
	}

	@Override
	public void setLightHue(float hue) {
		this.lightHue = hue;
		
	}

	@Override
	public float getLightSaturation() {
		return lightSat;
	}

	@Override
	public void setLightSaturation(float saturation) {
		this.lightSat = saturation;
		
	}

	@Override
	public float getTransparency() {
		return transparency;
	}

	@Override
	public void setTransparency(float transparency) {
		this.transparency = transparency;
	}

	@Override
	public float getLightBrightness() {
		return lightBrightness;
	}

	@Override
	public void setLightBrightness(float brightness) {
		this.lightBrightness = brightness;
		
	}	
		
}