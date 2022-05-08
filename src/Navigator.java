/*
 * move another player up to 2 adjacent tiles for 1 action
 */
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Navigator extends Player1
{
	private GameBoard gameBoard;
	private ArrayList<Tile1> movableTile1s;

	public Navigator(GameBoard gameBoard, int order, String Color, String Role, TreasureDeck treasureDeck,
					 BufferedImage pown, BufferedImage pown_move, int xPos, int yPos)
	{
		super(gameBoard, order, Color, Role, treasureDeck, pown, pown_move, xPos, yPos);
		this.gameBoard = gameBoard;
	}

}
