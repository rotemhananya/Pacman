package GhostsWeapons;

import javax.swing.ImageIcon;
import GameBoard.GamePanel;
import Ghosts.Blinky;
import GhostsWeapons.Weapons;
import Pacman.Pacman1;
import Pacman.Pacman2;
import Pacman.Pacman3;
import Timer.MyTimer;


/**
 * This class represents Blinky's weapon.
 *
 */
public class FireBalls extends Weapons {
	private ImageIcon imFireBallsLeft;
	private ImageIcon imFireBallsRight;
	private ImageIcon imFireBallsUp;
	private ImageIcon imFireBallsDown;
	private Blinky Blinky;


	/**
	 * FireBalls' constructor.
	 * 
	 * @param blinky - the gust that FireBalls belongs to. 
	 */
	public FireBalls(Blinky blinky, GamePanel gamePanel) {
		this.x=blinky.getX();
		this.y=blinky.getY();
		this.Blinky=blinky;
		this.GamePanel=gamePanel;
		MyTimer.getInstance().add(this);
		
		this.imFireBallsLeft = this.GamePanel.getFrame().getPics().getfireBallsPics(0);
		this.imFireBallsRight = this.GamePanel.getFrame().getPics().getfireBallsPics(1);
		this.imFireBallsUp = this.GamePanel.getFrame().getPics().getfireBallsPics(2);
		this.imFireBallsDown = this.GamePanel.getFrame().getPics().getfireBallsPics(3);
	}

	/**
	 *  FireBalls visits pacman
	 * 	@Override
	 */
	public void visit(Pacman1 pacman) {
		
	}

	public void visit(Pacman2 pacman) {

	}

	public void visit(Pacman3 pacman) {
		pacman.setLives(pacman.getLives()-1);		
	}

	/**
	 * This function makes FireBalls move.
	 * @Override
	 */
	public void action() {
		if (this.StartMoving==true) {
			if (this.MovesDone==this.Moves[1]) {
				this.x=this.Blinky.getX();
				this.y=this.Blinky.getY();
				this.Moves=this.GamePanel.getFireBallsPath(this);
				this.MovesDone=0;
			}
			else if (this.MovesDone<this.Moves[1]) {
				if (this.Moves[0]==LEFT)
					this.y-=1;
				else if (this.Moves[0]==RIGHT)
					this.y+=1;
				else if (this.Moves[0]==UP)
					this.x-=1;
				else 
					this.x+=1;
				this.MovesDone++;
			}
		}
	}

	/**
	 * Getters & setters
	 */
	public ImageIcon getImage() {
		if (this.Moves[0]==LEFT)
			return this.imFireBallsLeft;
		else if (this.Moves[0]==RIGHT)
			return this.imFireBallsRight;
		else if (this.Moves[0]==UP)
			return this.imFireBallsUp;
		else 
			return this.imFireBallsDown;
	}





}