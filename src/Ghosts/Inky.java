package Ghosts;

import GameBoard.GamePanel;
import GhostsWeapons.WaterSplash;
import Pacman.Pacman1;
import Pacman.Pacman2;
import Pacman.Pacman3;
import Timer.MyTimer;

/**
 * This class represents the ghost Inky.
 * Inky has a weapon - waterSplash.
 *
 */
public class Inky extends Ghost {
	private WaterSplash waterSplash; // Inky's weapon
	private int waterSplashGetReady=500; // counter for when waterSplash needs to start moving

	/**
	 * Inky's constructor.
	 * 
	 * @param GamePanel - the panel of the game.
	 */
	public Inky(int x1, int y1, GamePanel GamePanel) {
		this.x=x1;
		this.y=y1;
		this.GamePanel=GamePanel;
		MyTimer.getInstance().add(this);

		int a[]= {RIGHT, UP};
		this.Out= a;
		this.Speed=4;

		this.Im=this.GamePanel.getFrame().getPics().getGhostsPics(1);
		waterSplash= new WaterSplash(this, this.GamePanel);
	}

	/**
	 * Inky visits pacman
	 * @Override
	 */
	@Override
	public void visit(Pacman1 pacman1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Pacman2 pacman2) {
		if (this.Chase==true) {
			pacman2.setFreezeCounter(pacman2.getSecTime()); // pacman can't move for 5 seconds
			pacman2.setPoints(pacman2.getPoints()-10);
		}
	}

	@Override
	public void visit(Pacman3 pacman3) {
		if (this.Chase==true) 
			this.FreezeCounter=pacman3.getSecTime(); //inky freezes for 5 seconds

	}

	@Override
	public void action() {
		setStartMoving();
		if (this.y==38 && this.x==1) // if the ghost reached the right corner
			this.Chase=true;
		if (this.StartMoving==true && this.FreezeCounter==0) // if the ghost can move
			if (this.Chase==false && this.OutCounter!=this.Out.length)
				outOfCage();
			else if (this.Chase==false) // going to the right corner
				reachCorner();
			else if (this.CountRandom==0)
				chasePacman();
			else //stuck
				randomMove();	
		if (this.Sec - this.FreezeCounter==5)
			setFreezeCounter(0);
		Sec++;
	}


	/**
	 * Getters & setters.
	 */


	protected void setStartMoving() {
		if (this.Sec==8 || GamePanel.getPoints()==4000 || GamePanel.getPoints()==7900) // releasing Inky
			this.setStartMoving(true);
		if (x==1 && y==38 && waterSplash.getStartMoving()==false) 
			this.waterSplashGetReady = this.Sec;
		if (this.Sec - this.waterSplashGetReady == 4) { // waterSplash starts moving 4 seconds after Inky reaches the corner
			this.waterSplash.setStartMoving(true);
			this.waterSplash.setX(this.x);
			this.waterSplash.setY(this.y);
		}
	}

	public WaterSplash getWaterSplash() {
		return this.waterSplash;
	}

	public boolean getChase () {
		return this.Chase;
	}


}







