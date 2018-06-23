package Collections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class represents all of the boards that the user can choose from and play with.
 *
 */
public class Boards {
	private String boardsCSV = "boards.csv"; // the name of the csv file.
	private int boardsSize  = 40; // the boards size
	private int [][] board1;
	private int [][] board2;
	private int [][] board3;
	private int [][] board4;
	private int [][] boardLevel2;
	private int [][] boardLevel3;

	/**
	 * Constructor of Boards class that contains 6 game boards.
	 */
	public Boards() {
		this.board1 = new int [boardsSize][boardsSize];
		this.board2 = new int [boardsSize][boardsSize];
		this.board3 = new int [boardsSize][boardsSize];
		this.board4 = new int [boardsSize][boardsSize];
		this.boardLevel2 = new int [boardsSize][boardsSize]; 
		this.boardLevel3 = new int [boardsSize][boardsSize]; 
		initCSVFile(boardsCSV);
	}

	/**
	 * This method reads from CSV file.
	 * 
	 * @param boardsCSV - the path string of the file.
	 */
	private void initCSVFile(String boardsCSV){
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ","; // use comma as separator
		try {
			br = new BufferedReader(new FileReader(boardsCSV)); // reading from csv file
			while ((line = br.readLine()) != null) {
				String[] csv = line.split(csvSplitBy);
				for (int i=0; i<this.boardsSize; i++) {
					line = br.readLine(); 
					if (csv[0].equals("1"))  // if the current board is board1
						for (int j=0; j<this.boardsSize; j++) 
							board1[i][j] = Integer.parseInt(line.split(csvSplitBy)[j]); // add the next index of the board game.
					else if (csv[0].equals("2"))  // if the current board is board2
						for (int j=0; j<this.boardsSize; j++) 
							board2[i][j] = Integer.parseInt(line.split(csvSplitBy)[j]); // add the next index of the board game.
					else if (csv[0].equals("3")) // if the current board is board3
						for (int j=0; j<this.boardsSize; j++) 
							board3[i][j] = Integer.parseInt(line.split(csvSplitBy)[j]); // add the next index of the board game.
					else if (csv[0].equals("4")) // if the current board is board4
						for (int j=0; j<this.boardsSize; j++) 
							board4[i][j] = Integer.parseInt(line.split(csvSplitBy)[j]); // add the next index of the board game.
					else if (csv[0].equals("5"))  // if the current board is boardLevel2
						for (int j=0; j<this.boardsSize; j++) 
							boardLevel2[i][j] = Integer.parseInt(line.split(csvSplitBy)[j]); // add the next index of the board game.
					else  // if the current board is boardLevel3
						for (int j=0; j<this.boardsSize; j++) 
							boardLevel3[i][j] = Integer.parseInt(line.split(csvSplitBy)[j]); // add the next index of the board game.
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * This method returns game board of integers. 
	 * 
	 * @param i - the board index
	 * @return game board of integers.
	 */
	public int[][] getBoard(int i){
		if (i==1)
			return this.board1;
		else if (i==2)
			return this.board2;
		else if (i==3)
			return this.board3;
		else if (i==4)
			return this.board4;
		else if (i==5)
			return this.boardLevel2;
		else
			return this.boardLevel3;
	}
}