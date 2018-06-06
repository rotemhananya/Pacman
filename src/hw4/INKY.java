package hw4;

public class INKY {
	
	WaterSplash waterSplash ;
	
	public INKY() {
		waterSplash= new WaterSplash();
		
	}
	/**
	 * This method throws water splash
	 * @return the Inky's water splash
	 */
	public WaterSplash throwSplash() {
		return this.waterSplash;
	}

}
