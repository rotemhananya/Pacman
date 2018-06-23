package Ghosts;

import GameBoard.GamePanel;
import GhostsWeapons.FireBalls;
import Pacman.Pacman1;
import Pacman.Pacman2;
import Pacman.Pacman3;
import Timer.MyTimer;


/**
 * This class represents the ghost Blinky.
 * Blinky has a weapon - fireballs.
 *
 */
public class Blinky extends Ghost {

	private FireBalls fireballs;
	private int fireballsGetReady=500; // counter for when fireballs needs to start moving

	/**
	 * Blinky's constructor.
	 * 
	 * @param GamePanel - the panel of the game.
	 */
	public Blinky(int x1, int y1, GamePanel GamePanel) {
		this.x=x1;
		this.y=y1;
		this.GamePanel=GamePanel;
		MyTimer.getInstance().add(this);

		int a[]= {LEFT, UP};
		this.Out= a;
		this.Speed=5; 
		this.Im=this.GamePanel.getFrame().getPics().getGhostsPics(2);
		this.fireballs=new FireBalls(this, GamePanel); // initiating blinky's weapon 

	}

	/**
	 * Blinky visits pacman.
	 * @Override
	 */

	@Override
	public void visit(Pacman1 pacman1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Pacman2 pacman2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Pacman3 pacman3) {
		pacman3.setLives(pacman3.getLives()-1);

	}


	@Override
	public void action() {
		setStartMoving();
		if (this.y==38 && this.x==1) // if the ghost reached the right corner
			this.Chase=true;
		if (this.StartMoving==true) // if the ghost can move
			if (this.Chase==false && this.OutCounter!=this.Out.length)
				outOfCage();
			else if (this.Chase==false) // going to the right corner
				reachCorner();
			else if (this.CountRandom==0)
				chasePacman();
			else //stuck
				randomMove();
		Sec++;
	}


	/**
	 * Getters & setters.
	 */


	protected void setStartMoving() {
		if (this.Sec==10 || GamePanel.getPoints()==3800 || GamePanel.getPoints()==7700) // releasing Blinky
			this.setStartMoving(true);		
		if (x==1 && y==38 && fireballs.getStartMoving()==false) // counting 4 seconds from the moment Blinky reaches the corner 
			this.fireballsGetReady = this.Sec;
		if (this.Sec - this.fireballsGetReady == 4) { // fireballs start moving 4 seconds after Blinky reaches the corner
			this.fireballs.setStartMoving(true);
			this.fireballs.setX(this.x);
			this.fireballs.setY(this.y);
		}
	}

	public FireBalls getFireBalls() {
		return this.fireballs;
	}




}
