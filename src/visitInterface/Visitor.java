package visitInterface;

import creatures.Pacman;

/**
 * This class represents the visitor interface
 *
 */
public interface Visitor {

	public void visit(Pacman pacman);
}

