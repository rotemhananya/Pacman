package hw4;

import javax.swing.ImageIcon;
/**
 * This class represents an array of the ImageIcons that are used in the game.
 */
public class Pictures {
	private ImageIcon [] pics = new ImageIcon[6]; // an array that hold all of the game's ImageIcons

	/**
	 * Pictures constructor.
	 * This constructor initializes the array with the ImageIcons.
	 */
	public Pictures () {
		pics[0] = new ImageIcon("C:\\Users\\user\\Desktop\\University\\מונחה עצמים\\מונחה עצמים - תרגיל 4\\Pacman\\PacmanLo.jpg");
		pics[1] = new ImageIcon("C:\\Users\\user\\Desktop\\University\\מונחה עצמים\\מונחה עצמים - תרגיל 4\\Pacman\\1.jpg ");
		pics[2] = new ImageIcon("C:\\Users\\user\\Desktop\\University\\מונחה עצמים\\מונחה עצמים - תרגיל 4\\Pacman\\2.jpg ");
		pics[3] = new ImageIcon("C:\\Users\\user\\Desktop\\University\\מונחה עצמים\\מונחה עצמים - תרגיל 4\\Pacman\\3.jpg ");
		pics[4] = new ImageIcon("C:\\Users\\user\\Desktop\\University\\מונחה עצמים\\מונחה עצמים - תרגיל 4\\Pacman\\4.jpg ");
		pics[5] = new ImageIcon("C:\\Users\\user\\Desktop\\University\\מונחה עצמים\\מונחה עצמים - תרגיל 4\\Pacman\\pacman-1.gif ");
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
