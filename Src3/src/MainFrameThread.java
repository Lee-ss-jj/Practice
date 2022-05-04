
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainFrameThread extends JFrame {

	public MainFrameThread() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setLayout(null);

		int COUNT = 3;

		var btnSubmit = new JButton("애니메이션");
		var jPanel = new JPanel(null);
		var buttonList = new JButton[COUNT + 1];

		String[] text = { "A", "B", "C", "D", "E" };

		btnSubmit.setBounds(0, 100, 100, 30);
		jPanel.setBounds(10, 200, 300, 100);

		jPanel.setBorder(new LineBorder(Color.BLACK));

		for (int i = 0; i < COUNT + 1; i++) {
			buttonList[i] = new JButton(text[i]);

			buttonList[i].setBounds(i * 100, 0, 100, 100);

			jPanel.add(buttonList[i]);
		}

		add(btnSubmit);
		add(jPanel);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				new Thread(() -> {
					try {
						int id = 0;
						while (MainFrameThread.this.isVisible()) {
							for (int j = 0; j < buttonList.length; j++) {
								buttonList[j].setText(text[(id + j) % text.length]);
							}

							for (int i = 0; i < 100; i++) {
								for (int j = 0; j < buttonList.length; j++) {
									buttonList[j].setBounds(j * 100 - i, 0, 100, 100);
								}
								Thread.sleep(10);
							}

							Thread.sleep(1000);
							++id;
						}
					} catch (InterruptedException exc) {
						// TODO Auto-generated catch block
						exc.printStackTrace();
					}
				}).start();
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrameThread().setVisible(true);
	}

}