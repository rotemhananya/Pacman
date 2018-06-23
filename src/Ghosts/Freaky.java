package Ghosts;

import GameBoard.GamePanel;
import Pacman.Pacman1;
import Pacman.Pacman2;
import Pacman.Pacman3;
import Timer.MyTimer;
/**
 * This class represents the ghost Freaky.
 *
 */
public class Freaky extends Ghost {



	/**
	 * Freaky's constructor.
	 * 
	 * @param GamePanel - the panel of the game.
	 */
	public Freaky(int x1, int y1, GamePanel GamePanel) {
		this.x=x1;
		this.y=y1;
		this.GamePanel=GamePanel;
		MyTimer.getInstance().add(this);
		int a[]= {RIGHT, RIGHT, UP};
		this.Out= a;
		this.Speed=2;
		this.Im=this.GamePanel.getFrame().getPics().getGhostsPics(4);
	
	}

	/**
	 * Freaky visits pacman
	 * @Override
	 */
	@Override
	public void visit(Pacman1 pacman1) {
		if (this.Chase==true)
			pacman1.setLives(pacman1.getLives()-1);
		
	}

	@Override
	public void visit(Pacman2 pacman2) {
		if (this.Chase==true)
			pacman2.setLives(pacman2.getLives()-1);
		
	}

	@Override
	public void visit(Pacman3 pacman3) {
		if (this.Chase==true)
			pacman3.setLives(pacman3.getLives()-1);
		
	}
	
	/**
	 * Getters & setters.
	 */


	protected void setStartMoving() {
		if (this.Sec==5 || GamePanel.getPoints()==4200 || GamePanel.getPoints()==8100) // releasing Freaky 
			setStartMoving(true);
		
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


	

}
