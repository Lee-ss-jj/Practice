
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableCheckbox extends JFrame {

	public TableCheckbox() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);

		var btn = new JButton("Ãâ·Â");
		var dfm = new DefaultTableModel() {

			@Override
			public Class<?> getColumnClass(int columnIndex) {

				switch (columnIndex) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};

		dfm.setColumnIdentifiers("¼±ÅÃ,ÀÌ¸§,¹øÈ£".split(","));
		dfm.addRow(new Object[] { false, "À±ÀçÀ±", "1" });
		dfm.addRow(new Object[] { false, "ÀÌ½ÂÁÖ", "2" });
		dfm.addRow(new Object[] { false, "¹ÚÇöºó", "3" });

		var table = new JTable(dfm);
		var scrollPane = new JScrollPane(table);

		scrollPane.setBounds(0, 0, 400, 400);
		btn.setBounds(399, 405, 80, 50);

		add(scrollPane);
		add(btn);
		btn.addActionListener(e -> {
			for (int i = 0; i < table.getRowCount(); i++) {
				if(dfm.getValueAt(i, 0).equals(true)) {
					System.out.println(dfm.getValueAt(i, 1));
				}
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TableCheckbox().setVisible(true);
	}

}