package Food;

import javax.swing.ImageIcon;

import GameBoard.GamePanel;


public class Apple  extends Food {

	/**
	 * Apple's constructor.
	 * 
	 * @param x - the Apple's position.
	 * @param y - the Apple's position.
	 */
	public Apple(int x, int y, GamePanel gamePanel) {
		super(x, y, gamePanel);
	}


	/**
	 * Constructor without location 
	 */
	public Apple(GamePanel gamePanel) {
		super(gamePanel);

	}

	public void Eated() {
		this.Eaten=true;
		this.Shown=false;

	}

	public ImageIcon getImage(int i) {
		if (i==0)
			return GamePanel.getFrame().getPics().getFoodPic(3);
		else
			return GamePanel.getFrame().getPics().getFoodPicsFade(1);
	}
}

