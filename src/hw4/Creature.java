 package hw4;

import javax.swing.ImageIcon;

public abstract class Creature implements Visitor {
	
	public abstract ImageIcon getImage ();
	public abstract double getSpeed ();
	public abstract int getX();
	public abstract int getY();
}
