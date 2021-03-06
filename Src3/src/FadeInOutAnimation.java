
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FadeInOutAnimation extends JFrame {

	Image img;
	int a;

	class FadeInOutPanel extends JPanel {

		private float opacity = 0f;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2d = (Graphics2D) g;

			if (opacity > 0) {
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
				g2d.drawImage(img, 0, 0, 300, 300, 0, 0, img.getWidth(null), img.getHeight(null), null);
			}
		}

	}

	public FadeInOutAnimation() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		
		var panel = new FadeInOutPanel();
		panel.setBounds(0, 0, 300, 300);
		add(panel);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				new Thread(() -> {
					try {
						a = 0;
						
						if(a == 0) {
							img = ImageIO.read(new File("image/??????1.jpg"));
						} else if(a == 1) {
							img = ImageIO.read(new File("image/??????2.jpg"));
						}
						
						a = 1;
						while (FadeInOutAnimation.this.isVisible()) {
							long time = System.currentTimeMillis();

							// ???????? 0 ~ 1
							while ((System.currentTimeMillis() - time) <= 3000) {
								panel.opacity = (float) (System.currentTimeMillis() - time) / 3000f;
								panel.repaint();
								Thread.sleep(10);
							}

							time = System.currentTimeMillis();
							Thread.sleep(100);

							// ???ο????? 1 ~ 0
							while ((System.currentTimeMillis() - time) <= 3000) {
								panel.opacity = 1f - ((float) (System.currentTimeMillis() - time) / 3000f);
								panel.repaint();
								Thread.sleep(10);
							}
							panel.opacity = 0;
							panel.repaint();
							Thread.sleep(100);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}).start();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FadeInOutAnimation().setVisible(true);
	}
}
