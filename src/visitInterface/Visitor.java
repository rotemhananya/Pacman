package VisitInterface;

import Pacman.Pacman1;
import Pacman.Pacman2;
import Pacman.Pacman3;


/**
 * This class represents the visitor interface
 *
 */
public interface Visitor {

	public void visit(Pacman1 pacman1);
	public void visit(Pacman2 pacman2);
	public void visit(Pacman3 pacman3);
	
}

