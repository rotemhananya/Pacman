package Food;


import javax.swing.ImageIcon;

import GameBoard.GamePanel;

/**
 * This class represents an energy pill 
 *
 */
public class EnergyPill extends Food {

	/**
	 * EnergyPill's constructor.
	 * 
	 * @param x - the pill's position.
	 * @param y - the pill's position.
	 */
	public EnergyPill(int x, int y, GamePanel gamePanel, boolean shown) {
		super(x, y, gamePanel);
		this.Shown=shown;
	}

	public void Eated() {
		this.Eaten=true;
		this.Shown=false;
	}

	public ImageIcon getImage(int i) {
	return GamePanel.getFrame().getPics().getFoodPic(1);
	}
}
