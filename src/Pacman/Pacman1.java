package Pacman;

import javax.swing.ImageIcon;

import VisitInterface.Visitor;

public class Pacman1 extends Pacman {
	private ImageIcon imLevel1Left = new ImageIcon("yellowLeft.gif");
	private ImageIcon imLevel1Right = new ImageIcon("yellowRight.gif");
	private ImageIcon imLevel1Up = new ImageIcon("yellowUp.gif");
	private ImageIcon imLevel1Down = new ImageIcon("yellowDown.gif"); 
	
	public Pacman1() {
		super();
		this.Level=1;
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
				return this.imLevel1Up;
			else if (Way==DOWN)	
				return this.imLevel1Down;
			else if (Way==RIGHT)
				return this.imLevel1Right;
			else
				return this.imLevel1Left;
	}





}
