package Food;

import javax.swing.ImageIcon;

import GameBoard.GamePanel;

public class Strawberry  extends Food {

	/**
	 * Strawberry's constructor.
	 * 
	 * @param x - the Strawberry's position.
	 * @param y - the Strawberry's position.
	 */
	public Strawberry(int x, int y, GamePanel gamePanel) {
		super(x, y, gamePanel);
	}


	/**
	 * Constructor without location 
	 */
	public Strawberry(GamePanel gamePanel) {
		super(gamePanel);

	}

	public void Eated() {
		this.Eaten=true;
		this.Shown=false;
	}


	public ImageIcon getImage(int i) {
		if (i==0)
			return GamePanel.getFrame().getPics().getFoodPic(4);
		else
			return GamePanel.getFrame().getPics().getFoodPicsFade(2);
	}
}