
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
		setTitle("�α���");
		setSize(280, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);

		add(p1 = new JPanel(new FlowLayout()));
		p1.add(l[0] = new JLabel("���̵�"));
		p1.add(t = new JTextField(15));
		p1.add(l[1] = new JLabel("��й�ȣ"));
		p1.add(p = new JPasswordField(15));
		p1.add(l[2] = new JLabel("�г� ����"));
		p1.add(r[0] = new JRadioButton("1�г�"));
		p1.add(r[1] = new JRadioButton("2�г�", true));
		p1.add(r[2] = new JRadioButton("3�г�"));
		p1.add(l[3] = new JLabel("�а� ����"));
		p1.add(jc[0] = new JCheckBox("����"));
		p1.add(jc[1] = new JCheckBox("����"));
		p1.add(jc[2] = new JCheckBox("�ý���", true));
		p1.add(jcb = new JComboBox());
		String ln[] = "�ڹ�".split(" ");
		for (int i = 0; i < ln.length; i++) jcb.addItem(ln[i]);
		jcb.setSelectedIndex(0);
		p1.add(b[0] = new JButton("Ȯ��"));
		p1.add(b[1] = new JButton("���"));
		p1.add(l[4] = new JLabel());
		bg.add(r[0]);
		bg.add(r[1]);
		bg.add(r[2]);

		b[0].addActionListener(e -> {
			if (t.getText().equals("")) l[4].setText("���̵� �Է��ϼ���.");
			else if (p.getText().equals("")) l[4].setText("��й�ȣ�� �Է��ϼ���.");
			else l[4].setText("���̵�� : " + t.getText() + " ��й�ȣ�� : " + p.getText() + "�Դϴ�.");
		});

		b[1].addActionListener(e -> {
			t.setText("");
			p.setText("");
			r[1].setSelected(true);
			jc[0].setSelected(false);
			jc[1].setSelected(false);
			jc[2].setSelected(true);
			jcb.setSelectedIndex(0);
			l[4].setText("��ҵǾ����ϴ�.");
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		new test();
	}
}