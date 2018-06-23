package Ghosts;

import GameBoard.GamePanel;
import Pacman.Pacman1;
import Pacman.Pacman2;
import Pacman.Pacman3;
import Timer.MyTimer;

/**
 * This class represents the ghost Ginkey.
 *
 */
public class Ginkey extends Ghost{

	/**
	 * Ginkey's constructor.
	 * 
	 * @param x1 - location		
	 * @param y1 - location
	 * @param GamePanel - game panel
	 */
	public Ginkey(int x1, int y1, GamePanel GamePanel) {
		this.x=x1;
		this.y=y1;
		this.GamePanel=GamePanel;
		MyTimer.getInstance().add(this);

		int a[]= {UP};
		this.Out= a;
		this.Speed=2;
		this.Im=this.GamePanel.getFrame().getPics().getGhostsPics(0);
	}

	/**
	 * Ginkey visits pacman1
	 * @Override
	 */
	@Override
	public void visit(Pacman1 pacman1) {
		if (this.Chase==true)
			pacman1.setLives(pacman1.getLives()-1);

	}


	/**
	 * Ginkey visits pacman2
	 * @Override
	 */

	@Override
	public void visit(Pacman2 pacman2) {
		if (this.Chase==true)
			if (this.FreezeCounter==0) {
				this.FreezeCounter=pacman2.getSecTime(); //ginky disappears for 5 seconds
				this.Im=null;
			}

	}


	/**
	 * Ginkey visits pacman3
	 * @Override
	 */
	@Override
	public void visit(Pacman3 pacman3) {
		if (this.Chase==true) {
			this.StartMoving=false;	//ginky dies
			this.x=0;
			this.y=0;
			this.Im=null;
		}

	}


	/**
	 * This function makes Ginkey move.
	 * @Override
	 */
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
		if (this.Sec - FreezeCounter==5)
			setFreezeCounter(0);

		Sec++;
	}


	/**
	 * Getters & setters.
	 */

	protected void setStartMoving() {
		if (this.Sec==2 || this.GamePanel.getPoints()==3600 || this.GamePanel.getPoints()==7500) // releasing Ginkey
			this.StartMoving=true;

	}



}


