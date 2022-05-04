import javax.swing.JComponent;
import javax.swing.JFrame;

public class FrameBase extends JFrame {

	public FrameBase(String title, int width, int height) {
		setSize(width, height);
		setTitle(title);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		setLayout(null);
	}

	public void addComp(JComponent comp, int x, int y, int w, int h) {
		comp.setBounds(x, y, w, h);
		add(comp);
	}

}
