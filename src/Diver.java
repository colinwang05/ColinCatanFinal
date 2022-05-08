/*
 * move through 1 or more adjacent flooded and/or missing tiles for 1 action
 * (must end your turn on a tile)
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Diver extends Player1
{
	private int xPos, yPos;
	private ArrayList<ArrayList<Tile1>> allTiles_2D;
	private boolean isSpecial = true;

	public Diver(GameBoard gameBoard, int order, String Color, String Role, TreasureDeck treasureDeck,
				 BufferedImage pown, BufferedImage pown_move, int xPos, int yPos)
	{
		super(gameBoard, order, Color, Role, treasureDeck, pown, pown_move, xPos, yPos);
		allTiles_2D = gameBoard.getAllTiles_2D();
	}

	public ArrayList<Tile1> getMovableTiles(){
		if(isSpecial)
		{
			return super.getMovableTiles();
		}
		return diverMovement(yPos, xPos);
	}

	public ArrayList<Tile1> diverMovement(int x, int y)
	{
		ArrayList<Tile1> tile1s = new ArrayList<>();
		diverMovement(x, y, tile1s, new ArrayList<>());
		tile1s.remove(allTiles_2D.get(y).get(x));
		return tile1s;
	}

	//precondition, x, y not in tiles already
	public void diverMovement(int x, int y, ArrayList<Tile1> tile1s, ArrayList<Tile1> sunk)
	{
		System.out.println("diver");
		ArrayList<ArrayList<Tile1>> board = allTiles_2D;
		if (sunk.contains(board.get(y).get(x)))
		{
			return;
		}
		if ((board.get(y).get(x).getFloodState()!=-1))
		{
			tile1s.add(board.get(y).get(x));
		}
		else
		{
			sunk.add(board.get(y).get(x));
		}
		if (x > 0 && board.get(y).get(x - 1) != null && board.get(y).get(x - 1).getFloodState()!=1 && !tile1s.contains(board.get(y).get(x - 1)))
		{
			diverMovement(x - 1, y, tile1s, sunk);
		}
		else if (x > 0 && board.get(y).get(x - 1) != null)
		{
			if (!tile1s.contains(board.get(y).get(x - 1)))
				tile1s.add(board.get(y).get(x - 1));
		}
		if (x < 5 && board.get(y).get(x + 1) != null && board.get(y).get(x + 1).getFloodState()!=1 && !tile1s.contains(board.get(y).get(x + 1)))
		{
			diverMovement(x + 1, y, tile1s, sunk);
		}
		else if (x < 5 && board.get(y).get(x + 1) != null)
		{
			if (!tile1s.contains(board.get(y).get(x + 1)))
				tile1s.add(board.get(y).get(x + 1));
		}
		if (y > 0 && board.get(y - 1).get(x) != null && board.get(y - 1).get(x).getFloodState()!=1 && !tile1s.contains(board.get(y - 1).get(x)))
		{
			diverMovement(x, y - 1, tile1s, sunk);
		}
		else if (y > 0 && board.get(y - 1).get(x) != null)
		{
			if (!tile1s.contains(board.get(y - 1).get(x)))
				tile1s.add(board.get(y - 1).get(x));
		}
		if (y < 5 && board.get(y + 1).get(x) != null && board.get(y + 1).get(x).getFloodState()!=1 && !tile1s.contains(board.get(y + 1).get(x)))
		{
			diverMovement(x, y + 1, tile1s, sunk);
		}
		else if (y < 5 && board.get(y + 1).get(x) != null)
		{
			if (!tile1s.contains(board.get(y + 1).get(x)))
				tile1s.add(board.get(y + 1).get(x));
		}
	}
}
