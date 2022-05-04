package aframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class aframe extends JFrame {

	public JPanel p,pp,ppp,jp1,jp2,np,sp,cp,wp,ep;
	public JLabel l,ll,jl;
	public JScrollPane jsp;
	public JTable jta;
	public DefaultTableModel dtm;
	public DefaultTableCellRenderer cell = new DefaultTableCellRenderer();
	public SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
	public DecimalFormat zz = new DecimalFormat("00"), won = new DecimalFormat("#,##0");
	public String bl = "";
	public Date now = new Date();
	public static Stack<JFrame> stack = new Stack<JFrame>();
	public ResultSet rs;
	
	public void fs(String t) {
		setTitle(t);
		add(np = new JPanel(new BorderLayout()), BorderLayout.NORTH);
		add(sp = new JPanel(new BorderLayout()), BorderLayout.SOUTH);
		add(cp = new JPanel(new BorderLayout()), BorderLayout.CENTER);
		add(wp = new JPanel(new BorderLayout()), BorderLayout.WEST);
		add(ep = new JPanel(new BorderLayout()), BorderLayout.EAST);
	}
	
	public void sh() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void imsg(String m) {
		JOptionPane.showMessageDialog(null, m, "정보", 1);
	}
	
	public void wmsg(String m) {
		JOptionPane.showMessageDialog(null, m, "경고", 0);
	}
	
	public void size(JComponent c, int x, int y) {
		c.setPreferredSize(new Dimension(x, y));
	}
	
	public <T extends JComponent> T setcomp(T c, int x, int y) {
		c.setPreferredSize(new Dimension(x, y));
		return c;
	}
	
	public <T extends JComponent> T setcomp(T c, int x, int y, int w, int h) {
		c.setBounds(x, y, w, h);
		return c;
	}
	
	public int rei(String t) {
		try {
			return Integer.parseInt(t.replace(",", ""));
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public aframe() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				if(stack.isEmpty() == false) {
					stack.pop().setVisible(true);
				}
			}
		});
	}

}
