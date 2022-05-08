import java.util.ArrayList;

import javax.swing.JOptionPane;

public class WaterMeter
{
	private int initialLevel, waterLevel;
	public static int drawNum;
	private GameBoard gameBoard;

	public WaterMeter(GameBoard gameBoard, int level)
	{
		this.gameBoard = gameBoard;
		this.initialLevel = level;
		waterLevel = level;
		check();
	}

	public void waterRises()
	{
		waterLevel++;
		check();
	}

	public void check()
	{
		/*
		 * 0 (novice) 1 (normal) --> 2
		 * 2 (elite) 3 (legendaire) 4 --> 3
		 * 5 6 --> 4
		 * 7 8 -->5
		 * 9 --> lost
		 */
		if(waterLevel<=1){
			drawNum=2;
		}
		else if(waterLevel<=4){
			drawNum=3;
		}
		else if(waterLevel<=6){
			drawNum=4;
		}
		else if(waterLevel<=8){
			drawNum=5;
		}
		else{
			JOptionPane.showInputDialog(null, "You lost because water level > 5");
		}
	}

	public int getDrawNum(){
		return drawNum;
	}

	public int getWaterLevel()
	{
		return waterLevel;
	}


}
