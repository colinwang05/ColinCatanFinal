/*
 * move and/or shore up diagnally
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Explorer extends Player1
{
	private GameBoard gameBoard;
	private ArrayList<Tile1> movableTile1s;

	public Explorer(GameBoard gameBoard, int order, String Color, String Role, TreasureDeck treasureDeck,
					BufferedImage pown, BufferedImage pown_move, int xPos, int yPos)
	{
		super(gameBoard, order, Color, Role, treasureDeck, pown, pown_move, xPos, yPos);
		this.gameBoard = gameBoard;
	}
	@Override
	public ArrayList<Tile1> getMovableTiles()
	{
		ArrayList<Tile1> allTile1s = gameBoard.getAllTiles();
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
			if(tileX == x-1 && tileY == y-1)//the top left tile (Northwest)
			{
				movableTile1s.add(t);
			}
			if(tileX == x-1 && tileY == y+1)//the top right tile (NorthEast)
			{
				movableTile1s.add(t);
			}
			if(tileX == x+1 && tileY == y-1)//the bottom left tile (Southwest)
			{
				movableTile1s.add(t);
			}
			if(tileX == x+1 && tileY == y+1)//the bottom right tile (Southeast)
			{
				movableTile1s.add(t);
			}
		}
		return movableTile1s;
	}

}
