
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	public MainFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLayout(null);
		
		var tfMin = new JTextField();
		var tfMax = new JTextField();
		var tfPhone= new JTextField();
		
		tfMin.setBounds(0, 0, 100, 30);
		tfMax.setBounds(0, 50, 100, 30);
		tfPhone.setBounds(0, 150, 300, 30);
		
		add(tfMin);
		add(tfMax);
		add(tfPhone);
		
		tfPhone.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("typed : " + tfPhone.getText());
				
				// Ư��Ű ó��
				switch (e.getKeyChar()) {
				case KeyEvent.VK_BACK_SPACE:
				case KeyEvent.VK_DELETE:
					return;
				}
				
				if (tfPhone.getText().length() == 13) {
					e.consume();
					return;
				}
				
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					// 
					switch (tfPhone.getText().length()) {
					case 3: // 010-
					case 8: // 010-1234
						tfPhone.setText(tfPhone.getText() + "-");
						break;
					}
				} else {
					e.consume();
					JOptionPane.showMessageDialog(MainFrame.this, "���� ����");
				}
			}
		});
		
		var btnSubmit = new JButton("����");
		
		btnSubmit.setBounds(0, 100, 100, 30);
		
		add(btnSubmit);
		
		btnSubmit.addActionListener((ev) -> {
			int min = Integer.MIN_VALUE;
			int max = Integer.MAX_VALUE;
			
			if (tfMin.getText().length() > 0) {
				min = Integer.parseInt(tfMin.getText());
			}
			
			if (tfMax.getText().length() > 0) {
				max = Integer.parseInt(tfMax.getText());
			}
			
			System.out.println(min + " �̻�, " + max + " ����");
			
			System.out.println("WHERE price BETWEEN " + min + " AND " + max );
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame().setVisible(true);
	}

}