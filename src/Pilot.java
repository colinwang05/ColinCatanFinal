/*
 * Once per turn, fly to any tile on the island for 1 action
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Pilot extends Player1
{
	private GameBoard gameBoard;
	private ArrayList<Tile1> movableTile1s;
	private Boolean hasFlyOnAnyTile;

	public Pilot(GameBoard gameBoard, int order, String Color, String Role, TreasureDeck treasureDeck,
				 BufferedImage pown, BufferedImage pown_move, int xPos, int yPos)
	{
		super(gameBoard, order, Color, Role, treasureDeck, pown, pown_move, xPos, yPos);
		hasFlyOnAnyTile = false;
		this.gameBoard = gameBoard;
	}
	public void set(){
		hasFlyOnAnyTile=false;
	}
	public void usedSpecialAction()
	{
		hasFlyOnAnyTile = true;
	}
	public ArrayList<Tile1> getMovableTiles()
	{
		ArrayList<Tile1> allTile1s = gameBoard.getAllTiles();
		/*
		 * BUG!!! if the player choose to not use their special action in the first move, they should be able to use it in the next move
		 * seed 8
		 */
		if(!hasFlyOnAnyTile)
		{
			movableTile1s = allTile1s;



		}
		else
		{
			movableTile1s = new ArrayList<Tile1>();
			int x = getX();
			int y = getY();
			for(Tile1 t : allTile1s)
			{
				int tileX = t.getXPos();
				int tileY = t.getYPos();

				if(tileX == (x-1) && tileY == y)//the upper tile (North)
				{
					movableTile1s.add(t);
				}
				if(tileX == x && tileY == y-1)//the left tile (West)
				{
					movableTile1s.add(t);
				}
				if(tileX == (x+1) && tileY == y)//the bottom tile (South)
				{
					movableTile1s.add(t);
				}
				if(tileX == x && tileY == y+1)//the right tile (East)
				{
					movableTile1s.add(t);
				}
			}
		}
		return movableTile1s;
	}
}
