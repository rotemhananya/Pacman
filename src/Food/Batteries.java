package Food;

import javax.swing.ImageIcon;

import GameBoard.GamePanel;


public class Batteries  extends Food {

	/**
	 * Batteries's constructor.
	 * 
	 * @param x - the Batteries's position.
	 * @param y - the Batteries's position.
	 */
	public Batteries(int x, int y, GamePanel gamePanel) {
		super(x, y, gamePanel);
	}


	/**
	 * Constructor without location 
	 */
	public Batteries(GamePanel gamePanel) {
		super(gamePanel);
	}
	
	public void Eated() {
		this.Eaten=true;
		this.Shown=false;
	}
	
	public ImageIcon getImage(int i) {
	if (i==0)
		return GamePanel.getFrame().getPics().getFoodPic(5);
	else
		return GamePanel.getFrame().getPics().getFoodPicsFade(3);
	}
}
