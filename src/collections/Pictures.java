package Collections;

import javax.swing.ImageIcon;
/**
 * This class hold all the images that are used during the game.
 */
public class Pictures {
	private ImageIcon [] menuPics = new ImageIcon[6]; // an array that holds all of the menu's images
	private ImageIcon [] blockPics = new ImageIcon[2]; // an array that holds all of the block's images
	private ImageIcon [] pacman1Pics = new ImageIcon[4]; // an array that holds all of pacman1's images
	private ImageIcon [] pacman2Pics = new ImageIcon[4]; // an array that holds all of pacman2's images
	private ImageIcon [] pacman3Pics = new ImageIcon[4]; // an array that holds all of pacman3's images
	private ImageIcon [] ghostsPics = new ImageIcon[5]; // an array that holds all of the ghosts' images
	private ImageIcon [] fireBallsPics = new ImageIcon[4]; // an array that holds all of fireBalls' images
	private ImageIcon [] waterSplashPics = new ImageIcon[4]; // an array that holds all of waterSplash's images
	private ImageIcon [] foodPics = new ImageIcon[7]; // an array that holds all of the food's images
	private ImageIcon [] foodPicsFade = new ImageIcon[5]; // an array that holds all of the food's fading images
	private ImageIcon [] gameOverPics = new ImageIcon[2]; // an array that holds all of the gameOver's images

	/**
	 * Pictures constructor.
	 * This constructor initializes the arrays with the ImageIcons.
	 */
	public Pictures () {
		menuPics[0] = new ImageIcon("PacmanLo.jpg"); // the logo in Menu
		menuPics[1] = new ImageIcon("1.png"); // the first board
		menuPics[2] = new ImageIcon("2.png"); // the second board 
		menuPics[3] = new ImageIcon("3.png"); // the third board 
		menuPics[4] = new ImageIcon("4.png"); // the forth board 
		menuPics[5] = new ImageIcon("gifMenu.gif"); // the gif in Menu

		blockPics[0] = new ImageIcon("block.png");  
		blockPics[1] = new ImageIcon("CageBlock.jpg");

		pacman1Pics[0] = new ImageIcon("yellowLeft.gif");
		pacman1Pics[1] = new ImageIcon("yellowRight.gif");
		pacman1Pics[2] = new ImageIcon("yellowUp.gif");
		pacman1Pics[3] = new ImageIcon("yellowDown.gif");
		
		pacman2Pics[0] = new ImageIcon("blueLeft.gif");
		pacman2Pics[1] = new ImageIcon("blueRight.gif");
		pacman2Pics[2] = new ImageIcon("blueUp.gif");
		pacman2Pics[3] = new ImageIcon("blueDown.gif");
		
		pacman3Pics[0] = new ImageIcon("redLeft.gif");
		pacman3Pics[1] = new ImageIcon("redRight.gif");
		pacman3Pics[2] = new ImageIcon("redUp.gif");
		pacman3Pics[3] = new ImageIcon("redDown.gif");
		
		ghostsPics[0] = new ImageIcon("GINKEY.png"); 
		ghostsPics[1] = new ImageIcon("INKY.png");
		ghostsPics[2] = new ImageIcon("BLINKY.png"); 
		ghostsPics[3] = new ImageIcon("PINKY.png"); 
		ghostsPics[4] = new ImageIcon("FREAKY.png");  

		fireBallsPics[0] = new ImageIcon("fireBallsLeft.png");
		fireBallsPics[1] = new ImageIcon("fireBallsRight.png");
		fireBallsPics[2] = new ImageIcon("fireBallsUp.png");
		fireBallsPics[3] = new ImageIcon("fireBallsDown.png");
		
		waterSplashPics[0] = new ImageIcon("waterSplashLeft.png");
		waterSplashPics[1] = new ImageIcon("waterSplashRight.png");
		waterSplashPics[2] = new ImageIcon("waterSplashUp.png");
		waterSplashPics[3] = new ImageIcon("waterSplashDown.png");
		
		foodPics[0] = new ImageIcon("NormalPill.jpg");   		
		foodPics[1] = new ImageIcon("EnergyPill.jpg");   
		foodPics[2] = new ImageIcon("Pineapple.png");   
		foodPics[3] = new ImageIcon("Apple.png");   
		foodPics[4] = new ImageIcon("Strawberry.png");   
		foodPics[5] = new ImageIcon("Batteries.png");  
		foodPics[6] = new ImageIcon("Cherry.png");
		
		foodPicsFade[0] = new ImageIcon("PineappleFade.gif");   
		foodPicsFade[1] = new ImageIcon("AppleFade.gif");   
		foodPicsFade[2] = new ImageIcon("StrawberryFade.gif");   
		foodPicsFade[3] = new ImageIcon("BatteriesFade.gif");  
		foodPicsFade[4] = new ImageIcon("CherryFade.gif"); 

		gameOverPics[0] = new ImageIcon("fireworks.gif"); // the fireworks in GameOver
		gameOverPics[1] = new ImageIcon("PacmanCrying.PNG"); // the picture of pacman crying in GameOver
	}

	/**
	 * This function returns the ImageIcon that is in index i in menuPics.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getMenuPic(int i) {
		return menuPics[i];
	}

	/**
	 * This function returns the ImageIcon that is in index i in blockPics.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getBlockPic(int i) {
		return blockPics[i];
	}
	
	/**
	 * This function returns the ImageIcon that is in index i in pacman1Pics.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getPacman1Pic(int i) {
		return pacman1Pics[i];
	}
	
	/**
	 * This function returns the ImageIcon that is in index i in pacman2Pics.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getPacman2Pic(int i) {
		return pacman2Pics[i];
	}
	
	/**
	 * This function returns the ImageIcon that is in index i in pacman3Pics.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getPacman3Pic(int i) {
		return pacman3Pics[i];
	}
	
	/**
	 * This function returns the ImageIcon that is in index i in foodPics.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getFoodPic(int i) {
		return foodPics[i];
	}

	/**
	 * This function returns the ImageIcon that is in index i in foodPicsFade.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getFoodPicsFade(int i) {
		return foodPicsFade[i];
	}
	
	/**
	 * This function returns the ImageIcon that is in index i in ghosstsPics.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getGhostsPics(int i) {
		return ghostsPics[i];
	}
	

	/**
	 * This function returns the ImageIcon that is in index i in fireBallsPics.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getfireBallsPics(int i) {
		return fireBallsPics[i];
	}
	

	/**
	 * This function returns the ImageIcon that is in index i in waterSplashPics.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getwaterSplashPics(int i) {
		return waterSplashPics[i];
	}
	
	/**
	 * This function returns the ImageIcon that is in index i in gameOverPics.
	 * 
	 * @param i - the index of the returned ImageIcon.
	 * @return - the ImageIcon that is in index i.
	 */
	public ImageIcon getGameOverPic(int i) {
		return gameOverPics[i];
	}
}
