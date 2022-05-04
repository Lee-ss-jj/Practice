
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Member extends JFrame {

	JPanel mp, cp, sp, p;
	JLabel l;
	JButton b, jb[] = new JButton[2];
	JTextField jt[] = new JTextField[6];

	public Member() {
		setTitle("ȸ������");
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);

		add(mp = new JPanel(new BorderLayout()));
		mp.add(cp = new JPanel(new GridLayout(0, 1)), BorderLayout.CENTER);
		mp.add(sp = new JPanel(new GridLayout(0, 1)), BorderLayout.SOUTH);

		String ln[] = "�̸� :, ���̵� :, ��й�ȣ :, ��й�ȣüũ :, ��ȭ��ȣ :, ������� :".split(", ");
		for (int i = 0; i < ln.length; i++) {
			cp.add(p = new JPanel(new FlowLayout(FlowLayout.LEFT)));
			p.add(l = new JLabel(ln[i], JLabel.LEFT));
			l.setPreferredSize(new Dimension(100, 25));
			p.add(jt[i] = new JTextField(14));
			if (i == 1) {
				p.add(b = new JButton("�ߺ�Ȯ��"));
			}
		}

		sp.add(p = new JPanel(new FlowLayout(FlowLayout.RIGHT)));
		sp.add(p = new JPanel(new FlowLayout(FlowLayout.RIGHT)));
		String bn[] = "ȸ������, ���".split(", ");
		for (int j = 0; j < bn.length; j++) {
			p.add(jb[j] = new JButton(bn[j]));
		}
		sp.add(p = new JPanel(new FlowLayout(FlowLayout.RIGHT)));

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Member();
	}
}