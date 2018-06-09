package hw4;

public interface Visitor {

	public void visit(Pacman pacman);
	public void visit(Ginkey ginkey);
	public void visit(Inky inky);
	public void visit(Blinky blinky);
	public void visit(FireBalls firaBalls);
	public void visit(WaterSplash waterSplash);
}

