package GhostsWeapons;

import javax.swing.ImageIcon;

import GameBoard.GamePanel;
import Ghosts.Inky;
import Pacman.Pacman1;
import Pacman.Pacman2;
import Pacman.Pacman3;
import Timer.MyTimer;


/**
 * This class represents Inky's weapon.
 *
 */
public class WaterSplash extends Weapons {
	private ImageIcon imWaterSplashLeft;
	private ImageIcon imWaterSplashRight;
	private ImageIcon imWaterSplashUp;
	private ImageIcon imWaterSplashDown;
	private Inky Inky;


	/**
	 * WaterSplash's constructor.
	 * 
	 * @param x1 - FireBalls' position.
	 * @param y1 - FireBalls' position.
	 * @param inky - the gust that WaterSplash belongs to. 
	 */
	public WaterSplash(Inky inky, GamePanel gamePanel) {
		this.x=inky.getX();
		this.y=inky.getY();
		this.Inky=inky;
		this.GamePanel=gamePanel;
		MyTimer.getInstance().add(this);
		
		this.imWaterSplashLeft = this.GamePanel.getFrame().getPics().getwaterSplashPics(0);
		this.imWaterSplashRight = this.GamePanel.getFrame().getPics().getwaterSplashPics(1);
		this.imWaterSplashUp = this.GamePanel.getFrame().getPics().getwaterSplashPics(2);
		this.imWaterSplashDown = this.GamePanel.getFrame().getPics().getwaterSplashPics(3);
	}

	/**
	 *  WaterSplash visits pacmans
	 * 	@Override
	 */

	@Override
	public void visit(Pacman1 pacman1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Pacman2 pacman2) {
		pacman2.setFreezeCounter(pacman2.getSecTime()); // pacman can't move for 5 seconds
		pacman2.setPoints(pacman2.getPoints()-10);
		
	}

	@Override
	public void visit(Pacman3 pacman3) {
		this.Inky.setStartMoving(false); //inky freezes for 5 seconds
		
	}

	@Override
	public void action(){
		if (this.StartMoving==true) {
			if (this.MovesDone==this.Moves[1]) {
				this.x=this.Inky.getX();
				this.y=this.Inky.getY();
				this.Moves=this.GamePanel.getWaterSplashPath(this);
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
			return this.imWaterSplashLeft;
		else if (this.Moves[0]==RIGHT)
			return this.imWaterSplashRight;
		else if (this.Moves[0]==UP)
			return this.imWaterSplashUp;
		else 
			return this.imWaterSplashDown;
	}

}