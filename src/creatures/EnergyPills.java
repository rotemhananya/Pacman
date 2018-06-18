package creatures;

/**
 * This class represents an array of energy pills that are in the corner of the board.
 *
 */
public class EnergyPills {
	private EnergyPill [] energyPills = new EnergyPill[4];

	/**
	 * EnergyPills' constructor.
	 * 
	 */
	public EnergyPills() {
		energyPills[0]=new EnergyPill(1, 1);
		energyPills[0]=new EnergyPill(38, 1);
		energyPills[0]=new EnergyPill(38, 1);
		energyPills[0]=new EnergyPill(38, 38);
	}
	
	public int getLength() {
		return energyPills.length;
	}
}
