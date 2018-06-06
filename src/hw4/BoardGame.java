package hw4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class BoardGame extends JFrame implements KeyListener {

	private Image gameImage;
	Pacman pacman ;
	BLINKY blinky;
	GINKEY ginkey;
	INKY inky;
	Container container;
	int x=0, y=0;
	private int boardSize = 800;
	private int PixeleSize = 20;
	private int[][] boardGame; 
	boolean key_right, key_left, key_down, key_up; // Input booleans


	public BoardGame(int [][] boardGame1){
		super("Pacman");
		
		container = new Container();
		//addComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(boardSize,boardSize);
		setMinimumSize(new Dimension(boardSize, boardSize));
		setMaximumSize(new Dimension(boardSize, boardSize));
		this.boardGame = boardGame1;
		this.setVisible(true);
		this.setResizable(false);
		addKeyListener(this);
		setFocusable(true);
	}
	
	/*private void addComponents() {
		container.setLayout(null);
		pacman=new Pacman(20, 20, 10);
			container.add(pacman);
			container.add(blinky);
			container.add(ginkey);
			container.add(inky);
			
		}
	}*/

	public void paint(Graphics g) {
		Image offIm = createImage(boardSize, boardSize);
		Graphics g2 = offIm.getGraphics();
		for(int i=0; i<this.boardGame.length; i++) 
			for(int j=0; j<this.boardGame.length; j++)
				if (this.boardGame[i][j]==1) 
					g2.fillRect(j*PixeleSize, i*PixeleSize, PixeleSize, PixeleSize);
		gameImage=offIm;
		g.drawImage(offIm, x, y, this);
	}

	public static void main (String[]args) {
		Boards b = new Boards();
		new BoardGame(b.getBoard(4));
	}

	/**
	 * This method paints the components of the game
	 * @param n - the index of the component
	 */
	private void paintComponent(int n) {
		Graphics g = super.getGraphics();
		Component c = getComponent(n);

		g.drawImage(gameImage, x, y, this); 

		if (key_down) {
			loadImage("D");
			y++; 
		}


		if (key_up) {
			loadImage("U");
			y--; 
		}


		if (key_right) {
			loadImage("R");
			x++; 
		}


		if (key_left) {
			loadImage("L");
			x--; 
		}

		repaint();
	}

	public void loadImage(String img) {

	}

	public void keyTyped(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == e.VK_DOWN)
			key_down = false;
		if (e.getKeyCode() == e.VK_UP)
			key_up = false;
		if (e.getKeyCode() == e.VK_RIGHT)
			key_right = false;
		if (e.getKeyCode() == e.VK_LEFT)
			key_left = false;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_DOWN)
			key_down = true;
		if (e.getKeyCode() == e.VK_UP)
			key_up = true;
		if (e.getKeyCode() == e.VK_RIGHT) 
			key_right = true;
		if (e.getKeyCode() == e.VK_LEFT)
			key_left = true;
	}



	private boolean checkPosition(int x, int y) {

		return false;
	}

	private boolean checkPosition(int x, int y, int way) {

		return false;
	}


}

