
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ImageSaveFrame extends JFrame {

	public ImageSaveFrame() {
		setSize(700, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);

		var jbutton = new JButton("이미지 등록");
		var jbutton2 = new JButton("이미지 저장");
		var lbImg = new JLabel();

		lbImg.setBounds(0, 0, 600, 500);
		lbImg.setBorder(new LineBorder(Color.BLACK));
		jbutton.setBounds(0, 530, 100, 30);
		jbutton2.setBounds(120, 530, 100, 30);

		add(jbutton);
		add(jbutton2);
		add(lbImg);

		var img = new ImageIcon("image/흰둥이.jpg");
		var resizedImg = new ImageIcon(img.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH));

		jbutton.addActionListener((e) -> {

			lbImg.setIcon(resizedImg);
		});

		jbutton2.addActionListener((e) -> {

			try {
				// label의 이미지를 저장할 수 있게 변환
				var bufferedImage = new BufferedImage(600, 500, BufferedImage.TYPE_INT_RGB);

				// 0,0, -> 500, 500 크기로 그려주기
				bufferedImage.getGraphics().drawImage(resizedImg.getImage(), 0, 0, 600, 500, this);

				ImageIO.write(bufferedImage, "jpg", new File("./new_img.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageSaveFrame().setVisible(true);
	}

}