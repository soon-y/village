/**
 * Provides a panel which can be used for drawing.
 * 
 * @author Soonyoung Park
 * 
 */

package drawingGraphics;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DrawingTool extends JFrame implements ActionListener, ChangeListener {
	private DrawingArea drawing = new DrawingArea();
	private Buttons buttons = new Buttons();
	private ToggleButton toggle = new ToggleButton();

	public DrawingTool(String title) {
		super(title);

		setLayout(new BorderLayout());

		constructButtonMenu();
		constructDrawingArea();

		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void constructButtonMenu() {		
		buttons.addButtonsToAPanel(this);
		buttons.addActionListener(this);
		buttons.addChangeListener(this);
		toggle.addButtonToAPanel(this);
		toggle.addActionListener(this);
	}

	private void constructDrawingArea() {
		add(drawing, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	

		if(e.getSource() == buttons.getSceneButton()) { 
			tidyUpDrawingArea();
			System.out.println("scene");
			drawing.getScene().setVillage();
		}
		else if (e.getSource() == buttons.getHousesButton()) { 
			tidyUpDrawingArea();
			System.out.println("houses");
			drawing.getScene().setHouses();

		} 
		else if (e.getSource() == buttons.getCloudButton()) { 
			System.out.println("cloud");
			tidyUpDrawingArea();
			drawing.getScene().setCloud();
		} 
		else if (e.getSource() == buttons.getLampsButton()) { 
			tidyUpDrawingArea();
			System.out.println("lamps");
			drawing.getScene().setStreetLight();
		}
		else if (e.getSource() == buttons.getLightButton()) { 
			tidyUpDrawingArea();
			System.out.println("light");
			drawing.getScene().setLamps();
		}
		else if (e.getSource() == buttons.getBrokenLightButton()) { 
			tidyUpDrawingArea();
			System.out.println("brokenlight");
			drawing.getScene().setBrokenLamps();
		}

		else if (toggle.getToggle().isSelected() == false) { 
			daytimeState();
			buttons.getSlider().setVisible(false);
		}else if(toggle.getToggle().isSelected() == true) {
			nightState();
			buttons.getSlider().setVisible(false);
		}
	}

	public void nightState() {
		drawing.getScene().clear();
		drawing.setColorBrightness(0.4f);
		drawing.setLightHue(.13f);
		drawing.setLightSaturation(.85f);
		drawing.setLightBrightness(0);
		drawing.setTransparency(1f);
		buttons.getSlider().setValue(80);
		tidyUpDrawingArea();
	}

	public void daytimeState() {
		drawing.getScene().clear();
		drawing.setColorBrightness(0.7f);
		drawing.setLightHue(0);
		drawing.setLightSaturation(.2f);
		drawing.setLightBrightness(.7f);
		drawing.setTransparency(.5f);	
		buttons.getSlider().setValue(40);
		tidyUpDrawingArea();
	}

	public void stateChanged(ChangeEvent e)
	{
		float brightness = drawing.getTransparency();
		brightness = (float)buttons.getSlider().getValue()/100;
		System.out.println(brightness);
		drawing.setTransparency(brightness);
		tidyUpDrawingArea();	
	}

	private void tidyUpDrawingArea() {
		drawing.removeAll();
		drawing.revalidate();
		drawing.repaint();
	}

	public static void main(String[] args) {
		new DrawingTool("Village Graphics");
	}
}
