package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import aframe.aframe;

public class Solution1 extends aframe {

	LocalDateTime selected;
	LocalDateTime startTime;
	LocalDateTime lastTime;
	LocalDateTime recentTime;

	JLabel lbDate = new JLabel();
	JPanel timePanel = new JPanel();

	public Solution1() {
		fs("ddd");

		startTime = LocalDateTime.now();

		var curMin = startTime.getMinute();
		var min = (int) Math.round(curMin / 30f) * 30;

		startTime = startTime.plusMinutes(min - curMin);
		selected = startTime;
		recentTime = startTime;

		cp.setLayout(new FlowLayout(FlowLayout.LEFT));

		cp.add(lbDate);
		cp.add(timePanel);

		var scrollPane = new JPanel(new BorderLayout());

		scrollPane.setBorder(new LineBorder(Color.BLACK));

		var lbUp = new JLabel("¡ã", 0);
		var lbDown = new JLabel("¡å", 0);

		scrollPane.add(lbUp, "North");
		scrollPane.add(lbDown, "South");

		timePanel.setPreferredSize(new Dimension(60, 500));
		scrollPane.setPreferredSize(new Dimension(30, 400));

		lbUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				startTime = startTime.minusMinutes(30 * 15);
				up();
			}
		});

		lbDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				startTime = lastTime.plusMinutes(30);
				up();
			}
		});

		cp.add(scrollPane);

		this.up();
	}

	void up() {
		lbDate.setText(String.format("%d-%02d-%02d", startTime.getYear(), startTime.getMonthValue(),
				startTime.getDayOfMonth()));

		timePanel.removeAll();

		timePanel.add(new JLabel("½Ã°£"));

		var tmpTime = startTime;

		for (int i = 0; i < 15; i++) {
			var tmp = tmpTime;

			if (tmpTime.getDayOfMonth() > startTime.getDayOfMonth())
				break;

			var lb = new JLabel(String.format("%02d:%02d", tmpTime.getHour(), tmpTime.getMinute()));

			lb.setOpaque(true);
			lb.setBorder(new EmptyBorder(2, 8, 2, 8));

			lb.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					selected = tmp;
					up();
				}
			});

			if (tmpTime.compareTo(recentTime) == 0)
				lb.setBackground(Color.YELLOW);

			timePanel.add(lb);
			lastTime = tmpTime;
			tmpTime = tmpTime.plusMinutes(30);
		}

		timePanel.revalidate();
		timePanel.repaint();
	}

	public static void main(String[] args) throws Exception {
		new Solution1().sh();
	}

}
