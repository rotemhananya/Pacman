package Food;

import javax.swing.ImageIcon;

import GameBoard.GamePanel;

public class Cherry  extends Food {

	/**
	 * Cherry's constructor.
	 * 
	 * @param x - the Cherry's position.
	 * @param y - the Cherry's position.
	 */
	public Cherry(int x, int y, GamePanel gamePanel) {
		super(x, y, gamePanel);
	}


	/**
	 * Constructor without location 
	 */
	public Cherry(GamePanel gamePanel) {
		super(gamePanel);

	}

	public void Eated() {
		this.Eaten=true;
		this.Shown=false;
	}

	public ImageIcon getImage(int i) {
		if (i==0)
			return GamePanel.getFrame().getPics().getFoodPic(6);
		else
			return GamePanel.getFrame().getPics().getFoodPicsFade(4);
	}

}
