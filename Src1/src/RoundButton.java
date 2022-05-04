import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

public class RoundButton extends JLabel {
	
	public boolean isSelected = false;
	
	public RoundButton(String text) {
		super(text, 0);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isSelected = !isSelected;
				repaint();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		g.setColor(Color.YELLOW);
		g.fillOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		
		this.setForeground(isSelected ? Color.RED : Color.black);
		
		super.paintComponent(g);
	}
}
