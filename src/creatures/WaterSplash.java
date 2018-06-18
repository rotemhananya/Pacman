package creatures;

import javax.swing.ImageIcon;

import visitInterface.Visitor;

/**
 * This class represents Inky's weapon.
 *
 */
public class WaterSplash extends Creature implements Visitor{
	private ImageIcon im = new ImageIcon("WaterSplash.png");
	private int x;
	private int y;
	private Inky inky;
	private double speed;

	/**
	 * WaterSplash's constructor.
	 * 
	 * @param x1 - FireBalls' position.
	 * @param y1 - FireBalls' position.
	 * @param inky - the gust that WaterSplash belongs to. 
	 */
	public WaterSplash(Inky inky, int x1, int y1) {
		this.inky=inky;
		this.x=x1;
		this.y=y1;
	}

	/**
	 *  WaterSplash visits pacman
	 * 	@Override
	 */
	public void visit(Pacman pacman) {
		if (pacman.getLevel()==2) {
			pacman.setFreezeCounter(pacman.getSecTime()); // pacman can't move for 5 seconds
			pacman.setPoints(pacman.getPoints()-10);
		}
		else if(pacman.getLevel()==3) {
			this.inky.setStartMoving(false); //inky freezes for 5 seconds
		}
	}

	/**
	 * Getters & setters
	 */
	@Override
	public ImageIcon getImage() {
		return this.im;
	}

	@Override
	public double getSpeed() {
		return this.speed;
	}
	@Override
	public void setSpeed(double speed) {
		this.speed=speed;		
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
}
