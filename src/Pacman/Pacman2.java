package Pacman;

import javax.swing.ImageIcon;

import VisitInterface.Visitor;

public class Pacman2 extends Pacman{
	private ImageIcon imLevel2Left = new ImageIcon("blueLeft.gif");
	private ImageIcon imLevel2Right = new ImageIcon("blueRight.gif");
	private ImageIcon imLevel2Up = new ImageIcon("blueUp.gif");
	private ImageIcon imLevel2Down = new ImageIcon("blueDown.gif");

	/**
	 * Pacman2's constructor.
	 * 
	 * @param lives - the amount of lives pacman had when he finished the previous level.
	 * @param points - the amount of points pacman had when he finished the previous level.
	 * @param fruits - the amount of fruits pacman had when he finished the previous level.
	 * @param secTime - the amount of seconds that had passed since the beginning of the game.
	 */
	public Pacman2(int lives, int points, int fruits, int secTime) {
		super();
		this.Lives=lives;
		this.Points=points;
		this.Fruits=fruits;
		this.SecTime=secTime;
		this.Level=2;
	}
	
	
	@Override
	public void accept(Visitor visitor) {
			visitor.visit(this);
	}
	
	/**
	 * This function checks pacman's way in order to return 
	 * the image of pacman that is looking to the direction of its way.
	 * 
	 * @return - the image of pacman.
	 */
	public ImageIcon getImage() {
	if (Way==UP)
		return this.imLevel2Up;
	else if (Way==DOWN)	
		return this.imLevel2Down;
	else if (Way==RIGHT)
		return this.imLevel2Right;
	else
		return this.imLevel2Left;
}


}
