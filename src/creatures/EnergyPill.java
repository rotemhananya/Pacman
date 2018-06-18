package creatures;

import javax.swing.ImageIcon;

/**
 * This class represents an energy pill 
 *
 */
public class EnergyPill {
	private int x;
	private int y;
	private ImageIcon im = new ImageIcon("location");
	private boolean eaten=false;

	/**
	 * EnergyPill's constructor.
	 * 
	 * @param x - the pill's position.
	 * @param y - the pill's position.
	 */
	public EnergyPill(int x, int y) {
		this.x=x;
		this.y=y;
	}

	/**
	 * Getters & setters
	 */
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
