import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Calendar extends FrameBase {
	private int month;
	private LocalDate now;
	private Set<Integer> attendedSet = new HashSet<>();
	private int count = 0;

	class CalendarDay extends JLabel {
		private boolean isAttended = false;
		private LocalDate date;

		public CalendarDay(LocalDate date) {
			super("", 0);

			this.date = date;

		}

		@Override
		protected void paintComponent(Graphics g) {

			// �̹� ���̸�
			if (date.getMonthValue() == month) {
				// Label Text�� Border ����
				setText("" + date.getDayOfMonth());
				setBorder(new LineBorder(Color.BLACK));

				// Set�� �⼮ üũ�� �Ȱ��� Ȯ��,
				if (attendedSet.contains(date.getDayOfMonth())) {

					// �����̸� ������ ����
					if (date.compareTo(now) == 0) {
						g.setColor(Color.RED);
					} else {
						g.setColor(Color.BLACK);
					}

					// �߰��� ���׶�� �׸���
					g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
				}

			} else {
				setText("");
			}

			super.paintComponent(g);
		}

	}

	public Calendar() {
		super("�޷�", 400, 500);

		// �⼮ üũ�� �ڷᱸ��
		attendedSet.add(1);
		attendedSet.add(2);
		attendedSet.add(3);
		attendedSet.add(4);
		attendedSet.add(5);
		attendedSet.add(6);
		attendedSet.add(7);
		attendedSet.add(8);

		setLayout(new BorderLayout());

		now = LocalDate.now();
		var title = new JLabel(now.getYear() + "�� " + now.getMonthValue() + "��");

		this.month = now.getMonthValue();

		title.setFont(new Font("HY�߰��", 1, 20));
		title.setBorder(new EmptyBorder(10, 10, 10, 10));

		var sp = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
		var btn = new JButton("���� �ޱ�");

		var calendarGrid = new JPanel(new GridLayout(7, 7));
		Color[] color = { Color.RED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLUE };
		var weekdays = "�� �� ȭ �� �� �� ��".split(" ");

		for (int i = 0; i < weekdays.length; i++) {
			var lb = new JLabel(weekdays[i], 0);

			lb.setForeground(color[i]);
			calendarGrid.add(lb);
		}

		var firstDay = LocalDate.of(now.getYear(), now.getMonthValue(), 1);
		var calendarFirst = firstDay.minusDays(firstDay.getDayOfWeek().getValue() % 7);

		for (int i = 0; i < 6 * 7; i++) {
			calendarGrid.add(new CalendarDay(calendarFirst));

			calendarFirst = calendarFirst.plusDays(1);
		}

		sp.add(btn);

		add(title, "North");
		add(sp, "South");
		add(calendarGrid);

	}

	public static void main(String[] args) {
		new Calendar().setVisible(true);
	}

}
