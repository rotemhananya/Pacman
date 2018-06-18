 package creatures;

import javax.swing.ImageIcon;

/**
 * This class is an abstract class.
 *
 */
public abstract class Creature{
	
	public abstract ImageIcon getImage ();
	public abstract double getSpeed ();
	public abstract void setSpeed (double speed);
	public abstract int getX();
	public abstract int getY();
}
