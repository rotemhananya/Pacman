package hw4;

public class Food {

	private int x ;
	private int y ;
	private boolean isEaten ;
	
	public Food(int x, int y) {
		this.x=x;
		this.y=y;
		isEaten=false ;
	}
	
	public void eaten(boolean isEaten) {
		this.isEaten=isEaten;
	}
}
