package hw4;

import javax.swing.ImageIcon;

public class Ginkey extends Creature implements TimerListener {
	private ImageIcon im = new ImageIcon("GINKEY.png");
	private double speed = 3;
	private int x;
	private int y;
	private int radius;
	
	public Ginkey () {
		MyTimer.getInstance().add(this);
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		
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
	public void visit(Pacman pacman) {
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
	public ImageIcon getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}