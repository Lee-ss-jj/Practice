import javax.swing.JComponent;
import javax.swing.JPanel;

public class PanelBase extends JPanel {

	public PanelBase() {
		setLayout(null);
	}
	
	public void addComp(JComponent comp, int x, int y, int w, int h) {
		comp.setBounds(x, y, w, h);
		add(comp);
	}


}
