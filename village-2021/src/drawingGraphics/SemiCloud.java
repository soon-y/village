package drawingGraphics;

import java.awt.Color;

public class SemiCloud{
private int diameter, startangle, arcangle;

	
	public SemiCloud(int diameter , int startangle, int arcangle) {
		this.diameter = diameter;
		this.startangle = startangle;
		this.arcangle = arcangle;
	}

	public void draw(int center, int bottom, float brightness){
		
		int x = center-diameter/2;
		int y = bottom-diameter/2;
		
		Color cloud = Color.getHSBColor(0.72f, 0.45f, brightness-.2f); //0.16f
		
		Drawing.pen().setColor(cloud); 
		Drawing.pen().fillArc(x, y, diameter, diameter, startangle, arcangle);	
	}
}