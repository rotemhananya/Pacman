package creatures;

import javax.swing.ImageIcon;

import timer.MyTimer;
import timer.TimerListener;
import visitInterface.Visitor;

/**
 * This class represents Blinky's weapon.
 *
 */
public class FireBalls extends Creature implements Visitor, TimerListener{
	private ImageIcon im = new ImageIcon("Fireball.png");
	private int x;
	private int y;
	private Blinky blinky;
	private double speed;

	/**
	 * FireBalls' constructor.
	 * 
	 * @param x1 - FireBalls' position.
	 * @param y1 - FireBalls' position.
	 * @param blinky - the gust that FireBalls belongs to. 
	 */
	public FireBalls(Blinky blinky, int x1, int y1) {
		MyTimer.getInstance((int) this.speed).add(this);
		this.blinky=blinky;
		this.x=x1;
		this.y=y1;
	}

	/**
	 *  FireBalls visits pacman
	 * 	@Override
	 */
	public void visit(Pacman pacman) {
		if (pacman.getLevel()==3)
			pacman.setLives(pacman.getLives()-1);
	}

	@Override
	public void action() {
		
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
