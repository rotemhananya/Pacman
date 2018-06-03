package hw4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame {


	private BufferedImage image1 ;
	int radius = 0 ; // tha pacman radius

	public Game () {

		/*	getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(105, 56, 46, 14);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("");

		ImageIcon image = new ImageIcon("wallpaper2you_32136.png");
		Image resizedImage = image.getImage().getScaledInstance(800, 800, 0); 
		image1 = new 
		image1 = resizedImage ;
		image.setImage(resizedImage);
		label_1.setIcon( image);
		label_1.setBounds(50, 50, 800, 800);
		getContentPane().add(label_1);


		Board board = new Board();
		for (int i=1 ; i<776 ; i=i+25) {
			for (int j=1 ; j<776 ; j=j+20) {
				board.add(i,j,image1.getRGB(i,j));
			}
		}
		 */
	}




	private boolean checkPosition(int x, int y) {

		return false;
	}

	private boolean checkPosition(int x, int y, int way) {

		return false;
	}



}
