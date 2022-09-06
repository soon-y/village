package drawingGraphics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

public class Buttons implements ActionListener{
	private JButton housesButton = new JButton("Houses");
	private JButton lampsButton = new JButton("Streetlights");
	private JButton lightButton = new JButton("Funtional Streetlights");
	private JButton brokenLightButton = new JButton("Broken Streetlights");
	private JButton cloudButton = new JButton("Cloud");
	private JButton sceneButton = new JButton("Village");
	private JSlider brightness = new JSlider(0,100);
	private JLabel sliderlb = new JLabel("Set the light brightness");
	private String[] choices = { "Objects","Houses","Streetlights", "Cloud","Funtional Streetlights","Broken Streetlights"};
	private JComboBox<String> dropDown = new JComboBox<String>(choices);
	private JPanel menu = new JPanel();
	private JLabel checkboxlb = new JLabel("Tick objects in this frame.");
	private JCheckBox house = new JCheckBox("Houses");
	private JCheckBox cloud = new JCheckBox("Cloud");
	private JCheckBox moon = new JCheckBox("Moon");
	private JCheckBox sun = new JCheckBox("Sun");
	private JCheckBox lamp = new JCheckBox("Streetlights");
	private JCheckBox light = new JCheckBox("Functional Streetlights");
	private JCheckBox broken = new JCheckBox("Broken Streetlights");
	private JCheckBox ground = new JCheckBox("Ground");

	Buttons(){
		housesButton.addActionListener(this);
		lampsButton.addActionListener(this);
		lightButton.addActionListener(this);
		brokenLightButton.addActionListener(this);
		cloudButton.addActionListener(this);
		sceneButton.addActionListener(this);
		fontSetting();
	}

	public void addCheckBox(JPanel panel) {		
		panel.add(checkboxlb);
		panel.add(house);
		panel.add(cloud);
		panel.add(moon);
		panel.add(sun);
		panel.add(lamp);
		panel.add(light);
		panel.add(broken);
		panel.add(ground);	
	}

	public void fontSetting() {
		housesButton.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		lampsButton.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		lightButton.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		brokenLightButton.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		cloudButton.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		sceneButton.setFont(new Font("Helvetica",  Font.PLAIN, 14));
		sliderlb.setFont(new Font("Din", Font.PLAIN, 14));
		dropDown.setFont(new Font("Helvetica",  Font.PLAIN, 14));

	}

	public void addSlider(JPanel panel){
		brightness.setPaintTrack(true);
		brightness.setPaintTicks(true);
		brightness.setPaintLabels(true);
		brightness.setMajorTickSpacing(50);
		brightness.setMinorTickSpacing(10);
		panel.add(sliderlb);
		panel.add(brightness);
	}

	public void addButtonsToAPanel(JFrame frame) {
		brightness.setVisible(false);
		sliderlb.setVisible(false);
		menu.setLayout(new GridLayout(22, 1));
		menu.add(new JLabel(" Hit any buttons! "));
		menu.add(sceneButton);
		menu.add(housesButton);
		menu.add(cloudButton);
		menu.add(lampsButton);
		menu.add(brokenLightButton);
		menu.add(lightButton);
		addSlider(menu);
		menu.add(new JLabel(" The number of"));
		menu.add(dropDown);
		menu.add(new JTextField("is "));
		addCheckBox(menu); 	

		menu.setBorder(BorderFactory.createRaisedBevelBorder());
		frame.add(menu, BorderLayout.WEST);
	}

	public void addActionListener(ActionListener listener) {
		housesButton.addActionListener(listener);
		lampsButton.addActionListener(listener);
		lightButton.addActionListener(listener);
		brokenLightButton.addActionListener(listener);
		cloudButton.addActionListener(listener);
		sceneButton.addActionListener(listener);
	}

	public void addChangeListener(ChangeListener clistener) {
		brightness.addChangeListener(clistener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sceneButton || 
			e.getSource() == lampsButton|| e.getSource() == lightButton ) {
			brightness.setVisible(true);
			sliderlb.setVisible(true);
		}
		if(e.getSource() == housesButton ||
				e.getSource() == brokenLightButton || e.getSource() == cloudButton){
			brightness.setVisible(false);
			sliderlb.setVisible(false);

		}
	}

	public JButton getHousesButton() {
		return housesButton;
	}

	public JButton getLampsButton() {
		return lampsButton;
	}

	public JButton getLightButton() {
		return lightButton;
	}

	public JButton getBrokenLightButton() {
		return brokenLightButton;
	}

	public JButton getCloudButton() {
		return cloudButton;
	}
	public JButton getSceneButton() {
		return sceneButton;
	}

	public JLabel getSliderLb() {
		return sliderlb;
	}
	public JSlider getSlider() {
		return brightness;
	}
}

