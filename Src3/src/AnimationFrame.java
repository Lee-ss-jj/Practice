
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnimationFrame extends JFrame {

	int percent = 0;
	
	class ClockPanel extends JLabel {

		ClockPanel() {
			super("", 0);
		}

		@Override
		public void paintComponent(Graphics g) {
			double endAngle = 450d * ((double) percent / 100);

			g.setColor(Color.BLUE);
			g.fillArc(100, 100, this.getWidth() - 200, this.getHeight() - 200, 90, (int) endAngle);
			g.setColor(Color.white);
			g.fillArc(150, 150, this.getWidth() - 300, this.getHeight() - 300, 90, (int) endAngle);

			super.paintComponent(g);
		}

	}

	public AnimationFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		getContentPane().setBackground(Color.white);

		var loading = new ClockPanel();

		add(loading);

		new Thread(() -> {
			try {
				for (percent = 0; percent <= 100; percent++) {
					loading.setText(percent + "%");
					Thread.sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AnimationFrame().setVisible(true);
	}

}