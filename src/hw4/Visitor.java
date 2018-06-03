package hw4;

public interface Visitor {

	public void visit(Pacman pacman);
	public void visit(GINKEY ginkey);
	public void visit(INKY inky);
	public void visit(BLINKY blinky);
	public void visit(FireBalls firaBalls);
	public void visit(WaterSplash waterSplash);
}

