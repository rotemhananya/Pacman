package collections;

import javax.swing.ImageIcon;
/**
 * This class represents an array of the ImageIcons that are used in the game.
 */
public class Pictures {
	private ImageIcon [] pics = new ImageIcon[14]; // an array that holds all of the game's ImageIcons

	/**
	 * Pictures constructor.
	 * This constructor initializes the array with the ImageIcons.
	 */
	public Pictures () {
		pics[0] = new ImageIcon("PacmanLo.jpg"); // the logo in Menu
		pics[1] = new ImageIcon("1.jpg"); // the first board
		pics[2] = new ImageIcon("2.jpg"); // the second board 
		pics[3] = new ImageIcon("3.jpg"); // the third board 
		pics[4] = new ImageIcon("4.jpg"); // the forth board 
		pics[5] = new ImageIcon("eat.gif");
		pics[6] = new ImageIcon("pacman-1.gif"); // the gif in Menu
		pics[7] = new ImageIcon("fireworks.gif"); // the fireworks in GameOver
		pics[8] = new ImageIcon("PacmanCrying.PNG"); // the picture of pacman crying in GameOver
		pics[9] = new ImageIcon("GINKEY.png"); 
		pics[10] = new ImageIcon("INKY.png"); 
		pics[11] = new ImageIcon("BLINKY.png"); 
		pics[12] = new ImageIcon("Fireball.png"); 
		pics[13] = new ImageIcon("WaterSplash.png"); 

	}

	/**
	 * This function returns the ImageIcon that is in index i.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getPic(int i) {
		if (pics==null)
			new Pictures();
		return pics[i];
	}
}
