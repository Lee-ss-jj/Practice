
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Modification extends JFrame {
	
	public static void main(String[] args) {
		new Modification();
	}

	JPanel mp, np, cp, sp, p1, p2, sp1, sp2, bp;
	JButton jb;
	JLabel l;
	JComponent[] jcn1 = { new JTextField(20), new JComboBox(), new JTextField(20), new JTextField(15), new JComboBox() };
	JComponent[] jcn2 = { new JComboBox(), new JComboBox(), new JTextField(15) };
	JCheckBox jck;

	public Modification() {
		setTitle("수정");
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);

		add(mp = new JPanel(new BorderLayout()));
		mp.add(np = new JPanel(new GridLayout(0, 1, 10, 10)), BorderLayout.NORTH);
		mp.add(cp = new JPanel(new FlowLayout()), BorderLayout.CENTER);
		mp.add(sp = new JPanel(new GridLayout(0, 1, 10, 10)), BorderLayout.SOUTH);

		String s[] = "상호명 : , 종류 : , 주소 : , 전화번호 : , 방수 : ".split(", ");
		for (int i = 0; i < jcn1.length; i++) {
			np.add(p1 = new JPanel(new FlowLayout(FlowLayout.LEFT)));
			p1.add(l = new JLabel(s[i], JLabel.RIGHT));
			l.setPreferredSize(new Dimension(100, 25));
			p1.add(jcn1[i]);
			jcn1[i].setPreferredSize(new Dimension(80, 25));
		}

		String s1[] = "바베큐 수영장 카페 산책로 탁구장".split(" ");
		cp.add(l = new JLabel("부대시설 : ", JLabel.RIGHT));
		for (int i = 0; i < s1.length; i++) {
			cp.add(jck = new JCheckBox(s1[i]));
		}

		String s2[] = "지역 : , 성급 : , 1박당 가격 : ".split(", ");
		for (int i = 0; i < s2.length; i++) {
			sp.add(p2 = new JPanel(new FlowLayout(FlowLayout.LEFT)));
			p2.add(l = new JLabel(s2[i], JLabel.RIGHT));
			l.setPreferredSize(new Dimension(100, 25));
			p2.add(jcn2[i]);
			if (i == 0) jcn2[i].setPreferredSize(new Dimension(100, 25));
			else jcn2[i].setPreferredSize(new Dimension(60, 25));
		}

		sp.add(bp = new JPanel(new FlowLayout()), BorderLayout.SOUTH);
		bp.add(jb = new JButton("수정"));

		pack();
		setVisible(true);
	}
}