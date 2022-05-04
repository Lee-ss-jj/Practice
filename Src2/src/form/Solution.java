package form;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DB.DB;
import aframe.aframe;

public class Solution extends aframe {

	static class ComboItem {
		int id;
		String text;

		ComboItem(int id, String text) {
			this.id = id;
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}

	}

	JComboBox cb = new JComboBox<>();
	JTextField tfTheme = new JTextField(15);
	HashMap<Integer, Object[]> themeMap = new HashMap<>();

	public Solution() {
		fs("ddd");

		np.add(cb);
		np.setLayout(new FlowLayout());

		var btn = new JButton("검색");

		btn.addActionListener(e -> this.up());

		np.add(tfTheme);
		np.add(btn);

		dtm = new DefaultTableModel("id,지역".split(","), 0);
		jta = new JTable(dtm);

		jta.removeColumn(jta.getColumn("id"));
		jta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		wp.add(new JScrollPane(jta));

		try {
			try (var rs = DB.rs("SELECT * FROM genre")) {
				cb.addItem(new ComboItem(0, "전체"));

				while (rs.next()) {
					cb.addItem(new ComboItem(rs.getInt(1), rs.getString(2)));
				}
			}

			try (var rs = DB.rs("SELECT * FROM area")) {

				dtm.addRow(new Object[] { 0, "전국" });

				while (rs.next()) {
					dtm.addRow(new Object[] { rs.getInt(1), rs.getString(2) });
				}
			}

			try (var rs = DB.rs("SELECT * FROM theme")) {

				while (rs.next()) {
					themeMap.put(rs.getInt(1), new Object[] { rs.getString(2), rs.getInt(3) });
				}
			}

			jta.setRowSelectionInterval(0, 0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jta.addMouseListener(new MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				up();
			};
		});

		this.up();
	}

	void up() {
		var item = (ComboItem) cb.getSelectedItem();
		int areaId = (Integer) dtm.getValueAt(jta.getSelectedRow(), 0);

		try {
			var rs = DB.rs("SELECT * FROM cafe");

			while (rs.next()) {

				if (item.id != 0) {
					if (!Arrays.stream(rs.getString("t_no").split(",")).map(s -> Integer.parseInt(s)).anyMatch(tNo -> {
						return themeMap.containsKey(tNo) && item.id == (Integer) themeMap.get(tNo)[1];
					}))
						continue;
				}

				if (areaId != 0 && areaId != rs.getInt("a_no")) {
					continue;
				}

				if (tfTheme.getText().length() > 0) {
					if (!Arrays.stream(rs.getString("t_no").split(",")).map(s -> Integer.parseInt(s)).anyMatch(tNo -> {
						return themeMap.containsKey(tNo) && ((String) themeMap.get(tNo)[0]).contains(tfTheme.getText());
					}))
						continue;
				}

				System.out.println(rs.getString("c_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new Solution().sh();
	}

}
