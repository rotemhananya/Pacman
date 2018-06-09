package hw4;


import java.util.Random;
import javax.swing.ImageIcon;
//import javax.swing.Timer;

public class Blinky extends Creature implements TimerListener {
	private ImageIcon im = new ImageIcon("BLINKY.png");
	private double speed = 1;
	private int x;
	private int y;
	private int radius;
	private FireBalls fireballs;
	private int[][] boards;
	private Random rand = new Random();
	private int wall=3;

	public Blinky(int x1, int y1, int [][]bo) {
		MyTimer.getInstance().add(this);
		this.boards=bo;
		this.x=x1;
		this.y=y1;
		this.fireballs=new FireBalls();

	}


	@Override
	public void action() {
		move(true);
		//if  Xpacman=XBlinky do fire 
	}

	public void move(boolean start) {
		if (start==true) {
			if (this.boards[this.x-1][this.y]!=wall) // up
				this.x-=1;
			else if (this.boards[this.x][this.y-1]!=wall) // left
				this.y-=1;
			else if (this.boards[this.x][this.y+1]!=wall) //right
				this.y+=1;
			else  // down
				this.x+=1;
		}

		else {// Blinkey is chasing pacman

		}
	}

	@Override
	public ImageIcon getImage() {
		return this.im;
	}

	@Override
	public double getSpeed() {
		return this.speed;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	public void setX(int x1) {
		this.x=x1;
	}

	public void setY(int y1) {
		this.y=y1;
	}

	public void setBoards(int [][]b) {
		this.boards=b;
	}

	@Override
	public void visit(Ginkey ginkey) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Inky inky) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Blinky blinky) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(FireBalls firaBalls) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(WaterSplash waterSplash) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Pacman pacman) {
		// TODO Auto-generated method stub

	}

}
