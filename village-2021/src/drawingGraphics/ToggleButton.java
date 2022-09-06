package drawingGraphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ToggleButton extends AbstractButton implements ActionListener{
	private JLabel toggleLabel = new JLabel("Set the time!");
	private JToggleButton toggle;

	ToggleButton(){
		toggle = new JToggleButton("Nighttime");
		toggle.addActionListener(this);
		toggle.setOpaque(true);
		toggle.setBorderPainted(false);
		toggleNightMode();
		labelSetting();
		toggle.setSelected(true);
	}

	public void labelSetting() {
		toggleLabel.setHorizontalAlignment(CENTER);
		toggleLabel.setFont(new Font("Verdana",  Font.BOLD, 20));
		toggle.setFont(new Font("Verdana",  Font.BOLD, 20));
	}

	public void labelNightMode() {
		toggleLabel.setText("It's nighttime.");
	}

	public void toggleNightMode() {
		toggle.setText("Nighttime");
		System.out.println("nighttime");
		toggle.setSelected(true);
		toggle.setBackground(Color.getHSBColor(0.73f, 0.44f, 0.4f)); 
		toggle.setForeground(new Color(0xFFE667));
	}

	public void toggleDaytimeMode() {
		System.out.println("daytime");
		toggle.setText("Daytime");
		toggle.setSelected(false);
		toggle.setBackground(Color.getHSBColor(0.73f, 0.44f, 0.6f));
		toggle.setForeground(new Color(0xffffff));
		toggleLabel.setText("It's daytime.");
	}

	public void addButtonToAPanel(JFrame frame) {
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(1, 2));
		menu.add(toggleLabel);
		menu.add(toggle);
		menu.setBorder(BorderFactory.createRaisedBevelBorder());
		frame.add(menu, BorderLayout.NORTH);
	}
	
	public void addActionListener(ActionListener listener) {
		toggle.addActionListener(listener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (toggle.isSelected() == true) {
			toggleNightMode();
			labelNightMode();		
		}else {
			toggleDaytimeMode();			
		}
	}
	
	public JToggleButton getToggle() {
		return toggle;
	}

}