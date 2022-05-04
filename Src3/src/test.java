
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class test extends JFrame {

	JPanel p1;
	JLabel l[] = new JLabel[5];
	JTextField t;
	JPasswordField p;
	JRadioButton r[] = new JRadioButton[3];
	JCheckBox jc[] = new JCheckBox[3];
	JButton b[] = new JButton[2];
	JComboBox jcb;
	ButtonGroup bg = new ButtonGroup();

	test() {
		setTitle("로그인");
		setSize(280, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);

		add(p1 = new JPanel(new FlowLayout()));
		p1.add(l[0] = new JLabel("아이디"));
		p1.add(t = new JTextField(15));
		p1.add(l[1] = new JLabel("비밀번호"));
		p1.add(p = new JPasswordField(15));
		p1.add(l[2] = new JLabel("학년 선택"));
		p1.add(r[0] = new JRadioButton("1학년"));
		p1.add(r[1] = new JRadioButton("2학년", true));
		p1.add(r[2] = new JRadioButton("3학년"));
		p1.add(l[3] = new JLabel("학과 선택"));
		p1.add(jc[0] = new JCheckBox("설계"));
		p1.add(jc[1] = new JCheckBox("제어"));
		p1.add(jc[2] = new JCheckBox("시스템", true));
		p1.add(jcb = new JComboBox());
		String ln[] = "자바".split(" ");
		for (int i = 0; i < ln.length; i++) jcb.addItem(ln[i]);
		jcb.setSelectedIndex(0);
		p1.add(b[0] = new JButton("확인"));
		p1.add(b[1] = new JButton("취소"));
		p1.add(l[4] = new JLabel());
		bg.add(r[0]);
		bg.add(r[1]);
		bg.add(r[2]);

		b[0].addActionListener(e -> {
			if (t.getText().equals("")) l[4].setText("아이디를 입력하세요.");
			else if (p.getText().equals("")) l[4].setText("비밀번호를 입력하세요.");
			else l[4].setText("아이디는 : " + t.getText() + " 비밀번호는 : " + p.getText() + "입니다.");
		});

		b[1].addActionListener(e -> {
			t.setText("");
			p.setText("");
			r[1].setSelected(true);
			jc[0].setSelected(false);
			jc[1].setSelected(false);
			jc[2].setSelected(true);
			jcb.setSelectedIndex(0);
			l[4].setText("취소되었습니다.");
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		new test();
	}
}