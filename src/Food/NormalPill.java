package Food;

import javax.swing.ImageIcon;
import GameBoard.GamePanel;


public class NormalPill  extends Food {
	private ImageIcon Im;

	/**
	 * NormalPill's constructor.
	 * 
	 * @param x - the pill's position.
	 * @param y - the pill's position.
	 */
	public NormalPill(int x, int y, GamePanel gamePanel) {
		super(x, y, gamePanel);
		this.Im=gamePanel.getFrame().getPics().getFoodPic(0);
	}
	
	public ImageIcon getImage() {
		return this.Im;
	}

	public void Eated() {
		this.Eaten=true;
		this.Shown=false;
	}
	
	public ImageIcon getImage(int i) {
	return null;
	}
}

