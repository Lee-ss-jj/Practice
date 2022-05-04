import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainFrame extends FrameBase {

	public MainFrame() {
		super("메인", 500, 500);

		var btn = new JButton("asdasd");

		btn.addActionListener((ev) -> {
			var panel = new JPanel(new GridLayout(3, 4, 5, 5));
			var buttons = new RoundButton[12];
			
			panel.setPreferredSize(new Dimension(55 * 4, 55 * 3));
			
			int month = 0;
			
			for (int i = 0; i < 12; i++) {
				panel.add(buttons[i] = new RoundButton(++month + "월"));
				buttons[i].setName(month + "");
			}
			
			JOptionPane.showMessageDialog(this, panel, "월 선택", JOptionPane.PLAIN_MESSAGE);
			
			for (var button : buttons) {
				if (button.isSelected) {
					System.out.println(button.getName());
				}
			}
			
		});

		addComp(btn, 50, 50, 100, 50);

	}

	public static void main(String[] args) throws Exception {
		
		UIManager.put("OptionPane.okButtonText", "확인");
		// UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		// UIManager.put("Label.font", new Font("궁서체", 0, 20));
		// TODO Auto-generated method stub
		new MainFrame().setVisible(true);
	}

}